<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/FinancingProject/index_files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/FinancingProject/index_files/common.css" rel="stylesheet">
<link href="/FinancingProject/index_files/jw.css" rel="stylesheet">
<script src="/FinancingProject/index_files/jquery.js"></script>
<script type="text/javascript" src="/FinancingProject/index_files/layer.js"></script>
<link rel="stylesheet" href="/FinancingProject/index_files/layer.css" id="layui_layer_skinlayercss">
<script src="/FinancingProject/index_files/echarts.js"></script>
	<link href="/FinancingProject/images/timg.jpg" type="image/x-icon" rel="shortcut icon">

</head>
<body>

<div class="logo container">
    <div class="row">
            这里要显示图片
      
        <div class="telInfo">
          <!--   <img src="./400Icon.png" onmousemove="this.src = &#39;/400IconActive.png&#39;" onmouseout="	this.src = &#39;/400Icon.png&#39;"> -->
            <div class="detail">
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" target="_parent" href="/FinancingProject/IndexController/adminLogin">后台</a>
                        
                          <c:if test="${empty  member_login}">
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" target="_parent" href="/FinancingProject/IndexController/login">登录</a>
                       </c:if>
                         <c:if test="${!empty  member_login}">
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" target="_parent"   onclick="return confirm('确定退出?')"    href="/FinancingProject/LoginController/out">[欢迎您,${member_login.name }]退出</a>
                       </c:if>
                       
                       <c:if test="${empty  member_login}">
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" target="_parent" href="/FinancingProject/IndexController/register">注册</a>
                         </c:if>
                <br>4000-888-888
            </div>
        </div>
    </div>
</div>



</body>
</html>