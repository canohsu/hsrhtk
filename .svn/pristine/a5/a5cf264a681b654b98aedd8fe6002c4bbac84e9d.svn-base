/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.impl
 * @FileName: SearchServiceImpl.java
 * @author: tonywang
 * @date: 2013/12/15, 下午 03:39:21
 * 
 * <pre>
 *  Copyright 2013-2014 The ezTravel Co., Ltd. all rights reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of ezTravel Co., Ltd. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to ezTravel Co., Ltd. and its suppliers
 *  and may be covered by TAIWAN and Foreign Patents, patents in 
 *  process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from ezTravel Co., Ltd.
 *  </pre>
 */
package service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import models.comparator.RoomFavorPriceComparator;
import models.comparator.RoomUnionPriceComparator;
import models.enums.BusinessType;
import models.enums.RoomType;
import models.pojo.Hotel;
import models.pojo.HsrHtl;
import models.pojo.Page;
import models.pojo.Room;
import models.pojo.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import service.SearchService;
import task.hrs.RequestHsrProdInfoTask;
import task.htl.RequestHotelTask;
import task.htl.RequestRoomDescTask;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import utils.PriceUtils;
import exceptions.BusinessException;
import eztravel.rest.enums.common.FareType;
import eztravel.rest.enums.hsr.HsrCarClass;
import eztravel.rest.enums.hsr.HsrStation;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.hsr.HsrProductInfo;
import eztravel.rest.pojo.hsr.HsrScheduleInfo;
import eztravel.rest.pojo.htl.HotelInfo;
import eztravel.rest.pojo.htl.PictureInfo;
import eztravel.rest.pojo.htl.RoomDescriptionInfo;
import eztravel.rest.pojo.htl.RoomInfo;

/**
 * The Class SearchServiceImpl.
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author 003050
 */
public class SearchServiceImpl implements SearchService {

