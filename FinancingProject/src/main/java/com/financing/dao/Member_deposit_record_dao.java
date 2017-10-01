package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_deposit_record_dao;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;

@Component
public class Member_deposit_record_dao implements IN_Member_deposit_record_dao {
	@Resource
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return this.sessionFactory.getCurrentSession();
		};
		
		
		
		//查询充值记录
		public Member_deposit_record get_deposit(String no) {
			Session session=getSession();
			Query  query =  session.createQuery("from  Member_deposit_record  where  pay_channel_order_no=:no");
		   query.setString("no", no);
		   List<Member_deposit_record>list=query.list();
		  Member_deposit_record m2=null;
		   for (Member_deposit_record member_deposit_record : list) {
			  m2=  member_deposit_record;
		}
		   return m2;
		}
		
		//修改充值记录
		public void update(Member_deposit_record member_deposit_record
				,Member_trade_record member_trade_record
				) {
			Session session=getSession();
			session.update(member_deposit_record);
			session.save(member_trade_record);
		}
		
		
		//保存充值记录
		public void save(Member_deposit_record member_deposit_record) {
			Session session=getSession();
			session.save(member_deposit_record);
		}
		
		//显示充值记录表
		public List<Member_deposit_record> listMember_deposit_record(Map map){
			String hql=" from Member_deposit_record where 0=0";
			Session session=getSession();
			hql=listMember_deposit_record(map, hql);
			List<Member_deposit_record> listMember_deposit_record=session.createQuery(hql).list();
			return listMember_deposit_record;
		}
		
		public String listMember_deposit_record(Map map,String hql){
			String serial_numberm=(String)map.get("serial_numberm");
			String mobile_Phonem=(String)map.get("mobile_Phonem");
			String statusm=(String)map.get("statusm");
			String pay_channel_namem=(String)map.get("pay_channel_namem");
			String create_datem=(String)map.get("create_datem");
			
			if (serial_numberm!=null && !serial_numberm.equals("")) {
				hql+=" and serial_number like '%"+serial_numberm+"%'";
			}
			if (mobile_Phonem!=null && !mobile_Phonem.equals("")) {
				hql+="and member_id.mobile_Phone like '%"+mobile_Phonem+"%'";
			}
			if (statusm!=null && !statusm.equals("")) {
				hql+="and status like '%"+statusm+"%'";
			}
			if (pay_channel_namem!=null &&  !pay_channel_namem.equals("")) {
				hql+=" and pay_channel_name like '%"+pay_channel_namem+"%'";
			}
			if (create_datem!=null && !create_datem.equals("")) {
				hql+=" and create_date like '%"+create_datem+"%'";
			}
			return hql;
		}
}
