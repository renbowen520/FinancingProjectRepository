package com.financing.bean;

import java.util.Date;

public class Feedback {
//意见反馈表
	private int id;  //主键
	private String content;//内容 
	private Date create_date;//创建时间
	private Member member;//引用会员id
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
