package com.financing.bean;

import java.util.Date;

public class Users {
//用户基本表  
	private  int id;
	private String user_name;//用户名
	private String  name;  //名称
	private  String password;
	private  String salt;//密码盐
	private  String mobile_Phone;
	private  int status;//'账号状态（0正常，1锁定，2删除）',
	private int del_flag; //删除标志',
	private int   identity;//身份',
	private Date create_date;//创建时间
	private Date update_date;//修改时间
}
