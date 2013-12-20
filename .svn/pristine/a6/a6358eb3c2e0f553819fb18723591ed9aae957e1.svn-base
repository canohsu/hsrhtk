/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: CustomerInfoController.java
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

import static play.mvc.Results.ok;
import static play.mvc.Results.unauthorized;

import java.util.List;

import models.enums.BusinessType;
import models.pojo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.mvc.Result;
import play.mvc.With;
import service.order.CustomerInfoService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.IdentifyAction;
import actions.LogAction;
import context.SecurityContext;


/**
 * The Class CustomerInfoController.
 * 
 * <pre>
 * 
 * </pre>
 */
@With(LogAction.class)
@Controller
public class CustomerInfoController {

  /** The customer info service. */
  @Autowired
  private CustomerInfoService customerInfoService;

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(CustomerInfoController.class);


  // 查詢會員資訊（填寫住宿旅客代表人使用）
  /**
   * Gets the customer info.
   * 
   * @param personId the person id
   * @param index the index
   * @return the customer info
   */
  @With(IdentifyAction.class)
  public Result getCustomerInfo(String personId, String index) {
    if (BusinessType.WEBORDER != SecurityContext.getCurrentUser().getBusinessType()) {
      return unauthorized("未授權存取");
    }
    List<Customer> list = null;
    try {
      list = this.customerInfoService.listCustomer(personId);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ok(views.html.order.customerSearch.render(list, index));
  }



}
