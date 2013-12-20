/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order.impl
 * @FileName: MemberInfoServiceImpl.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import models.pojo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import service.order.MemberInfoService;
import task.member.RequestCustomerByPersonIdTask;
import eztravel.rest.pojo.member.PersonInfo;

/**
 * The Class MemberInfoServiceImpl.
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author CJWang
 */
public class MemberInfoServiceImpl implements MemberInfoService {

  /*
   * (non-Javadoc)
   * 
   * @see service.order.MemberInfoService#listMember(java.lang.String)
   */
  @Override
  public List<Member> listMember(String personId) throws InterruptedException, ExecutionException {
    List<Member> memlist = new ArrayList<Member>();
    Future<List<PersonInfo>> result =
        this.taskExecutor.submit(new RequestCustomerByPersonIdTask(this.restTemplate, personId));
    List<PersonInfo> personlist = result.get();
    if (null != personlist) {
      for (PersonInfo person : personlist) {
        Member member = new Member();
        member.setCustNo(person.getCustNo());
        member.setCustType(person.getCustType());
        member.setNameChnLast(person.getName());
        member.setSex(person.getSex());
        member.setPersonId(person.getPersonId());
        member.setNationality(person.getNationality());
        member.setZip(person.getZipCdCon());
        member.setAddress(person.getAddrCont());
        member.setTelAreaDay(person.getTelContAreaDay());
        member.setTelDay(person.getTelContDay());
        member.setTelExDay(person.getTelContExDay());
        member.setTelMobile(person.getTelMobile());
        member.setEmail1(person.getEmail());
        memlist.add(member);
      }
    }
    return memlist;
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
