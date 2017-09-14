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
<script type="text/javascript" src="/FinancingProject/js/jquery.min.js" ></script>
<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){ //编辑查看
		$("#form1").attr("action","/FinancingProject/oversea/bfupdate/${li.id}");
		$("#form1").submit();
	});
	$("#btn2").click(function(){ //查看投资
		$("#form1").attr("action","/FinancingProject/oversea/config/${li.id}");
		$("#form1").submit();
	});
 });
 </script>
<body>

<form id="form1" action="" method="post" role="form">
<table class="table">
				<tr align="center">
					<td colspan="8" align="right">
						<a href="/FinancingProject/oversea/addoversea">新增</a>
					</td>
				</tr>
				<tr class="success">
					<th>序号</th>
					<th>标题</th>
					<th>子标题</th>
					<th>状态</th>
					<th>排序值</th>
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
				<c:if test="${li.status==2}">募集完成</c:if>
				</td>
				<td>${li.sortColum}</td>
				<td><img src="${li.oversea_icon}" /></td>
				<td>${li.addTime}</td>
				<td>
				 <input type="button" value="编辑查看" id="btn1"/>
					<input type="button" value="查看投资" id="btn2"/> 
				</td>
			</tr>
			</c:forEach>	
			</table>
	</form>
</body>
</html>