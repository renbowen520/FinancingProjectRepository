package com.financing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Subject_purchase_record_dao;
import com.financing.Interface_service.IN_Subject_purchase_record_service;
import com.financing.bean.Subject_purchase_record;

@Service
@Transactional
public class Subject_purchase_record_service  implements IN_Subject_purchase_record_service {
		
	@Autowired
	private IN_Subject_purchase_record_dao isprd;
	
	public List<Subject_purchase_record> getSubject_purchase_record(int id){
		return this.isprd.getSubject_purchase_record(id);
	}
	
}
