<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私募基金</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/FinancingProject/js/jquery.min.js" ></script>
<!--  <script type="text/javascript">
$(document).ready(function(){
	$("#btn1").click(function(){ 
		alert("1");
		document.forms[0].action="/FinancingProject/finance/addfinance";
		document.forms[0].submit();
	});
	$("#btn2").click(function(){ 
		alert("2");
		document.forms[0].action="/FinancingProject/AdminController/menus2";
		document.forms[0].submit();
	});
 });
</script>-->
<script type="text/javascript">
 $(document).ready(function(){
	$("#btn1").click(function(){
		$("#form1").attr("action","/FinancingProject/finance/addfinance");
		$("#form1").submit();
	});
 });
 </script>
<body>
<font size="+5">私募基金  </font><br>
<form action="" id="form1" method="post">
<center>
名称:<input type="text" name="name" placeholder="名称" value="${sname }">
状态:<select name="status">
<option value="">全部</option>
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>  
类别:<select name="type">
<option value="">全部</option>
<option value="SIMU">私募</option>
<option value="GUQUAN">股权</option>
</select>
<!-- 
<input type="button" id="#btn2" value="查询">
<input type="button" id="#btn1" value="新增">
 -->
 <a href="/FinancingProject/AdminController/menus2">查询</a>
 <a href="/FinancingProject/finance/addfinance">新增</a>
</center>
	<table width="100%" border="o" cellspacing="0">
		<tr>
		<th>序号</th>
		<th>名称</th>
		<th>类型</th>
		<th>状态</th>
		<th>年化收益</th>
		<th>返佣比例</th>
		<th>开始日期</th>
		<th>结束日期</th>
		<th>投资期限</th>
		<th>起投金额</th>
		<th>添加时间</th>
		<th>操作</th>
			<c:forEach items="${listfinance}" var="li" varStatus="l">
				<tr>
				<td>${l.index+1}</td>
				<td>${li.name}</td>
				<td>${li.type}</td>
				<td>${li.status }</td>
				<td>${li.year_rate}</td>
				<td>${li.radio }</td>
				<td>${li.start_date }</td>
				<td>${li.end_date }</td>
				<td>${li.period }</td>
				<td>${li.floor_amount }</td>
				<td>${li.create_date }</td>
				<td>
				<a href="/FinancingProject/finance/subscribe/${li.id}">签署状态</a>
				<a href="/FinancingProject/finance/bfupdate/${li.id}">编辑查看</a>
				</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	</form>
</body>
</html>