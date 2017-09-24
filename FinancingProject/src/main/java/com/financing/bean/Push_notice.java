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
public class Push_notice {//公告表

	private int id;   //主键
	private String title;//标题
	private String content;//内容
	private int status;//公告状态
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	private  Users users;   //发布人
	private  Users users2;   //更新人
	
	
	
	
	@ManyToOne
	@JoinColumn(name="update_id")
	public Users getUsers2() {
		return users2;
	}
	public void setUsers2(Users users2) {
		this.users2 = users2;
	}
	@ManyToOne
	@JoinColumn(name="create_id")
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
