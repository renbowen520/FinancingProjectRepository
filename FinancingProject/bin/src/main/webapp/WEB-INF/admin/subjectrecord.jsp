<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="1" cellspacing="0">
	<tr align="center">
	<th>序号</th>
	<th>流水号</th>
	<th>会员姓名</th>
	<th>购买金额</th>
	<th>结算利息</th>
	<th>是否还款</th>
	<th>购买时间</th>
	</tr>
	<c:forEach items="${listsubjectrecord}" var="li" varStatus="l">
	<tr align="center">
	<td>${l.index+1 }</td>
	<td>${li.serial_number }</td>
	<td>${li.member_id}</td>
	<td>${li.amount }</td>
	<td>${li.interest }</td>
	<td>${li.ispayment }</td>
	<td>${li.create_date}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>