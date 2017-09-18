package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.Subject_bbin_purchase_record;


public interface IN_Subject_bbin_purchase_record_dao {
	Session getSession();
	
	List<Subject_bbin_purchase_record> listsubject_bbin_purchase_record(int id);
	
}
