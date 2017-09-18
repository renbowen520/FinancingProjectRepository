<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体验金付息计划</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
			<tr>
				<th>序号</th>
				<th>流水号</th>
				<th>投资人手机号</th>
				<th>投资人姓名</th>
				<th>投资人身份证</th>
				<th>还款利息</th>
				<th>还款时间</th>
				<th>还款状态</th>
			</tr>
			<c:forEach items="${listSubject_bbin_purchase_record }" var="lbpr" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${lbpr.serial_number }</td>
				<td>${lbpr.member.mobile_Phone }</td>
				<td>${lbpr.member.member_name }</td>
				<td>${lbpr.member.identity}</td>
				<td>${lbpr.interest }</td>
				<td>${lbpr.create_date}</td>
				<td><c:if test="${lbpr.ispayment==0}"><font color="green">已还款</font></c:if>
				<c:if test="${lbpr.ispayment==1}"><font color="">未还款</font></c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>
</body>
</html>