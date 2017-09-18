<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付息计划</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){
		$("#form1").attr("action","/FinancingProject/subject/menus11");
		$("#form1").submit();
	});
	
});
</script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
		<br>
		<div>
			<font size="+1">
				名称:<input type="text" name="namem" value="${namem }">&nbsp;&nbsp;&nbsp;
				状态:<input type="text" name="statusm" value="${statusm }">&nbsp;&nbsp;&nbsp;
				类型:<input type="text" name="typem" value="${typem }">&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-primary" id="btn1">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="resetBtn" class="btn btn-success">重置</button> &nbsp;&nbsp;&nbsp;&nbsp;
		
			</font>
		
		</div>
		<br>
			<tr>
				<th>序号</th>
				<th>合同编号</th>
				<th>标的类别</th>
				<th>标的名称</th>
				<th>标的总金额</th>
				<th>已投金额</th>
				<th>已投人数</th>
				<th>标的期限</th>
				<th>年化收益</th>
				<th>标的状态</th>
				<th>可体检金购买</th>
			</tr>
		<c:forEach items="${listSubject }" var="ls" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${ls.serial_no }</td>
				<td>${ls.type }</td>
				<td>${ls.name }</td>
				<td>${ls.amount}元</td>
				<td>${ls.floor_amount }</td>
				<td>${ls.bought }人</td>
				<td>${ls.period }</td>
				<td>${ls.year_rate }%</td>
				<td>${ls.status }</td>
				<td>
					<c:if test="${ls.exper_status ==0}"><font color="red">否</font></c:if>
					<c:if test="${ls.exper_status ==1}"><font color="green">是</font></c:if>
				</td>
				<td></td>
			</tr>
	
		</c:forEach>
		</table>
	</form>

</div>
</body>
</html>