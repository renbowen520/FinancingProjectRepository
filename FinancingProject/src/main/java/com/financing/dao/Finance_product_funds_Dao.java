package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;


@Component
public class Finance_product_funds_Dao {
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	
	//查询显示
	public List<Finance_product_funds> listfinance(){
		String hql="from Finance_product_funds where 0=0";
		Session session=getSession();
		List<Finance_product_funds> listfinance=session.createQuery(hql).list();
		return listfinance;
	}
	
	
	
	//新增
	public void save(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.save(finance_product_funds);
	}
	
	//修改之前的查询
	public Finance_product_funds getById(int id){
		Session session=getSession();
		Finance_product_funds finance_product_funds=(Finance_product_funds)session.get(Finance_product_funds.class, id);
		return finance_product_funds;
	}
	
	//修改
	public void update(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.update(finance_product_funds);
	}
	
	//查看预约 
	//查询显示
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		String hql="from Finance_product_subscribe";
		Session session=getSession();
		List<Finance_product_subscribe> listfinanceSubcribe=session.createQuery(hql).list();
		return listfinanceSubcribe;
	}
	
}
