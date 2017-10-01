package com.financing.realm;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.financing.Interface_dao.IN_Role_permission_relation_dao;
import com.financing.Interface_service.IN_Role_permission_relation_service;
import com.financing.Interface_service.IN_Users_service;
import com.financing.bean.Role_permission_relation;
import com.financing.bean.Users;
import com.financing.service.Users_service;
public class MyRealm extends AuthorizingRealm{

	  @Autowired
	   private IN_Users_service users_service;

	  @Autowired
	  private IN_Role_permission_relation_service p;
	  
	/**
	 * Ϊ����ǰ��¼���û������ɫ��Ȩ��
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		 Users user =(Users) arg0.getPrimaryPrincipal();//ȡ����½�û���ʵ����
		  System.out.println("userName=========="+user.getUser_name());
		  //Ȩ����Ϣ����info,������Ų�����û������еĽ�ɫ��role����Ȩ�ޣ�permission��  
       SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
  
          //�û��Ľ�ɫ����
           info.addRole(user.getUser_role().getCname());
        System.out.println("��ɫ="+user.getUser_role().getCname());
       //    Set<Role_permission_relation>r=  user.getUser_role().getRole_permission_relation();
        //   Set<String>str= new HashSet<>();
       //    for (Role_permission_relation role_permission_relation : r) {
		//	System.out.println("==="+role_permission_relation.getPermission_ename());
	    //   str.add(role_permission_relation.getPermission_ename());
       //   }
    
         Set<String>set  =p.list_pname(user.getId());
         for (String string : set) {
			 System.out.println("set==="+string);
		}
          info.setStringPermissions(set);
		  return info;
	}

	
	/**
	 * ��֤��ǰ��¼���û�
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		  //ȡ���û�������˺ź�����
		 UsernamePasswordToken token = (UsernamePasswordToken) arg0;
	     String phone =token.getUsername();
	     String upwd = String.valueOf(token.getPassword());
	     System.out.println("ȡ��:"+phone+"   "+upwd);
	     Users users = users_service.getByPhone(phone) ;
	    if (users!= null) {//��ѯ���и��û�
	    	// ��������������
	         String  	newupwd= MD5(upwd,users.getSalt() );
	         System.out.println("���ܺ�:"+newupwd);
	         System.out.println("���ݿ��е�����:"+users.getPassword());
	         //����Ҫ��ͬ ���� ״̬0��������
	    	 if(users.getPassword().equals(newupwd)&&users.getStatus()==0){
	    		    System.out.println("˵���ɹ���");
	    		    //�����û�����Ϣ
	    		    AuthenticationInfo au = new SimpleAuthenticationInfo(users, users.getPassword(),users.getUser_name());
	    	        token.setPassword(users.getPassword().toCharArray());
	    		    return au;
           } else {
        	   // throw new IncorrectCredentialsException("�������");
           }
	    	
     }
	     return null;
	}
	
	
	//MD5����
	 public static String MD5( String password,String salt) {
	      return new Md5Hash(password,salt).toString();
	}

}
