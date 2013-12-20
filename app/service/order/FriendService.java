/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order
 * @FileName: FriendService.java
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
package service.order;

import java.util.List;
import java.util.concurrent.ExecutionException;

import models.pojo.Friend;
import eztravel.rest.pojo.member.FriendInfo;

/**
 * The Interface FriendService.
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author CJWang
 */
public interface FriendService {

  /**
   * 加入好友.
   * 
   * @param friend the friend
   * @return status 200 表示成功
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public int addFriend(Friend friend) throws InterruptedException, ExecutionException;

  /**
   * 查詢好友.
   * 
   * @param custNo the cust no
   * @return the list
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public List<FriendInfo> queryFriend(String custNo) throws InterruptedException,
      ExecutionException;
}
