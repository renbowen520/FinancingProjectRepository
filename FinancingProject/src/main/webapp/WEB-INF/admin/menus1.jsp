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
	$("#btn2").click(function(){ //新增按钮
		$("#form1").attr("action","/FinancingProject/subject/addfixget");
		$("#form1").submit();
	});
	$("#btn1").click(function(){ //模糊查询按钮
		$("#form1").attr("action","/FinancingProject/subject/menus1");
		$("#form1").submit();
	});
	});
 function test3(id){
	 $("#form1").attr("action","/FinancingProject/subject/bfupdate/"+id);
		$("#form1").submit();
 }
 function test4(id){
	 $("#form1").attr("action","/FinancingProject/subject/listsubjectrecord/"+id);
		$("#form1").submit();
 }
 </script>
<body>
<br>
<div class="table table-responsive">
<form method="post" id="form1" role="form">
			<table class="table table-striped" width="100%" >
			<div><p>
		名称:<input type="text" placeholder="名称" name="sname" value="${sname}">
				
				
						状态:<select name="status">
							<option value="">全部</option>
							<option value="0">未发布</option>
							<option value="1">募集中</option>
							<option value="2">回款中</option>
							<option value="3">还款完成</option>
						</select>
				
						类型:<select name="stype">
							<option value="">全部</option>
							<option value="0">固收类</option>
							<option value="1">P2P车贷</option>
							<option value="2">P2P房贷</option>
						</select>
					
						<input type="button" id="btn1" value="查询">
						<input type="reset"  value="重置">
					<input type="button" value="新增" id="btn2"/>
	</p>	</div>		
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
				<tr class="table table-hover">
					<td>${l.index+1 }</td>
					<td>${li.serial_no}</td>
					<td>
					<c:if test="${li.type==0}">固收类</c:if>
					<c:if test="${li.type==1}">P2P车贷</c:if>
					<c:if test="${li.type==2}">P2P房贷</c:if>
					</td>
					<td>${li.name}</td>
					<td>${li.amount}</td>
					<td>
			 <script type="text/javascript">
				  var id='${li.id}';
				  $.ajaxSetup({  
					    async : false  
					}); 
				  var num1=0;
				  $.post("/FinancingProject/subject/getTotalMoney",{id:id},function(data){
					 num1=data;
				  });
				  document.write(num1);
				 </script>
					</td>
					<td>${li.period}天</td>
					<td>${li.floor_amount}</td>
					<td>${li.year_rate*10}%</td>
					<td>
					<c:if test="${li.status==0}">未发布</c:if>
					<c:if test="${li.status==1}">募集中</c:if>
					<c:if test="${li.status==2}">回款中</c:if>
					<c:if test="${li.status==3}">回款完成</c:if>
					</td>
					<td>
					<c:if test="${li.exper_status==0}">否</c:if>
					<c:if test="${li.exper_status==1}">是</c:if>
					</td>
					<td>${li.create_date}</td>
					<td>
					 <input type="button" onclick="test3(${li.id})" value="编辑查看">
					 <input type="button" onclick="test4(${li.id})" value="查看投资">
					</td>
				</tr>
				</c:forEach>
			</table>
</form>
</div>			
</body>
</html>