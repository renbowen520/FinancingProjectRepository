package com.financing.bean;

import java.util.Date;

//�û���ɫ������
//�����õ�
public class User_role_relation {

	private int id;  //����
	private Users users;  //����users id
	private User_role userRole;   //����user_role  id
	private Date create_date; //����ʱ��
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public User_role getUserRole() {
		return userRole;
	}
	public void setUserRole(User_role userRole) {
		this.userRole = userRole;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	
}
