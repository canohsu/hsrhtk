/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: CreateOrderController.java
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
package controllers.order;

import static play.data.Form.form;
import static play.mvc.Results.ok;
import models.pojo.Order;
import models.pojo.OrderData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import service.order.CustomerInfoService;
import service.order.OrderService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.LogAction;
import eztravel.rest.pojo.order.OrderInfo;
import eztravel.rest.pojo.order.OrderRequest;

/**
 * The Class CreateOrderController.
 * 
 * <pre>
 * 
 * </pre>
 */
@With(LogAction.class)
@Controller
public class CreateOrderController {

  /** The order service. */
  @Autowired
  private OrderService orderService;

  /** The customer info service. */
  @Autowired
  private CustomerInfoService customerInfoService;

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(OrderFormController.class);


  /**
   * Creates the order.
   * 
   * @return the result
   */
  public Result createOrder() {
    try {
      /*
       * 寫入訂單步驟： 1. 先利用 .bindFromRequest()，得到大部分的 OrderRequest 資訊 2.
       * 手動存入無法「自動轉換」或「需重算」的資訊（如生日、高鐵票價數量）
       * 
       * 變數說明： 1. OrderRequest：由填寫訂購頁（order.scala.html）的 tag 自動轉換而來 2. OrderData：無法自動轉換成
       * OrderRequest 的變數（ex.生日） 3. Order：訂購明細共用模板（orderDetail.scala.html）上的 tag，利用此變數查詢高鐵、飯店資訊
       */

      // 1. OrderRequest
      Form<OrderRequest> createOrderForm = form(OrderRequest.class);
      OrderRequest orderRequest = createOrderForm.bindFromRequest().get();

      // 2. OrderData
      Form<OrderData> orderDataForm = form(OrderData.class);
      OrderData orderData = orderDataForm.bindFromRequest().get();

      // 3. Order
      Form<Order> orderForm = form(Order.class);
      Order order = orderForm.bindFromRequest().get();

      OrderInfo orderInfo = orderService.createOrder(orderRequest, orderData, order);

      // 轉至 payment 參數準備
      String orderNo = orderInfo.getOrderNo();
      String custNo = orderRequest.getCustomerInfo().getCustNo();
      String sessionId = order.getUser().getSessionId();

      return ok(views.html.order.paymentBuffer.render(orderNo, custNo, sessionId));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok(views.html.fail.render("新增訂單失敗"));
    }
  }


}
