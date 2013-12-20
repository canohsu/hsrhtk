/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.order
 * @FileName: RequestOrderTask.java
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
package task.order;

import java.util.Date;
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
import eztravel.rest.pojo.order.OrderInfo;


/**
 * 訂單查詢.
 * 
 * @author CJWang
 */
public class RequestOrderTask implements Callable<OrderInfo> {

  /**
   * 訂單查詢.
   * 
   * @param restTemplate the rest template
   * @param orderNo 訂單編號
   */
  public RequestOrderTask(RestTemplate restTemplate, String orderNo) {
    this.restTemplate = restTemplate;
    this.orderNo = orderNo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public OrderInfo call() throws Exception {
    String endpoint = null;
    List<OrderInfo> list = null;
    OrderInfo info = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("order.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("orderNo", this.orderNo);

    ParameterizedTypeReference<RestResource<OrderInfo>> responseType =
        new ParameterizedTypeReference<RestResource<OrderInfo>>() {};

    logger.info("訂單查詢");
    Date before = new Date();
    ResponseEntity<RestResource<OrderInfo>> res =
        restTemplate.exchange(endpoint + ORD_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    logger.info("訂單查詢結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<OrderInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      } else {
        list = body.getItems();
        if (null != list && list.size() > 0) info = list.get(0);
      }
    }
    return info;
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/order/";

  /** The Constant ORD_QRY_URL. */
  private static final String ORD_QRY_URL = "order/{orderNo}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestOrderTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The order no. */
  private String orderNo;
}
