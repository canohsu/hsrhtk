/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order.impl
 * @FileName: OrderServiceImpl.java
 * @author: tonywang
 * @date: 2013/12/15, 下午 03:39:20
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
package service.order.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import models.comparator.HsrHtlProdComparator;
import models.pojo.CustomerData;
import models.pojo.Hotel;
import models.pojo.Order;
import models.pojo.OrderData;
import models.pojo.Room;
import models.pojo.Snapshot;
import models.pojo.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import service.order.OrderService;
import task.hrs.RequestHsrByTrainNoTask;
import task.htl.RequestHotelTask;
import task.htl.RequestRoomDescTask;
import task.order.RequestCreateOrderTask;
import task.order.RequestOrderTask;
import utils.DateUtils;
import utils.PriceUtils;
import exceptions.BusinessException;
import eztravel.rest.enums.common.FareType;
import eztravel.rest.enums.hsr.HsrCarClass;
import eztravel.rest.enums.hsr.HsrStation;
import eztravel.rest.enums.hsr.HsrTicketType;
import eztravel.rest.enums.htl.HtlCustType;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.hsr.HsrProductInfo;
import eztravel.rest.pojo.hsr.HsrScheduleInfo;
import eztravel.rest.pojo.htl.HotelInfo;
import eztravel.rest.pojo.htl.RoomDescriptionInfo;
import eztravel.rest.pojo.htl.RoomInfo;
import eztravel.rest.pojo.order.OrderCustomer;
import eztravel.rest.pojo.order.OrderHsrProduct;
import eztravel.rest.pojo.order.OrderHtlProduct;
import eztravel.rest.pojo.order.OrderInfo;
import eztravel.rest.pojo.order.OrderProdInfo;
import eztravel.rest.pojo.order.OrderRequest;
import eztravel.rest.pojo.order.OrderUnion;

/**
 * 訂單相關邏輯.
 * 
 * @author CJWang
 */
public class OrderServiceImpl implements OrderService {

  /*
   * (non-Javadoc)
   * 
   * @see service.order.OrderService#getOrderInfo(models.pojo.Order)
   */
  @Override
  public Order getOrderInfo(Order order) throws InterruptedException, ExecutionException {
    // 查詢高鐵、飯店資訊共用程式
    Map<String, List<?>> hsrHtlInfo = this.selectHsrHtlInfo(order);
    HsrProductInfo depProd = (HsrProductInfo) hsrHtlInfo.get("depHsr").get(0);
    HsrProductInfo rtnProd = (HsrProductInfo) hsrHtlInfo.get("rtnHsr").get(0);
    order.setDepSchedule(depProd.getScheduleInfos().get(0));
    order.setReturnSchedule(rtnProd.getScheduleInfos().get(0));
    order.setDepTicket(PriceUtils.separatedHsrTicket(depProd.getTicketInfos()));
    order.setReturnTicket(PriceUtils.separatedHsrTicket(rtnProd.getTicketInfos()));

    HotelInfo htlInfo = (HotelInfo) hsrHtlInfo.get("htlInfos").get(0);
    Hotel hotel = new Hotel();
    hotel.setHotelCd(htlInfo.getHotelCd());
    hotel.setHotelName(htlInfo.getHotelNm());
    hotel.setEnglishName(htlInfo.getNameEng());
    hotel.setRoomList(order.getRooms());
    order.setHotel(hotel);

    List<RoomInfo> roomInfos = htlInfo.getRoomInfos();
    for (Room room : order.getRooms()) {
      if (null != room.getRoomInfo()) {
        for (RoomInfo roomInfo : roomInfos) {
          if (null != room.getRoomInfo().getRoomCd()
              && room.getRoomInfo().getRoomCd().equals(roomInfo.getRoomCd())) {
            room.setRoomInfo(roomInfo);
            RoomDescriptionInfo desc = new RoomDescriptionInfo();
            desc.setRoomtypeMark(roomInfo.getRoomtypeMark());
            desc.setProjDesc(roomInfo.getProjDesc());
            desc.setAddBedYn(roomInfo.getAddBedYn());
            desc.setAddbedBfsYn(roomInfo.getAddbedBfsYn());
            desc.setAddBreakfastYn(roomInfo.getAddBreakfastYn());
            desc.setRoomInstallation(roomInfo.getRoomInstallation());
            room.setRoomDescriptionInfo(desc);
            break;
          }
        }
      }
    }
    return order;
  }



