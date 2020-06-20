package com.demo.price.bean.promotion;

import java.math.BigDecimal;

/**
 * 红包
 * @author tr.wang
 *
 */
public class UserRedPacket {

	private int id; //红包ID
	private int userId; //领取用户ID
	private String sku; //商品SKU
	private BigDecimal redPacket; //领取红包金额

	public UserRedPacket(int id, int userId, String sku, BigDecimal redPacket) {
		this.id = id;
		this.userId = userId;
		this.sku = sku;
		this.redPacket = redPacket;
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
	public BigDecimal getRedPacket() {
		return redPacket;
	}
	public void setRedPacket(BigDecimal redPacket) {
		this.redPacket = redPacket;
	}
	
}
