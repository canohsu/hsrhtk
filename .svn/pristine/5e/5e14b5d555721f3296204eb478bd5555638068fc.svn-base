/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: MemberInfoController.java
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
import models.pojo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.mvc.Result;
import play.mvc.With;
import service.order.MemberInfoService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.IdentifyAction;
import actions.LogAction;
import context.SecurityContext;

/**
 * EC會員查詢.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class MemberInfoController {

  /**
   * 查詢會員資訊.
   * 
   * @param personId the person id
   * @return the member info
   */
  @With(IdentifyAction.class)
  public Result getMemberInfo(String personId) {
    if (BusinessType.WEBORDER != SecurityContext.getCurrentUser().getBusinessType())
      return unauthorized("未授權存取");
    List<Member> list = null;
    try {
      list = this.memberInfoService.listMember(personId);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ok(views.html.order.customerSearchEC.render(list));
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class);

  /** The member info service. */
  @Autowired
  private MemberInfoService memberInfoService;

  /**
   * Gets the member info service.
   * 
   * @return the memberInfoService
   */
  public MemberInfoService getMemberInfoService() {
    return memberInfoService;
  }

  /**
   * Sets the member info service.
   * 
   * @param memberInfoService the memberInfoService to set
   */
  public void setMemberInfoService(MemberInfoService memberInfoService) {
    this.memberInfoService = memberInfoService;
  }
}
