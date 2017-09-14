package com.financing.bean;

import java.util.Date;

public class Subject_file {//附件表
	private int id;  //主键
	private String path;//文件路径
	private String file_name;//文件名
	private String original_name;//原文件名
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	private Subject_folder subject_folder;//引用附件归属表
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
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
	public Subject_folder getSubject_folder() {
		return subject_folder;
	}
	public void setSubject_folder(Subject_folder subject_folder) {
		this.subject_folder = subject_folder;
	}
	
	
}
