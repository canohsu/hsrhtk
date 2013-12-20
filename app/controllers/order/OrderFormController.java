/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: OrderFormController.java
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
package controllers.order;

import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

import java.util.List;

import models.enums.BusinessType;
import models.pojo.Customer;
import models.pojo.Member;
import models.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import service.order.CustomerInfoService;
import service.order.FriendService;
import service.order.OrderService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.AuthenticateAction;
import actions.LogAction;
import context.SecurityContext;
import eztravel.rest.pojo.member.FriendInfo;

/**
 * 填寫訂購資料.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class OrderFormController {

  /**
   * 填寫訂購資料.
   * 
   * @return the result
   */
  @With(AuthenticateAction.class)
  public Result fillOrderForm() {
    try {
      Form<Order> orderForm = form(Order.class);
      Order order = orderForm.bindFromRequest().get();
      order.setUser(SecurityContext.getCurrentUser());
      order = this.orderService.getOrderInfo(order);

      Member member = new Member();

      String personId = order.getUser().getLoginId().toUpperCase();
      List<Customer> customerList = null;
      Customer customer = new Customer();
      // 非客服人員，才查詢旅客資料
      if (!order.getUser().getBusinessType().equals(BusinessType.WEBORDER)) {
        customerList = customerInfoService.listCustomer(personId);
        customer = customerList.get(0);
      }

      String ip = request().remoteAddress();
      order.getUser().setIp(ip);

      List<FriendInfo> friendInfoList = friendService.queryFriend(customer.getCustNo());
      customer.setFriendInfoList(friendInfoList);

      return ok(views.html.order.order.render(order, member, customer));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok(views.html.fail.render("載入訂購明細失敗"));
    }
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(OrderFormController.class);

  /** The order service. */
  @Autowired
  private OrderService orderService;

  /** The customer info service. */
  @Autowired
  private CustomerInfoService customerInfoService;
  @Autowired
  private FriendService friendService;

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
