package com.demo.price.decorator.base;

import com.demo.price.bean.order.OrderDetail;

import java.math.BigDecimal;

/**
 * 计算支付金额的抽象类
 * @author tr.wang
 *
 */
public abstract class BaseCountDecorator implements IBaseCount {
	
	private IBaseCount count;
	
	public BaseCountDecorator(IBaseCount count) {
		this.count = count;
	}

	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		
		
		BigDecimal payTotalMoney = new BigDecimal(0);
		
		if(count!=null) {
			payTotalMoney = count.countPayMoney(orderDetail);
		}
		return payTotalMoney;
	}
	

}
