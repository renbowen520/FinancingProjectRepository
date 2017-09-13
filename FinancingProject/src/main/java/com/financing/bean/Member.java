package com.financing.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {//�û�������
		private int id;//�û�id
		private String member_name;//��ʵ����
		private String name;//�û���
		private String password;// ����
		private String salt;//������
		private String mobile_Phone;// �ֻ���
		private int status;// �ʺ�״̬��������������ɾ����
		private int del_flag;//ɾ������
		private String identity;// ���֤����
		private Date create_date;//����ʱ��
		private Date update_date;//�޸�ʱ��
		private String werBoAccount;//΢���ʺŹ���
		private String weixinAccount;//΢���ʺŹ���
		private int headid;//ͷ��ͼƬid
		private String invitatioinCode;//������
		private String withdraw_password;//�������
		private String qqAccount;//qq�ʺŹ���
		private String invitedCode;//��������
		private String qqNumber;//qq����
		
		
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
