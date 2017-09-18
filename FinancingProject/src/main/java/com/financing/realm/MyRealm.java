package com.financing.realm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.financing.Interface_service.IN_Users_service;
import com.financing.bean.Users;
import com.financing.service.Users_service;
public class MyRealm extends AuthorizingRealm{

	  @Autowired
	   private IN_Users_service users_service;

	/**
	 * Ϊ����ǰ��¼���û������ɫ��Ȩ��
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		  String userName=(String)arg0.getPrimaryPrincipal();
		  System.out.println("userName+"+userName);
		  return null;
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
	    	 if(users.getPassword().equals(newupwd)){
	    		    System.out.println("˵���ɹ���");
	    		    AuthenticationInfo au = new SimpleAuthenticationInfo(users.getUser_name(), users.getPassword(),"x");
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
