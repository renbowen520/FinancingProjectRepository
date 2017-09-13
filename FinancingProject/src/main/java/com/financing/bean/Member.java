package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {//用户基本表
		private int id;//用户id
		private String member_name;//真实姓名
		private String name;//用户名
		private String password;// 密码
		private String salt;//密码盐
		private String mobile_Phone;// 手机号
		private int status;// 帐号状态（正常、锁定、删除）
		private int del_flag;//删除编制
		private String identity;// 身份证号码
		private Date create_date;//创建时间
		private Date update_date;//修改时间
		private String werBoAccount;//微博帐号关联
		private String weixinAccount;//微信帐号关联
		private int headid;//头像图片id
		private String invitatioinCode;//邀请码
		private String withdraw_password;//提款密码
		private String qqAccount;//qq帐号关联
		private String invitedCode;//被邀请码
		private String qqNumber;//qq号码
		
		
		@Id
		@GeneratedValue
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMember_name() {
			return member_name;
		}
		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSalt() {
			return salt;
		}
		public void setSalt(String salt) {
			this.salt = salt;
		}
		public String getMobile_Phone() {
			return mobile_Phone;
		}
		public void setMobile_Phone(String mobile_Phone) {
			this.mobile_Phone = mobile_Phone;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public int getDel_flag() {
			return del_flag;
		}
		public void setDel_flag(int del_flag) {
			this.del_flag = del_flag;
		}
		public String getIdentity() {
			return identity;
		}
		public void setIdentity(String identity) {
			this.identity = identity;
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
		public String getWerBoAccount() {
			return werBoAccount;
		}
		public void setWerBoAccount(String werBoAccount) {
			this.werBoAccount = werBoAccount;
		}
		public String getWeixinAccount() {
			return weixinAccount;
		}
		public void setWeixinAccount(String weixinAccount) {
			this.weixinAccount = weixinAccount;
		}
		public int getHeadid() {
			return headid;
		}
		public void setHeadid(int headid) {
			this.headid = headid;
		}
		public String getInvitatioinCode() {
			return invitatioinCode;
		}
		public void setInvitatioinCode(String invitatioinCode) {
			this.invitatioinCode = invitatioinCode;
		}
		public String getWithdraw_password() {
			return withdraw_password;
		}
		public void setWithdraw_password(String withdraw_password) {
			this.withdraw_password = withdraw_password;
		}
		public String getQqAccount() {
			return qqAccount;
		}
		public void setQqAccount(String qqAccount) {
			this.qqAccount = qqAccount;
		}
		public String getInvitedCode() {
			return invitedCode;
		}
		public void setInvitedCode(String invitedCode) {
			this.invitedCode = invitedCode;
		}
		public String getQqNumber() {
			return qqNumber;
		}
		public void setQqNumber(String qqNumber) {
			this.qqNumber = qqNumber;
		}
		
		
}
