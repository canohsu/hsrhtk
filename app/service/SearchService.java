/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service
 * @FileName: SearchService.java
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
package service;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;

import models.pojo.HsrHtl;
import models.pojo.Page;
import eztravel.rest.pojo.htl.RoomDescriptionInfo;

/**
 * 高鐵+酒店查詢.
 * 
 * @author 003050
 */
public interface SearchService {

  /**
   * 查詢高鐵+酒店組合.
   * 
   * @param hsrHtl 查詢條件
   * @param page 分頁資訊
   * @return the hsr htl
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   * @throws ParseException the parse exception
   */
  public HsrHtl search(HsrHtl hsrHtl, Page page) throws InterruptedException, ExecutionException,
      ParseException;

  /**
   * 查詢房型說明.
   * 
   * @param hotelNo 飯店編號(商品代號)
   * @param roomNo 房型編號
   * @return the room desc
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public RoomDescriptionInfo getRoomDesc(String hotelNo, String roomNo)
      throws InterruptedException, ExecutionException;
}
