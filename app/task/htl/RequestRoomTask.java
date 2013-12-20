/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.htl
 * @FileName: RequestRoomTask.java
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
package task.htl;

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

import eztravel.rest.pojo.common.RestError;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.htl.RoomInfo;


/**
 * 飯店房型查詢.
 * 
 * @author CJWang
 */
public class RequestRoomTask implements Callable<List<RoomInfo>> {

  /**
   * 飯店房型查詢.
   * 
   * @param restTemplate the rest template
   * @param hotelNo 飯店代碼
   * @param checkInDt 入住日
   * @param checkOutDt 退房日
   * @param loginId 登入帳號/cust_no 目前僅B2E需要
   * @param custType 客戶類別
   */
  public RequestRoomTask(RestTemplate restTemplate, String hotelNo, Date checkInDt,
      Date checkOutDt, String loginId, String custType) {
    this.restTemplate = restTemplate;
    this.hotelNo = hotelNo;
    this.checkInDt = checkInDt;
    this.checkOutDt = checkOutDt;
    this.loginId = loginId;
    this.custType = custType;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public List<RoomInfo> call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("htl.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("hotelNo", this.hotelNo);
    uriVariables.put("checkInDt", dateFormat.format(this.checkInDt));
    uriVariables.put("checkOutDt", dateFormat.format(this.checkOutDt));
    uriVariables.put("country", "TW");
    uriVariables.put("unionType", "HR1");
    uriVariables.put("loginId", this.loginId);
    uriVariables.put("custType", this.custType);

    ParameterizedTypeReference<RestResource<RoomInfo>> responseType =
        new ParameterizedTypeReference<RestResource<RoomInfo>>() {};

    logger.info("查詢飯店房型");
    Date before = new Date();
    ResponseEntity<RestResource<RoomInfo>> res =
        restTemplate.exchange(endpoint + ROOM_DESC_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    logger.info("查詢飯店房型結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<RoomInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
    }
    return body.getItems();
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/htl/";

  /** The Constant ROOM_DESC_QRY_URL. */
  private static final String ROOM_DESC_QRY_URL =
      "hotel/{hotelNo}/room?checkInDt={checkInDt}&checkOutDt={checkOutDt}&country={country}&unionType={unionType}&loginId={loginId}&custType={custType}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestRoomTask.class);

  /** The date format. */
  private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The hotel no. */
  private String hotelNo;

  /** The check in dt. */
  private Date checkInDt;

  /** The check out dt. */
  private Date checkOutDt;

  /** The login id. */
  private String loginId;

  /** The cust type. */
  private String custType;
}
