package com.demo.price.decorator;

import com.demo.price.decorator.base.IBaseCount;
import com.demo.price.bean.SupportPromotions;
import com.demo.price.bean.order.OrderDetail;
import com.demo.price.decorator.base.BaseCountDecorator;

import java.math.BigDecimal;

/**
 * 计算使用红包后的金额
 *
 * @author tr.wang
 */
public class RedPacketDecorator extends BaseCountDecorator {
  private SupportPromotions supportPromotions;

  public RedPacketDecorator(IBaseCount count, SupportPromotions supportPromotions) {
    super(count);
    this.supportPromotions = supportPromotions;
  }

  public BigDecimal countPayMoney(OrderDetail orderDetail) {
    BigDecimal payTotalMoney = new BigDecimal(0);
    payTotalMoney = super.countPayMoney(orderDetail);
    payTotalMoney = countCouponPayMoney(orderDetail);
    return payTotalMoney;
  }

  private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
    System.out.println("--------------------------使用红包-----------------------");
    BigDecimal redPacket = new BigDecimal(0);
    redPacket = supportPromotions.getUserRedPacket().getRedPacket();
    System.out.println("红包优惠金额：" + redPacket);

    orderDetail.setPayMoney(
        orderDetail.getPayMoney().subtract(redPacket).setScale(2, BigDecimal.ROUND_HALF_UP));
    System.out.println("红包后商品价格：" + orderDetail.getPayMoney());
    System.out.println("  ");
    return orderDetail.getPayMoney();
  }
}
