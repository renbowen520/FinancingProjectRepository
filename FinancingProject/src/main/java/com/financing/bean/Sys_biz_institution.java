package com.financing.bean;

import java.util.Set;

//商业机构表

public class Sys_biz_institution {

	
	private int id; //主键
	private String province;//省
	private String city;  //城市
	private String biz_type;//机构类别
	private String biz_sub_type;//机构子类别
	private String institution_name;//机构名称
	private String institution_code;//机构编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBiz_type() {
		return biz_type;
	}
	public void setBiz_type(String biz_type) {
		this.biz_type = biz_type;
	}
	public String getBiz_sub_type() {
		return biz_sub_type;
	}
	public void setBiz_sub_type(String biz_sub_type) {
		this.biz_sub_type = biz_sub_type;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public String getInstitution_code() {
		return institution_code;
	}
	public void setInstitution_code(String institution_code) {
		this.institution_code = institution_code;
	}
	

}
