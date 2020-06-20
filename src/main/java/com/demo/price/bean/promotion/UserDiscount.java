package com.demo.price.bean.promotion;

/** @Description 折扣 @Author tr.wang @Date 2020/6/19 10:16 @Version 1.0 */
public class UserDiscount {
  private int id; // 折扣ID
  private int userId; // 领取折扣用户ID
  private String sku; // 商品SKU
  private double  discount; // 折扣,10表示1折

  public UserDiscount(int id, int userId, String sku, double  discount) {
    this.id = id;
    this.userId = userId;
    this.sku = sku;
    this.discount = discount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public double  getDiscount() {
    return discount;
  }

  public void setDiscount(double  discount) {
    this.discount = discount;
  }
}
