/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.hrs
 * @FileName: RequestHsrByTrainNoTask.java
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
package task.hrs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import eztravel.rest.enums.common.FareType;
import eztravel.rest.enums.hsr.HsrCarClass;
import eztravel.rest.enums.hsr.HsrStation;
import eztravel.rest.pojo.common.RestError;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.hsr.HsrProductInfo;


/**
 * 查詢高鐵資訊.
 * 
 * @author CJWang
 */
public class RequestHsrByTrainNoTask implements Callable<List<HsrProductInfo>> {

  /**
   * 查詢高鐵資訊.
   * 
   * @param restTemplate the rest template
   * @param from 起站
   * @param to 迄站
   * @param date 出發日期
   * @param ticketQty 車票張數
   * @param fareType the fare type
   * @param carClass 車廂等級
   * @param loginId the login id
   * @param trainNo 車次
   */
  public RequestHsrByTrainNoTask(RestTemplate restTemplate, HsrStation from, HsrStation to,
      Date date, int ticketQty, FareType fareType, HsrCarClass carClass, String loginId,
      String trainNo) {
    this.restTemplate = restTemplate;
    this.from = from;
    this.to = to;
    this.date = date;
    this.ticketQty = ticketQty;
    this.fareType = fareType;
    this.carClass = carClass;
    this.loginId = loginId;
    this.trainNo = trainNo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public List<HsrProductInfo> call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("hsr.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;
    List<HsrProductInfo> list = null;

    // hsr日期格式為yyyyMMdd
    String dateStr = null;
    if (null != date) dateStr = dateFormat.format(date);

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("from", this.from);
    uriVariables.put("to", this.to);
    uriVariables.put("date", dateStr);
    uriVariables.put("ticketQty", this.ticketQty);
    uriVariables.put("fareType", this.fareType);
    uriVariables.put("carClass", this.carClass);
    uriVariables.put("loginId", this.loginId);
    uriVariables.put("cond1Type", this.trainNo);

    ParameterizedTypeReference<RestResource<HsrProductInfo>> responseType =
        new ParameterizedTypeReference<RestResource<HsrProductInfo>>() {};

    logger.info("查詢高鐵資訊");
    Date before = new Date();
    ResponseEntity<RestResource<HsrProductInfo>> res =
        restTemplate.exchange(endpoint + PROD_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    logger.info("查詢高鐵資訊結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<HsrProductInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
      list = body.getItems();
    }
    return list;
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/hsr/";

  /** The Constant PROD_QRY_URL. */
  private static final String PROD_QRY_URL =
      "hsrProducts/{cond1Type}?from={from}&to={to}&date={date}&ticketQty={ticketQty}&fareType={fareType}&hsrCarClass={carClass}&loginId={loginId}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestHsrByTrainNoTask.class);

  /** The date format. */
  private final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The from. */
  private HsrStation from;

  /** The to. */
  private HsrStation to;

  /** The date. */
  private Date date;

  /** The ticket qty. */
  private int ticketQty;

  /** The fare type. */
  private FareType fareType;

  /** The car class. */
  private HsrCarClass carClass;

  /** The login id. */
  private String loginId;

  /** The train no. */
  private String trainNo;
}
