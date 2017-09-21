package com.financing.Interface_dao;

import org.hibernate.Session;

import com.financing.bean.Bbin_info;

public interface IN_bbin_info_dao {
	 void save(Bbin_info bbin_info);
	 Session getSession();
}
