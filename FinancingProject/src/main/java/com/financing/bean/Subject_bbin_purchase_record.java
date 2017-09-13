package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Subject_bbin_purchase_record {
	private int id;
	private String serial_number;//流水号
	private double amount;//购买金额
	private String deal_ip;//交易ip
	private int subject_id;//标的id
	private int member_id;//会员id               得到会员名称，与member表一对一
	private int delflag;//是否删除
	private Date create_date;
	private Date update_date;
	private double interest;//结算利息
	private int ispayment;//是否还款
	private int pay_interest_times;//支付次数
	private int last_profit_day;//最后计息日
	
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
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
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
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getIspayment() {
		return ispayment;
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
	public int getLast_profit_day() {
		return last_profit_day;
	}
	public void setLast_profit_day(int last_profit_day) {
		this.last_profit_day = last_profit_day;
	}
	
	
}