  /*
   * (non-Javadoc)
   * 
   * @see service.SearchService#search(models.pojo.HsrHtl, models.pojo.Page)
   */
  @Override
  public HsrHtl search(HsrHtl hsrHtl, final Page page) throws InterruptedException,
      ExecutionException, ParseException {
    HsrStation from = HsrStation.valueOf(hsrHtl.getPlaceFrom());
    HsrStation to = HsrStation.valueOf(hsrHtl.getPlaceTo());
    Date depDate = hsrHtl.getDepDate();
    Date returnDate = hsrHtl.getReturnDate();
    int totalTicket = hsrHtl.getTotalTicketQty();
    User user = hsrHtl.getUser();
    String loginId = user.getLoginId();

    // FareType、HtlCustType只有分B2B, B2C, B2E
    BusinessType businessType = user.getBusinessType();
    String fareTypeStr = null;
    switch (businessType) {
      default:
        fareTypeStr = FareType.B2C.toString();
        break;
      case B2B:
        fareTypeStr = FareType.B2B.toString();
        break;
      case B2E:
        fareTypeStr = FareType.B2E.toString();
        break;
    }
    FareType fareType = FareType.valueOf(fareTypeStr);
    HsrCarClass carClass = HsrCarClass.valueOf(hsrHtl.getCarClass());

    // 查詢高鐵去程班次
    Future<List<HsrProductInfo>> depHsr =
        this.taskExecutor.submit(new RequestHsrProdInfoTask(this.restTemplate, from, to, depDate,
            totalTicket, fareType, carClass, loginId));

    // 查詢高鐵回程班次
    Future<List<HsrProductInfo>> returnHsr =
        this.taskExecutor.submit(new RequestHsrProdInfoTask(this.restTemplate, to, from,
            returnDate, totalTicket, fareType, carClass, loginId));

    // 查詢飯店
    Future<RestResource<HotelInfo>> hotelResult =
        this.taskExecutor.submit(new RequestHotelTask(this.restTemplate, hsrHtl.getArrCity(),
            hsrHtl.getHotelNo(), depDate, returnDate, hsrHtl.getSgl(), hsrHtl.getTwn(), hsrHtl
                .getTrp(), hsrHtl.getQud(), user.getCustNo(), fareTypeStr, page.getStartIndex(),
            page.getPageSize(), page.getOrderBy()));

    // 等待並取得結果
    List<HsrProductInfo> depHsrInfoList = depHsr.get();
    List<HsrProductInfo> returnHsrInfoList = returnHsr.get();
    RestResource<HotelInfo> hotelResource = hotelResult.get();
    page.setTotal(hotelResource.getTotalItems());

    // 去程高鐵
    if (null != depHsrInfoList && depHsrInfoList.size() > 0) {
      HsrProductInfo info = depHsrInfoList.get(0);
      hsrHtl.setDepHsrInfo(info);

      // 班次分群
      TreeMap<String, List<HsrScheduleInfo>> scheduleMap =
          this.divideSchedule(info.getScheduleInfos());
      hsrHtl.setDepScheduleMap(scheduleMap);

      HsrScheduleInfo schedule = null;
      if (null != hsrHtl.getDepSchedule()
          && StringUtils.hasText(hsrHtl.getDepSchedule().getTrainNo())) {
        /**
         * 已選擇班次， 找出相關資訊
         */
        List<HsrScheduleInfo> scheduleList = null;
        for (String period : scheduleMap.keySet()) {
          if (null != schedule) break;
          scheduleList = scheduleMap.get(period);
          if (scheduleList.size() > 0) {
            for (HsrScheduleInfo sch : scheduleList) {
              if (hsrHtl.getDepSchedule().getTrainNo().equals(sch.getTrainNo())) {
                schedule = sch;
                hsrHtl.setDepPeriod(period);
                break;
              }
            }
          }
        }
      }

      if (null == schedule) {
        /**
         * 未選擇班次，或已選擇班次無座位<br>
         * 去程推薦班次邏輯:<br>
         * 當日00:00之後最早班次
         */
        for (String period : scheduleMap.keySet()) {
          List<HsrScheduleInfo> scheduleList = scheduleMap.get(period);
          if (scheduleList.size() > 0) {
            hsrHtl.setDepPeriod(period);
            schedule = scheduleList.get(0);
            break;
          }
        }
      }

      // 票價
      hsrHtl.setDepTicket(PriceUtils.separatedHsrTicket(info.getTicketInfos()));
      hsrHtl.setDepSchedule(schedule);
    }

    // 回程高鐵
    if (null != returnHsrInfoList && returnHsrInfoList.size() > 0) {
      HsrProductInfo info = returnHsrInfoList.get(0);
      hsrHtl.setReturnHsrInfo(info);

      // 班次分群
      TreeMap<String, List<HsrScheduleInfo>> scheduleMap =
          this.divideSchedule(info.getScheduleInfos());
      hsrHtl.setReturnScheduleMap(scheduleMap);

      HsrScheduleInfo schedule = null;
      if (null != hsrHtl.getReturnSchedule()
          && StringUtils.hasText(hsrHtl.getReturnSchedule().getTrainNo())) {
        /**
         * 已選擇班次， 找出相關資訊
         */
        List<HsrScheduleInfo> scheduleList = null;
        for (String period : scheduleMap.keySet()) {
          if (null != schedule) break;
          scheduleList = scheduleMap.get(period);
          if (scheduleList.size() > 0) {
            for (HsrScheduleInfo sch : scheduleList) {
              if (hsrHtl.getReturnSchedule().getTrainNo().equals(sch.getTrainNo())) {
                schedule = sch;
                hsrHtl.setReturnPeriod(period);
                break;
              }
            }
          }
        }
      }
      if (null == schedule) {
        /**
         * 未選擇班次，或已選擇班次無座位<br>
         * 回程推薦班次邏輯:<br>
         * 當日17:00之後最早班次<br>
         * 若完全沒車，取17:00以前最晚班次
         */
        boolean skip = true;
        for (String period : scheduleMap.keySet()) {
          if ("17:00~21:00".equals(period)) skip = false;
          if (!skip) {
            List<HsrScheduleInfo> scheduleList = scheduleMap.get(period);
            if (scheduleList.size() > 0) {
              hsrHtl.setReturnPeriod(period);
              schedule = scheduleList.get(0);
              break;
            }
          }
        }
        if (null == schedule) {
          Iterator<String> it = scheduleMap.descendingKeySet().iterator();
          skip = true;
          while (it.hasNext()) {
            String period = it.next();
            if ("13:00~17:00".equals(period)) skip = false;
            if (!skip) {
              List<HsrScheduleInfo> scheduleList = scheduleMap.get(period);
              int size = scheduleList.size();
              if (size > 0) {
                hsrHtl.setReturnPeriod(period);
                schedule = scheduleList.get(size - 1);
                break;
              }
            }
          }
        }
      }

      // 票價
      hsrHtl.setReturnTicket(PriceUtils.separatedHsrTicket(info.getTicketInfos()));
      hsrHtl.setReturnSchedule(schedule);
    }

    List<HotelInfo> items = hotelResource.getItems();
    if (null != items && items.size() > 0) {
      hsrHtl.setArrCityName(items.get(0).getCityNm());
      List<Hotel> hotels = new ArrayList<Hotel>();
      for (HotelInfo hotelInfo : hotelResource.getItems()) {
        logger.debug("prodNo: " + hotelInfo.getHotelCd());
        try {
          PriceUtils.checkHotelRoomPrice(hotelInfo);
          // 計算房型數量
          LinkedList<RoomInfo> sglList = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> twnList = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> trpList = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> qudList = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> sglCandidate = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> twnCandidate = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> trpCandidate = new LinkedList<RoomInfo>();
          LinkedList<RoomInfo> qudCandidate = new LinkedList<RoomInfo>();
          List<RoomInfo> roomInfoList = hotelInfo.getRoomInfos();
          for (RoomInfo roomInfo : roomInfoList) {
            logger.debug("roomCd: " + roomInfo.getRoomCd());
            logger.debug("原價" + roomInfo.getSitePrice());
            logger.debug("組合價" + roomInfo.getUnionPrice());
            logger.debug("優惠價" + roomInfo.getFavorPrice());
            int qty = roomInfo.getRoomQty();
            switch (roomInfo.getHtlNum()) {
              case 1:// 單人房
                sglCandidate.add(roomInfo);
                for (int i = 0; i < qty; i++)
                  sglList.add(roomInfo);
                break;
              case 2:// 雙人房
                twnCandidate.add(roomInfo);
                for (int i = 0; i < qty; i++)
                  twnList.add(roomInfo);
                break;
              case 3:// 三人房
                trpCandidate.add(roomInfo);
                for (int i = 0; i < qty; i++)
                  trpList.add(roomInfo);
                break;
              case 4:// 四人房
                qudCandidate.add(roomInfo);
                for (int i = 0; i < qty; i++)
                  qudList.add(roomInfo);
                break;
            }
          }

          // 依價格排序
          Comparator<RoomInfo> comparator = null;
          switch (businessType) {
            default:
              comparator = new RoomUnionPriceComparator();
              break;
            case B2B:
            case B2E:
              comparator = new RoomFavorPriceComparator();
              break;
          }
          Collections.sort(sglList, comparator);
          Collections.sort(twnList, comparator);
          Collections.sort(trpList, comparator);
          Collections.sort(qudList, comparator);
          Collections.sort(sglCandidate, comparator);
          Collections.sort(twnCandidate, comparator);
          Collections.sort(trpCandidate, comparator);
          Collections.sort(qudCandidate, comparator);

          // 推薦房間(只考慮最低價，不考慮其他因素ex.包不包含早餐)
          Hotel hotel = new Hotel();
          List<Room> rooms = new ArrayList<Room>();
          for (Room r : hsrHtl.getRooms()) {
            Room room = new Room();
            BeanUtils.copyProperties(r, room);
            RoomInfo roomInfo = null;
            switch (RoomType.valueOf(room.getRoomType())) {
              case SGL:
                roomInfo = sglList.pollFirst();
                if (null == roomInfo) throw new BusinessException("房間不足");
                room.setRoomInfo(roomInfo);
                break;
              case TWN:
                roomInfo = twnList.pollFirst();
                if (null == roomInfo) throw new BusinessException("房間不足");
                room.setRoomInfo(roomInfo);
                break;
              case TRP:
                roomInfo = trpList.pollFirst();
                if (null == roomInfo) throw new BusinessException("房間不足");
                room.setRoomInfo(roomInfo);
                break;
              case QUD:
                roomInfo = qudList.pollFirst();
                if (null == roomInfo) throw new BusinessException("房間不足");
                room.setRoomInfo(roomInfo);
                break;
            }
            rooms.add(room);
          }
          hotel.setHotelCd(hotelInfo.getHotelCd());
          List<PictureInfo> photos = hotelInfo.getPictureInfoM();
          if (null != photos) {
            if (photos.size() > 1)
              hotel.setHotelPhotoLink(photos.get(1).getPhotoUrl());
            else if (photos.size() > 0) hotel.setHotelPhotoLink(photos.get(0).getPhotoUrl());
          }
          hotel.setHotelName(hotelInfo.getHotelNm());
          hotel.setEnglishName(hotelInfo.getNameEng());
          hotel.setAddress(hotelInfo.getAddrCont());
          hotel.setReviewScore(BigDecimal.valueOf(hotelInfo.getReviewScore()).divide(
              BigDecimal.valueOf(10), 1, RoundingMode.HALF_UP));
          hotel.setRoomList(rooms);
          hotel.setSglCandidate(sglCandidate);
          hotel.setTwnCandidate(twnCandidate);
          hotel.setTrpCandidate(trpCandidate);
          hotel.setQudCandidate(qudCandidate);
          hotels.add(hotel);
        } catch (Exception e) {
          logger.warn(e.getMessage(), e);
        }
      }
      hsrHtl.setHotelList(hotels);
    }
    return hsrHtl;
  }

