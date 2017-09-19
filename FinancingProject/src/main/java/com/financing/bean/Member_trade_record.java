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
public class Member_trade_record {
	//���׼�¼��
	private int id; //����
	private String trade_no;//���׺�
	private String trade_name;//��������
	private String counterpart;//���׶Է�
	private double amount;//���׽��
	private String trade_type;//���׷���
	private int  fund_flow;  //�ʽ����� ��0���� 1���룩
	private int trade_status; //����״̬
	private String ext_field1;//��չ1
	private String ext_field2;//��չ2
	private String ext_field3;//��չ3
	private Date create_date; //����ʱ��
	private Date update_date;//�޸�ʱ��
	private Member member_id;	//�������û���id
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getTrade_name() {
		return trade_name;
	}
	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}
	public String getCounterpart() {
		return counterpart;
	}
	public void setCounterpart(String counterpart) {
		this.counterpart = counterpart;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public int getFund_flow() {
		return fund_flow;
	}
	public void setFund_flow(int fund_flow) {
		this.fund_flow = fund_flow;
	}
	public int getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(int trade_status) {
		this.trade_status = trade_status;
	}
	public String getExt_field1() {
		return ext_field1;
	}
	public void setExt_field1(String ext_field1) {
		this.ext_field1 = ext_field1;
	}
	public String getExt_field2() {
		return ext_field2;
	}
	public void setExt_field2(String ext_field2) {
		this.ext_field2 = ext_field2;
	}
	public String getExt_field3() {
		return ext_field3;
	}
	public void setExt_field3(String ext_field3) {
		this.ext_field3 = ext_field3;
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
	
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember_id() {
		return member_id;
	}
	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}

	
	
	
}
