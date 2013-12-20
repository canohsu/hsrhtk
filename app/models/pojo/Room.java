/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: models.pojo
 * @FileName: Room.java
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

import java.util.ArrayList;
import java.util.List;

import eztravel.rest.enums.hsr.HsrTicketType;
import eztravel.rest.pojo.htl.RoomDescriptionInfo;
import eztravel.rest.pojo.htl.RoomInfo;

/**
 * 房間票種對應.
 * 
 * @author CJWang
 */
public class Room {

  /** 房型. */
  private String roomType;

  /** 成人票數量. */
  private int full;

  /** 銀髮族票數量. */
  private int senior;

  /** 孩童票數量. */
  private int children;

  /** 愛心票數量. */
  private int half;

  /** 房間資訊. */
  private RoomInfo roomInfo;

  /** 房型說明. */
  private RoomDescriptionInfo roomDescriptionInfo;

  /**
   * 取得每一房型所有票種.
   * 
   * @return the hsr ticket type
   */
  public List<HsrTicketType> getHsrTicketType() {
    List<HsrTicketType> hsrTicketTypeList = new ArrayList<HsrTicketType>();

    for (int i = 0; i < this.full; i++) {
      hsrTicketTypeList.add(HsrTicketType.ADULT);
    }
    for (int i = 0; i < this.children; i++) {
      hsrTicketTypeList.add(HsrTicketType.CHILDREN);
    }
    for (int i = 0; i < this.senior; i++) {
      hsrTicketTypeList.add(HsrTicketType.SENIOR);
    }
    for (int i = 0; i < this.half; i++) {
      hsrTicketTypeList.add(HsrTicketType.HEART);
    }

    return hsrTicketTypeList;
  }

  // /**
  // * 去程高鐵成人票資訊
  // */
  // private HsrTicketInfo depAdultTicket;
  // /**
  // * 去程高鐵孩童票資訊
  // */
  // private HsrTicketInfo depChildrenTicket;
  // /**
  // * 去程高鐵資深公民資訊
  // */
  // private HsrTicketInfo depSeniorTicket;
  // /**
  // * 去程高鐵愛心票資訊
  // */
  // private HsrTicketInfo depHeartTicket;
  // /**
  // * 回程高鐵成人票資訊
  // */
  // private HsrTicketInfo rtnAdultTicket;
  // /**
  // * 回程高鐵孩童票資訊
  // */
  // private HsrTicketInfo rtnChildrenTicket;
  // /**
  // * 回程高鐵資深公民資訊
  // */
  // private HsrTicketInfo rtnSeniorTicket;
  // /**
  // * 回程高鐵愛心票資訊
  // */
  // private HsrTicketInfo rtnHeartTicket;

  // /**
  // * 取得原價
  // *
  // * @return 原價
  // */
  // public BigDecimal getSitePrice() {
  // BigDecimal price = null;
  // BigDecimal hsrAdult =
  // this.depAdultTicket.getFullPrice().add(this.rtnAdultTicket.getFullPrice());
  // BigDecimal hsrChildren =
  // this.depChildrenTicket.getFullPrice().add(this.rtnChildrenTicket.getFullPrice());
  // BigDecimal hsrSenior =
  // this.depSeniorTicket.getFullPrice().add(this.rtnSeniorTicket.getFullPrice());
  // BigDecimal hsrHeart =
  // this.depHeartTicket.getFullPrice().add(this.rtnHeartTicket.getFullPrice());
  // BigDecimal priceAdult = hsrAdult.multiply(BigDecimal.valueOf(this.full));
  // BigDecimal priceChildren = hsrChildren.multiply(BigDecimal.valueOf(this.children));
  // BigDecimal priceSenior = hsrSenior.multiply(BigDecimal.valueOf(this.senior));
  // BigDecimal priceHeart = hsrHeart.multiply(BigDecimal.valueOf(this.half));
  // price =
  // priceAdult.add(priceChildren).add(priceSenior).add(priceHeart)
  // .add(this.roomInfo.getSitePrice());
  // if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("原價異常");
  // return price;
  // }

