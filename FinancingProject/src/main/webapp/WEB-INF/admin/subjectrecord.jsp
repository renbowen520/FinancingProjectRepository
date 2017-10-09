<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>标的投资记录</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>投资记录</b>
</h3>
<hr>

<center>
<div  style="width: 90%">
<table class="table table-striped" >
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
	<tr >
	<td>${l.index+1 }</td>
	<td>${li.serial_number }</td>
	<td>${li.member.member_name}</td>
	<td>¥${li.amount }</td>
	<td>${li.interest}
<!-- 	<script type="text/javascript">
	var first="${li.amount}";
	var date=${li.subject.year_rate}/100;
	var t="${e.subject.period}";
	var shou=((first*date)/365)*t;
	document.write(parseFloat(shou).toFixed(2));
	</script> -->
	</td>
	<td>
	<c:if test="${li.ispayment==0}">是</c:if>
	<c:if test="${li.ispayment==1}">否</c:if>
	</td>
	<td>${li.create_date}</td>
	</tr>
	</c:forEach>
</table>
<button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
</div>
</center>

</body>
</html>