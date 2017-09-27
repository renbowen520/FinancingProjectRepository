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
public class Member_bankcards {//(成员银联表) 

		private int id;//绑卡id
		private String type;//银行卡类型
		private Member member_id;//用户表id 外键
		private  String card_no;//银行卡号
		private int delflag;//是否删除（0：正常使用，1：被删除）
		private Date create_date;//创建时间
		private Date update_date;//修改时间
		private String cardaddress;//开户银行所在地
		@Id
		@GeneratedValue
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@ManyToOne
		@JoinColumn(name="member_id")
		public Member getMember_id() {
			return member_id;
		}
		public void setMember_id(Member member_id) {
			this.member_id = member_id;
		}
		public String getCard_no() {
			return card_no;
		}
		public void setCard_no(String card_no) {
			this.card_no = card_no;
		}
		public int getDelflag() {
			return delflag;
		}
		public void setDelflag(int delflag) {
			this.delflag = delflag;
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
		public String getCardaddress() {
			return cardaddress;
		}
		public void setCardaddress(String cardaddress) {
			this.cardaddress = cardaddress;
		}
		
		
		
}