  /*
   * (non-Javadoc)
   * 
   * @see service.order.OrderService#getOrderInfo(java.lang.String)
   */
  @Override
  public Order getOrderInfo(String orderNo) throws InterruptedException, ExecutionException,
      ParseException {
    // 查詢訂單
    Future<OrderInfo> future =
        this.taskExecutor.submit(new RequestOrderTask(this.restTemplate, orderNo));
    OrderInfo oinfo = future.get();
    List<OrderProdInfo> oprods = oinfo.getOrderProdInfos();

    // 分群
    Collections.sort(oprods, new HsrHtlProdComparator());

    List<Room> rooms = new ArrayList<Room>();
    Hotel hotel = new Hotel();
    hotel.setRoomList(rooms);
    Snapshot order = new Snapshot();
    order.setOrderNo(orderNo);
    order.setHotel(hotel);
    order.setRooms(rooms);
    order.setOrderAmt(oinfo.getOrderAmt());

    Map<Date, HsrProductInfo> hsrs = new TreeMap<Date, HsrProductInfo>();
    String uno = oprods.get(0).getUnionNo();
    int full = 0;
    int chld = 0;
    int senr = 0;
    int half = 0;
    Room room = new Room();
    for (OrderProdInfo oprod : oprods) {
      if (!uno.equals(oprod.getUnionNo())) {
        // 結算房間票種人數(訂單上沒有區分來回票，乾脆全部相加除以2)
        room.setFull(full / 2);
        room.setChildren(chld / 2);
        room.setSenior(senr / 2);
        room.setHalf(half / 2);
        rooms.add(room);

        full = 0;
        chld = 0;
        senr = 0;
        half = 0;
        room = new Room();
        uno = oprod.getUnionNo();
      }
      String ptype = oprod.getProdType();
      String pdesc = oprod.getProdDesc();
      Date fromDt = DateUtils.parse(oprod.getFromDt(), DateUtils.PATTERN_NO_SEPERATED);
      Date endDt = DateUtils.parse(oprod.getEndDt(), DateUtils.PATTERN_NO_SEPERATED);
      if ("HTL".equals(ptype)) {
        // 房間
        order.setDepDate(fromDt);
        order.setReturnDate(endDt);
        order.setTravelDay((int) (endDt.getTime() - fromDt.getTime()) / (24 * 60 * 60 * 1000));
        hotel.setHotelCd(oprod.getProdNo());

        RoomInfo rinfo = new RoomInfo();
        room.setRoomInfo(rinfo);
        rinfo.setRoomCd(pdesc.split(",")[1].substring(0, 3));// 房型編號

        BigDecimal price = BigDecimal.valueOf(100000);
        rinfo.setSitePrice(price);
        rinfo.setUnionPrice(price);
        rinfo.setFavorPrice(price);
      } else if ("GRP".equals(ptype) && "ODT".equals(oprod.getProdSubtype())) {
        // 高鐵
        String[] pdescs = pdesc.split("【|】|(-{4})|，|：|。");
        HsrProductInfo hsrprod = null;
        if (hsrs.containsKey(fromDt))
          hsrprod = hsrs.get(fromDt);
        else {
          hsrprod = new HsrProductInfo();
          hsrs.put(fromDt, hsrprod);
        }
        // 起站
        hsrprod.setFrom(HsrStation.fromName(pdescs[2]));
        // 迄站
        hsrprod.setTo(HsrStation.fromName(pdescs[3]));

        HsrScheduleInfo sche = new HsrScheduleInfo();
        Calendar depTime = Calendar.getInstance(Locale.TAIWAN);
        Calendar arrTime = Calendar.getInstance(Locale.TAIWAN);
        depTime.setTime(DateUtils.parse(pdescs[7], DateUtils.PATTERN_TIME));// 出發時間
        arrTime.setTime(DateUtils.parse(pdescs[9], DateUtils.PATTERN_TIME));// 抵達時間
        sche.setDepTime(depTime);
        sche.setArrTime(arrTime);

        // 車次
        sche.setTrainNo(pdescs[5]);

        List<HsrScheduleInfo> sches = null;
        if (null == hsrprod.getScheduleInfos()) {
          sches = new ArrayList<HsrScheduleInfo>();
          hsrprod.setScheduleInfos(sches);
        } else
          sches = hsrprod.getScheduleInfos();
        sches.add(sche);

        // 票種
        if (pdescs[10].equals(HsrTicketType.ADULT.getName()))
          full++;
        else if (pdescs[10].equals(HsrTicketType.CHILDREN.getName()))
          chld++;
        else if (pdescs[10].equals(HsrTicketType.SENIOR.getName()))
          senr++;
        else if (pdescs[10].equals(HsrTicketType.HEART.getName())) half++;
      }
    }
    // 結算房間票種人數(訂單上沒有區分來回票，乾脆全部相加除以2)
    room.setFull(full / 2);
    room.setChildren(chld / 2);
    room.setSenior(senr / 2);
    room.setHalf(half / 2);
    rooms.add(room);

    HsrProductInfo depHsrProd = hsrs.get(order.getDepDate());
    HsrProductInfo rtnHsrProd = hsrs.get(order.getReturnDate());
    order.setPlaceFrom(depHsrProd.getFrom().toString());
    order.setPlaceTo(rtnHsrProd.getFrom().toString());
    order.setDepSchedule(depHsrProd.getScheduleInfos().get(0));
    order.setReturnSchedule(rtnHsrProd.getScheduleInfos().get(0));

    // 取得房間明細
    List<Future<RoomDescriptionInfo>> futures = new ArrayList<Future<RoomDescriptionInfo>>();
    for (Room r : rooms)
      futures.add(this.taskExecutor.submit(new RequestRoomDescTask(this.restTemplate, order
          .getHotel().getHotelCd(), r.getRoomInfo().getRoomCd())));
    for (int i = 0; i < futures.size(); i++) {
      RoomDescriptionInfo rdesc = futures.get(i).get();
      Room r = rooms.get(i);
      r.getRoomInfo().setRoomtypeDesc(rdesc.getRoomtypeDesc());
      r.setRoomDescriptionInfo(rdesc);
    }
    RoomDescriptionInfo rdinfo = rooms.get(0).getRoomDescriptionInfo();
    hotel.setHotelName(rdinfo.getHotelNm());
    hotel.setEnglishName(rdinfo.getNameEng());
    return order;
  }



