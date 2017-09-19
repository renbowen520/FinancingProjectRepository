package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Bbin_info {
//体验金信息表
	private int id;//主键
	private int  status; //状况   0正常   1No
	private double amont;//体验金
    private  Date create_date; //创建时间
    private  Date  update_date;//修改时间
    private Member member;//引用会员id

	
	public double getAmont() {
		return amont;
	}
	public void setAmont(double amont) {
		this.amont = amont;
	}
	
	@OneToOne
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
