/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: task.htl
 * @FileName: RequestHotelTask.java
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
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;

import com.typesafe.config.ConfigFactory;

import eztravel.rest.pojo.common.RestError;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.htl.HotelInfo;


/**
 * 查詢飯店資訊.
 * 
 * @author CJWang
 */
public class RequestHotelTask implements Callable<RestResource<HotelInfo>> {

  /**
   * 查詢飯店資訊.
   * 
   * @param restTemplate the rest template
   * @param city 城市代碼
   * @param hotelNo 飯店編號(商品代號)
   * @param checkInDt 入住日
   * @param checkOutDt 退房日
   * @param sgl 單人房間數
   * @param twn 雙人房間數
   * @param trp 三人房間數
   * @param qud 四人房間數
   * @param loginId 登入帳號/cust_no 目前僅B2E需要
   * @param custType 客戶類別
   * @param startIndex 分頁起始位置
   * @param maxResults 每頁筆數
   * @param rankBy 排序
   */
  public RequestHotelTask(RestTemplate restTemplate, String city, String hotelNo, Date checkInDt,
      Date checkOutDt, int sgl, int twn, int trp, int qud, String loginId, String custType,
      int startIndex, int maxResults, String rankBy) {
    this.restTemplate = restTemplate;
    this.city = city;
    this.hotelNo = hotelNo;
    this.checkInDt = checkInDt;
    this.checkOutDt = checkOutDt;
    this.sgl = sgl;
    this.twn = twn;
    this.trp = trp;
    this.qud = qud;
    this.loginId = loginId;
    this.custType = custType;
    this.startIndex = startIndex;
    this.maxResults = maxResults;
    this.rankBy = rankBy;
  }

  /**
   * 查詢飯店資訊.
   * 
   * @param restTemplate the rest template
   * @param city 城市代碼
   * @param hotelNo 飯店編號(商品代號)
   * @param checkInDt 入住日
   * @param checkOutDt 退房日
   * @param sgl 單人房間數
   * @param twn 雙人房間數
   * @param trp 三人房間數
   * @param qud 四人房間數
   * @param loginId 登入帳號/cust_no 目前僅B2E需要
   * @param custType 客戶類別
   */
  public RequestHotelTask(RestTemplate restTemplate, String city, String hotelNo, Date checkInDt,
      Date checkOutDt, int sgl, int twn, int trp, int qud, String loginId, String custType) {
    this.restTemplate = restTemplate;
    this.city = city;
    this.hotelNo = hotelNo;
    this.checkInDt = checkInDt;
    this.checkOutDt = checkOutDt;
    this.sgl = sgl;
    this.twn = twn;
    this.trp = trp;
    this.qud = qud;
    this.loginId = loginId;
    this.custType = custType;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public RestResource<HotelInfo> call() throws Exception {
    String endpoint = null;
    try {
      endpoint = ConfigFactory.load("config.properties").getString("htl.endpoint");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
    if (null == endpoint) endpoint = ENDPOINT;

    // htl日期格式為yyyyMMdd
    String checkInDtStr = null;
    String checkOutDtStr = null;
    if (null != checkInDt) checkInDtStr = dateFormat.format(checkInDt);
    if (null != checkOutDt) checkOutDtStr = dateFormat.format(checkOutDt);

    Map<String, Object> uriVariables = new HashMap<String, Object>();
    uriVariables.put("city", this.city);
    uriVariables.put("hotelNo", StringUtils.hasText(this.hotelNo) ? this.hotelNo : "");
    uriVariables.put("checkInDt", checkInDtStr);
    uriVariables.put("checkOutDt", checkOutDtStr);
    uriVariables.put("country", "TW");
    uriVariables.put("unionType", "HR1");
    uriVariables.put("sgl", this.sgl);
    uriVariables.put("twn", this.twn);
    uriVariables.put("trp", this.trp);
    uriVariables.put("qud", this.qud);
    uriVariables.put("loginId", StringUtils.hasText(this.loginId) ? this.loginId : "");
    uriVariables.put("custType", this.custType);
    uriVariables.put("startIndex", this.startIndex > 0 ? this.startIndex : "");
    uriVariables.put("maxResults", this.maxResults > 0 ? this.maxResults : "");
    uriVariables.put("rankBy", StringUtils.hasText(this.rankBy) ? this.rankBy : "");

    ParameterizedTypeReference<RestResource<HotelInfo>> responseType =
        new ParameterizedTypeReference<RestResource<HotelInfo>>() {};

    logger.info("查詢飯店資訊");
    Date before = new Date();
    ResponseEntity<RestResource<HotelInfo>> res =
        restTemplate.exchange(endpoint + HTL_QRY_URL, HttpMethod.GET, null, responseType,
            uriVariables);
    logger.info("查詢飯店資訊結束，共花費{}ms", new Date().getTime() - before.getTime());

    RestResource<HotelInfo> body = res.getBody();
    if (null != body) {
      List<RestError> errors = body.getErrors();
      if (null != errors) {
        for (RestError error : errors)
          logger.error(error.getMessage(), error);
      }
    }
    return body;
  }

  /** The Constant ENDPOINT. */
  private static final String ENDPOINT = "http://localhost:8080/htl/";

  /** The Constant HTL_QRY_URL. */
  private static final String HTL_QRY_URL =
      "hotel?city={city}&hotelNo={hotelNo}&checkInDt={checkInDt}&checkOutDt={checkOutDt}&country={country}&unionType={unionType}&sgl={sgl}&twn={twn}&trp={trp}&qud={qud}&loginId={loginId}&custType={custType}&startIndex={startIndex}&maxResults={maxResults}&rankBy={rankBy}";

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(RequestHotelTask.class);

  /** The date format. */
  private final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  /** The rest template. */
  private RestTemplate restTemplate;

  /** The city. */
  private String city;

  /** The hotel no. */
  private String hotelNo;

  /** The check in dt. */
  private Date checkInDt;

  /** The check out dt. */
  private Date checkOutDt;

  /** The sgl. */
  private int sgl;

  /** The twn. */
  private int twn;

  /** The trp. */
  private int trp;

  /** The qud. */
  private int qud;

  /** The login id. */
  private String loginId;

  /** The cust type. */
  private String custType;

  /** The start index. */
  private int startIndex;

  /** The max results. */
  private int maxResults;

  /** The rank by. */
  private String rankBy;
}
