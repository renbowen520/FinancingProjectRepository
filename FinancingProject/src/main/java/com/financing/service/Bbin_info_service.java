package com.financing.service;

import javax.transaction.Transactional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financing.Interface_dao.IN_bbin_info_dao;
import com.financing.Interface_service.IN_bbin_info_service;
import com.financing.bean.Bbin_info;


@Service
@Transactional
public class Bbin_info_service implements IN_bbin_info_service {

	@Autowired
	private IN_bbin_info_dao dao;
	
	@Override
	public void save(Bbin_info bbin_info) {
	dao.save(bbin_info);
	}

}
