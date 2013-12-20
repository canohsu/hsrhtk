/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order.impl
 * @FileName: FriendServiceImpl.java
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
package service.order.impl;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import models.pojo.Friend;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import service.order.FriendService;
import task.member.InsFriendTask;
import task.member.QueryFriendTask;
import eztravel.rest.pojo.member.FriendInfo;

/**
 * The Class FriendServiceImpl.
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author CJWang
 */
public class FriendServiceImpl implements FriendService {

  /*
   * (non-Javadoc)
   * 
   * @see service.order.FriendService#addFriend(models.pojo.Friend)
   */
  @Override
  public int addFriend(Friend friend) throws InterruptedException, ExecutionException {
    FriendInfo info = new FriendInfo();
    info.setCustNo(friend.getCustNo());
    info.setNameChnFirst(friend.getNameChnFirst());
    info.setNameChnLast(friend.getNameChnLast());
    if (StringUtils.hasText(friend.getNameEngFirst()))
      info.setNameEngFirst(friend.getNameEngFirst());
    if (StringUtils.hasText(friend.getNameEngLast())) info.setNameEngLast(friend.getNameEngLast());
    info.setSex(friend.getSex());
    Calendar birthday = Calendar.getInstance();
    birthday.setTime(friend.getBirthday());
    info.setBirthday(birthday);
    info.setPersonId(friend.getPersonId());
    Future<Integer> future = this.taskExecutor.submit(new InsFriendTask(this.restTemplate, info));
    int status = future.get();
    return status;
  }

  /*
   * (non-Javadoc)
   * 
   * @see service.order.FriendService#queryFriend(java.lang.String)
   */
  @Override
  public List<FriendInfo> queryFriend(String custNo) throws InterruptedException,
      ExecutionException {

    Future<List<FriendInfo>> future =
        this.taskExecutor.submit(new QueryFriendTask(this.restTemplate, custNo));

    List<FriendInfo> friendInfoList = future.get();
    BeanUtils.copyProperties(friendInfoList, friendInfoList);

    return friendInfoList;
  }


  /** The rest template. */
  @Autowired
  private RestTemplate restTemplate;

  /** The task executor. */
  @Autowired
  private ThreadPoolTaskExecutor taskExecutor;

  /**
   * Gets the rest template.
   * 
   * @return the restTemplate
   */
  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  /**
   * Sets the rest template.
   * 
   * @param restTemplate the restTemplate to set
   */
  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Gets the task executor.
   * 
   * @return the taskExecutor
   */
  public ThreadPoolTaskExecutor getTaskExecutor() {
    return taskExecutor;
  }

  /**
   * Sets the task executor.
   * 
   * @param taskExecutor the taskExecutor to set
   */
  public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }

}
