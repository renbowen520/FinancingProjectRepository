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
public class Finance_product_subscribe {
	//���������ƷԤԼ��¼��
	private int id;  //����
	private String name;//����
	private String phone;//�绰
	private String addr;//���ڵ���
	private int status;//�Ƿ�ǩ��0ǩ������|1:��ǩԼ|2:�����|3:ǩ��ʧ�ܣ�
	private String comment;//����ǩ���ļ���Ϣ
	private String risk_reveal;//���ս�ʾ��
	private Date create_date;
	private Date update_date;
	private double amount;//˽ļ������
	private double interest;//˽ļ��������
	private String start_date;//��ʼʱ��
	private String end_date;//����ʱ��
	private String signed_photos;//ǩ������
	
	 private Member Member;//���û�Ա��id
	 private   Finance_product_funds finance_product_funds;//�������������id
	
	 
	 
	 
	 @Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRisk_reveal() {
		return risk_reveal;
	}
	public void setRisk_reveal(String risk_reveal) {
		this.risk_reveal = risk_reveal;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getSigned_photos() {
		return signed_photos;
	}
	public void setSigned_photos(String signed_photos) {
		this.signed_photos = signed_photos;
	}
	
	
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return Member;
	}
	public void setMember(Member member) {
		Member = member;
	}
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	public Finance_product_funds getFinance_product_funds() {
		return finance_product_funds;
	}
	public void setFinance_product_funds(Finance_product_funds finance_product_funds) {
		this.finance_product_funds = finance_product_funds;
	}
	
	
	
	
}
