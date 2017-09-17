<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示海外配置订阅记录</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<body>
<div class="table table-responsive">
<form method="post" id="form1" role="form">
	<table class="table table-striped" width="100%" >
	<tr>
	<th>序号</th>
	<th>姓名</th>
	<th>联系电话</th>
	<th>地址</th>
	<th>预约时间</th>
	</tr>
	<c:forEach items="${listConfig}" var="li" varStatus="l">
		<tr>
		<td>${l.index+1}</td>
		<td>${li.name }</td>
		<td>${li.phone }</td>
		<td>${li.addr}</td>
		<td>${li.create_date}</td>
		</tr>
	</c:forEach>

	</table>
	</form>
	</div>
</body>
</html>