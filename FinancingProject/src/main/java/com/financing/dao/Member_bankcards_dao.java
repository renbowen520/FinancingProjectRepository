package com.financing.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_bankcards_dao;
import com.financing.bean.Member_bankcards;

@Component

public class Member_bankcards_dao implements IN_Member_bankcards_dao {
	
	
		@Resource
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return this.sessionFactory.getCurrentSession();
		}
		
		
		//根据用户查询卡号
		public List<Member_bankcards> getById(int id){
			Session session=getSession();
			Query query = session.createQuery("from Member_bankcards b where b.member_id.id=:id");
			query.setInteger("id", id);
			List<Member_bankcards>list = query.list();
			return list;
		}
		
		//查询绑卡信息以及身份信息
		public List<Member_bankcards> listmember_bankcards(Map map){
			String hql=" from Member_bankcards where 0=0";
			Session session=getSession();
			hql=listHql(map, hql);
			List<Member_bankcards> listmember_bankcards=session.createQuery(hql).list();
			return listmember_bankcards;
		}
		
		public String listHql(Map map,String hql){
			String mobile_Phonem=(String)map.get("mobile_Phonem");
			String member_namem=(String)map.get("member_namem");
			String card_nom=(String)map.get("card_nom");
			String create_datem=(String)map.get("create_datem");
			if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
				hql+="and member_id.mobile_Phone like '%"+mobile_Phonem+"%'";
			}
			if (member_namem!=null && !member_namem.equals("")) {
				hql+=" and member_id.member_name like '%"+member_namem+"%'";
			}
			if (card_nom!=null && !card_nom.equals("")) {
				hql+=" and card_no like '%"+card_nom+"%'";
			}
			
			if (create_datem!=null && !create_datem.equals("")) {
				hql+=" and create_date like '%"+create_datem+"%'";
			}
			return hql;
		}
}
