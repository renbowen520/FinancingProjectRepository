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
	   //重置按钮事件 
    $("#resetBtn").off().on("click",function(){  
        $("#namem").val("");  
        $("#statusm").val("");  
        $("#typem").val("");
        $("#form1").attr("action","/FinancingProject/subject/menus11");
		$("#form1").submit();
    });
});
function fun(id){
	$("#form1").attr("action","/FinancingProject/subject/menus24/"+id);
	$("#form1").submit();
};
</script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
		<br>
		<div>
			<font size="+1">
				名称:<input type="text" name="namem" value="${namem }" id="namem">&nbsp;&nbsp;&nbsp;
				状态:<select name="statusm" value="${statusm }" id="statusm" >
				<option >全部</option>
				<option value="0">未发布</option>
				<option value="1">募集中</option>
				<option value="2">回款中</option>
				<option value="3">还款完成</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				类型:<select name="typem" value="${typem }" id="typem" >
				<option >全部</option>
				<option value="0">固收类</option>
				<option value="1">P2P车贷</option>
				<option value="2">房贷</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
				<th>操作</th>
			</tr>
		<c:forEach items="${listSubject }" var="ls" varStatus="stat">
			<tr>
			<input type="hidden" name="subject_id"  value="${ls.id }">
				<td>${stat.index+1}</td>
				<td>${ls.serial_no }</td>
				<td><c:if test="${ls.type==0 }">固收类</c:if>
				<c:if test="${ls.type==1 }">P2P车贷</c:if>
				<c:if test="${ls.type==2 }">房贷</c:if>
				</td>
				<td>${ls.name }</td>
				<td>￥${ls.amount}</td>
				<td>
				<script type="text/javascript">
				      //在全局设置				  				 
				      var amount="";
				      var subject_id=${ls.id };		
				         $.ajaxSetup({  
				      		 async : false  
				      	});       
					        $.post(
					          "/FinancingProject/subject/menus112",	
					           {id:subject_id},
					           function(data){
					        amount=data;								
					       });		
					            document.write('￥'+amount);
				      </script>
				      </td>
				<td>0</td>
				<td>${ls.period }</td>
				<td>${ls.year_rate }%</td>
				<td><c:if test="${ls.status==0 }">未发布</c:if>
				<c:if test="${ls.status==1 }">募集中</c:if>
				<c:if test="${ls.status==2 }">回款中</c:if>
				<c:if test="${ls.status==3 }">还款完成</c:if></td>
				<td>
					<c:if test="${ls.exper_status ==0}"><font color="red">否</font></c:if>
					<c:if test="${ls.exper_status ==1}"><font color="green">是</font></c:if>
				</td>
				<td><button type="button" class="btn btn-primary" id="btn2" onclick="fun(${ls.id})" >体验金付息</button>&nbsp;<button type="button" class="btn btn-primary" id="btn3">付息列表</button></td>
			</tr>
	
		</c:forEach>
		</table>
	</form>

</div>
</body>
</html>