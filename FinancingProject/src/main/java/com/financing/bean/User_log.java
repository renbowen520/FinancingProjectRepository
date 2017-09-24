package com.financing.bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//登陆日志表

@Entity
@Table
public class User_log {
	private int id;	 // ID
	private  int action;	 //动作 0表示登陆    1表示退出
	private Date create_date;	//创建时间
	private Date update_date;	//修改时间  
	private String login_ip;	//登陆ip
	private Users users;	//引用用户表id
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
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
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

	
	
	
}
