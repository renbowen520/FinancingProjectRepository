package com.financing.bean;

import java.math.BigDecimal;
import java.util.Date;

//��ֵ������

public class Sys_recharge_price_config {

	private int id;   //����
	private String type;//����
	private BigDecimal market_price;//���
	private BigDecimal sell_price;//��֪��ʲô���
	private Date create_date;//����ʱ��
	private Date update_date;//�޸�ʱ��
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getMarket_price() {
		return market_price;
	}
	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}
	public BigDecimal getSell_price() {
		return sell_price;
	}
	public void setSell_price(BigDecimal sell_price) {
		this.sell_price = sell_price;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
	
	
	
}
