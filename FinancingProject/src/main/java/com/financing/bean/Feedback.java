package com.financing.bean;

import java.util.Date;

public class Feedback {
//���������
	private int id;  //����
	private String content;//���� 
	private Date create_date;//����ʱ��
	private Member member;//���û�Աid
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
	
}
