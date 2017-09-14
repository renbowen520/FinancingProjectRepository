package com.financing.bean;

public class Member_puc_charge_item {
//缴费项目表
	private  int  id;//主键
	private String charge_type;//缴费类别
	private String charge_institution_name;//缴费机构名称
	private String charge_institution_code;//缴费机构编码
	private String customer_code;//客户编码
	private String comment;//备注
	private Sys_biz_institution sys_biz_institution;//引用缴费类别id
	private Member_puc_charge_home member_puc_charge_home;//引用缴费家庭id
	private Member member;//引用 用户表id

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public String getCharge_institution_name() {
		return charge_institution_name;
	}
	public void setCharge_institution_name(String charge_institution_name) {
		this.charge_institution_name = charge_institution_name;
	}
	public String getCharge_institution_code() {
		return charge_institution_code;
	}
	public void setCharge_institution_code(String charge_institution_code) {
		this.charge_institution_code = charge_institution_code;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Sys_biz_institution getSys_biz_institution() {
		return sys_biz_institution;
	}
	public void setSys_biz_institution(Sys_biz_institution sys_biz_institution) {
		this.sys_biz_institution = sys_biz_institution;
	}
	public Member_puc_charge_home getMember_puc_charge_home() {
		return member_puc_charge_home;
	}
	public void setMember_puc_charge_home(Member_puc_charge_home member_puc_charge_home) {
		this.member_puc_charge_home = member_puc_charge_home;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}






}



