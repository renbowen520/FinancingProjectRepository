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
public class Oversea_config_subscribe {//海外配置订阅表
	private int id;
	private int member_id;//会员id
	private int oversea_id;//海外配置id
	private String name;//
	private String phone;//电话
	private String addr;//地址
	private int status;//状态
	private Date create_date;
	private Date update_date;
//	private Oversea_config Oversea_config;
//	
//	@ManyToOne
//	@JoinColumn(name="oversea_id")
//	public Oversea_config getOversea_config() {
//		return Oversea_config;
//	}
//	public void setOversea_config(Oversea_config oversea_config) {
//		Oversea_config = oversea_config;
//	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getOversea_id() {
		return oversea_id;
	}
	public void setOversea_id(int oversea_id) {
		this.oversea_id = oversea_id;
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
