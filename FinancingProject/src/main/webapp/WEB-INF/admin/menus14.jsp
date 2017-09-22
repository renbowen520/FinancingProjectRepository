<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邀请奖励</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
		<br>
		<div>
			<font size="+1">
			姓名:<input type="text" name="member_namem">&nbsp;&nbsp;&nbsp;
			手机号:<input type="text" name="mobile_Phonem"> &nbsp;&nbsp;&nbsp;
			邀请码:<input type="invitationCodem">&nbsp;&nbsp;&nbsp;
			被邀请码:<input type="invitedCodem">&nbsp;&nbsp;&nbsp;<br><br>
			是否已注册奖励:<select name="typem">
			<option value="0">全部</option>
			</select>&nbsp;&nbsp;&nbsp;
			是否已投资奖励:<select name="isAwardm">
			<option value="0">全部</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btn1">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" id="resetBtn" class="btn btn-success">重置</button> &nbsp;&nbsp;&nbsp;&nbsp;
		
			</font>
		
		</div>
		<br>
			<tr>
				<th>序号</th>
				<th>手机号</th>
				<th>姓名</th>
				<th>邀请码</th>
				<th>被邀请码</th>
				<th>投资金额</th>
				<th>是否已注册奖励</th>
				<th>是否已投资奖励</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${listaward_records }" var="lr" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${lr.member.mobile_Phone }</td>
				<td>${lr.member.member_name }</td>
				<td>${lr.member.invitationCode }</td>
				<td>${lr.member.invitedCode }</td>
				<td></td>
				<td><c:if test="${lr.type==0 }"><font color="green">是</font></c:if>
				<c:if test="${lr.type==1 }"><font color="red">否</font></c:if>
				</td>
				<td><c:if test="${lr.isAward==0}"><font color="red">否</font></c:if>
				<c:if test="${lr.isAward==1}"><font color="green">是</font></c:if>
				</td>
				<td>${lr.addTime}</td>
				<td>不能奖励&nbsp;&nbsp;|&nbsp;&nbsp;<button type="button" class="btn btn-primary" id="btn2" >奖励记录</button></td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>
</body>
</html>