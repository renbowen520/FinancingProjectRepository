package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Role_permission_relation_dao;
import com.financing.bean.Role_permission_relation;
@Component
public class Role_permission_relation_dao  implements IN_Role_permission_relation_dao{
	 
	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	
	//查询所有的权限
	public List<Role_permission_relation> listAll() {
		Session session = getSession();
		List<Role_permission_relation> list = session.createQuery("from Role_permission_relation  where 0=0").list();
		return list;
	}

	//查询角色拥有的权限
	 public  List<Integer>list_role_All(int rid){
		   Session session = getSession();
	       Query query = session.createSQLQuery("select  pid  from  user_ss where  rid=:rid");
		     query.setInteger("rid", rid); 
		    return  query.list();
	}
	
}
