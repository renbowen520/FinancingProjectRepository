package com.financing.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;

@Component
public class Member_withdraw_record_dao {//���ּ�¼���ܰ�
		
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//��ʾ�������ּ�¼
	public List<Member_withdraw_record> listmember_withdraw_record(Map map){
		String hql=" from Member_withdraw_record where 0=0";
		Session session=getSession();
		hql=listMember_withdraw_record(map, hql);
		List<Member_withdraw_record> listmember_withdraw_record=session.createQuery(hql).list();
		return listmember_withdraw_record;
	}
	
	
	//ģ����ѯ
	public String listMember_withdraw_record(Map map,String hql){
		String member_namem=(String)map.get("member_namem");
		String mobile_Phonem=(String)map.get("mobile_Phonem");
		String bank_cardm=(String)map.get("bank_cardm");
		String create_datem=(String)map.get("create_datem");
		
		if (member_namem!=null && !member_namem.equals("")) {
			hql+=" and member_id.member_name like '%"+member_namem+"%'";
		}
		if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
			hql+=" and member_id.mobile_Phone like '%"+mobile_Phonem+"%'";
		}
		if (bank_cardm!=null && !bank_cardm.equals("")) {
			hql+="and bank_card like '%"+bank_cardm+"%'";
		}
		if (create_datem!=null && !create_datem.equals("")) {
			hql+="and create_date like '%"+create_datem+"%'";
		}
		
		return hql;
	}
	
	//��ʾ�ʺ���Ϣ
		public List<Member> listMember(){
			String hql="from Member ";
			Session session=getSession();
//			hql=listMemberM(map, hql);
			List<Member> listMember=session.createQuery(hql).list();
			return listMember;
		}
		//ģ����ѯ
//		public String listMemberM(Map map,String hql){
//			String mname=(String)map.get("mname");
//			System.out.println("mname�û���:"+mname);
//			String mobile_Phonem=(String)map.get("mobile_Phonem");
//			System.out.println("mobile_Phonem�ֻ���:"+mobile_Phonem);
//			String member_namem=(String)map.get("member_namem");
//			System.out.println("member_namem��ʵ����:"+member_namem);
//			String invitatioinCodem=(String)map.get("invitatioinCodem");
//			System.out.println("invitatioinCodem������:"+invitatioinCodem);
//			
//			if(mname!=null && !mname.equals("")){
//				hql+=" and name like '%"+mname+"%'";
//			}
//			if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
//				hql+=" and mobile_Phone like '%"+mobile_Phonem+"%'";
//			}
//			if (member_namem!=null && !member_namem.equals("")) {
//				hql+=" and member_name like '%"+member_namem+"%'";
//			}
//			if (invitatioinCodem!=null&& !invitatioinCodem.equals("")) {
//				hql+=" and invitatioinCode like '%"+invitatioinCodem+"%'";
//			}
//			System.out.println("hql:"+hql);
//			return hql;
//		}
}
