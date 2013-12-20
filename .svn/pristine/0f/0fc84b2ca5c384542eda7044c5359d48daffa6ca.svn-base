/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers
 * @FileName: IndexController.java
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

import org.springframework.stereotype.Controller;

import play.mvc.Result;
import play.mvc.With;
import actions.LogAction;

/**
 * 高鐵+酒店搜尋表單.
 * 
 * @author CJWang
 */
@With(LogAction.class)
@Controller
public class IndexController {

  /**
   * 組合搜尋.
   * 
   * @return the result
   */
  public Result index() {
    /**
     * 高鐵站城市對應定義於js檔
     */
    // logger.info("取得所有高鐵站及都市地緣關係");
    // List<HsrStation> stations = hsrService.listStationInfo();
    //
    // HsrHtl hsrHtl = new HsrHtl();
    // hsrHtl.setStations(stations);
    //
    // // 去程日期 = 系統日 + 3天
    // Date date = new Date();
    // Calendar cal = Calendar.getInstance();
    // cal.setTime(date);
    // cal.add(Calendar.DAY_OF_MONTH, 3);
    // hsrHtl.setDepDate(new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
    // cal.add(Calendar.DAY_OF_MONTH, 2);
    // hsrHtl.setArrDate(new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));

    // return ok(views.html.search.searchForm.render(hsrHtl));
    return ok(views.html.search.searchForm.render());
  }

  // @Autowired
  // private HsrService hsrService;
  //
  // /**
  // * @return the hsrService
  // */
  // public HsrService getHsrService() {
  // return hsrService;
  // }
  //
  // /**
  // * @param hsrService the hsrService to set
  // */
  // public void setHsrService(HsrService hsrService) {
  // this.hsrService = hsrService;
  // }
}
