package com.financing.Interface_dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.financing.bean.Role_permission_relation;

public interface IN_Role_permission_relation_dao {
	 Session getSession();
	 List<Role_permission_relation> listAll();
	 List<Integer>list_role_All(int rid);
	 Role_permission_relation getById(int id);
	 Set<String>list_pname(int uid);
}