  // /**
  // * 取得組合價
  // *
  // * @return 組合價
  // */
  // public BigDecimal getUnionPrice() {
  // BigDecimal price = null;
  // BigDecimal hsrAdult =
  // this.depAdultTicket.getPackagePrice().add(this.rtnAdultTicket.getPackagePrice());
  // BigDecimal hsrChildren =
  // this.depChildrenTicket.getPackagePrice().add(this.rtnChildrenTicket.getPackagePrice());
  // BigDecimal hsrSenior =
  // this.depSeniorTicket.getPackagePrice().add(this.rtnSeniorTicket.getPackagePrice());
  // BigDecimal hsrHeart =
  // this.depHeartTicket.getPackagePrice().add(this.rtnHeartTicket.getPackagePrice());
  // BigDecimal priceAdult = hsrAdult.multiply(BigDecimal.valueOf(this.full));
  // BigDecimal priceChildren = hsrChildren.multiply(BigDecimal.valueOf(this.children));
  // BigDecimal priceSenior = hsrSenior.multiply(BigDecimal.valueOf(this.senior));
  // BigDecimal priceHeart = hsrHeart.multiply(BigDecimal.valueOf(this.half));
  // price =
  // priceAdult.add(priceChildren).add(priceSenior).add(priceHeart)
  // .add(this.roomInfo.getUnionPrice());
  // if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("組合價異常");
  // return price;
  // }

  // /**
  // * 取得優惠價
  // *
  // * @return 優惠價
  // */
  // public BigDecimal getFavorPrice() {
  // BigDecimal price = null;
  // BigDecimal hsrAdult =
  // this.depAdultTicket.getFinalPrice().add(this.rtnAdultTicket.getFinalPrice());
  // BigDecimal hsrChildren =
  // this.depChildrenTicket.getFinalPrice().add(this.rtnChildrenTicket.getFinalPrice());
  // BigDecimal hsrSenior =
  // this.depSeniorTicket.getFinalPrice().add(this.rtnSeniorTicket.getFinalPrice());
  // BigDecimal hsrHeart =
  // this.depHeartTicket.getFinalPrice().add(this.rtnHeartTicket.getFinalPrice());
  // BigDecimal priceAdult = hsrAdult.multiply(BigDecimal.valueOf(this.full));
  // BigDecimal priceChildren = hsrChildren.multiply(BigDecimal.valueOf(this.children));
  // BigDecimal priceSenior = hsrSenior.multiply(BigDecimal.valueOf(this.senior));
  // BigDecimal priceHeart = hsrHeart.multiply(BigDecimal.valueOf(this.half));
  // price =
  // priceAdult.add(priceChildren).add(priceSenior).add(priceHeart)
  // .add(this.roomInfo.getFavorPrice());
  // if (price.compareTo(BigDecimal.valueOf(0)) <= 0) throw new BusinessException("優惠價異常");
  // return price;
  // }

  /**
   * Gets the full.
   * 
   * @return 成人票數量
   */
  public int getFull() {
    return full;
  }

  /**
   * Sets the full.
   * 
   * @param full 成人票數量
   */
  public void setFull(int full) {
    this.full = full;
  }

  /**
   * Gets the senior.
   * 
   * @return 銀髮族票數量
   */
  public int getSenior() {
    return senior;
  }

  /**
   * Sets the senior.
   * 
   * @param senior 銀髮族票數量
   */
  public void setSenior(int senior) {
    this.senior = senior;
  }

  /**
   * Gets the children.
   * 
   * @return 孩童票數量
   */
  public int getChildren() {
    return children;
  }

  /**
   * Sets the children.
   * 
   * @param children 孩童票數量
   */
  public void setChildren(int children) {
    this.children = children;
  }

  /**
   * Gets the half.
   * 
   * @return 愛心票數量
   */
  public int getHalf() {
    return half;
  }

  /**
   * Sets the half.
   * 
   * @param half 愛心票數量
   */
  public void setHalf(int half) {
    this.half = half;
  }

  /**
   * Gets the room type.
   * 
   * @return 房型
   */
  public String getRoomType() {
    return roomType;
  }

  /**
   * Sets the room type.
   * 
   * @param roomType 房型
   */
  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  /**
   * Gets the room info.
   * 
   * @return 房間資訊
   */
  public RoomInfo getRoomInfo() {
    return roomInfo;
  }

