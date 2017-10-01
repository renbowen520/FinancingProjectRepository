package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.financing.Interface_dao.IN_Member_dao;
import com.financing.bean.Award_records;
import com.financing.bean.Bank;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Sys_region;
import com.financing.bean.Users;


@Component
public class Member_dao implements IN_Member_dao {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Sys_region> get_s333( int rid,  int  pid ) { //ѡ���ַ
	    Session session = this.getSession();
	    Query query = session.createQuery("from Sys_region s  where  s.region_level=:rid  and  s.parent_id=:pid ");
		query.setInteger("rid", rid);
	    query.setInteger("pid", pid);
	    List<Sys_region> list=query.list();
	     return list;
}
	
	
/*	public List<Sys_region> get_s222(int  id ) { //ѡ���ַ
		    Session session = this.getSession();
		    Query query = session.createQuery("from Sys_region  where  region_level=2  and parent_id=:id");
			query.setInteger("id", id);
		    List<Sys_region> list=query.list();
		     return list;
	}
	*/
	
	
/*	public List<Sys_region> get_s111(int  id ) { //ѡ���ַ
		   Session session = this.getSession();
		    Query query = session.createQuery("from Sys_region  where  region_level=:id");
			query.setInteger("id", id);
		    List<Sys_region> list=query.list();
		     return list;
	}
	*/
	
	
	public List<Bank> get_bank() {
		   Session session = this.getSession();
		    Query query = session.createQuery("from Bank  where  0=0");
			  List<Bank> list=query.list();
		     return list;
	}
	
	public Bank get_bank_id(int id) {
		 Session session = this.getSession();
		 Bank bank = (Bank) session.get(Bank.class, id);
		 return bank;
	}
	
	
	
	
	public void update(Member member) {
		   Session session = this.getSession();
		   session.update(member);
	}
	
	
	public Member getById(int id) {
		   Session session = this.getSession();
		   Member member = (Member) session.get(Member.class, id);
		   return member;
	}
	
	
	//��ѯ������
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
	
	
	//����������
	public String getma(int k) {
		 String s="";
		   for(int i=0;i<k;i++) {
			 String chars = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";
			    s+=chars.charAt((int)(Math.random() * 52));
		   }
		  return s;
	}
	
	
	//�������֤�Ų�ѯ
	public Member getByIdentity(String identity) {
		    Session session = this.getSession();
		    Query query = session.createQuery("from Member  where identity=:identity");
			  query.setString("identity", identity);
			  List<Member> list=query.list();
		  	Member member=null; 
		 	for(Member member2:list){
		 		member=member2;
			}
			return member;
	}
	
	
	
	
	//�����ֻ��Ų�ѯ
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

	
	
	//�˺�����  ��ʾ�˻���Ϣ
	public List<Member> getMemberById(int id){
		String hql="from Member where id="+id;
		Session session=getSession();
		List<Member> getmemberbyid=session.createQuery(hql).list();
		return getmemberbyid;
	}
	
	//�����˺�id��ʾ���˺ŵ��ʽ���Ϣ
	public List<Member_account> listMember_account(int id){
		String hql="from Member_account where member_id="+id;
		Session session=getSession();
		List<Member_account>listMember_account=session.createQuery(hql).list();
		return listMember_account;
	}
	
	//�����˺�id��ʾ���˺ŵ����ּ�¼
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
	
	//�����˺�id��ʾ���˺ŵ�Ͷ�ʼ�¼
	public List<Member_trade_record> listMember_trade_record(int id){
		String hql="from Member_trade_record where id="+id;
		Session session=getSession();
		List<Member_trade_record> listmember_trade_record = session.createQuery(hql).list();
		return listmember_trade_record;
	}
	//�����˺�id��ʾ���˺ŵĳ�ֵ��¼
	public List<Subject_purchase_record> getSubject_purchase_record(int id){
		String hql="from Subject_purchase_record where member_id="+id;
		Session session=getSession();
		List<Subject_purchase_record> listsubject_purchase_record=session.createQuery(hql).list();
		return listsubject_purchase_record;
	}
	
	



	@Override 
	public void save(Member member) {  //����
		// TODO Auto-generated method stub
		Session session=getSession();
		session.save(member);
	}
	
	//ע�ᱣ�� ��Ա��  ������  ������  �˻���
	public void saveAll(Member member
			,Bbin_info bbin_info,Award_records award_records,
			Member_account member_account
			) {
		Session session=getSession();
		session.save(member);
		session.save(bbin_info);
		session.save(award_records);
		session.save(member_account);
	 }

}
