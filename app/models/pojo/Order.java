/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: models.pojo
 * @FileName: Order.java
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
package models.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import models.enums.RoomType;
import play.data.format.Formats;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import eztravel.rest.enums.hsr.HsrTicketType;
import eztravel.rest.pojo.hsr.HsrScheduleInfo;
import eztravel.rest.pojo.hsr.HsrTicketInfo;

/**
 * 訂購資訊.
 * 
 * @author CJWang
 */
public class Order {

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(Order.class);

  /** 訂單編號. */
  private String orderNo;

  /** 使用者資訊. */
  private User user;

  /** 出發高鐵站. */
  private String placeFrom;

  /** 目的城市. */
  private String arrCity;

  /** 目的高鐵站. */
  private String placeTo;

  /** 車廂種類. */
  private String carClass;

  /** 飯店編號(商品代號). */
  private String hotelNo;

  /** 出發日期. */
  @Formats.DateTime(pattern = "yyyy/MM/dd")
  private Date depDate;

  /** 旅遊天數. */
  private int travelDay;

  /** 返回日期. */
  @Formats.DateTime(pattern = "yyyy/MM/dd")
  private Date returnDate;

  /** 去程高鐵班次. */
  private HsrScheduleInfo depSchedule;

  /** 去程高鐵票資訊. */
  private Map<HsrTicketType, HsrTicketInfo> depTicket;

  /** 回程高鐵票資訊. */
  private Map<HsrTicketType, HsrTicketInfo> returnTicket;

  /** 回程高鐵班次. */
  private HsrScheduleInfo returnSchedule;

  /** 房型票種. */
  private List<Room> rooms;

  /** 飯店資訊. */
  private Hotel hotel;

  /**
   * Gets the sgl.
   * 
   * @return 單人房
   */
  public int getSgl() {
    int sgl = 0;
    if (null != rooms) {
      for (Room room : rooms) {
        try {
          if (RoomType.SGL.equals(RoomType.valueOf(room.getRoomType()))) sgl++;
        } catch (Exception e) {
          logger.warn(e.getMessage(), e);
        }
      }
    }
    return sgl;
  }

  /**
   * Gets the twn.
   * 
   * @return 雙人房
   */
  public int getTwn() {
    int twn = 0;
    if (null != rooms) {
      for (Room room : rooms) {
        try {
          if (RoomType.TWN.equals(RoomType.valueOf(room.getRoomType()))) twn++;
        } catch (Exception e) {
          logger.warn(e.getMessage(), e);
        }
      }
    }
    return twn;
  }

  /**
   * Gets the trp.
   * 
   * @return 三人房
   */
  public int getTrp() {
    int trp = 0;
    if (null != rooms) {
      for (Room room : rooms) {
        try {
          if (RoomType.TRP.equals(RoomType.valueOf(room.getRoomType()))) trp++;
        } catch (Exception e) {
          logger.warn(e.getMessage(), e);
        }
      }
    }
    return trp;
  }

  /**
   * Gets the qud.
   * 
   * @return 四人房
   */
  public int getQud() {
    int qud = 0;
    if (null != rooms) {
      for (Room room : rooms) {
        try {
          if (RoomType.QUD.equals(RoomType.valueOf(room.getRoomType()))) qud++;
        } catch (Exception e) {
          logger.warn(e.getMessage(), e);
        }
      }
    }
    return qud;
  }

  /**
   * 取得總票數.
   * 
   * @return the total ticket qty
   */
  public int getTotalTicketQty() {
    int qty = 0;
    if (null != this.rooms) {
      for (Room room : this.rooms) {
        qty += room.getFull();
        qty += room.getChildren();
        qty += room.getSenior();
        qty += room.getHalf();
      }
    }
    return qty;
  }

  /**
   * 取得成人票總數.
   * 
   * @return the full ticket qty
   */
  public int getFullTicketQty() {
    int qty = 0;
    if (null != this.rooms) {
      for (Room room : this.rooms)
        qty += room.getFull();
    }
    return qty;
  }

  /**
   * 取得資深公民票總數.
   * 
   * @return the senior ticket qty
   */
  public int getSeniorTicketQty() {
    int qty = 0;
    if (null != this.rooms) {
      for (Room room : this.rooms)
        qty += room.getSenior();
    }
    return qty;
  }

  /**
   * 取得愛心票總數.
   * 
   * @return the half ticket qty
   */
  public int getHalfTicketQty() {
    int qty = 0;
    if (null != this.rooms) {
      for (Room room : this.rooms)
        qty += room.getHalf();
    }
    return qty;
  }

  /**
   * 取得兒童票總數.
   * 
   * @return the children ticket qty
   */
  public int getChildrenTicketQty() {
    int qty = 0;
    if (null != this.rooms) {
      for (Room room : this.rooms)
        qty += room.getChildren();
    }
    return qty;
  }

  /**
   * 取得某一房型的總票數（從0開始）.
   * 
   * @param index the index
   * @return the total ticket qty for room
   */
  public int getTotalTicketQtyForRoom(int index) {
    int qty = 0;
    if (null != this.rooms) {
      Room room = this.rooms.get(index);
      qty += room.getFull();
      qty += room.getChildren();
      qty += room.getSenior();
      qty += room.getHalf();
    }
    return qty;
  }

