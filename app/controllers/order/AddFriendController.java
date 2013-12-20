/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers.order
 * @FileName: AddFriendController.java
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

import java.net.URLDecoder;

import models.pojo.Friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import service.order.FriendService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.LogAction;

/**
 * 加入好友名單.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class AddFriendController {

  /**
   * 加入好友名單.
   * 
   * @return the result
   */
  public Result addFriend() {
    try {
      Form<Friend> friendForm = form(Friend.class);
      Friend friend = friendForm.bindFromRequest().get();
      friend.setCustNo(URLDecoder.decode(friend.getCustNo(), "UTF-8"));
      friend.setNameChnFirst(URLDecoder.decode(friend.getNameChnFirst(), "UTF-8"));
      friend.setNameChnLast(URLDecoder.decode(friend.getNameChnLast(), "UTF-8"));
      friend.setNameEngFirst(URLDecoder.decode(friend.getNameEngFirst(), "UTF-8"));
      friend.setNameEngLast(URLDecoder.decode(friend.getNameEngLast(), "UTF-8"));
      friend.setPersonId(URLDecoder.decode(friend.getPersonId(), "UTF-8"));
      int result = this.friendService.addFriend(friend);
      if (result == 200)
        return ok("好友名單新增資料完成");
      else
        return ok("好友名單新增失敗");
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok("好友名單新增失敗");
    }
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AddFriendController.class);

  /** The friend service. */
  @Autowired
  private FriendService friendService;

  /**
   * Gets the friend service.
   * 
   * @return the friendService
   */
  public FriendService getFriendService() {
    return friendService;
  }

  /**
   * Sets the friend service.
   * 
   * @param friendService the friendService to set
   */
  public void setFriendService(FriendService friendService) {
    this.friendService = friendService;
  }
}
