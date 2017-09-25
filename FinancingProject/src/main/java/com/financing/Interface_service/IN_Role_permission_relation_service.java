package com.financing.Interface_service;

import java.util.List;

import com.financing.bean.Role_permission_relation;

public interface IN_Role_permission_relation_service {

	List<Role_permission_relation> listAll();
	List<Integer>list_role_All(int rid);
}
