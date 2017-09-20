package com.financing.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.context.request.NativeWebRequest;

@Entity
@Table
public class User_role {   //角色表
	private String id;//主键
	private String cname;//中文名
	private String ename;//英文名
	private int available;//是否可用
	private String remark;//备注
	private Date create_date;//创建时间
	private Date update_date;//修改时间 
	//private String category;//分类
//	private  int source_type;//原型类别
	//private   source_id   源id    实体类Role_Permission_Relation

	private int delFlag;  //是否删除
	
	//角色和权限 多对多
	private Set<Role_permission_relation>role_permission_relation=new HashSet<>();
	
	
	
	@ManyToMany
	@JoinTable(name="user_ss",joinColumns=@JoinColumn(name="rid"),inverseJoinColumns=@JoinColumn(name="pid"))
	public Set<Role_permission_relation> getRole_permission_relation() {
		return role_permission_relation;
	}
	public void setRole_permission_relation(Set<Role_permission_relation> role_permission_relation) {
		this.role_permission_relation = role_permission_relation;
	}
	
	
	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	/*public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSource_type() {
		return source_type;
	}
	public void setSource_type(int source_type) {
		this.source_type = source_type;
	}*/
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}







}
