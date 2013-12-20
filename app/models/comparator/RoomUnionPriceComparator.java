/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: models.comparator
 * @FileName: RoomUnionPriceComparator.java
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
package models.comparator;

import java.util.Comparator;

import eztravel.rest.pojo.htl.RoomInfo;

/**
 * 比較房型組合價.
 * 
 * @author CJWang
 */
public class RoomUnionPriceComparator implements Comparator<RoomInfo> {

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(RoomInfo room1, RoomInfo room2) {
    if (null == room1 || null == room2) return 0;
    return room1.getUnionPrice().compareTo(room2.getUnionPrice());
  }

}
