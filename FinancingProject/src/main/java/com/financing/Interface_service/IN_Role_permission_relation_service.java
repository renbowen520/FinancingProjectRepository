package com.financing.Interface_service;

import java.util.List;
import java.util.Set;

import com.financing.bean.Role_permission_relation;

public interface IN_Role_permission_relation_service {

	List<Role_permission_relation> listAll();
	List<Integer>list_role_All(int rid);
	Role_permission_relation getById(int id);
	 Set<String>list_pname(int uid);
}