  /**
   * Sets the room info.
   * 
   * @param roomInfo 房間資訊
   */
  public void setRoomInfo(RoomInfo roomInfo) {
    this.roomInfo = roomInfo;
  }

  // /**
  // * @return 去程高鐵成人票資訊
  // */
  // public HsrTicketInfo getDepAdultTicket() {
  // return depAdultTicket;
  // }
  //
  // /**
  // * @param depAdultTicket 去程高鐵成人票資訊
  // */
  // public void setDepAdultTicket(HsrTicketInfo depAdultTicket) {
  // this.depAdultTicket = depAdultTicket;
  // }
  //
  // /**
  // * @return 去程高鐵孩童票資訊
  // */
  // public HsrTicketInfo getDepChildrenTicket() {
  // return depChildrenTicket;
  // }
  //
  // /**
  // * @param depChildrenTicket 去程高鐵孩童票資訊
  // */
  // public void setDepChildrenTicket(HsrTicketInfo depChildrenTicket) {
  // this.depChildrenTicket = depChildrenTicket;
  // }
  //
  // /**
  // * @return 去程高鐵資深公民資訊
  // */
  // public HsrTicketInfo getDepSeniorTicket() {
  // return depSeniorTicket;
  // }
  //
  // /**
  // * @param depSeniorTicket 去程高鐵資深公民資訊
  // */
  // public void setDepSeniorTicket(HsrTicketInfo depSeniorTicket) {
  // this.depSeniorTicket = depSeniorTicket;
  // }
  //
  // /**
  // * @return 去程高鐵愛心票資訊
  // */
  // public HsrTicketInfo getDepHeartTicket() {
  // return depHeartTicket;
  // }
  //
  // /**
  // * @param depHeartTicket 去程高鐵愛心票資訊
  // */
  // public void setDepHeartTicket(HsrTicketInfo depHeartTicket) {
  // this.depHeartTicket = depHeartTicket;
  // }
  //
  // /**
  // * @return 回程高鐵成人票資訊
  // */
  // public HsrTicketInfo getRtnAdultTicket() {
  // return rtnAdultTicket;
  // }
  //
  // /**
  // * @param rtnAdultTicket 回程高鐵成人票資訊
  // */
  // public void setRtnAdultTicket(HsrTicketInfo rtnAdultTicket) {
  // this.rtnAdultTicket = rtnAdultTicket;
  // }
  //
  // /**
  // * @return 回程高鐵孩童票資訊
  // */
  // public HsrTicketInfo getRtnChildrenTicket() {
  // return rtnChildrenTicket;
  // }
  //
  // /**
  // * @param rtnChildrenTicket 回程高鐵孩童票資訊
  // */
  // public void setRtnChildrenTicket(HsrTicketInfo rtnChildrenTicket) {
  // this.rtnChildrenTicket = rtnChildrenTicket;
  // }
  //
  // /**
  // * @return 回程高鐵資深公民資訊
  // */
  // public HsrTicketInfo getRtnSeniorTicket() {
  // return rtnSeniorTicket;
  // }
  //
  // /**
  // * @param rtnSeniorTicket 回程高鐵資深公民資訊
  // */
  // public void setRtnSeniorTicket(HsrTicketInfo rtnSeniorTicket) {
  // this.rtnSeniorTicket = rtnSeniorTicket;
  // }
  //
  // /**
  // * @return 回程高鐵愛心票資訊
  // */
  // public HsrTicketInfo getRtnHeartTicket() {
  // return rtnHeartTicket;
  // }
  //
  // /**
  // * @param rtnHeartTicket 回程高鐵愛心票資訊
  // */
  // public void setRtnHeartTicket(HsrTicketInfo rtnHeartTicket) {
  // this.rtnHeartTicket = rtnHeartTicket;
  // }

  /**
   * Gets the room description info.
   * 
   * @return the roomDescriptionInfo
   */
  public RoomDescriptionInfo getRoomDescriptionInfo() {
    return roomDescriptionInfo;
  }

  /**
   * Sets the room description info.
   * 
   * @param roomDescriptionInfo the roomDescriptionInfo to set
   */
  public void setRoomDescriptionInfo(RoomDescriptionInfo roomDescriptionInfo) {
    this.roomDescriptionInfo = roomDescriptionInfo;
  }
}
