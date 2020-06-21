package com.demo.price.decorator;

import com.demo.price.bean.SupportPromotions;
import com.demo.price.bean.order.OrderDetail;
import com.demo.price.decorator.base.BaseCountDecorator;
import com.demo.price.decorator.base.IBaseCount;

import java.math.BigDecimal;
import java.util.List;

/**
 * 计算使用优惠券后的金额
 *
 * @author tr.wang
 */
public class CouponDecorator extends BaseCountDecorator {
  private SupportPromotions supportPromotions;

  public CouponDecorator(IBaseCount count, SupportPromotions supportPromotions) {
    super(count);
    this.supportPromotions = supportPromotions;
  }

  public BigDecimal countPayMoney(OrderDetail orderDetail) {
    super.countPayMoney(orderDetail);
    BigDecimal payTotalMoney = new BigDecimal(0);
    payTotalMoney = countCouponPayMoney(orderDetail);
    return payTotalMoney;
  }

  private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
    System.out.println("-----------------------使用优惠券-----------------------");
    List<SupportPromotions> supportPromotionsList =
        orderDetail.getMerchandise().getSupportPromotionsList();
    BigDecimal coupon = new BigDecimal(0);
    coupon = supportPromotions.getUserCoupon().getCoupon();
    System.out.println("优惠券金额：" + coupon);

    orderDetail.setPayMoney(
        orderDetail.getPayMoney().subtract(coupon).setScale(2, BigDecimal.ROUND_HALF_UP));
    System.out.println("优惠券后商品价格：" + orderDetail.getPayMoney());
    System.out.println("  ");
    return orderDetail.getPayMoney();
  }
}
