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
	//private Date create_date;  //创建时间
	private int  up_id; //上级id
	private int    Parent_node ;//是不是父节点 0是  1不是 
	
	
	
	
	
	//引用角色表   多对多
	private Set<User_role> user_role=new HashSet<User_role>();

	public int getParent_node() {
		return Parent_node;
	}
	public void setParent_node(int parent_node) {
		Parent_node = parent_node;
	}
	public int getUp_id() {
		return up_id;
	}
	public void setUp_id(int up_id) {
		this.up_id = up_id;
	}

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

	
	@ManyToMany(mappedBy="role_permission_relation")
	public Set<User_role> getUser_role() {
		return user_role;
	}
	public void setUser_role(Set<User_role> user_role) {
		this.user_role = user_role;
	}
	
	

	
	
}
