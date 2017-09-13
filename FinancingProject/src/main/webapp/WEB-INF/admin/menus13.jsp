<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提现记录</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<div >
	<form action="" role="form"  method="post">
		<table class="table table-striped" width="100%">
		<div>
			
		
		</div>
		<br>
			<tr>
				<th>序号</th>
				<th>手机号</th>
				<th>姓名</th>
				<th>身份证</th>
				<th>提现金额</th>
				<th>提现银行</th>
				<th>提现卡号</th>
				<th>提现开户行地址</th>
				<th>提现状态</th>
				<th>提现时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ listmember}" var="lm" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${lm.mobile_Phone }</td>
				<td>${lm.member_name }</td>
				<td>${lm.identity }</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>
</body>
</html>