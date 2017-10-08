package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//标的购买表

@Entity
@Table
public class Subject_purchase_record {

	
	private int id;  //主键
	private String serial_number;//流水号
	private double amount;//购买金额
	private String deal_ip; //交易ip
	private int delflag;  //是否删除   0正常   1删除
	private Date create_date;//添加时间
	private Date update_date;//修改时间
	private double interest; //结算利息
	private int ispayment;//是否还款    0是   1否
	private int pay_interest_times;//购买次数
	private   String last_profit_day;//最后计息日
	private String  bonus_info;//红包金额信息
	

private  Subject subject; //引用了标 的id
private  Member member;//引用了用户表的id

@Id
@GeneratedValue
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
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getDeal_ip() {
	return deal_ip;
}
public void setDeal_ip(String deal_ip) {
	this.deal_ip = deal_ip;
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
public int getIspayment() {
	return ispayment;
}
public double getInterest() {
	return interest;
}
public void setInterest(double interest) {
	this.interest = interest;
}
public void setIspayment(int ispayment) {
	this.ispayment = ispayment;
}
public int getPay_interest_times() {
	return pay_interest_times;
}
public void setPay_interest_times(int pay_interest_times) {
	this.pay_interest_times = pay_interest_times;
}
public String  getLast_profit_day() {
	return last_profit_day;
}
public void setLast_profit_day(String last_profit_day) {
	this.last_profit_day = last_profit_day;
}
public String getBonus_info() {
	return bonus_info;
}
public void setBonus_info(String bonus_info) {
	this.bonus_info = bonus_info;
}

@ManyToOne
@JoinColumn(name="subject_id")
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}

@ManyToOne
@JoinColumn(name="member_id")
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}




}
