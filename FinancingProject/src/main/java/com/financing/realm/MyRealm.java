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
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		 Users user =(Users) arg0.getPrimaryPrincipal();//取出登陆用户的实体类
		  System.out.println("userName=========="+user.getUser_name());
		  //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
       SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
  
          //用户的角色集合
           info.addRole(user.getUser_role().getCname());
        System.out.println("角色="+user.getUser_role().getCname());
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
	         //密码要相同 并且 状态0是正常的
	    	 if(users.getPassword().equals(newupwd)&&users.getStatus()==0){
	    		    System.out.println("说明成功了");
	    		    //保存用户的信息
	    		    AuthenticationInfo au = new SimpleAuthenticationInfo(users, users.getPassword(),users.getUser_name());
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
