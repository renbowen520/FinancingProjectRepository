<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$("#form1").attr("action","/FinancingProject/MemberController/zhanghao");
			$("#form1").submit();
		});
		
	});
</script>
</head>
<body>

<div class="table-responsive">
<form action="" role="form" id="form1" method="post">
	<table class="table table-bordered" width="100%" >
	<br>
	<div>
	<p>	用户名:<input type="text" name="mname" value="${mname}">&nbsp;
		手机号:<input type="text" name="mobile_Phonem" value="${ mobile_Phonem}">&nbsp;
		姓名:<input type="text" name="member_namem" value="${member_namem }">&nbsp;
		邀请码:<input type="text" name="invitatioinCodem" value="${invitatioinCodem }">
		<button type="button" class="btn btn-primary" id="btn1">查询</button>&nbsp;
		
<button type="button" id="resetBtn" class="btn btn-success">重置</button> 
		<p>
	</div>	
	<br>
	<br>
		<tr>
			<td align="center">序号</td>
			<td align="center">手机号</td>
			<td align="center">用户名</td>
			<td align="center">姓名</td>
			<td align="center">身份证</td>
			<td align="center">邀请码</td>
			<td align="center">注册时间</td>
			<td align="center">操作</td>
			
		</tr>
		<c:forEach items="${listmember}" var="lm" varStatus="stat">
		<tr class="table table-hover">
			<td align="center">${stat.index+1}</td>
			<td align="center">${lm.mobile_Phone }</td>
			<td align="center">${lm.name }</td>
			<td align="center">${lm.member_name }</td>
			<td align="center">${lm.identity }</td>
			<td align="center">${lm.invitatioinCode }</td>
			<td align="center">${lm.create_date }</td>
			<td align="center">
			<button type="button" class="btn btn-primary" > 账号详情</button>
  			
			</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</div>

</body>
</html>