  /*
   * (non-Javadoc)
   * 
   * @see service.order.OrderService#createOrder(eztravel.rest.pojo.order.OrderRequest,
   * models.pojo.OrderData, models.pojo.Order)
   */
  @Override
  public OrderInfo createOrder(OrderRequest orderRequest, OrderData orderData, Order order)
      throws InterruptedException, ExecutionException {

    try {
      // 重新查詢高鐵、飯店資訊
      Map<String, List<?>> hsrHtlInfo = this.selectHsrHtlInfo(order);

      // 重新取得高鐵資訊（確認票數是否足夠、重新計算價錢）
      HsrProductInfo hsrProductInfoDep = (HsrProductInfo) hsrHtlInfo.get("depHsr").get(0); // 去程
      HsrProductInfo hsrProductInfoRet = (HsrProductInfo) hsrHtlInfo.get("rtnHsr").get(0); // 回程
      // 重新取得飯店資訊（取得飯店編號...等）
      List<RoomInfo> roomInfoList = ((HotelInfo) hsrHtlInfo.get("htlInfos").get(0)).getRoomInfos(); // 查詢出飯店的「所有房型」資訊



      // 存入旅客資訊
      List<OrderCustomer> orderCustomers = new ArrayList<OrderCustomer>(); // 旅客list
      int customerQty = 1; // 旅客數

      // for 房間數
      for (int i = 0; i < order.getRooms().size(); i++) {
        RoomInfo roomInfoForOrder = new RoomInfo(); // 房間資訊（寫入訂單用）

        // 房型比對：將「客人所選」房型（order.getRooms()）與「查詢出」房型（roomInfoList），比對後存入 roomInfoForOrder
        for (RoomInfo roomInfo : roomInfoList) {
          if (order.getRooms().get(i).getRoomInfo().getRoomCd().equals(roomInfo.getRoomCd())) {
            roomInfoForOrder = roomInfo;
            break;
          }
        }

        // for 房間內的旅客數（依「房間內所有票種」跑迴圈）
        for (int j = 0; j < order.getRooms().get(i).getHsrTicketType().size(); j++) {
          CustomerData customerData = orderData.getCustomerData().get(customerQty - 1); // 旅客資訊（傳入）
          OrderCustomer orderCustomer = new OrderCustomer(); // 旅客資訊（寫入訂單用）
          HsrTicketType hsrTicketType = order.getRooms().get(i).getHsrTicketType().get(j); // 高鐵票種

          // 複製項目：中英文姓名、ID、性別
          BeanUtils.copyProperties(customerData, orderCustomer);
          // 旅客生日
          Calendar birthday = Calendar.getInstance();
          birthday.setTime(eztravel.rest.util.common.DateUtils.str2Date(customerData.getBirYs()
              + customerData.getBirMs() + customerData.getBirDs(), "yyyyMMdd"));
          orderCustomer.setBirthday(birthday);

          // 聯合銷品資訊
          this.setOrderUnion((i + 1), orderCustomer);

          // 國內訂房商品（第一為旅客才需寫入）
          if (j == 0)
            this.setHtlProduct(roomInfoForOrder, orderCustomer, hsrProductInfoDep,
                hsrProductInfoRet);

          /*
           * 高鐵商品存入說明： 1. 先分去程、回程（setHsrProducts） 2. 再存入 OrderHsrProduct（setOrderHsrProduct）（價錢除外）
           * 3. 根據票種switch，存入價錢 （switchHsrTicketType、setPrice）
           */
          this.setHsrProducts(hsrProductInfoDep, hsrProductInfoRet, hsrTicketType, orderCustomer);

          customerQty++;

          orderCustomers.add(orderCustomer);

        }// for 旅客（結束）
      }// for 房型（結束）

      orderRequest.setOrderCustomers(orderCustomers);


      // 呼叫寫入訂單 webService
      Future<List<OrderInfo>> depOrderFuture =
          this.taskExecutor.submit(new RequestCreateOrderTask(this.restTemplate, orderRequest));
      List<OrderInfo> depHsr = depOrderFuture.get();

      return depHsr.get(0);

    } catch (Exception e) {
      return null;
    }
  }



