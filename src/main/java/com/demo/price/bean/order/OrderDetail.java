package com.demo.price.bean.order;

import com.demo.price.bean.Merchandise;

import java.math.BigDecimal;

/**
 * 详细订单
 * @author tr.wang
 *
 */
public class OrderDetail {
	private int id; //详细订单ID
	private int orderId;//主订单ID
	private Merchandise merchandise; //商品详情
	private BigDecimal payMoney; //支付单价
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
}
