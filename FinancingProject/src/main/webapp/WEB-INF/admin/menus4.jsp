<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海外配置</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript">
$(function(){
		$("#btn1").click(function(){ //新增
			$("#form1").attr("action","/FinancingProject/oversea/addoversea");
			$("#form1").submit();
		});
 });
function test1(id){//查看投资
	 $("#form1").attr("action","/FinancingProject/oversea/config/"+id);
		$("#form1").submit();
}
function test2(id){//编辑查看
	 $("#form1").attr("action","/FinancingProject/oversea/bfupdate/"+id);
		$("#form1").submit();
}
 </script>
<body>

<center>

<div style="width: 95%">
<form id="form1" action="" method="post" role="form">
<table class="table table-striped" >
				<div><p align="right">
				<button type="button" class="btn btn-primary" id="btn1">新增</button> 
				</p></div>
				<tr >
					<th>序号</th>
					<th>标题</th>
					<th>子标题</th>
					<th>状态</th>
					<th>排序值</th>
					<th>募集开始</th>
					<th>募集结束</th>
					<th>图标</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
			<c:forEach items="${listOversea}" var="li" varStatus="l">
			<tr>
				<td>${l.index+1}</td>
				<td>${li.title}</td>
				<td>${li.child_title}</td>
				<td>
				<c:if test="${li.status==0}">未募集</c:if>
				<c:if test="${li.status==1}">募集中</c:if>
				<c:if test="${li.status==2}">已结束</c:if>
				</td>
				<td>${li.sortColum}</td>
					<td>${li.start_date}</td>
						<td>${li.end_date}</td>
				<td><img src="${li.oversea_icon}" /></td>
				<td>${li.addTime}</td>
				<td>
				<button type="button" class="btn btn-primary" onclick="test1(${li.id})">查看预约</button> 
				<button type="button" class="btn btn-primary" onclick="test2(${li.id})">编辑查看</button> 
				</td>
			</tr>
			</c:forEach>	
			</table>
	</form>
	
	</div>
</center>
</body>
</html>