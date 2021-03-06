<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>

<link rel="stylesheet" type="text/css" href="/FinancingProject/adminlogin/style.css" >
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="/FinancingProject/adminlogin/jquery.min(1).js"></script>
<script src="/FinancingProject/adminlogin/jquery.min(2).js"></script>
<script src="/FinancingProject/adminlogin/verificationNumbers.js"></script>
<script src="/FinancingProject/adminlogin/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
        dotColor: '#5cbdaa',
        lineColor: '#5cbdaa'
  });
  //验证码
  createCode();//调用验证码
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){ //当点击提交按钮时
	  var boo =  validate();
	  if(boo==false){ //验证码不通过
		    return;
	  }
	   var a=document.getElementById("mobile_Phone").value;    
	   var b=document.getElementById("password").value;    
	  
        if(a.length<1){
	      document.getElementById("mobile_Phone").setAttribute("placeholder","账号不能为空!");
		  return ;
	    }
		if(b.length<1){
		    document.getElementById("password").setAttribute("placeholder","密码不能为空!");
		  return ;
		}
         location.href="/FinancingProject/AdminController/admin";

	  });
});
</script>
</head>
<body><canvas class="pg-canvas" width="1536" height="642"></canvas>
<dl class="admin_login">
 <dt>
  <strong>孔明理财后台管理系统</strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
         <input type="text"   id="mobile_Phone"  name="mobile_Phone"   placeholder="账号"   maxlength="12"   class="login_txtbx">
 </dd>
 <dd class="pwd_icon">
       <input type="password"   id="password" name="password"   placeholder="密码"  min="6"       class="login_txtbx">
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext"       placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
 <input type="button" value="验证码核验" class="ver_btn" onclick="validate();">
 </dd>
 <dd>
  <input type="button" value="立即登陆" class="submit_btn">
 </dd>
 <dd>
  <p>© 2017 襄阳孔明投资管理有限公司  版权所有</p>
  
 </dd>
</dl>


</body></html>