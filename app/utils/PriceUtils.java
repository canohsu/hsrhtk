/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: utils
 * @FileName: PriceUtils.java
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
package utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.pojo.Room;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import exceptions.BusinessException;
import eztravel.rest.enums.hsr.HsrTicketType;
import eztravel.rest.pojo.hsr.HsrTicketInfo;
import eztravel.rest.pojo.htl.HotelInfo;
import eztravel.rest.pojo.htl.RoomInfo;

/**
 * 高鐵票工具類別.
 * 
 * @author CJWang
 */
public class PriceUtils {

  /**
   * 檢查高鐵票價.
   * 
   * @param hsrTicketInfo the hsr ticket info
   */
  public static void checkHsrTicketPrice(HsrTicketInfo hsrTicketInfo) {
    BigDecimal price = null;
    price = hsrTicketInfo.getFinalPrice();
    if (null == price || price.compareTo(BigDecimal.valueOf(0)) <= 0)
      throw new BusinessException(String.format("高鐵會員折扣價異常，票種: %1$s，票價: %2$f",
          hsrTicketInfo.getType(), price));
    price = hsrTicketInfo.getPackagePrice();
    if (null == price || price.compareTo(BigDecimal.valueOf(0)) <= 0)
      throw new BusinessException(String.format("高鐵組合價異常，票種: %1$s，票價: %2$f",
          hsrTicketInfo.getType(), price));
  }

  /**
   * 檢查並區分高鐵票種.
   * 
   * @param ticketInfoList the ticket info list
   * @return 高鐵票種
   */
  public static Map<HsrTicketType, HsrTicketInfo> separatedHsrTicket(
      List<HsrTicketInfo> ticketInfoList) {
    Map<HsrTicketType, HsrTicketInfo> map = new HashMap<HsrTicketType, HsrTicketInfo>();
    for (HsrTicketInfo ticketInfo : ticketInfoList) {
      checkHsrTicketPrice(ticketInfo);
      HsrTicketType type = ticketInfo.getType();
      switch (type) {
        case ADULT:
          logger.debug("去程高鐵成人票");
          break;
        case CHILDREN:
          logger.debug("去程高鐵孩童票");
          break;
        case SENIOR:
          logger.debug("去程高鐵資深公民票");
          break;
        case HEART:
          logger.debug("去程高鐵愛心票");
          break;
      }
      logger.debug("原價: " + ticketInfo.getFullPrice());
      logger.debug("組合價: " + ticketInfo.getPackagePrice());
      logger.debug("優惠價: " + ticketInfo.getFinalPrice());
      map.put(type, ticketInfo);
    }
    return map;
  }

  /**
   * 檢查房價.
   * 
   * @param hotelInfo the hotel info
   */
  public static void checkHotelRoomPrice(HotelInfo hotelInfo) {
    BigDecimal price = null;
    for (RoomInfo room : hotelInfo.getRoomInfos()) {
      price = room.getFavorPrice();
      if (null == price || price.compareTo(BigDecimal.valueOf(0)) <= 0)
        throw new BusinessException(String.format("飯店優惠價異常，飯店代碼: %1$s，房間代碼: %2$s，房價: %3$f",
            hotelInfo.getHotelCd(), room.getRoomCd(), price));
      price = room.getUnionPrice();
      if (null == price || price.compareTo(BigDecimal.valueOf(0)) <= 0)
        throw new BusinessException(String.format("飯店組合價異常，飯店代碼: %1$s，房間代碼: %2$s，房價: %3$f",
            hotelInfo.getHotelCd(), room.getRoomCd(), price));
    }
  }

  /**
   * 取得原價.
   * 
   * @param depTicket 去程高鐵票價資訊
   * @param returnTicket 回程高鐵票價資訊
   * @param roomList 住宿資訊
   * @return 原價
   */
  public static BigDecimal calculateSitePrice(Map<HsrTicketType, HsrTicketInfo> depTicket,
      Map<HsrTicketType, HsrTicketInfo> returnTicket, List<Room> roomList) {
    BigDecimal price = BigDecimal.valueOf(0);
    for (Room room : roomList)
      price =
          price.add(calculateRoomPrice(depTicket.get(HsrTicketType.ADULT).getFullPrice(),
              returnTicket.get(HsrTicketType.ADULT).getFullPrice(),
              depTicket.get(HsrTicketType.CHILDREN).getFullPrice(),
              returnTicket.get(HsrTicketType.CHILDREN).getFullPrice(),
              depTicket.get(HsrTicketType.SENIOR).getFullPrice(),
              returnTicket.get(HsrTicketType.SENIOR).getFullPrice(),
              depTicket.get(HsrTicketType.HEART).getFullPrice(),
              returnTicket.get(HsrTicketType.HEART).getFullPrice(), room.getRoomInfo()
                  .getSitePrice(), room.getFull(), room.getChildren(), room.getSenior(), room
                  .getHalf()));
    if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("原價總計異常");
    return price;
  }

