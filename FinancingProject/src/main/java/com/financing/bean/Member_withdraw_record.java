package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Member_withdraw_record {//���ּ�¼��
	
	private int id;//id
	private String serial_number;//��ˮ��
	 
	//��Ҫ����  �����ϵ ����
//	private int member_id;//�û�id
	private Member member_id;//�û�id
	private double amount;//���ֽ��
	private String bank_name;//��������
	private String bank_card;//���п���
	private int status;//����״̬��0:����ˣ�1:�Ѵ�2:����У�3:���ʧ�ܣ�
	private int delFlag;//�Ƿ�ɾ��
	private String cardaddress;//�����������ڵ�
	private String channel_name;// ���ͨ��������,������
	private Date create_date;//����ʱ��
	private Date update_date;//�޸�ʱ��
	
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
<<<<<<< HEAD
/*	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}*/
=======
>>>>>>> branch 'master' of https://github.com/renbowen520/FinancingProjectRepository
	public double getAmount() {
		return amount;
	}
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember_id() {
		return member_id;
	}
	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_card() {
		return bank_card;
	}
	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
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
