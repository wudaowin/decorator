package com.demo.price.decorator.base;

import com.demo.price.bean.order.OrderDetail;

import java.math.BigDecimal;
import java.util.concurrent.Semaphore;

/**
 * 支付基本类
 * @author tr.wang
 *
 */
public class BaseCount implements IBaseCount {

	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());
		System.out.println("商品原单价金额为：" +  orderDetail.getPayMoney());
		return orderDetail.getPayMoney();
	}

}
