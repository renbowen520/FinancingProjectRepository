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
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		  String userName=(String)arg0.getPrimaryPrincipal();
		  System.out.println("userName+"+userName);
		  return null;
	}

	
	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		  //取出用户输入的账号和密码
		 UsernamePasswordToken token = (UsernamePasswordToken) arg0;
	     String phone =token.getUsername();
	     String upwd = String.valueOf(token.getPassword());
	     System.out.println("取出:"+phone+"   "+upwd);
	    Users users = users_service.getByPhone(phone) ;
	    if (users!= null) {//查询到有该用户
	    	// 对输入的密码加密
	         String  	newupwd= MD5(upwd,users.getSalt() );
	         System.out.println("加密后:"+newupwd);
	         System.out.println("数据库中的密码:"+users.getPassword());
	    	 if(users.getPassword().equals(newupwd)){
	    		    System.out.println("说明成功了");
	    		    AuthenticationInfo au = new SimpleAuthenticationInfo(users.getUser_name(), users.getPassword(),"x");
	    	        token.setPassword(users.getPassword().toCharArray());
	    		    return au;
           } else {
        	   // throw new IncorrectCredentialsException("密码错误");
           }
	    	
     }
	     return null;
	}
	
	
	//MD5加密
	 public static String MD5( String password,String salt) {
	      return new Md5Hash(password,salt).toString();
	}

}