  /**
   * 查詢高鐵、飯店資訊共用程式.
   * 
   * @param order the order
   * @return the map
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public Map<String, List<?>> selectHsrHtlInfo(Order order) throws InterruptedException,
      ExecutionException {

    HsrStation from = HsrStation.valueOf(order.getPlaceFrom());
    HsrStation to = HsrStation.valueOf(order.getPlaceTo());
    Date depDate = order.getDepDate();
    Date returnDate = order.getReturnDate();
    int totalTicket = order.getTotalTicketQty();
    User user = order.getUser();
    String loginId = user.getLoginId();
    String custType = null;
    switch (user.getBusinessType()) {
      default:
        custType = HtlCustType.B2C.toString();
        break;
      case B2B:
        custType = HtlCustType.B2B.toString();
        break;
      case B2E:
        custType = HtlCustType.B2E.toString();
        break;
    }
    FareType fareType = FareType.valueOf(custType);
    HsrCarClass carClass = HsrCarClass.valueOf(order.getCarClass());

    // 查詢飯店
    Future<RestResource<HotelInfo>> htlFuture =
        this.taskExecutor.submit(new RequestHotelTask(this.restTemplate, order.getArrCity(), order
            .getHotelNo(), depDate, returnDate, order.getSgl(), order.getTwn(), order.getTrp(),
            order.getQud(), user.getCustNo(), custType));

    // 查詢去程高鐵資訊
    Future<List<HsrProductInfo>> depHsrFuture =
        this.taskExecutor.submit(new RequestHsrByTrainNoTask(this.restTemplate, from, to, depDate,
            totalTicket, fareType, carClass, loginId, order.getDepSchedule().getTrainNo()));

    // 查詢回程高鐵資訊
    Future<List<HsrProductInfo>> rtnHsrFuture =
        this.taskExecutor.submit(new RequestHsrByTrainNoTask(this.restTemplate, to, from,
            returnDate, totalTicket, fareType, carClass, loginId, order.getReturnSchedule()
                .getTrainNo()));

    RestResource<HotelInfo> htlResult = htlFuture.get();
    List<HsrProductInfo> depHsr = depHsrFuture.get();
    List<HsrProductInfo> rtnHsr = rtnHsrFuture.get();

    List<HotelInfo> htlInfos = htlResult.getItems();
    if (200 != htlResult.getStatus() || null == htlInfos || htlInfos.size() <= 0)
      throw new BusinessException("飯店查詢失敗");
    if (null == depHsr || depHsr.size() <= 0 || null == depHsr.get(0).getScheduleInfos()
        || depHsr.get(0).getScheduleInfos().size() <= 0) throw new BusinessException("去程高鐵查詢失敗");
    if (null == rtnHsr || rtnHsr.size() <= 0 || null == rtnHsr.get(0).getScheduleInfos()
        || rtnHsr.get(0).getScheduleInfos().size() <= 0) throw new BusinessException("回程高鐵查詢失敗");

    Map<String, List<?>> hsrHtlInfo = new HashMap<String, List<?>>();
    hsrHtlInfo.put("htlInfos", htlInfos);
    hsrHtlInfo.put("depHsr", depHsr);
    hsrHtlInfo.put("rtnHsr", rtnHsr);

    return hsrHtlInfo;

  }



  /**
   * 存入聯合銷品資訊.
   * 
   * @param unionGroup the union group
   * @param orderCustomer the order customer
   */
  public void setOrderUnion(int unionGroup, OrderCustomer orderCustomer) {

    OrderUnion ounion = new OrderUnion();
    ounion.setUnionGroup(unionGroup);
    ounion.setUnionType("HR1");
    orderCustomer.setOrderUnion(ounion);
  }



