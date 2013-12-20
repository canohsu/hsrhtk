/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: service.order
 * @FileName: MemberInfoService.java
 * @author: tonywang
 * @date: 2013/12/15, 下午 03:39:21
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
package service.order;

import java.util.List;
import java.util.concurrent.ExecutionException;

import models.pojo.Member;

/**
 * EC會員查詢.
 * 
 * @author CJWang
 */
public interface MemberInfoService {

  /**
   * 查詢會員資訊.
   * 
   * @param personId 身分證字號
   * @return the list
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  public List<Member> listMember(String personId) throws InterruptedException, ExecutionException;
}
