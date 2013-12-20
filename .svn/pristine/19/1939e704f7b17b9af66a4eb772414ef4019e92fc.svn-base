/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.htl
 * @FileName: RequestRoomDescTask.java
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
package task.htl;

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
import eztravel.rest.pojo.htl.RoomDescriptionInfo;


/**
 * 飯店房型查詢.
 * 
 * @author CJWang
 */
public class RequestRoomDescTask implements Callable<RoomDescriptionInfo> {

  /**
   * 飯店房型查詢.
   * 
   * @param restTemplate the rest template
   * @param hotelNo 飯店代碼
   * @param roomNo 房型代碼
   */
  public RequestRoomDescTask(RestTemplate restTemplate, String hotelNo, String roomNo) {
    this.restTemplate = restTemplate;
    this.hotelNo = hotelNo;
    this.roomNo = roomNo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public RoomDescriptionInfo call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("htl.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("hotelNo", this.hotelNo);
    uriVariables.put("roomNo", this.roomNo);

    ParameterizedTypeReference<RestResource<RoomDescriptionInfo>> responseType =
        new ParameterizedTypeReference<RestResource<RoomDescriptionInfo>>() {};

    logger.info("查詢飯店房型");
    Date before = new Date();
    ResponseEntity<RestResource<RoomDescriptionInfo>> res =
        restTemplate.exchange(endpoint + ROOM_DESC_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    logger.info("查詢飯店房型結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<RoomDescriptionInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
    }
    return body.getItems().get(0);
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/htl/";

  /** The Constant ROOM_DESC_QRY_URL. */
  private static final String ROOM_DESC_QRY_URL = "hotel/{hotelNo}/room/{roomNo}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestRoomDescTask.class);

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The hotel no. */
  private String hotelNo;

  /** The room no. */
  private String roomNo;
}
