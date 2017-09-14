package com.financing.bean;

import java.util.Date;

public class Subject_field_record {//主题记录表

	private int id;//主键
	private String field_value;//字段值
	private byte delflag;//删除标记
	private Date create_date;//创建时间
	private Date update_date;//更新时间
	
	private Subject subject;	  //引用 标id
	private Subject_file  subject_file; //引用附件表id
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getField_value() {
		return field_value;
	}
	public void setField_value(String field_value) {
		this.field_value = field_value;
	}
	public byte getDelflag() {
		return delflag;
	}
	public void setDelflag(byte delflag) {
		this.delflag = delflag;
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
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Subject_file getSubject_file() {
		return subject_file;
	}
	public void setSubject_file(Subject_file subject_file) {
		this.subject_file = subject_file;
	}



}
