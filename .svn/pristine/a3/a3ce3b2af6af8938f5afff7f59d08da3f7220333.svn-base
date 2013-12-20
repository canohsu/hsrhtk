/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.member
 * @FileName: QueryFriendTask.java
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
package task.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;

import com.typesafe.config.ConfigFactory;

import eztravel.rest.pojo.common.RestError;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.member.FriendInfo;

/**
 * 查詢好友.
 * 
 * @author 003084
 */
public class QueryFriendTask implements Callable<List<FriendInfo>> {

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/member/";

  /** The Constant HTL_QRY_URL. */
  private static final String HTL_QRY_URL = "member/{custNo}/friend";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(QueryFriendTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The cust no. */
  private String custNo;

  /**
   * Instantiates a new query friend task.
   * 
   * @param restTemplate the rest template
   * @param custNo the cust no
   */
  public QueryFriendTask(RestTemplate restTemplate, String custNo) {
    this.restTemplate = restTemplate;
    this.custNo = custNo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public List<FriendInfo> call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("member.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("custNo", this.custNo);

    ParameterizedTypeReference<RestResource<FriendInfo>> responseType =
        new ParameterizedTypeReference<RestResource<FriendInfo>>() {};

    ResponseEntity<RestResource<FriendInfo>> res =
        restTemplate.exchange(endpoint + HTL_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);

    RestResource<FriendInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
    }
    return body.getItems();
  }

}
