package com.financing.bean;

import java.math.BigDecimal;
import java.util.Date;

//��Ķ�����


public class Subject_order_record {
    
	private int id;  //����
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