  /**
   * 存入飯店資訊.
   * 
   * @param roomInfo the room info
   * @param orderCustomer the order customer
   * @param hsrProductInfoDep the hsr product info dep
   * @param hsrProductInfoRet the hsr product info ret
   */
  public void setHtlProduct(RoomInfo roomInfo, OrderCustomer orderCustomer,
      HsrProductInfo hsrProductInfoDep, HsrProductInfo hsrProductInfoRet) {

    OrderHtlProduct orderHtlProduct = new OrderHtlProduct();
    // 複製項目：areaCd、countryCd、pkgType
    BeanUtils.copyProperties(roomInfo, orderHtlProduct);
    orderHtlProduct.setHotelNo(roomInfo.getHotelCd());
    orderHtlProduct.setRoomNo(roomInfo.getRoomCd());
    orderHtlProduct.setCheckInDt(hsrProductInfoDep.getDate());
    orderHtlProduct.setCheckOutDt(hsrProductInfoRet.getDate());
    orderHtlProduct.setAgentType("HR1");
    orderHtlProduct.setMoneyCd("NTD");
    orderHtlProduct.setExchangeRate("1");
    orderCustomer.setHtlProduct(orderHtlProduct);
  }



  /**
   * 存入旅客的高鐵資訊（去程、回程）.
   * 
   * @param hsrProductInfoDep the hsr product info dep
   * @param hsrProductInfoRet the hsr product info ret
   * @param hsrTicketType the hsr ticket type
   * @param orderCustomer the order customer
   */
  public void setHsrProducts(HsrProductInfo hsrProductInfoDep, HsrProductInfo hsrProductInfoRet,
      HsrTicketType hsrTicketType, OrderCustomer orderCustomer) {

    List<OrderHsrProduct> orderHsrProductList = new ArrayList<OrderHsrProduct>();
    // 去程、回程
    OrderHsrProduct orderHsrProductDep = this.setOrderHsrProduct(hsrProductInfoDep, hsrTicketType);
    OrderHsrProduct orderHsrProductRet = this.setOrderHsrProduct(hsrProductInfoRet, hsrTicketType);

    orderHsrProductList.add(orderHsrProductDep);
    orderHsrProductList.add(orderHsrProductRet);
    orderCustomer.setHsrProducts(orderHsrProductList);
  }



