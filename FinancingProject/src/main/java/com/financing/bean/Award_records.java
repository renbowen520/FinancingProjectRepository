package com.financing.bean;

import java.util.Date;

public class Award_records {
//������¼��
	private  int id;//����
	private  int inviting ;//������id
	private int byinvitingid;//��������id
	private int type;//�������� 0ע��   1Ͷ��
	private int isAward;//����״̬  0δ  1�Ѿ�
	private Date addTime;//���ʱ��
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInviting() {
		return inviting;
	}
	public void setInviting(int inviting) {
		this.inviting = inviting;
	}
	public int getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(int byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
 
	
	
	
}
