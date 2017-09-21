package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.bean.Subject;

public interface IN_Finance_product_funds_dao {

	 Session getSession();
	<T>T  listDataHql(Map map,String hql);
	<T>T listfinance(Map map);
	void save(Finance_product_funds finance_product_funds);
	 Finance_product_funds getById(int id);
	 void update(Finance_product_funds finance_product_funds);
	 List<Finance_product_subscribe> listfinanceSubscribe(int id);
	 void savesubscribe(Finance_product_subscribe finance_product_subscribe);
	 Finance_product_subscribe getSubscribeById(int id);
	 void updatesubscribe(Finance_product_subscribe finance_product_subscribe);
	 Finance_product_subscribe getsubscribe(int id);
	 void lose(int id);
	 List<Finance_product_funds> finance(Map map);
}
