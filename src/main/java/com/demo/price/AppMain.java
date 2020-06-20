package com.demo.price;

import com.demo.price.bean.order.Order;
import com.demo.price.bean.order.OrderDetail;
import com.demo.price.bean.promotion.UserCoupon;
import com.demo.price.enums.PromotionType;
import com.demo.price.bean.Merchandise;
import com.demo.price.bean.SupportPromotions;
import com.demo.price.bean.promotion.UserDiscount;
import com.demo.price.bean.promotion.UserRedPacket;
import com.demo.price.factory.PromotionFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class AppMain {

  public static void main(String[] args) throws InterruptedException, IOException {
    Order order = new Order();
    init(order);

    for (OrderDetail orderDetail : order.getList()) {
      System.out.println("   ");
      System.out.println("        【 订单明细Id： "+orderDetail.getId()+"商品名称："+orderDetail.getMerchandise().getName()+" 】 ");
      System.out.println("   ");

      BigDecimal payMoney = PromotionFactory.getPayMoney(orderDetail);

      System.out.println("-----------------------");
      System.out.println("最终支付金额：" + orderDetail.getPayMoney());
    }
  }

  private static Order init(Order order) {
    List<OrderDetail> OrderDetailList = getOrderDetails();
    order.setList(OrderDetailList);
    return order;
  }

  /**
   * 生成订单明细
   * @return
   */
  private static List<OrderDetail> getOrderDetails() {
    List<SupportPromotions> supportPromotionslist = genSupportPromotions("促销大苹果");
    Merchandise merchandise = getMerchandise("促销大苹果","红富士苹果",new BigDecimal(70),supportPromotionslist);

    List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setId(1);
    orderDetail.setOrderId(1111);
    orderDetail.setMerchandise(merchandise);
    orderDetailList.add(orderDetail);

    List<SupportPromotions> supportPromotionslist1 = genSupportPromotions1("西瓜");
    Merchandise merchandise1 = getMerchandise("西瓜","8424西瓜",new BigDecimal(50),supportPromotionslist1);
    OrderDetail orderDetail1 = new OrderDetail();
    orderDetail1.setId(2);
    orderDetail1.setOrderId(1111);
    orderDetail1.setMerchandise(merchandise1);
    orderDetailList.add(orderDetail1);
    return orderDetailList;
  }

  /**
   * 生成商品信息
   * @return
   */
  private static Merchandise getMerchandise(String sku,String name,BigDecimal price,List<SupportPromotions> supportPromotionslist) {
    Merchandise merchandise = new Merchandise();
    merchandise.setSku(sku);
    merchandise.setName(name);
    merchandise.setPrice(price);
    merchandise.setSupportPromotionsList(supportPromotionslist);
    return merchandise;
  }

  /**
   * 获取商品对应的折扣信息
   *
   * @return
   */
  private static List<SupportPromotions> genSupportPromotions(String sku) {
    List<SupportPromotions> supportPromotionslist = new LinkedList<SupportPromotions>();

    SupportPromotions supportPromotions = new SupportPromotions();
    supportPromotions.setPromotionType(PromotionType.COUPON);
    supportPromotions.setPriority(2);
    UserCoupon userCoupon = new UserCoupon(1, 11, sku, new BigDecimal(3));
    supportPromotions.setUserCoupon(userCoupon);
    supportPromotionslist.add(supportPromotions);

    SupportPromotions supportPromotions1 = supportPromotions.clone();
    supportPromotions1.setPromotionType(PromotionType.REDPACKED);
    supportPromotions1.setPriority(3);
    UserRedPacket userRedPacket = new UserRedPacket(1, 11, sku, new BigDecimal(10));
    supportPromotions1.setUserRedPacket(userRedPacket);
    supportPromotionslist.add(supportPromotions1);

    SupportPromotions supportPromotions2 = supportPromotions.clone();
    supportPromotions2.setPromotionType(PromotionType.DISCOUNT);
    supportPromotions2.setPriority(4);
    UserDiscount userDiscount = new UserDiscount(3, 11, sku, 80);
    supportPromotions2.setUserDiscount(userDiscount);
    supportPromotionslist.add(supportPromotions2);

    SupportPromotions supportPromotions3 = supportPromotions.clone();
    supportPromotions3.setPromotionType(PromotionType.DISCOUNT);
    supportPromotions3.setPriority(1);
    UserDiscount userDiscount1 = new UserDiscount(2, 11, sku, 90);
    supportPromotions3.setUserDiscount(userDiscount1);
    supportPromotionslist.add(supportPromotions3);

    return supportPromotionslist.stream()
        .sorted(Comparator.comparing(SupportPromotions::getPriority))
        .collect(Collectors.toList());
  }

  /**
   * 获取商品对应的折扣信息
   *
   * @return
   */
  private static List<SupportPromotions> genSupportPromotions1(String sku) {
    List<SupportPromotions> supportPromotionslist = new LinkedList<SupportPromotions>();

    SupportPromotions supportPromotions = new SupportPromotions();
    supportPromotions.setPromotionType(PromotionType.COUPON);
    supportPromotions.setPriority(2);
    UserCoupon userCoupon = new UserCoupon(3, 11, sku, new BigDecimal(10));
    supportPromotions.setUserCoupon(userCoupon);
    supportPromotionslist.add(supportPromotions);

    SupportPromotions supportPromotions1 = supportPromotions.clone();
    supportPromotions1.setPromotionType(PromotionType.REDPACKED);
    supportPromotions1.setPriority(3);
    UserRedPacket userRedPacket = new UserRedPacket(1, 11, sku, new BigDecimal(5));
    supportPromotions1.setUserRedPacket(userRedPacket);
    supportPromotionslist.add(supportPromotions1);

    SupportPromotions supportPromotions2 = supportPromotions.clone();
    supportPromotions2.setPromotionType(PromotionType.DISCOUNT);
    supportPromotions2.setPriority(4);
    UserDiscount userDiscount = new UserDiscount(2, 11, sku, 75);
    supportPromotions2.setUserDiscount(userDiscount);
    supportPromotionslist.add(supportPromotions2);


    return supportPromotionslist.stream()
            .sorted(Comparator.comparing(SupportPromotions::getPriority))
            .collect(Collectors.toList());
  }
}
