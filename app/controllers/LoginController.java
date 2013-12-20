/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers
 * @FileName: LoginController.java
 * @author: tonywang
 * @date: 2013/12/15, 下午 03:39:19
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
package controllers;

import static play.data.Form.form;
import static play.mvc.Results.ok;
import models.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import service.order.OrderService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.IdentifyAction;
import actions.LogAction;
import context.SecurityContext;

/**
 * The Class LoginController.
 * 
 * <pre>
 * 
 * </pre>
 */
@With(LogAction.class)
@Controller
public class LoginController {

  /**
   * Login.
   * 
   * @return the result
   */
  @With(IdentifyAction.class)
  public Result login() {
    try {
      Form<Order> orderForm = form(Order.class);
      Order order = orderForm.bindFromRequest().get();
      order.setUser(SecurityContext.getCurrentUser());
      order = this.orderService.getOrderInfo(order);
      return ok(views.html.order.login.render(order));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok(views.html.fail.render("載入訂購明細失敗"));
    }
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

  /** The order service. */
  @Autowired
  private OrderService orderService;

  /**
   * Gets the order service.
   * 
   * @return the orderService
   */
  public OrderService getOrderService() {
    return orderService;
  }

  /**
   * Sets the order service.
   * 
   * @param orderService the orderService to set
   */
  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }
}
