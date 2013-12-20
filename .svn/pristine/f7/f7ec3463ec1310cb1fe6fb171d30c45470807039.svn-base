/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package:
 * @FileName: ApplicationTest.java
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
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import org.junit.Test;

import play.mvc.Content;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are interested in mocking a
 * whole application, see the wiki for more details.
 * 
 */
public class ApplicationTest {

  /**
   * Simple check.
   */
  @Test
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }

  /**
   * Render template.
   */
  @Test
  public void renderTemplate() {
    // HsrHtl hsrHtl = new HsrHtl();
    Content html = views.html.search.searchForm.render();
    // Content html = views.html.search.searchForm.render(hsrHtl);
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("出發高鐵站");
  }

}
