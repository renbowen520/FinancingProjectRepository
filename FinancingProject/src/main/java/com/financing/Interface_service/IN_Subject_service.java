package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;

public interface IN_Subject_service {
	 void save(Subject subject);
	 void update(Subject subject);
	 List<Subject> listSubject(Map map);
	 Subject getById(int id);
	 List<Subject_bbin_purchase_record> listsubjectrecord(int id);
	 
}
