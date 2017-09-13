package com.financing.bean;

import java.math.BigDecimal;
import java.util.Date;

//标的订单表


public class Subject_order_record {
    
	private int id;  //主键
	private String serial_number;//流水号
	private int    deal_type; //交易类型
	private BigDecimal amount;//订单金额
	private int   status; //订单状态
	private int  delflag;//是否删除
	private Date create_date;//创建时间
	private Date update_date;//更新时间
	private Member member;//引用用户id
	private Subject subject;//引用表的id
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public int getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(int deal_type) {
		this.deal_type = deal_type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
	
	
}
