package com.financing.bean;

import java.util.Date;

public class Subject_field_record {//�����¼��

	private int id;//����
	private String field_value;//�ֶ�ֵ
	private byte delflag;//ɾ�����
	private Date create_date;//����ʱ��
	private Date update_date;//����ʱ��
	
	private Subject subject;	  //���� ��id
	private Subject_file  subject_file; //���ø�����id
	
	
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
