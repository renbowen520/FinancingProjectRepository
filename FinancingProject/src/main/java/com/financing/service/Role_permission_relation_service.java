package com.financing.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Role_permission_relation_dao;
import com.financing.Interface_service.IN_Role_permission_relation_service;
import com.financing.bean.Role_permission_relation;


@Service
@Transactional
public class Role_permission_relation_service  implements IN_Role_permission_relation_service {

	@Autowired
	private  IN_Role_permission_relation_dao IN_Role_permission_relation_dao;
	
	@Override
	public List<Role_permission_relation> listAll() {
		// TODO Auto-generated method stub
		return IN_Role_permission_relation_dao.listAll();
	}

	@Override
	public List<Integer> list_role_All(int rid) {
		// TODO Auto-generated method stub
		return IN_Role_permission_relation_dao.list_role_All(rid);
	}

}
