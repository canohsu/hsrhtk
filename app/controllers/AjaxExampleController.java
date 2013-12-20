/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: controllers
 * @FileName: AjaxExampleController.java
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
 * Ajax Example.
 * 
 * @author TonyWang
 */
@With(LogAction.class)
@Controller
public class AjaxExampleController {

  /**
   * 組合搜尋.
   * 
   * @return the result
   */
  public Result index() {
    return ok(views.html.ajaxexample.index.render());
  }

  /**
   * Gets the something.
   * 
   * @return the something
   */
  public Result getSomething() {

    play.mvc.Controller.response().setContentType("application/json");
    return ok("{\"message\":\"ok\"}");
  }
}