  /**
   * 取得組合價.
   * 
   * @param depTicket 去程高鐵票價資訊
   * @param returnTicket 回程高鐵票價資訊
   * @param roomList 住宿資訊
   * @return 組合價
   */
  public static BigDecimal calculateUnionPrice(Map<HsrTicketType, HsrTicketInfo> depTicket,
      Map<HsrTicketType, HsrTicketInfo> returnTicket, List<Room> roomList) {
    BigDecimal price = BigDecimal.valueOf(0);
    for (Room room : roomList)
      price =
          price.add(calculateRoomPrice(depTicket.get(HsrTicketType.ADULT).getPackagePrice(),
              returnTicket.get(HsrTicketType.ADULT).getPackagePrice(),
              depTicket.get(HsrTicketType.CHILDREN).getPackagePrice(),
              returnTicket.get(HsrTicketType.CHILDREN).getPackagePrice(),
              depTicket.get(HsrTicketType.SENIOR).getPackagePrice(),
              returnTicket.get(HsrTicketType.SENIOR).getPackagePrice(),
              depTicket.get(HsrTicketType.HEART).getPackagePrice(),
              returnTicket.get(HsrTicketType.HEART).getPackagePrice(), room.getRoomInfo()
                  .getUnionPrice(), room.getFull(), room.getChildren(), room.getSenior(), room
                  .getHalf()));
    if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("原價總計異常");
    return price;
  }

  /**
   * 取得優惠價.
   * 
   * @param depTicket 去程高鐵票價資訊
   * @param returnTicket 回程高鐵票價資訊
   * @param roomList 住宿資訊
   * @return 優惠價
   */
  public static BigDecimal calculateFavorPrice(Map<HsrTicketType, HsrTicketInfo> depTicket,
      Map<HsrTicketType, HsrTicketInfo> returnTicket, List<Room> roomList) {
    BigDecimal price = BigDecimal.valueOf(0);
    for (Room room : roomList)
      price =
          price.add(calculateRoomPrice(depTicket.get(HsrTicketType.ADULT).getFinalPrice(),
              returnTicket.get(HsrTicketType.ADULT).getFinalPrice(),
              depTicket.get(HsrTicketType.CHILDREN).getFinalPrice(),
              returnTicket.get(HsrTicketType.CHILDREN).getFinalPrice(),
              depTicket.get(HsrTicketType.SENIOR).getFinalPrice(),
              returnTicket.get(HsrTicketType.SENIOR).getFinalPrice(),
              depTicket.get(HsrTicketType.HEART).getFinalPrice(),
              returnTicket.get(HsrTicketType.HEART).getFinalPrice(), room.getRoomInfo()
                  .getFavorPrice(), room.getFull(), room.getChildren(), room.getSenior(), room
                  .getHalf()));
    if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("原價總計異常");
    return price;
  }

  /**
   * 計算現省.
   * 
   * @param depTicket 去程高鐵票價資訊
   * @param returnTicket 回程高鐵票價資訊
   * @param roomList 住宿資訊
   * @return 現省
   */
  public static BigDecimal calculateSave(Map<HsrTicketType, HsrTicketInfo> depTicket,
      Map<HsrTicketType, HsrTicketInfo> returnTicket, List<Room> roomList) {
    BigDecimal price =
        calculateSitePrice(depTicket, returnTicket, roomList).subtract(
            calculateUnionPrice(depTicket, returnTicket, roomList));
    return price;
  }

  /**
   * 計算再省.
   * 
   * @param depTicket 去程高鐵票價資訊
   * @param returnTicket 回程高鐵票價資訊
   * @param roomList 住宿資訊
   * @return 再省
   */
  public static BigDecimal calculateSaveMore(Map<HsrTicketType, HsrTicketInfo> depTicket,
      Map<HsrTicketType, HsrTicketInfo> returnTicket, List<Room> roomList) {
    BigDecimal price =
        calculateUnionPrice(depTicket, returnTicket, roomList).subtract(
            calculateFavorPrice(depTicket, returnTicket, roomList));
    return price;
  }

  /**
   * 計算高鐵+房價.
   * 
   * @param depAdultPrice 去程高鐵成人票價
   * @param rtnAdultPrice 回程高鐵成人票價
   * @param depChildrenPrice 去程高鐵孩童票價
   * @param rtnChildrenPrice 回程高鐵孩童票價
   * @param depSeniorPrice 去程高鐵資深公民票價
   * @param rtnSeniorPrice 回程高鐵資深公民票價
   * @param depHeartPrice 去程高鐵愛心票價
   * @param rtnHeartPrice 回程高鐵愛心票價
   * @param roomPrice 房價
   * @param full 成人票人數
   * @param children 孩童票人數
   * @param senior 資深公民票人數
   * @param half 愛心票人數
   * @return the big decimal
   */
  public static BigDecimal calculateRoomPrice(BigDecimal depAdultPrice, BigDecimal rtnAdultPrice,
      BigDecimal depChildrenPrice, BigDecimal rtnChildrenPrice, BigDecimal depSeniorPrice,
      BigDecimal rtnSeniorPrice, BigDecimal depHeartPrice, BigDecimal rtnHeartPrice,
      BigDecimal roomPrice, int full, int children, int senior, int half) {
    BigDecimal price = null;
    BigDecimal hsrAdult = depAdultPrice.add(rtnAdultPrice);
    BigDecimal hsrChildren = depChildrenPrice.add(rtnChildrenPrice);
    BigDecimal hsrSenior = depSeniorPrice.add(rtnSeniorPrice);
    BigDecimal hsrHeart = depHeartPrice.add(rtnHeartPrice);
    BigDecimal priceAdult = hsrAdult.multiply(BigDecimal.valueOf(full));
    BigDecimal priceChildren = hsrChildren.multiply(BigDecimal.valueOf(children));
    BigDecimal priceSenior = hsrSenior.multiply(BigDecimal.valueOf(senior));
    BigDecimal priceHeart = hsrHeart.multiply(BigDecimal.valueOf(half));
    price = priceAdult.add(priceChildren).add(priceSenior).add(priceHeart).add(roomPrice);
    if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("原價異常");
    return price;
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(PriceUtils.class);
}
