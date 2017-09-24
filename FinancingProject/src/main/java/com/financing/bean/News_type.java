package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//新闻类别表
@Table
@Entity
public class News_type {
	private int id;  // 主键
	private String name;//名称
	private String link;//链接
	private String note;//备注
	private int sort;//排序
	private String pageType;//页面类型
	private String info;//简介
	private String cPhoto;//封面图片
	private String text; //内容
	private String seoTitle;//页面seo标题
	private String seoKey;//seo关键字
	private String seoDes;//seo描述
	private Date updTime;//修改时间
	private Date addTime; //添加时间
   private   int supType;
   private Users users;//添加人
   private Users users2;//修改人
   
private   int status;  //0正常    1删除

 


public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getSupType() {
	return supType;
}
public void setSupType(int supType) {
	this.supType = supType;
}


@ManyToOne
@JoinColumn(name="create_id")
public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}

@ManyToOne
@JoinColumn(name="update_id")
public Users getUsers2() {
	return users2;
}
public void setUsers2(Users users2) {
	this.users2 = users2;
}
	@Id
	@GeneratedValue
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getcPhoto() {
		return cPhoto;
	}
	public void setcPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoKey() {
		return seoKey;
	}
	public void setSeoKey(String seoKey) {
		this.seoKey = seoKey;
	}
	public String getSeoDes() {
		return seoDes;
	}
	public void setSeoDes(String seoDes) {
		this.seoDes = seoDes;
	}
	public Date getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}



	
	
}
