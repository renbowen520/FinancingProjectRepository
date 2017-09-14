package com.financing.bean;

import java.util.Date;

//附件归属表

public class Subject_folder {

	private int id;  //主键
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	

}
