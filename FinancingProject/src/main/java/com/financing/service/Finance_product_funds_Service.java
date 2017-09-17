package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.financing.Interface_dao.IN_Finance_product_funds_dao;
import com.financing.Interface_service.IN_Finance_produce_funds_service;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.bean.Finance_product_subscribe_record;
import com.financing.bean.Member;
import com.financing.dao.Finance_product_funds_Dao;


@Service
@Transactional
public class Finance_product_funds_Service implements IN_Finance_produce_funds_service {
	
	@Autowired
	private IN_Finance_product_funds_dao finance_product_funds_Dao;

	
	//保存私募
	public void save(Finance_product_funds finance_product_funds){
		this.finance_product_funds_Dao.save(finance_product_funds);
	}
	
	//修改之前的查询
	public Finance_product_funds getById(int id){
		return this.finance_product_funds_Dao.getById(id);
	}
	
	
	//修改私募
	public void update(Finance_product_funds finance_product_funds){
		this.finance_product_funds_Dao.update(finance_product_funds);
	}
	
	//查询显示私募
	public List<Finance_product_funds> listfinance(Map map){
	return this.finance_product_funds_Dao.listfinance(map);
	}
	
	//查询显示私募订阅
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		return this.finance_product_funds_Dao.listfinanceSubscribe(id);
	}
	
	//签署合同
	public void savesubscribe(Finance_product_subscribe finance_product_subscribe){
		this.finance_product_funds_Dao.savesubscribe(finance_product_subscribe);
	}
	
	//签署合约之前的查询
	public Finance_product_subscribe getSubscribeById(int id){
		return this.finance_product_funds_Dao.getSubscribeById(id);
	}
	
	
}
