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
<script type="text/javascript" src="/FinancingProject/js/jquery.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#btn2").click(function(){ //新增按钮
		$("#form1").attr("action","/FinancingProject/finance/addfinance");
		$("#form1").submit();
	});
	$("#btn1").click(function(){ //模糊查询按钮
		alert("2");
		$("#form1").attr("action","/FinancingProject/AdminController/menus2");
		$("#form1").submit();
	});
	function test3(id){//签署状态
		 $("#form1").attr("action","/FinancingProject/finance/subscribe/"+id);
			$("#form1").submit();
	 }
	 function test4(id){//编辑查看
		 $("#form1").attr("action","//FinancingProject/finance/bfupdate/"+id);
			$("#form1").submit();
	 }
 });
 </script>
<body>
<div class="table table-responsive">
<form method="post" id="form1" role="form">
	<table class="table table-striped" width="100%" >
	<div>
	<p>
	<center>
		名称:<input type="text" name="name" placeholder="名称" value="${sname }">
		状态:<select name="status">
				<option value="-1">全部</option>
				<option value="0">未发布</option>
				<option value="1">募集中</option>
				<option value="2">已结束</option>
			</select>  
		类别:<select name="type">
				<option value="-1">全部</option>
				<option value="SIMU">私募</option>
				<option value="GUQUAN">股权</option>
		</select>
 		<button type="button" id="btn2" class="btn btn-success">查询</button> 
		<button type="button" id="btn1" class="btn btn-success">新增</button> 

</center>
	</p>
	</div>
		<tr class="table table-hover">
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
				<tr class="table table-hover">
				<td>${l.index+1}</td>
				<td>${li.name}</td>
				<td>
				<c:if test="${li.type==SIMU}">私募</c:if>
				<c:if test="${li.type==GUQUAN}">股权</c:if>
				</td>
				<td>
				<c:if test="${li.status==0}">未发布</c:if>
				<c:if test="${li.status==1}">募集中</c:if>
				<c:if test="${li.status==2}">已结束</c:if>
				</td>
				<td>${li.year_rate*10}%</td>
				<td>${li.radio }</td>
				<td>${li.start_date }</td>
				<td>${li.end_date }</td>
				<td>${li.period}天</td>
				<td>${li.floor_amount }</td>
				<td>${li.create_date }</td>
				<td>
				<button type="button" id="btn3" class="btn btn-primary" onclick="test3(${li.id})">签署状态</button> 
				<button type="button" id="btn4" class="btn btn-primary" onclick="test4(${li.id})">编辑查看</button> 
				</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>