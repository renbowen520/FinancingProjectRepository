package com.financing.bean;

import java.util.Date;

/*
 * �û���¼���Ʊ�
 */

public class User_login_token {

	private String token;	//���ƺ�
	private String user_name;	//��¼ʱ���û��������û����ֻ��ŵ�
	private String password;	//����
	private Date expire_time;	//��Чʱ��
	private Date create_date;	//����ʱ��
	private Date update_date;	//�޸�ʱ��
	private Users users;	//�����û����id
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
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
