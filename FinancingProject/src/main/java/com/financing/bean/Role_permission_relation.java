package com.financing.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//权限表
@Table
@Entity
public class Role_permission_relation {

	private int  id;
	private String permission_ename;//权限名称
	private Date create_date;  //创建时间
	//引用角色表   多对多
	private Set<User_role> user_role=new HashSet<User_role>();
	
	@Id
	@GeneratedValue
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
	
	@ManyToMany(mappedBy="role_permission_relation")
	public Set<User_role> getUser_role() {
		return user_role;
	}
	public void setUser_role(Set<User_role> user_role) {
		this.user_role = user_role;
	}
	
	

	
	
}
