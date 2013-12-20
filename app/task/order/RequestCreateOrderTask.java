/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.order
 * @FileName: RequestCreateOrderTask.java
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
package task.order;

import java.util.ArrayList;
import java.util.List;
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
import eztravel.rest.pojo.order.OrderInfo;
import eztravel.rest.pojo.order.OrderRequest;

/**
 * The Class RequestCreateOrderTask.
 * 
 * <pre>
 * 
 * </pre>
 */
public class RequestCreateOrderTask implements Callable<List<OrderInfo>> {

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/order/";

  /** The Constant ORDER_QRY_URL. */
  private static final String ORDER_QRY_URL = "order/hr1";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestCreateOrderTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The order request. */
  private OrderRequest orderRequest;

  /**
   * Instantiates a new request create order task.
   * 
   * @param restTemplate the rest template
   * @param orderRequest the order request
   */
  public RequestCreateOrderTask(RestTemplate restTemplate, OrderRequest orderRequest) {
    this.restTemplate = restTemplate;
    this.orderRequest = orderRequest;
  }


  // 成立訂單
  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public List<OrderInfo> call() throws Exception {

    String endpoint = null;
    List<OrderInfo> list = new ArrayList<OrderInfo>();

    try {
      endpoint = ConfigFactory.load("config.properties").getString("order.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) {
      endpoint = ENDPOINT;
    }


    ParameterizedTypeReference<RestResource<OrderInfo>> responseType =
        new ParameterizedTypeReference<RestResource<OrderInfo>>() {};

    // 設定 Header、Entity
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<OrderRequest> entity = new HttpEntity<OrderRequest>(orderRequest, headers);

    // 執行 webService
    ResponseEntity<RestResource<OrderInfo>> res =
        restTemplate.exchange(endpoint + ORDER_QRY_URL, HttpMethod.POST, entity, responseType);

    // 只取得資料（key、status不取）
    RestResource<OrderInfo> body = res.getBody();

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
