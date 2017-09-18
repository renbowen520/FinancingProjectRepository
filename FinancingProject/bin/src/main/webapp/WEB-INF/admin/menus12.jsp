<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值管理</title>
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
				<th>订单编号</th>
				<th>手机号</th>
				<th>订单金额</th>
				<th>订单状态</th>
				<th>充值渠道</th>
				<th>充值渠道订单号</th>
				<th>订单时间</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${listMember_deposit_record }" var="lmdr" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${lmdr.serial_number }</td>
				<td>${lmdr.member_id.mobile_Phone  }</td>
				<td>${lmdr.amount }</td>
				<td>
				<c:if test="${lmdr.status==0 }">
					<font color="red">待付款</font>
				</c:if>
				<c:if test="${lmdr.status ==1}">
					<font color="green">完成</font>
				</c:if>
				</td>
				<td>${lmdr.pay_channel_name }</td>
				<td>${lmdr.pay_channel_order_no}</td>
				<td>${lmdr.create_date }</td>
				<td></td>
			</tr>
			
		</c:forEach>
		</table>
	</form>

</div>
</body>
</html>