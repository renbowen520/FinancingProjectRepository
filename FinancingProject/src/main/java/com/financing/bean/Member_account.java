package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Member_account {
//成员账号表
	private String id;  //主键
	private double  useable_balance;//可用余额
	private double imuseale_balance;//冻结资金
	private double total_profit;//累计收益
	private Date create_date; //创建时间
	private Date update_date;//修改时间
	private double bonus_amount;//红包金额
	private double invest_amount;//投资金额
	private int delflag; //删除状态 0 ok    1 no
	//private double bbin_amount;//体验金
	private Member member;//引用用户表id     一对一
	
	
	
	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getUseable_balance() {
		return useable_balance;
	}
	public void setUseable_balance(double useable_balance) {
		this.useable_balance = useable_balance;
	}
	public double getImuseale_balance() {
		return imuseale_balance;
	}
	public void setImuseale_balance(double imuseale_balance) {
		this.imuseale_balance = imuseale_balance;
	}
	public double getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
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
	public double getBonus_amount() {
		return bonus_amount;
	}
	public void setBonus_amount(double bonus_amount) {
		this.bonus_amount = bonus_amount;
	}
	public double getInvest_amount() {
		return invest_amount;
	}
	public void setInvest_amount(double invest_amount) {
		this.invest_amount = invest_amount;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
/*	public double getBbin_amount() {
		return bbin_amount;
	}
	public void setBbin_amount(double bbin_amount) {
		this.bbin_amount = bbin_amount;
	}*/
	
	
	@OneToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
