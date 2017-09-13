package com.financing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.dao.Finance_product_funds_Dao;


@Service
@Transactional
public class Finance_product_funds_Service {
	@Autowired
	private Finance_product_funds_Dao finance_product_funds_Dao;
	
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

}
