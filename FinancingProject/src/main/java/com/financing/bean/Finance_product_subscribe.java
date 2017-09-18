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
	//理财类基金产品预约记录表
	private int id;  //主键
	private String name;//名称
	private String phone;//电话
	private String addr;//所在地区
	private int status;//是否签署（0签署拍照|1:已签约|2:审核中|3:签署失败）
	private String comment;//电子签署文件信息
	private String risk_reveal;//风险揭示书
	private Date create_date;
	private Date update_date;
	private double amount;//私募购买金额
	private double interest;//私募结算收益
	private String start_date;//开始时间
	private String end_date;//结束时间
	private String signed_photos;//签署拍照
	
	 private Member Member;//引用会员表id
	 private   Finance_product_funds finance_product_funds;//引用理财类基金表id
	
	 
	 
	 
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
