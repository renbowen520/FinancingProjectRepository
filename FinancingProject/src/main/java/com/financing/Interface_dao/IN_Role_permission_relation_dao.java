package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.Role_permission_relation;

public interface IN_Role_permission_relation_dao {
	 Session getSession();
	 List<Role_permission_relation> listAll();
	 List<Integer>list_role_All(int rid);
}