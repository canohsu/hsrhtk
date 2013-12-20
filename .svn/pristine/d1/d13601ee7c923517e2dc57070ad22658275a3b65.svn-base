/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: configs
 * @FileName: AppConfig.java
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
package configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;
import actions.AuthenticateAction;
import actions.IdentifyAction;
import actions.LogAction;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * The Class AppConfig.
 * 
 * <pre>
 * 
 * </pre>
 */
@Configuration
@ComponentScan({"controllers"})
public class AppConfig {

  /**
   * Rest template.
   * 
   * @return the rest template
   */
  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    messageConverters.add(new MappingJackson2HttpMessageConverter());
    restTemplate.setMessageConverters(messageConverters);
    return restTemplate;
  }

  /**
   * Task executor.
   * 
   * @return the thread pool task executor
   */
  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
    try {
      pool.setCorePoolSize(config.getInt("thread.corePoolSize"));
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
      pool.setCorePoolSize(10);
    }
    try {
      pool.setMaxPoolSize(config.getInt("thread.maxPoolSize"));
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
      pool.setMaxPoolSize(30);
    }
    pool.setWaitForTasksToCompleteOnShutdown(true);
    return pool;
  }

  /**
   * Log action.
   * 
   * @return the log action
   */
  @Bean
  public LogAction logAction() {
    return new LogAction();
  }

  /**
   * Identify action.
   * 
   * @return the identify action
   */
  @Bean
  public IdentifyAction identifyAction() {
    return new IdentifyAction();
  }

  /**
   * Authenticate action.
   * 
   * @return the authenticate action
   */
  @Bean
  public AuthenticateAction authenticateAction() {
    return new AuthenticateAction();
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

  /** The config. */
  private Config config = ConfigFactory.load("config.properties");
}
