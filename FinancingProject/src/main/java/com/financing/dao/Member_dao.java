package com.financing.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Member;

@Component
public class Member_dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//��ʾ�ʺ���Ϣ
	public List<Member> listMember(Map map){
		String hql="from Member where 0=0";
		Session session=getSession();
		hql=listMemberM(map, hql);
		List<Member> listMember=session.createQuery(hql).list();
		return listMember;
	}
	//ģ����ѯ
	public String listMemberM(Map map,String hql){
		String mname=(String)map.get("mname");
		System.out.println("mname�û���:"+mname);
		String mobile_Phonem=(String)map.get("mobile_Phonem");
		System.out.println("mobile_Phonem�ֻ���:"+mobile_Phonem);
		String member_namem=(String)map.get("member_namem");
		System.out.println("member_namem��ʵ����:"+member_namem);
		String invitatioinCodem=(String)map.get("invitatioinCodem");
		System.out.println("invitatioinCodem������:"+invitatioinCodem);
		
		if(mname!=null && !mname.equals("")){
			hql+=" and name like '%"+mname+"%'";
		}
		if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
			hql+=" and mobile_Phone like '%"+mobile_Phonem+"%'";
		}
		if (member_namem!=null && !member_namem.equals("")) {
			hql+=" and member_name like '%"+member_namem+"%'";
		}
		if (invitatioinCodem!=null&& !invitatioinCodem.equals("")) {
			hql+=" and invitatioinCode like '%"+invitatioinCodem+"%'";
		}
		System.out.println("hql:"+hql);
		return hql;
	}
}