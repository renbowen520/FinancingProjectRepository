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
			<c:forEach items="${listMember_withdraw_record}" var="lmwr" varStatus="stat" >
			<tr>
				<td>${stat.index+1}</td>
				<td>${lmwr.member_id.mobile_Phone }</td>
				<td>${lmwr.member_id.member_name }</td>
				<td>${lmwr.member_id.identity }</td>
				<td>${lmwr.amount }</td>
				<td>${lmwr.bank_name }</td>
				<td>${lmwr.bank_card }</td>
				<td>${lmwr.cardaddress }</td>
				<td>
				<c:if test="${lmwr.status==0 }">
				<font color="green">待审核</font></c:if>
				<c:if test="${lmwr.status==1 }">
				<font color="green">已打款</font></c:if>
				<c:if test="${lmwr.status==2 }">
				<font color="green">打款中</font></c:if>
				<c:if test="${lmwr.status==3 }">
				<font color="red">打款失败</font></c:if>
				</td>
				<td>${lmwr.create_date}</td>
				<td></td>
			</tr>
			</c:forEach>
		
		</table>
	</form>

</div>
</body>
</html>