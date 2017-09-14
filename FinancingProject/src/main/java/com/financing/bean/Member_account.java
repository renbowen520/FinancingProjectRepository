package com.financing.bean;

import java.util.Date;

public class Member_account {
//成员账号表
	private String id;  //主键
	private double  useable_balance;//可用余额
	private double imuseale_balance;//冻结资金
	private double total_profit;//累计收益
	private Date create_date; //创建时间
	private Date update_date;//修改时间
	private double bonus_amount;//红包金额
	private double invest_amount;//投资金额
	private int delflag; //状态
	private double bbin_amount;//体验金
	private Member member;//引用用户表id
	
	
}
