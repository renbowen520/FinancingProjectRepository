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
public class Award_records {
//奖励记录表
	private  int id;//主键
	//private  int inviting ;//邀请人id
	//private int byinvitingid;//被邀请人id
	 private int type;//奖励类型 0注册   1投资
	 private int isAward;//奖励状态  0未  1已经
	 private Date addTime;//添加时间
	 private double amount ;//奖金
	private Member member;
	
	
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
 
	
	
	
}
