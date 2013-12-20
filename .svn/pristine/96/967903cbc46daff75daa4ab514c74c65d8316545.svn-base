/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package:
 * @FileName: Global.java
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;
import configs.AppConfig;
import configs.ServiceConfig;

/**
 * The Class Global.
 * 
 * <pre>
 * 
 * </pre>
 */
public class Global extends GlobalSettings {

  /** The ctx. */
  private ApplicationContext ctx;

  /*
   * (non-Javadoc)
   * 
   * @see play.GlobalSettings#onStart(play.Application)
   */
  @Override
  public void onStart(Application app) {
    ctx = new AnnotationConfigApplicationContext(AppConfig.class, ServiceConfig.class);
  }

  /*
   * (non-Javadoc)
   * 
   * @see play.GlobalSettings#getControllerInstance(java.lang.Class)
   */
  @Override
  public <A> A getControllerInstance(Class<A> clazz) {
    return ctx.getBean(clazz);
  }

}
