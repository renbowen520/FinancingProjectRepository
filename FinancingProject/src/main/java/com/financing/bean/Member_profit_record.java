package com.financing.bean;

import java.util.Date;

public class Member_profit_record {
//成员利润记录表
	
	private int id;//主键
	private String serial_number;//流水号
	private int  type; //类型
	private double amount;//金额
	private byte delflag;  // 状态
	private Date create_date; //创建时间
	private Date update_date;//修改时间
	 private String comment; // 备注
	 private int profit_year; //计息年
	 private int profit_month;//计息月
	 private int profit_day; //计息日
	private Member member;//引用用户表id
	private Subject subject;//引用 标的id
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public byte getDelflag() {
		return delflag;
	}
	public void setDelflag(byte delflag) {
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getProfit_year() {
		return profit_year;
	}
	public void setProfit_year(int profit_year) {
		this.profit_year = profit_year;
	}
	public int getProfit_month() {
		return profit_month;
	}
	public void setProfit_month(int profit_month) {
		this.profit_month = profit_month;
	}
	public int getProfit_day() {
		return profit_day;
	}
	public void setProfit_day(int profit_day) {
		this.profit_day = profit_day;
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