  /**
   * 存入高鐵資訊.
   * 
   * @param hsrProductInfo the hsr product info
   * @param hsrTicketType the hsr ticket type
   * @return the order hsr product
   */
  public OrderHsrProduct setOrderHsrProduct(HsrProductInfo hsrProductInfo,
      HsrTicketType hsrTicketType) {

    OrderHsrProduct orderHsrProduct = new OrderHsrProduct();

    // 複製項目：prodNo、date、from、to
    BeanUtils.copyProperties(hsrProductInfo, orderHsrProduct);
    // 複製項目：daySeq、partNo、groupNo
    BeanUtils.copyProperties(hsrProductInfo.getScheduleInfos().get(0), orderHsrProduct);
    orderHsrProduct.setScheduleNo(hsrProductInfo.getScheduleInfos().get(0).getTrainNo());
    orderHsrProduct.setTicketType(hsrTicketType);
    this.switchHsrTicketType(orderHsrProduct, hsrProductInfo, hsrTicketType);

    return orderHsrProduct;
  }



  /**
   * 依據票種切換價錢.
   * 
   * @param orderHsrProduct the order hsr product
   * @param hsrProductInfo the hsr product info
   * @param hsrTicketType the hsr ticket type
   * @return the order hsr product
   */
  public OrderHsrProduct switchHsrTicketType(OrderHsrProduct orderHsrProduct,
      HsrProductInfo hsrProductInfo, HsrTicketType hsrTicketType) {

    switch (hsrTicketType) {
      case ADULT:
        orderHsrProduct = this.setPrice(orderHsrProduct, hsrProductInfo, 0);
        break;
      case CHILDREN:
        orderHsrProduct = this.setPrice(orderHsrProduct, hsrProductInfo, 1);
        break;
      case SENIOR:
        orderHsrProduct = this.setPrice(orderHsrProduct, hsrProductInfo, 2);
        break;
      case HEART:
        orderHsrProduct = this.setPrice(orderHsrProduct, hsrProductInfo, 3);
        break;
    }

    return orderHsrProduct;
  }



  /**
   * 存入價錢至高鐵資訊.
   * 
   * @param orderHsrProduct the order hsr product
   * @param hsrProductInfo the hsr product info
   * @param index the index
   * @return the order hsr product
   */
  public OrderHsrProduct setPrice(OrderHsrProduct orderHsrProduct, HsrProductInfo hsrProductInfo,
      int index) {

    orderHsrProduct.setFullPrice(hsrProductInfo.getTicketInfos().get(index).getFullPrice());
    orderHsrProduct.setPackagePrice(hsrProductInfo.getTicketInfos().get(index).getPackagePrice());
    orderHsrProduct.setFinalPrice(hsrProductInfo.getTicketInfos().get(index).getFinalPrice());

    return orderHsrProduct;
  }


  /** The rest template. */
  @Autowired
  private RestTemplate restTemplate;

  /** The task executor. */
  @Autowired
  private ThreadPoolTaskExecutor taskExecutor;

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

  /**
   * Gets the rest template.
   * 
   * @return the restTemplate
   */
  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  /**
   * Sets the rest template.
   * 
   * @param restTemplate the restTemplate to set
   */
  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }



}
