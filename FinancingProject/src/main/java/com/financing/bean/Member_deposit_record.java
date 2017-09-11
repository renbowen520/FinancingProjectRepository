package com.financing.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member_deposit_record {//(充值记录表)
	private int id;//id
	private String serial_number;//流水号
	private int member_id;//用户Id
	private double amount;//充值金额
	private int status;//状态（0:代付款,1:完成）
	private String pay_channel_name;//充值渠道名称
	private String pay_cheannel_order_no;//充值渠道订单号；
	private int delFlag;
	
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
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPay_channel_name() {
		return pay_channel_name;
	}
	public void setPay_channel_name(String pay_channel_name) {
		this.pay_channel_name = pay_channel_name;
	}
	public String getPay_cheannel_order_no() {
		return pay_cheannel_order_no;
	}
	public void setPay_cheannel_order_no(String pay_cheannel_order_no) {
		this.pay_cheannel_order_no = pay_cheannel_order_no;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	
	
		
}
