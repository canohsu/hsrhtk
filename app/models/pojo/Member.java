/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: models.pojo
 * @FileName: Member.java
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

import eztravel.rest.enums.member.SexType;

/**
 * 會員.
 * 
 * @author CJWang
 */
public class Member {

  /** 客戶編號. */
  private String custNo;

  /** 客戶類別. */
  private String custType;

  /** 中文姓. */
  private String nameChnFirst;

  /** 中文名. */
  private String nameChnLast;

  /** 性別. */
  private SexType sex;

  /** 身分證字號. */
  private String personId;

  /** 國籍. */
  private String nationality;

  /** 聯絡地址郵遞區號. */
  private String zip;

  /** 聯絡地址. */
  private String address;

  /** 聯絡電話區碼(日). */
  private String telAreaDay;

  /** 聯絡電話(日). */
  private String telDay;

  /** 聯絡電話分機(日). */
  private String telExDay;

  /** 行動電話. */
  private String telMobile;

  /** 電子郵件1. */
  private String email1;

  /**
   * Gets the cust no.
   * 
   * @return 客戶編號
   */
  public String getCustNo() {
    return custNo;
  }

  /**
   * Sets the cust no.
   * 
   * @param custNo 客戶編號
   */
  public void setCustNo(String custNo) {
    this.custNo = custNo;
  }

  /**
   * Gets the cust type.
   * 
   * @return 客戶類別
   */
  public String getCustType() {
    return custType;
  }

  /**
   * Sets the cust type.
   * 
   * @param custType 客戶類別
   */
  public void setCustType(String custType) {
    this.custType = custType;
  }

  /**
   * Gets the name chn first.
   * 
   * @return 中文姓
   */
  public String getNameChnFirst() {
    return nameChnFirst;
  }

  /**
   * Sets the name chn first.
   * 
   * @param nameChnFirst 中文姓
   */
  public void setNameChnFirst(String nameChnFirst) {
    this.nameChnFirst = nameChnFirst;
  }

  /**
   * Gets the name chn last.
   * 
   * @return 中文名
   */
  public String getNameChnLast() {
    return nameChnLast;
  }

  /**
   * Sets the name chn last.
   * 
   * @param nameChnLast 中文名
   */
  public void setNameChnLast(String nameChnLast) {
    this.nameChnLast = nameChnLast;
  }

  /**
   * Gets the sex.
   * 
   * @return 性別
   */
  public SexType getSex() {
    return sex;
  }

  /**
   * Sets the sex.
   * 
   * @param sex 性別
   */
  public void setSex(SexType sex) {
    this.sex = sex;
  }

  /**
   * Gets the person id.
   * 
   * @return 身分證字號
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * Sets the person id.
   * 
   * @param personId 身分證字號
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * Gets the nationality.
   * 
   * @return 國籍
   */
  public String getNationality() {
    return nationality;
  }

  /**
   * Sets the nationality.
   * 
   * @param nationality 國籍
   */
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  /**
   * Gets the zip.
   * 
   * @return 聯絡地址郵遞區號
   */
  public String getZip() {
    return zip;
  }

  /**
   * Sets the zip.
   * 
   * @param zip 聯絡地址郵遞區號
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * Gets the address.
   * 
   * @return 聯絡地址
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   * 
   * @param address 聯絡地址
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets the tel area day.
   * 
   * @return 聯絡電話區碼(日)
   */
  public String getTelAreaDay() {
    return telAreaDay;
  }

  /**
   * Sets the tel area day.
   * 
   * @param telAreaDay 聯絡電話區碼(日)
   */
  public void setTelAreaDay(String telAreaDay) {
    this.telAreaDay = telAreaDay;
  }

  /**
   * Gets the tel day.
   * 
   * @return 聯絡電話(日)
   */
  public String getTelDay() {
    return telDay;
  }

  /**
   * Sets the tel day.
   * 
   * @param telDay 聯絡電話(日)
   */
  public void setTelDay(String telDay) {
    this.telDay = telDay;
  }

  /**
   * Gets the tel ex day.
   * 
   * @return 聯絡電話分機(日)
   */
  public String getTelExDay() {
    return telExDay;
  }

  /**
   * Sets the tel ex day.
   * 
   * @param telExDay 聯絡電話分機(日)
   */
  public void setTelExDay(String telExDay) {
    this.telExDay = telExDay;
  }

  /**
   * Gets the tel mobile.
   * 
   * @return 行動電話
   */
  public String getTelMobile() {
    return telMobile;
  }

  /**
   * Sets the tel mobile.
   * 
   * @param telMobile 行動電話
   */
  public void setTelMobile(String telMobile) {
    this.telMobile = telMobile;
  }

  /**
   * Gets the email1.
   * 
   * @return 電子郵件1
   */
  public String getEmail1() {
    return email1;
  }

  /**
   * Sets the email1.
   * 
   * @param email1 電子郵件1
   */
  public void setEmail1(String email1) {
    this.email1 = email1;
  }
}
