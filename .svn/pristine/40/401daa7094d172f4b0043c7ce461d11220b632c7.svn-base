/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers
 * @FileName: RoomDescController.java
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
package controllers;

import static play.mvc.Results.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.mvc.Result;
import play.mvc.With;
import service.SearchService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.LogAction;
import eztravel.rest.pojo.htl.RoomDescriptionInfo;

/**
 * 房型說明.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class RoomDescController {

  /**
   * 房型說明.
   * 
   * @param hotelNo 飯店編號(商品代號)
   * @param roomNo 房型編號
   * @return the room desc
   */
  public Result getRoomDesc(String hotelNo, String roomNo) {
    try {
      RoomDescriptionInfo info = this.searchService.getRoomDesc(hotelNo, roomNo);
      return ok(views.html.search.searchRoomDesc.render(info));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok("查無房型資訊");
    }
  }

  /** The logger. */
  private static Logger logger = LoggerFactory.getLogger(RoomDescController.class);

  /** The search service. */
  @Autowired
  private SearchService searchService;

  /**
   * Gets the search service.
   * 
   * @return the search service
   */
  public SearchService getSearchService() {
    return searchService;
  }

  /**
   * Sets the search service.
   * 
   * @param searchService the new search service
   */
  public void setSearchService(SearchService searchService) {
    this.searchService = searchService;
  }
}
