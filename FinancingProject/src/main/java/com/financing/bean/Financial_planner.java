package com.financing.bean;

import java.util.Date;

public class Financial_planner {
//理财师表
	private int  id;//主键
	private String name;//真实姓名
	private String orgname;//机构名称
	private String mycard;//我的名片
	private String address;//地址
	private int status;//状态
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	private Member member;//引用会员id

}
