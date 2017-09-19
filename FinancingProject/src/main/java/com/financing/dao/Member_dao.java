package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_dao;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;

@Component
public class Member_dao implements IN_Member_dao {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//显示帐号信息
	public List<Member> listMember(Map map){
		String hql="from Member where 0=0";
		Session session=getSession();
		hql=listMemberM(map, hql);
		List<Member> listMember=session.createQuery(hql).list();
		return listMember;
	}
	//模糊查询
	public String listMemberM(Map map,String hql){
		String mname=(String)map.get("mname");
		System.out.println("mname用户名:"+mname);
		String mobile_Phonem=(String)map.get("mobile_Phonem");
		System.out.println("mobile_Phonem手机号:"+mobile_Phonem);
		String member_namem=(String)map.get("member_namem");
		System.out.println("member_namem真实姓名:"+member_namem);
		String invitatioinCodem=(String)map.get("invitatioinCodem");
		System.out.println("invitatioinCodem邀请码:"+invitatioinCodem);
		
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
	
	
	//账号详情  显示账户信息
	public List<Member> getMemberById(int id){
		String hql="from Member where id="+id;
		Session session=getSession();
		List<Member> getmemberbyid=session.createQuery(hql).list();
		return getmemberbyid;
	}
	
	//根据账号id显示该账号的资金信息
	public List<Member_account> listMember_account(int id){
		String hql="from Member_account where member_id="+id;
		Session session=getSession();
		List<Member_account>listMember_account=session.createQuery(hql).list();
		return listMember_account;
	}
	
	//根据账号id显示该账号的提现记录
	public List<Member_withdraw_record> getMember_withdraw_recordByid(int id){
		String hql="from Member_withdraw_record where member_id="+id;
		Session session=getSession();
		List<Member_withdraw_record> getmember_withdraw_recordByid =session.createQuery(hql).list();
		return getmember_withdraw_recordByid;
	}
	
	
	
	public List<Member_deposit_record> getMember_deposit_recordById(int id){
		String hql="from Member_deposit_record where member_id="+id;
		Session session=getSession();
		List<Member_deposit_record> getmember_deposit_recordByid= session.createQuery(hql).list();
		return getmember_deposit_recordByid;
	}
	
	//根据账号id显示该账号的投资记录
	public List<Member_trade_record> listMember_trade_record(int id){
		String hql="from Member_trade_record where id="+id;
		Session session=getSession();
		List<Member_trade_record> listmember_trade_record = session.createQuery(hql).list();
		return listmember_trade_record;
	}
	//根据账号id显示该账号的充值记录
	public List<Subject_purchase_record> getSubject_purchase_record(int id){
		String hql="from Subject_purchase_record where member_id="+id;
		Session session=getSession();
		List<Subject_purchase_record> listsubject_purchase_record=session.createQuery(hql).list();
		return listsubject_purchase_record;
	}
	
	
}
