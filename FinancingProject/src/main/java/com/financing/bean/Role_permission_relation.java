package com.financing.bean;

import java.util.Date;

//��ɫȨ�ޱ�
public class Role_permission_relation {

	private int  id;
	private String permission_ename;//Ȩ������
	private Date create_date;  //����ʱ��
	private User_role user_role; //���ý�ɫ��id
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermission_ename() {
		return permission_ename;
	}
	public void setPermission_ename(String permission_ename) {
		this.permission_ename = permission_ename;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public User_role getUser_role() {
		return user_role;
	}
	public void setUser_role(User_role user_role) {
		this.user_role = user_role;
	}
	
	
	
}
