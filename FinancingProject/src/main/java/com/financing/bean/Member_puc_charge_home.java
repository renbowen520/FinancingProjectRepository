package com.financing.bean;

import java.util.Date;

public class Member_puc_charge_home {
//�ɷѼ�ͥ
	
	private int id;//����
	private String name;//��ͥ����
	private int  is_default; //�Ƿ�Ĭ��  0No 1yes
	private Date create_date;  //����ʱ��
	private Date update_date; //�޸�ʱ��
	private Member member; //�����û���
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIs_default() {
		return is_default;
	}
	public void setIs_default(int is_default) {
		this.is_default = is_default;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
}
