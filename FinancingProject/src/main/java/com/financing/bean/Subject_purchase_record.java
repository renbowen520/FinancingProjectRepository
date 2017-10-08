package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//��Ĺ����

@Entity
@Table
public class Subject_purchase_record {

	
	private int id;  //����
	private String serial_number;//��ˮ��
	private double amount;//������
	private String deal_ip; //����ip
	private int delflag;  //�Ƿ�ɾ��   0����   1ɾ��
	private Date create_date;//���ʱ��
	private Date update_date;//�޸�ʱ��
	private double interest; //������Ϣ
	private int ispayment;//�Ƿ񻹿�    0��   1��
	private int pay_interest_times;//�������
	private   String last_profit_day;//����Ϣ��
	private String  bonus_info;//��������Ϣ
	

private  Subject subject; //�����˱� ��id
private  Member member;//�������û����id

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
