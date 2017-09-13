<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>固收类</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){ 
		$("#form1").attr("action","/FinancingProject/subject/addfixget");
		$("#form1").submit();
	});
 });
 </script>
<body>
<br>
<form method="post" id="form1" role="form">
			
						名称:<input type="text" placeholder="名称" name="sname" value="${sname}">
				
				
						状态:<select>
							<option value="0">全部</option>
							<option value="1">未发布</option>
							<option value="2">募集中</option>
							<option value="3">回款中</option>
							<option value="4">还款完成</option>
						</select>
				
						类型:<select>
							<option value="0">全部</option>
							<option value="1">固收类</option>
							<option value="2">P2P车贷</option>
							<option value="3">P2P房贷</option>
						</select>
					
						<input type="button" id="btn1" value="查询">
				<a href="/FinancingProject/subject/menus1">select</a>
						<input type="reset"  value="重置">
					<input type="button" value="新增" id="btn1"/>
						<a href="/FinancingProject/subject/addfixget">新增</a>
				<table class="table" width="90%" border="0" cellspacing="1">
				<tr class="success">
					<th>序号</th>
					<th>合同编号</th>
					<th>类型</th>
					<th>名称</th>
					<th>标的金额</th>
					<th>已投金额</th>
					<th>投资期限</th>
					<th>起投金额</th>
					<th>年化收益</th>
					<th>状态</th>
					<th>可用体验金</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${listSubject}"  var="li" varStatus="l">
				<tr>
					<td>${l.index+1 }</td>
					<td>${li.serial_no}</td>
					<td>${li.type}</td>
					<td>${li.name}</td>
					<td>${li.floor_amount}</td>
					<td>${li.floor_amount}</td>
					<td>${li.period}</td>
					<td>${li.floor_amount}</td>
					<td>${li.year_rate}</td>
					<td>${li.status}</td>
					<td>${li.exper_status}</td>
					<td>${li.create_date}</td>
					<td>
					<a href="/FinancingProject/subject/bfupdate/${li.id}">编辑查看</a>|
					<a href="/FinancingProject/subject/listsubjectrecord/${li.id}">查看投资</a>
					</td>
				</tr>
				</c:forEach>
			</table>
</form>
		
</body>
</html>