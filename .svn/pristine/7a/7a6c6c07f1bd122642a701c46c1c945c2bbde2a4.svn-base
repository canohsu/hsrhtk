/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order.impl
 * @FileName: CustomerInfoServiceImpl.java
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
package service.order.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import models.pojo.Customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import service.order.CustomerInfoService;
import task.member.RequestCustomerInfoByPersonIdTask;
import eztravel.rest.pojo.member.CustomerInfo;

/**
 * The Class CustomerInfoServiceImpl.
 * 
 * <pre>
 * 
 * </pre>
 */
public class CustomerInfoServiceImpl implements CustomerInfoService {

  /** The rest template. */
  @Autowired
  private RestTemplate restTemplate;

  /** The task executor. */
  @Autowired
  private ThreadPoolTaskExecutor taskExecutor;

  /**
   * Gets the rest template.
   * 
   * @return the rest template
   */
  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  /**
   * Sets the rest template.
   * 
   * @param restTemplate the new rest template
   */
  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Gets the task executor.
   * 
   * @return the task executor
   */
  public ThreadPoolTaskExecutor getTaskExecutor() {
    return taskExecutor;
  }

  /**
   * Sets the task executor.
   * 
   * @param taskExecutor the new task executor
   */
  public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }


  // 依身份證查詢旅客資料（填寫住宿旅客代表人使用）
  /*
   * (non-Javadoc)
   * 
   * @see service.order.CustomerInfoService#listCustomer(java.lang.String)
   */
  @Override
  public List<Customer> listCustomer(String personId) throws InterruptedException,
      ExecutionException {

    List<Customer> customerList = new ArrayList<Customer>();

    // 從 webService 取得的資料
    Future<List<CustomerInfo>> result =
        this.taskExecutor
            .submit(new RequestCustomerInfoByPersonIdTask(this.restTemplate, personId));
    List<CustomerInfo> customerInfoList = result.get();

    // 將上述資料（CustomerInfo），轉換為 Customer 後傳出
    if (null != customerInfoList) {

      for (CustomerInfo customerInfo : customerInfoList) {
        Customer customer = new Customer();

        BeanUtils.copyProperties(customerInfo, customer);
        customer.setCustType("EC會員");

        customerList.add(customer);
      }
    }

    return customerList;
  }

}
