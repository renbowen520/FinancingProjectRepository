package com.financing.Interface_service;

import java.util.List;

import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;

public interface IN_Oversea_config_service {
	void save(Oversea_config oversea_config);
	Oversea_config getById(int id);
	 void update(Oversea_config oversea_config);
	 List<Oversea_config> listOversea();
	 
	 List<Oversea_config_subscribe> listConfig(int id);
	 
}
