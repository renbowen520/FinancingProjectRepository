package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_dao;
import com.financing.bean.Member;
import com.financing.bean.Users;

@Component
public class Member_dao implements IN_Member_dao {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Member getById(int id) {
		   Session session = this.getSession();
		   Member member = (Member) session.get(Member.class, id);
		   return member;
	}
	
	
	//查询邀请码
	public Member getByCode(String code) {
		   Session session = this.getSession();
		    Query query = session.createQuery("from Member  where  invitationCode=:code");
			  query.setString("code", code);
			  List<Member> list=query.list();
		  	Member member=null; 
		 	for(Member member2:list){
		 		member=member2;
			}
			return member;
	}
	
	
	//邀请码生成
	public String getma(int k) {
		 String s="";
		   for(int i=0;i<k;i++) {
			 String chars = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";
			    s+=chars.charAt((int)(Math.random() * 52));
		   }
		  return s;
	}
	
	
	
	
	//根据手机号查询
	public Member getByPhone(String phone) {
		    Session session = this.getSession();
		    Query query = session.createQuery("from Member  where mobile_Phone=:phone");
			  query.setString("phone", phone);
			  List<Member> list=query.list();
		  	Member member=null; 
		 	for(Member member2:list){
		 		member=member2;
			}
			return member;
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


	@Override 
	public void save(Member member) {  //保存
		// TODO Auto-generated method stub
		Session session=getSession();
		session.save(member);
	}
}
