package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table
public class News { //�����б�

	private int id;   // ����
	private String title;//����
	private String subTitle;//������
	private int  sort;  //����
	private String info;//���
	private String cPhoto;//����ͼƬ
	private String link;//���ӵ�ַ
	private String author;//����
	private String source;//��Դ
	private String label; //��ǩ
	private int clickNumber;//�������
	private String text; //����
	private String filelink;//������ַ
	private String seoTitle;//ҳ��seo����
	private String seoKey;//seo�ؼ���
	private String seoDes; //seo����
	private int placTop;//�Ƿ��ö� 0�� 1��
	private int recommend; //�Ƿ��Ƽ�
	private int audit;//�Ƿ����
	private Date addTime;//���ʱ��
	private Date updTime;//�޸�ʱ��
	
	//private int updId;   ��Ҫ����users��
    //	private int  addId;  ��Ҫ����users�� 
	private News_type news_type;//�����������id

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFilelink() {
		return filelink;
	}

	public void setFilelink(String filelink) {
		this.filelink = filelink;
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

	public int getPlacTop() {
		return placTop;
	}

	public void setPlacTop(int placTop) {
		this.placTop = placTop;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	
	 @ManyToOne
	 @JoinColumn(name="typeId")
	public News_type getNews_type() {
		return news_type;
	}

	public void setNews_type(News_type news_type) {
		this.news_type = news_type;
	}
	
	
	
}
