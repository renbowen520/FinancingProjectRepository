package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;

public interface IN_Finance_produce_funds_service {
	void save(Finance_product_funds finance_product_funds);
	Finance_product_funds getById(int id);
	 void update(Finance_product_funds finance_product_funds);
	 List<Finance_product_funds> listfinance(Map map);
	 List<Finance_product_subscribe> listfinanceSubscribe(int id);
	 void savesubscribe(Finance_product_subscribe finance_product_subscribe);
	 Finance_product_subscribe getSubscribeById(int id);
	 void updatesubscribe(Finance_product_subscribe finance_product_subscribe);
	 void losesubscribe(int id);
	 Finance_product_subscribe getsubscribe(int id);
}
