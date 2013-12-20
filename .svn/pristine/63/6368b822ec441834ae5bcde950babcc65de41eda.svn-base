/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers
 * @FileName: SearchListController.java
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

import static play.data.Form.form;
import static play.mvc.Results.ok;
import models.pojo.HsrHtl;
import models.pojo.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.mvc.Content;
import play.mvc.Result;
import play.mvc.With;
import service.SearchService;
import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.IdentifyAction;
import actions.LogAction;

import com.typesafe.config.ConfigFactory;

import context.SecurityContext;

/**
 * 組合頁.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class SearchListController {

  /**
   * 組合列表.
   * 
   * @param pageNo the page no
   * @param orderBy the order by
   * @return the result
   */
  @With(IdentifyAction.class)
  public Result searchList(int pageNo, String orderBy) {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    page.setOrderBy(orderBy);
    HsrHtl result = null;
    try {
      Form<HsrHtl> hsrHtlForm = form(HsrHtl.class);
      HsrHtl hsrHtl = hsrHtlForm.bindFromRequest().get();
      hsrHtl.setUser(SecurityContext.getCurrentUser());
      logger.info("查詢高鐵酒店");
      result = this.searchService.search(hsrHtl, page);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return ok(views.html.search.notFound.render());
    }
    Content content = null;
    if (null == result) {
      logger.info("查無資料");
      content = views.html.search.notFound.render();
    } else if (null == result.getDepHsrInfo() || null == result.getDepSchedule()) {
      logger.info("查無去程高鐵資料");
      content = views.html.search.notFound.render();
    } else if (null == result.getReturnHsrInfo() || null == result.getReturnSchedule()) {
      logger.info("查無回程高鐵資料");
      content = views.html.search.notFound.render();
    } else if (null == result.getHotelList() || result.getHotelList().size() <= 0) {
      logger.info("查無飯店資料");
      content = views.html.search.notFound.render();
    } else
      content = views.html.search.searchList.render(result, page);
    return ok(content);
  }

  /** The logger. */
  private static Logger logger = LoggerFactory.getLogger(SearchListController.class);

  /** The search service. */
  @Autowired
  private SearchService searchService;

  /** 每頁筆數. */
  private int pageSize = 10;

  /**
   * Instantiates a new search list controller.
   */
  public SearchListController() {
    try {
      this.pageSize = ConfigFactory.load("config.properties").getInt("page.pageSize");
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
    }
  }

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

  /**
   * Gets the page size.
   * 
   * @return 每頁筆數
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets the page size.
   * 
   * @param pageSize 每頁筆數
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}
