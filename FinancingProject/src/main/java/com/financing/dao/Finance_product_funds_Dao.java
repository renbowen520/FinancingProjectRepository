package com.financing.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Finance_product_funds_dao;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;


@Component
public class Finance_product_funds_Dao  implements IN_Finance_product_funds_dao {
	@Resource
	private SessionFactory sf;
	
	public Session getSession() {
		return this.sf.getCurrentSession();
	}
	
	
	//��ҳ��ʾ
	
	
	//ģ����ѯ
	public String listDataHql(Map map,String hql){
		String   name=(String)map.get("name");
		String  status=(String) map.get("status");
		String  type=(String)map.get("type");
		if(name!=null&&!name.equals("")){
			hql+="    and f.name like '%"+name+"%'";
		}
		if(status!=null && !status.equals("")){
			hql+="    and    f.status="+status;
		}
		if(type!=null&&!type.equals("")){
			hql+="    and   f.type='"+type+"'";
		}
		
	//	System.out.println("hql======="+hql);
		return hql;
	}
	//��ѯ��ʾ��̨
	public List<Finance_product_funds> listfinance(Map map){
		String hql="from Finance_product_funds   f   where  0=0";
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Finance_product_funds> listfinance=session.createQuery(hql).list();
		return listfinance;
	}
	
	//ǰ̨��ѯ
	public List<Finance_product_funds> finance(Map map){
		String hql="from Finance_product_funds where 0=0";
		Session session=getSession();
		List<Finance_product_funds> finance=session.createQuery(hql).list();
		return finance;
	}
	
	//����
	public void save(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.save(finance_product_funds);
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	public Finance_product_funds getById(int id){
		Session session=getSession();
		Finance_product_funds finance_product_funds=(Finance_product_funds)session.get(Finance_product_funds.class, id);
		return finance_product_funds;
	}
	
	//�޸�
	public void update(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.update(finance_product_funds);
	}
	
	
	//ǩ��ʧ��ǰ��ѯ
	public Finance_product_subscribe getsubscribe(int id){
		Session session=getSession();
		Finance_product_subscribe finance_product_subscribe=(Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return finance_product_subscribe;
	}
	
	//ǩ��ʧ��
	public void lose(int id){
		Session session=this.getSession();
		Finance_product_subscribe finance_product_subscribe=this.getsubscribe(id);
		finance_product_subscribe.setStatus(3);
		session.update(finance_product_subscribe);
	}
	
	//�鿴ǩ��״̬
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		String hql = "from Finance_product_subscribe where product_id="+id+" order by create_date desc";
		Session session=getSession();
		List<Finance_product_subscribe> listfinanceSubcribe=session.createQuery(hql).list();
		return listfinanceSubcribe;
	}
	
	
	//����˽ļǩ���ͬ
	public void savesubscribe(Finance_product_subscribe finance_product_subscribe){
		Session session=getSession();
		finance_product_subscribe.setStatus(1);
		session.update(finance_product_subscribe);
	}
	
	public void updatesubscribe(Finance_product_subscribe finance_product_subscribe){
		Session session=getSession();
		session.update(finance_product_subscribe);
	}
	
	//��ѯǩԼ����Ϣ
	public Finance_product_subscribe getSubscribeById(int id){
		Session session=getSession();
		Finance_product_subscribe sub=(Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return sub;
	}


	
}
