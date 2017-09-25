<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>奖励记录</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
		<br>
		<br>
			<tr>
				<th>序号</th>
				<th>邀请人手机号</th>
				<th>奖励类型</th>
				<th>奖励金额</th>
				<th>奖励时间</th>
			
			</tr>
			<c:forEach items="${getAward_records }" var="ar" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>
				${ar.member.mobile_Phone }</td>
				<td><c:if test="${ar.type ==0}">注册奖励</c:if><c:if test="${ar.type ==1}">投资奖励</c:if></td>
				<td>${ar. amount}</td>
				<td>${ar.addTime }</td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>
</body>
</html>