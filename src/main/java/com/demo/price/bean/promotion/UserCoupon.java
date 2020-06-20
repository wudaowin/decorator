package com.demo.price.bean.promotion;

import java.math.BigDecimal;

/**
 * 优惠券
 * @author tr.wang
 *
 */
public class UserCoupon {
	
	private int id; //优惠券ID
	private int userId; //领取优惠券用户ID
	private String sku; //商品SKU
	private BigDecimal coupon; //优惠金额

	public UserCoupon(int id, int userId, String sku, BigDecimal coupon) {
		this.id = id;
		this.userId = userId;
		this.sku = sku;
		this.coupon = coupon;
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
	public BigDecimal getCoupon() {
		return coupon;
	}
	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}
}
