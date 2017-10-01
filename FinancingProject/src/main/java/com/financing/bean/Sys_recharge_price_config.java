package com.financing.bean;

import java.math.BigDecimal;
import java.util.Date;

//充值面额管理

public class Sys_recharge_price_config {

	private int id;   //主键
	private String type;//类型
	private double market_price;//金额  售价
	private double sell_price;//实际付款金额
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	
	
	
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getSell_price() {
		return sell_price;
	}
	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}
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
