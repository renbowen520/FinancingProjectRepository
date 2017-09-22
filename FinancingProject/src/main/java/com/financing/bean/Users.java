package com.financing.bean;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Users {
//�û�������  
	private  int id;
	private String user_name;//�û���
	private String  name;  //����
	private  String password;
	private  String salt;//������
	private  String mobile_Phone;
	private  int status;//'�˺�״̬��0������1������2ɾ����',
//	private int del_flag; //ɾ����־',
//	private int   identity;//���',
	private Date create_date;//����ʱ��
	private Date update_date;//�޸�ʱ��
	private User_role user_role; //���ý�ɫ�� һ��һ
	
	
	
	@OneToOne
	@JoinColumn(name="role_id")
	public User_role getUser_role() {
		return user_role;
	}
	public void setUser_role(User_role user_role) {
		this.user_role = user_role;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
/*	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}*/

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
	
	
	
}
