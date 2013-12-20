/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: SnapshotController.java
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
package controllers.order;

import static play.mvc.Results.ok;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import models.enums.BusinessType;
import models.pojo.Order;
import models.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.Logger;
import play.mvc.Result;
import play.mvc.With;
import service.order.OrderService;
import views.html.order.snapshot;
import actions.LogAction;
import eztravel.rest.enums.hsr.HsrTicketType;
import eztravel.rest.pojo.hsr.HsrTicketInfo;

/**
 * 快照.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class SnapshotController {

  /**
   * 快照.
   * 
   * @param orderNo the order no
   * @return the result
   */
  public Result snapshot(String orderNo) {
    try {
      Order order = this.orderService.getOrderInfo(orderNo);
      BigDecimal price = BigDecimal.valueOf(100000);
      HsrTicketInfo htinfo = new HsrTicketInfo();
      htinfo.setFullPrice(price);
      htinfo.setPackagePrice(price);
      htinfo.setFinalPrice(price);
      Map<HsrTicketType, HsrTicketInfo> tkts = new HashMap<HsrTicketType, HsrTicketInfo>();
      tkts.put(HsrTicketType.ADULT, htinfo);
      tkts.put(HsrTicketType.CHILDREN, htinfo);
      tkts.put(HsrTicketType.SENIOR, htinfo);
      tkts.put(HsrTicketType.HEART, htinfo);
      User user = new User();
      user.setBusinessType(BusinessType.B2C);
      order.setDepTicket(tkts);
      order.setReturnTicket(tkts);
      order.setUser(user);
      return ok(snapshot.render(order));
    } catch (Exception e) {
      Logger.error(e.getMessage(), e);
      // 20131206 經過Mars討論，快照異常時吐空白頁面
      return ok("");
    }
  }

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
