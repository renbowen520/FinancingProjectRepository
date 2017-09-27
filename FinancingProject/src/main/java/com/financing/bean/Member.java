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
public class Member {//�û�������
		private int id;//�û�id
		private String member_name;//��ʵ����
		private String name;//�û���
		private String password;// ����
		private String salt;//������
		private String mobile_Phone;// �ֻ���
		private int status;// �ʺ�״̬��0������1������2ɾ����
		private String identity;// ���֤����
		private Date create_date;//����ʱ��
		private Date update_date;//�޸�ʱ��
		private String werBoAccount;//΢���ʺŹ���
		private String weixinAccount;//΢���ʺŹ���
		private String  headid;//ͷ��ͼƬ
		private String invitationCode;//������
		private String withdraw_password;//�������
		private String qqAccount;//qq�ʺŹ���
		private String invitedCode;//��������
		private String qqNumber;//qq����
		private String salt2;// ȡ��������
		
		//һ��һ
		private Member_account Member_account;//�����˻���
		//һ��һ
		private 	Bbin_info bbin_info;//�����
		
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
