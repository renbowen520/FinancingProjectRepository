package com.financing.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Subject {
	private int id;
	private String serial_number;//��ˮ��
	private String serial_no;//��ͬ���
	private String name;//�������
	private int type;//����
	private int status;//״̬
	private double floor_amount;//��Ͷ���
	private double amount;//��Ľ��
	private int first_id;//ʼ��id
	private int parent_id;//����id
	private int period;//����
	private String purpose;//���Ŀ��
	private Date raise_start;//ļ����ʼ
	private Date raise_end;//ļ������
	private int refund_way;//���ʽ
	private int safeGuard_way;//���Ϸ�ʽ
	private String start_date;//��Ŀ�ʼʱ��
	private String end_date;//��Ľ���ʱ��
	private double year_rate;//�껯��
	private String comment;//��Ʒ����
	private int folder_id;//�ļ���id
	private int delflag;//�Ƿ�ɾ��
	private Date update_date;
	private Date create_date;
	private String borrowername;//���������
	private int borrowerid;//�����id
	private int bought;//�ѹ�����
	private String projectDetails;//��Ŀ����
	private String safetyControl;//��ȫ����
	private int exper_status;//������Ƿ���Թ���
	
	//ͬһ������Ա�������  һ�Զ࣬�ü���
	private Set<Subject_purchase_record> subject_purchase_record=new HashSet<>();//��Ĺ����(�������)
	private Set<Subject_bbin_purchase_record> Subject_bbin_purchase_record=new HashSet<>();//��������
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="subject")
	public Set<Subject_bbin_purchase_record> getSubject_bbin_purchase_record() {
		return Subject_bbin_purchase_record;
	}
	public void setSubject_bbin_purchase_record(Set<Subject_bbin_purchase_record> subject_bbin_purchase_record) {
		Subject_bbin_purchase_record = subject_bbin_purchase_record;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="subject")
	public Set<Subject_purchase_record> getSubject_purchase_record() {
		return subject_purchase_record;
	}
	public void setSubject_purchase_record(Set<Subject_purchase_record> subject_purchase_record) {
		this.subject_purchase_record = subject_purchase_record;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getFloor_amount() {
		return floor_amount;
	}
	public void setFloor_amount(double floor_amount) {
		this.floor_amount = floor_amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getFirst_id() {
		return first_id;
	}
	public void setFirst_id(int first_id) {
		this.first_id = first_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getRaise_start() {
		return raise_start;
	}
	public void setRaise_start(Date raise_start) {
		this.raise_start = raise_start;
	}
	public Date getRaise_end() {
		return raise_end;
	}
	public void setRaise_end(Date raise_end) {
		this.raise_end = raise_end;
	}
	public int getRefund_way() {
		return refund_way;
	}
	public void setRefund_way(int refund_way) {
		this.refund_way = refund_way;
	}
	public int getSafeGuard_way() {
		return safeGuard_way;
	}
	public void setSafeGuard_way(int safeGuard_way) {
		this.safeGuard_way = safeGuard_way;
	}
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public double getYear_rate() {
		return year_rate;
	}
	public void setYear_rate(double year_rate) {
		this.year_rate = year_rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}
	public String getSafetyControl() {
		return safetyControl;
	}
	public void setSafetyControl(String safetyControl) {
		this.safetyControl = safetyControl;
	}
	public int getFolder_id() {
		return folder_id;
	}
	public void setFolder_id(int folder_id) {
		this.folder_id = folder_id;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getBorrowername() {
		return borrowername;
	}
	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}
	public int getBorrowerid() {
		return borrowerid;
	}
	public void setBorrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}
	public int getBought() {
		return bought;
	}
	public void setBought(int bought) {
		this.bought = bought;
	}
	public int getExper_status() {
		return exper_status;
	}
	public void setExper_status(int exper_status) {
		this.exper_status = exper_status;
	}
	
	
}
