/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: configs
 * @FileName: ServiceConfig.java
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
package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.IdentifyService;
import service.SearchService;
import service.impl.IdentifyServiceImpl;
import service.impl.SearchServiceImpl;
import service.order.CustomerInfoService;
import service.order.FriendService;
import service.order.MemberInfoService;
import service.order.OrderService;
import service.order.impl.CustomerInfoServiceImpl;
import service.order.impl.FriendServiceImpl;
import service.order.impl.MemberInfoServiceImpl;
import service.order.impl.OrderServiceImpl;

/**
 * The Class ServiceConfig.
 * 
 * <pre>
 * 
 * </pre>
 */
@Configuration
public class ServiceConfig {

  /**
   * Search service.
   * 
   * @return the search service
   */
  @Bean
  public SearchService searchService() {
    return new SearchServiceImpl();
  }

  /**
   * Identify service.
   * 
   * @return the identify service
   */
  @Bean
  public IdentifyService identifyService() {
    return new IdentifyServiceImpl();
  }

  /**
   * Member info service.
   * 
   * @return the member info service
   */
  @Bean
  public MemberInfoService memberInfoService() {
    MemberInfoServiceImpl service = new MemberInfoServiceImpl();
    return service;
  }

  /**
   * Friend service.
   * 
   * @return the friend service
   */
  @Bean
  public FriendService friendService() {
    return new FriendServiceImpl();
  }

  /**
   * Order service.
   * 
   * @return the order service
   */
  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl();
  }

  /**
   * Customer info service.
   * 
   * @return the customer info service
   */
  @Bean
  public CustomerInfoService customerInfoService() {
    CustomerInfoService customerInfoService = new CustomerInfoServiceImpl();
    return customerInfoService;
  }

}
