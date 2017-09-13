package com.financing.bean;

import java.math.BigDecimal;
import java.util.Date;

//标的订单表


public class Subject_order_record {
    
	private int id;  //主键
	private String serial_number;//
	
	private BigDecimal amount;
	private Date createDate;
	private byte dealType;
	private byte delflag;
	
	private byte status;
	private Date updateDate;
	private Member member;
	private Subject subject;

	
}
