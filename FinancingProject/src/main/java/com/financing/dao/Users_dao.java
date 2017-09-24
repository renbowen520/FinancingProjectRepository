package com.financing.dao;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.financing.Interface_dao.IN_Users_dao;
import com.financing.bean.Feedback;
import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;
import com.financing.bean.User_log;
import com.financing.bean.Users;
@Component
public class Users_dao  implements IN_Users_dao{
    //对用户表的操作 
	 
	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	
	//登陆日志
	public void  save_User_log(User_log user_log) {
		 Session session = this.getSession();
		  session.save(user_log);
	}
	
	
	//得到客户端的真实ip
	 public String getIpAddr(HttpServletRequest request){  
	        String ipAddress = request.getHeader("x-forwarded-for");  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getRemoteAddr();  
	                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
	                    //根据网卡取本机配置的IP  
	                    InetAddress inet=null;  
	                    try {  
	                        inet = InetAddress.getLocalHost();  
	                    } catch (UnknownHostException e) {  
	                        e.printStackTrace();  
	                    }  
	                    ipAddress= inet.getHostAddress();  
	                }  
	            }  
	            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	                if(ipAddress.indexOf(",")>0){  
	                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	                }  
	            }  
	            return ipAddress;   
	    }
	
	
	
	
	
	
	public void save_users(Users users) {
		 Session session = this.getSession();
		 session.save(users);
	}
	
	
	public void update(Users users) {
		  Session session = this.getSession();
		   session.update(users);
	}
	
	
	public	 Users getByPhone(String phone) {
		   Session session = this.getSession();
		  Query query = session.createQuery("from Users  where mobile_Phone=:phone");
		  query.setString("phone", phone);
		  List<Users> list=query.list();
	 	  Users users2=null; 
	 	for(Users users:list){
		   users2=users;
		}
		return users2;
	}

	@Override
	public List<Users> list_Users(Map map) {
	
		  String hql="from  Users s     where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<Users>list = session.createQuery(hql).list();
	/*	   for (Users users : list) {
			System.out.println("users====="+users.getUser_role().getCname());
		}*/
		   return list;
	}
	
	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("users_q1");
		 String q2 = (String) map.get("users_q2");
		 if(!q1.equals("")&&q1!=null) {
			     hql+="    and  s.user_name  like '%"+q1+"%'";
		   }
        if(!q2.equals("")&&q2!=null) {
        	  hql+="    and  s.mobile_Phone   like  '%"+q2+"%'";
		   }
         hql+=  "     order by   s.status asc ";
		   return hql;
	}

	@Override
	public Users getById(int id) {
		  Session session = this.getSession();
		  Users users = (Users) session.get(Users.class, id);
		 return users;
	}
	
} 
