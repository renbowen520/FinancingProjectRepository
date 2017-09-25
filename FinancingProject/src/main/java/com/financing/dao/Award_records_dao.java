package com.financing.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_award_records_dao;
import com.financing.bean.Award_records;

@Component
public class Award_records_dao  implements IN_award_records_dao{

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Award_records award_records) {
		 Session  session = this.getSession();
		 session.save(award_records);
	}

//ÑûÇë½±Àø
	public List<Award_records> listaward_records(Map map){
		String hql="from Award_records ar where 0=0";
		Session session=getSession();
		hql=listMap(map, hql);
		List<Award_records> listaward_records=session.createQuery(hql).list();
		return listaward_records;
	}
	//Ä£ºý²éÑ¯
	public String listMap(Map map,String hql){
		String member_namem=(String)map.get("member_namem");
		String mobile_Phonem=(String)map.get("mobile_Phonem");
		String invitationCodem=(String)map.get("invitationCodem");
		String invitedCodem=(String)map.get("invitedCodem");
		String typem=(String)map.get("typem");
		String isAwardm=(String)map.get("isAwardm");
		
		if (member_namem!=null && !member_namem.equals("")) {
			hql+=" and ar.member.member_name like '%"+member_namem+"%'";
		}
		if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
			hql+=" and ar.member.mobile_Phone like '%"+mobile_Phonem+"%'";
		}
		if (invitationCodem!=null && !invitationCodem.equals("")) {
			hql+=" and ar.member.invitationCode like '%"+invitationCodem+"%'";
		}
		
		if (invitedCodem!=null && !invitedCodem.equals("")) {
			hql+=" and ar.member.invitedCode like '%"+invitedCodem+"%'";
		}
		if (typem!=null && !typem.equals("")) {
			hql+=" and ar.type="+typem;
		}
		if (isAwardm!=null && !isAwardm.equals("")) {
			hql+=" and ar.isAward="+isAwardm;
		}
		return hql;
	}
	
	//ÑûÇë½±Àø¼Ç
	
	public List<Award_records> getAward_records(int id){
		System.out.println("dao");
		String hql="from Award_records a where a.member.id="+id;
		Session session=getSession();
		List<Award_records> listAward_records=session.createQuery(hql).list();
		for (Award_records a : listAward_records) {
			System.out.println("iD"+a.getId());
		}
		return listAward_records;
	}
	
}
