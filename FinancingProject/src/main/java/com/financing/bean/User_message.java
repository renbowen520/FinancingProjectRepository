package com.financing.bean;

import java.util.Date;

public class User_message {     //用户消息表

	private String id;	//主键
	private String title;	//消息标题
	private byte business_type;	//业务类别
	private int ownerId;	//业务
	private String content;	//消息内容
	private int  msg_status;	//状态,(已读未读)
	private byte del_flag;	// 删除标志
	private Date create_date;	//创建时间
	private Date update_date;	//修改时间
	  
  	private Users users;	//需要关联用户表的id

  	
  	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(byte business_type) {
		this.business_type = business_type;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(int msg_status) {
		this.msg_status = msg_status;
	}

	public byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
