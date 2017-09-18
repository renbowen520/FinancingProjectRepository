package com.financing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.bean.Finance_product_subscribe_record;
import com.financing.bean.Member;
import com.financing.dao.Finance_product_funds_Dao;


@Service
@Transactional
public class Finance_product_funds_Service {
	@Autowired
	private Finance_product_funds_Dao finance_product_funds_Dao;
	
	//����˽ļ
	public void save(Finance_product_funds finance_product_funds){
		this.finance_product_funds_Dao.save(finance_product_funds);
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	public Finance_product_funds getById(int id){
		return this.finance_product_funds_Dao.getById(id);
	}
	
	
	//�޸�˽ļ
	public void update(Finance_product_funds finance_product_funds){
		this.finance_product_funds_Dao.update(finance_product_funds);
	}
	
	//��ѯ��ʾ˽ļ
	public List<Finance_product_funds> listfinance(Map map){
	return this.finance_product_funds_Dao.listfinance(map);
	}
	
	//��ѯ��ʾ˽ļ����
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		return this.finance_product_funds_Dao.listfinanceSubscribe(id);
	}
	
	//ǩ���ͬ
	public void savesubscribe(Finance_product_subscribe finance_product_subscribe){
		this.finance_product_funds_Dao.savesubscribe(finance_product_subscribe);
	}
	
	public void updatesubscribe(Finance_product_subscribe finance_product_subscribe){
		this.finance_product_funds_Dao.updatesubscribe(finance_product_subscribe);
	}
	
	//ǩ���Լ֮ǰ�Ĳ�ѯ
	public Finance_product_subscribe getSubscribeById(int id){
		return this.finance_product_funds_Dao.getSubscribeById(id);
	}
	//ǩ��ʧ�ܲ�ѯ
	public Finance_product_subscribe getsubscribe(int id){
		return this.finance_product_funds_Dao.getsubscribe(id);
	}
	//ǩ��ʧ��
	public void losesubscribe(int id){
		this.finance_product_funds_Dao.lose(id);
	}
	
}
