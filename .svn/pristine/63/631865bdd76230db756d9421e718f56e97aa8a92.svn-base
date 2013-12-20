/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: models.pojo
 * @FileName: Page.java
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
package models.pojo;

/**
 * 分頁.
 * 
 * @author CJWang
 */
public class Page {

  /**
   * Gets the start index.
   * 
   * @return startIndex
   */
  public int getStartIndex() {
    return 1 + (pageNo - 1) * pageSize;
  }

  /** 頁數. */
  private int pageNo;

  /** 每頁筆數. */
  private int pageSize;

  /** 總數. */
  private int total;

  /** 排序. */
  private String orderBy;

  /**
   * Gets the total page.
   * 
   * @return the total page
   */
  public int getTotalPage() {
    if (this.pageSize == 0) return 0;
    return (this.total + this.pageSize - 1) / this.pageSize;
  }

  /**
   * Gets the page no.
   * 
   * @return 頁數
   */
  public int getPageNo() {
    return pageNo;
  }

  /**
   * Sets the page no.
   * 
   * @param pageNo 頁數
   */
  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
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

  /**
   * Gets the total.
   * 
   * @return 總數
   */
  public int getTotal() {
    return total;
  }

  /**
   * Sets the total.
   * 
   * @param total 總數
   */
  public void setTotal(int total) {
    this.total = total;
  }

  /**
   * Gets the order by.
   * 
   * @return 排序
   */
  public String getOrderBy() {
    return orderBy;
  }

  /**
   * Sets the order by.
   * 
   * @param orderBy 排序
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }
}
