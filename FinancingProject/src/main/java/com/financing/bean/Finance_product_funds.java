package com.financing.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Finance_product_funds {
	
	//私募产品表
	private int id;
	private String type;//类型
	private String name;//名称
	private int status;//状态
	private int period;//周期
	private double floor_amount;//起投金额
	private double year_rate;//年化率
	private int subscribe_count;//预约人数
	private String product_topic;//关于基金、基金专题
	private String product_factor;//产品要素
	private String product_strategy;// 产品策略
	private String product_manager;//基金经理详细
	private Date update_date;
	private Date create_date;
	private String product_manager_name;//管理人名称
	private String product_manager_pic;//管理人图片
	private String product_manager_title;//管理人头衔
	private String product_manager_desc;//产品管理人介绍
	private String invest_points;//投资方向
	private double amount;//募集金额
	private double sold_amount;//已售金额
	private int buyer_count;//购买人数
	private String start_date;//开始时间
	private String end_date;//结束时间
	private double ratio;//返佣比例
	private String contract;//私募合同
	private String bank_account;//银行账户(银行名称，账号，户名)
	
	private Set<Finance_product_subscribe> finance_product_subscribe=new HashSet<>();
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="finance_product_funds")
	public Set<Finance_product_subscribe> getFinance_product_subscribe() {
		return finance_product_subscribe;
	}
	public void setFinance_product_subscribe(Set<Finance_product_subscribe> finance_product_subscribe) {
		this.finance_product_subscribe = finance_product_subscribe;
	}

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getFloor_amount() {
		return floor_amount;
	}
	public void setFloor_amount(double floor_amount) {
		this.floor_amount = floor_amount;
	}
	public double getYear_rate() {
		return year_rate;
	}
	public void setYear_rate(double year_rate) {
		this.year_rate = year_rate;
	}
	public int getSubscribe_count() {
		return subscribe_count;
	}
	public void setSubscribe_count(int subscribe_count) {
		this.subscribe_count = subscribe_count;
	}
	public String getProduct_topic() {
		return product_topic;
	}
	public void setProduct_topic(String product_topic) {
		this.product_topic = product_topic;
	}
	public String getProduct_factor() {
		return product_factor;
	}
	public void setProduct_factor(String product_factor) {
		this.product_factor = product_factor;
	}
	public String getProduct_strategy() {
		return product_strategy;
	}
	public void setProduct_strategy(String product_strategy) {
		this.product_strategy = product_strategy;
	}
	public String getProduct_manager() {
		return product_manager;
	}
	public void setProduct_manager(String product_manager) {
		this.product_manager = product_manager;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getProduct_manager_name() {
		return product_manager_name;
	}
	public void setProduct_manager_name(String product_manager_name) {
		this.product_manager_name = product_manager_name;
	}
	public String getProduct_manager_pic() {
		return product_manager_pic;
	}
	public void setProduct_manager_pic(String product_manager_pic) {
		this.product_manager_pic = product_manager_pic;
	}
	public String getProduct_manager_title() {
		return product_manager_title;
	}
	public void setProduct_manager_title(String product_manager_title) {
		this.product_manager_title = product_manager_title;
	}
	public String getProduct_manager_desc() {
		return product_manager_desc;
	}
	public void setProduct_manager_desc(String product_manager_desc) {
		this.product_manager_desc = product_manager_desc;
	}
	public String getInvest_points() {
		return invest_points;
	}
	public void setInvest_points(String invest_points) {
		this.invest_points = invest_points;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getSold_amount() {
		return sold_amount;
	}
	public void setSold_amount(double sold_amount) {
		this.sold_amount = sold_amount;
	}
	public int getBuyer_count() {
		return buyer_count;
	}
	public void setBuyer_count(int buyer_count) {
		this.buyer_count = buyer_count;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	
	
}
