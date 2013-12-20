/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order
 * @FileName: OrderService.java
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
package service.order;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;

import models.pojo.Order;
import models.pojo.OrderData;
import eztravel.rest.pojo.order.OrderInfo;
import eztravel.rest.pojo.order.OrderRequest;

/**
 * 訂購相關邏輯.
 * 
 * @author CJWang
 */
public interface OrderService {

  /**
   * 取得訂單資訊.
   * 
   * @param order 查詢條件
   * @return 訂單資訊
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public Order getOrderInfo(Order order) throws InterruptedException, ExecutionException;

  /**
   * 取得訂單資訊.
   * 
   * @param orderNo 訂單編號
   * @return 訂單資訊
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   * @throws ParseException the parse exception
   */
  public Order getOrderInfo(String orderNo) throws InterruptedException, ExecutionException,
      ParseException;

  /**
   * 寫入訂單.
   * 
   * @param orderRequest the order request
   * @param orderData the order data
   * @param order the order
   * @return the order info
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public OrderInfo createOrder(OrderRequest orderRequest, OrderData orderData, Order order)
      throws InterruptedException, ExecutionException;

}