  /*
   * (non-Javadoc)
   * 
   * @see service.SearchService#getRoomDesc(java.lang.String, java.lang.String)
   */
  @Override
  public RoomDescriptionInfo getRoomDesc(String hotelNo, String roomNo)
      throws InterruptedException, ExecutionException {
    Future<RoomDescriptionInfo> result =
        this.taskExecutor.submit(new RequestRoomDescTask(this.restTemplate, hotelNo, roomNo));
    RoomDescriptionInfo info = result.get();
    return info;
  }

  /**
   * 依照時段區分班次.
   * 
   * @param schedules the schedules
   * @return the tree map
   */
  public TreeMap<String, List<HsrScheduleInfo>> divideSchedule(List<HsrScheduleInfo> schedules) {
    @SuppressWarnings("unchecked")
    List<HsrScheduleInfo>[] periods = new List[5];
    for (int i = 0; i < periods.length; i++)
      periods[i] = new ArrayList<HsrScheduleInfo>();

    for (HsrScheduleInfo schedule : schedules) {
      Calendar depTime = schedule.getDepTime();
      int hour = depTime.get(Calendar.HOUR_OF_DAY);
      int min = depTime.get(Calendar.MINUTE);
      try {
        int depTimeStr = Integer.parseInt(String.format("%1$02d%2$02d", hour, min));
        if (depTimeStr < 900)// 00:00~09:00
          periods[0].add(schedule);
        else if (depTimeStr < 1300)// 09:00~13:00
          periods[1].add(schedule);
        else if (depTimeStr < 1700)// 13:00~17:00
          periods[2].add(schedule);
        else if (depTimeStr < 2100)// 17:00~21:00
          periods[3].add(schedule);
        else
          // 21:00~00:00
          periods[4].add(schedule);
      } catch (Exception e) {
        logger.warn(e.getMessage(), e);
      }
    }
    TreeMap<String, List<HsrScheduleInfo>> scheduleMap =
        new TreeMap<String, List<HsrScheduleInfo>>();
    scheduleMap.put("00:00~09:00", periods[0]);
    scheduleMap.put("09:00~13:00", periods[1]);
    scheduleMap.put("13:00~17:00", periods[2]);
    scheduleMap.put("17:00~21:00", periods[3]);
    scheduleMap.put("21:00~00:00", periods[4]);
    return scheduleMap;
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

  /** The rest template. */
  @Autowired
  private RestTemplate restTemplate;

  /** The task executor. */
  @Autowired
  private ThreadPoolTaskExecutor taskExecutor;

  /**
   * Gets the rest template.
   * 
   * @return the rest template
   */
  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  /**
   * Sets the rest template.
   * 
   * @param restTemplate the new rest template
   */
  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Gets the task executor.
   * 
   * @return the taskExecutor
   */
  public ThreadPoolTaskExecutor getTaskExecutor() {
    return taskExecutor;
  }

  /**
   * Sets the task executor.
   * 
   * @param taskExecutor the taskExecutor to set
   */
  public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }
}
