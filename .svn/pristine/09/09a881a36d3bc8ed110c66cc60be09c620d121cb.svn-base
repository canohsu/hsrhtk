/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.member
 * @FileName: InsFriendTask.java
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
package task.member;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;

import com.typesafe.config.ConfigFactory;

import eztravel.rest.pojo.common.RestError;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.member.FriendInfo;


/**
 * 加入好友名單.
 * 
 * @author CJWang
 */
public class InsFriendTask implements Callable<Integer> {

  /**
   * 加入好友名單.
   * 
   * @param restTemplate the rest template
   * @param friendInfo the friend info
   */
  public InsFriendTask(RestTemplate restTemplate, FriendInfo friendInfo) {
    this.restTemplate = restTemplate;
    this.friendInfo = friendInfo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public Integer call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("member.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("custNo", this.friendInfo.getCustNo());

    ParameterizedTypeReference<RestResource<FriendInfo>> responseType =
        new ParameterizedTypeReference<RestResource<FriendInfo>>() {};

    logger.info("加入好友名單");
    Date before = new Date();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    ResponseEntity<RestResource<FriendInfo>> res =
        restTemplate.exchange(endpoint + HTL_QRY_URL, HttpMethod.POST, new HttpEntity<FriendInfo>(
            this.friendInfo, headers), responseType, uriVariables);
    logger.info("加入好友名單結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<FriendInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
    }
    return body.getStatus();
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/member/";

  /** The Constant HTL_QRY_URL. */
  private static final String HTL_QRY_URL = "member/{custNo}/friend";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(InsFriendTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The friend info. */
  private FriendInfo friendInfo;
}
