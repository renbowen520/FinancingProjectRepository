package com.financing.bean;

import java.util.Date;

public class User_message {     //�û���Ϣ��

	private String id;	//����
	private String title;	//��Ϣ����
	private byte business_type;	//ҵ�����
	private int ownerId;	//ҵ��
	private String content;	//��Ϣ����
	private int  msg_status;	//״̬,(�Ѷ�δ��)
	private byte del_flag;	// ɾ����־
	private Date create_date;	//����ʱ��
	private Date update_date;	//�޸�ʱ��
	  
  	private Users users;	//��Ҫ�����û����id

  	
  	
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
