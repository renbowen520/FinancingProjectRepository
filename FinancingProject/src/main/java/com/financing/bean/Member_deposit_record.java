package com.financing.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member_deposit_record {//(��ֵ��¼��)
	private int id;//id
	private String serial_number;//��ˮ��
	private int member_id;//�û�Id
	private double amount;//��ֵ���
	private int status;//״̬��0:������,1:��ɣ�
	private String pay_channel_name;//��ֵ��������
	private String pay_cheannel_order_no;//��ֵ���������ţ�
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