  /**
   * Gets the user.
   * 
   * @return 使用者資訊
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the user.
   * 
   * @param user 使用者資訊
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Gets the place from.
   * 
   * @return 出發高鐵站
   */
  public String getPlaceFrom() {
    return placeFrom;
  }

  /**
   * Sets the place from.
   * 
   * @param placeFrom 出發高鐵站
   */
  public void setPlaceFrom(String placeFrom) {
    this.placeFrom = placeFrom;
  }

  /**
   * Gets the arr city.
   * 
   * @return 目的城市
   */
  public String getArrCity() {
    return arrCity;
  }

  /**
   * Sets the arr city.
   * 
   * @param arrCity 目的城市
   */
  public void setArrCity(String arrCity) {
    this.arrCity = arrCity;
  }

  /**
   * Gets the place to.
   * 
   * @return 目的高鐵站
   */
  public String getPlaceTo() {
    return placeTo;
  }

  /**
   * Sets the place to.
   * 
   * @param placeTo 目的高鐵站
   */
  public void setPlaceTo(String placeTo) {
    this.placeTo = placeTo;
  }

  /**
   * Gets the car class.
   * 
   * @return 車廂種類
   */
  public String getCarClass() {
    return carClass;
  }

  /**
   * Sets the car class.
   * 
   * @param carClass 車廂種類
   */
  public void setCarClass(String carClass) {
    this.carClass = carClass;
  }

  /**
   * Gets the hotel no.
   * 
   * @return 飯店編號(商品代號)
   */
  public String getHotelNo() {
    return hotelNo;
  }

  /**
   * Sets the hotel no.
   * 
   * @param hotelNo 飯店編號(商品代號)
   */
  public void setHotelNo(String hotelNo) {
    this.hotelNo = hotelNo;
  }

  /**
   * Gets the dep date.
   * 
   * @return 出發日期
   */
  public Date getDepDate() {
    return depDate;
  }

  /**
   * Sets the dep date.
   * 
   * @param depDate 出發日期
   */
  public void setDepDate(Date depDate) {
    this.depDate = depDate;
  }

  /**
   * Gets the travel day.
   * 
   * @return 旅遊天數
   */
  public int getTravelDay() {
    return travelDay;
  }

  /**
   * Sets the travel day.
   * 
   * @param travelDay 旅遊天數
   */
  public void setTravelDay(int travelDay) {
    this.travelDay = travelDay;
  }

  /**
   * Gets the return date.
   * 
   * @return 返回日期
   */
  public Date getReturnDate() {
    return returnDate;
  }

  /**
   * Sets the return date.
   * 
   * @param returnDate 返回日期
   */
  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  /**
   * Gets the dep schedule.
   * 
   * @return 去程高鐵班次
   */
  public HsrScheduleInfo getDepSchedule() {
    return depSchedule;
  }

  /**
   * Sets the dep schedule.
   * 
   * @param depSchedule 去程高鐵班次
   */
  public void setDepSchedule(HsrScheduleInfo depSchedule) {
    this.depSchedule = depSchedule;
  }

  /**
   * Gets the return schedule.
   * 
   * @return 回程高鐵班次
   */
  public HsrScheduleInfo getReturnSchedule() {
    return returnSchedule;
  }

  /**
   * Sets the return schedule.
   * 
   * @param returnSchedule 回程高鐵班次
   */
  public void setReturnSchedule(HsrScheduleInfo returnSchedule) {
    this.returnSchedule = returnSchedule;
  }

  /**
   * Gets the rooms.
   * 
   * @return 房型票種
   */
  public List<Room> getRooms() {
    return rooms;
  }

  /**
   * Sets the rooms.
   * 
   * @param rooms 房型票種
   */
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  /**
   * Gets the hotel.
   * 
   * @return 飯店資訊
   */
  public Hotel getHotel() {
    return hotel;
  }

  /**
   * Sets the hotel.
   * 
   * @param hotel the new hotel
   */
  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  /**
   * Gets the dep ticket.
   * 
   * @return 去程高鐵票資訊
   */
  public Map<HsrTicketType, HsrTicketInfo> getDepTicket() {
    return depTicket;
  }

  /**
   * Sets the dep ticket.
   * 
   * @param depTicket 去程高鐵票資訊
   */
  public void setDepTicket(Map<HsrTicketType, HsrTicketInfo> depTicket) {
    this.depTicket = depTicket;
  }

  /**
   * Gets the return ticket.
   * 
   * @return 回程高鐵票資訊
   */
  public Map<HsrTicketType, HsrTicketInfo> getReturnTicket() {
    return returnTicket;
  }

  /**
   * Sets the return ticket.
   * 
   * @param returnTicket 回程高鐵票資訊
   */
  public void setReturnTicket(Map<HsrTicketType, HsrTicketInfo> returnTicket) {
    this.returnTicket = returnTicket;
  }

  /**
   * Gets the order no.
   * 
   * @return 訂單編號
   */
  public String getOrderNo() {
    return orderNo;
  }

  /**
   * Sets the order no.
   * 
   * @param orderNo 訂單編號
   */
  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }
}
