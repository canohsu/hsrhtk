/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.member
 * @FileName: RequestCustomerInfoByPersonIdTask.java
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

import java.util.ArrayList;
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
import eztravel.rest.pojo.member.CustomerInfo;


/**
 * The Class RequestCustomerInfoByPersonIdTask.
 * 
 * <pre>
 * 
 * </pre>
 */
public class RequestCustomerInfoByPersonIdTask implements Callable<List<CustomerInfo>> {

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/member/";

  /** The Constant HTL_QRY_URL. */
  private static final String HTL_QRY_URL = "member?personId={personId}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory
      .getLogger(RequestCustomerInfoByPersonIdTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The person id. */
  private String personId;

  /**
   * Instantiates a new request customer info by person id task.
   * 
   * @param restTemplate the rest template
   * @param personId the person id
   */
  public RequestCustomerInfoByPersonIdTask(RestTemplate restTemplate, String personId) {
    this.restTemplate = restTemplate;
    this.personId = personId;
  }


  // 使用PersonId取得旅客資料
  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public List<CustomerInfo> call() throws Exception {

    String endpoint = null;
    List<CustomerInfo> list = new ArrayList<CustomerInfo>();

    try {
      endpoint = ConfigFactory.load("config.properties").getString("member.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }

    if (null == endpoint) {
      endpoint = ENDPOINT;
    }

    // 傳遞的變數
    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("personId", this.personId);

    ParameterizedTypeReference<RestResource<CustomerInfo>> responseType =
        new ParameterizedTypeReference<RestResource<CustomerInfo>>() {};
    // 執行 webService
    ResponseEntity<RestResource<CustomerInfo>> res =
        restTemplate.exchange(endpoint + HTL_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    // 只取得資料（key、status不取）
    RestResource<CustomerInfo> body = res.getBody();

    if (null != body) {

      List<RestError> errors = body.getErrors();

      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);

      } else {
        list = body.getItems();
      }

    }

    return list;
  }

}
