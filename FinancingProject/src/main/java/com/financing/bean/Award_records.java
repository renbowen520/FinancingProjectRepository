package com.financing.bean;

import java.util.Date;

public class Award_records {
//奖励记录表
	private  int id;//主键
	private  int inviting ;//邀请人id
	private int byinvitingid;//被邀请人id
	private int type;//奖励类型 0注册   1投资
	private int isAward;//奖励状态  0未  1已经
	private Date addTime;//添加时间
	
	
	
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
