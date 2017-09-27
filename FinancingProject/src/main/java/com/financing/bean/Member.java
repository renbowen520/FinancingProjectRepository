package com.financing.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
		private int status;// 帐号状态（0正常、1锁定、2删除）
		private String identity;// 身份证号码
		private Date create_date;//创建时间
		private Date update_date;//修改时间
		private String werBoAccount;//微博帐号关联
		private String weixinAccount;//微信帐号关联
		private String  headid;//头像图片
		private String invitationCode;//邀请码
		private String withdraw_password;//提款密码
		private String qqAccount;//qq帐号关联
		private String invitedCode;//被邀请码
		private String qqNumber;//qq号码
		private String salt2;// 取款密码盐
		
		//一对一
		private Member_account Member_account;//关联账户表
		//一对一
		private 	Bbin_info bbin_info;//体验金
		
		@OneToOne(mappedBy="member",cascade=CascadeType.ALL)
		public Bbin_info getBbin_info() {
			return bbin_info;
		}
		public void setBbin_info(Bbin_info bbin_info) {
			this.bbin_info = bbin_info;
		}
		
		@OneToOne(mappedBy="member",cascade=CascadeType.ALL)
		public Member_account getMember_account() {
			return Member_account;
		}
	
		public void setMember_account(Member_account member_account) {
			Member_account = member_account;
		}
		@Id
		@GeneratedValue
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getHeadid() {
			return headid;
		}
		public void setHeadid(String headid) {
			this.headid = headid;
		}
		public String getSalt2() {
			return salt2;
		}
		public void setSalt2(String salt2) {
			this.salt2 = salt2;
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
		

	
	
		
		public String getInvitationCode() {
			return invitationCode;
		}
		public void setInvitationCode(String invitationCode) {
			this.invitationCode = invitationCode;
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
