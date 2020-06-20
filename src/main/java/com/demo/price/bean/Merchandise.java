package com.demo.price.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品
 * @author tr.wang
 *
 */
public class Merchandise {
	
	private String sku;//商品SKU
	private String name; //商品名称
	private BigDecimal price; //商品单价
	private List<SupportPromotions> supportPromotionsList; //支持促销类型
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<SupportPromotions> getSupportPromotionsList() {
		return supportPromotionsList;
	}

	public void setSupportPromotionsList(List<SupportPromotions> supportPromotionsList) {
		this.supportPromotionsList = supportPromotionsList;
	}
}
