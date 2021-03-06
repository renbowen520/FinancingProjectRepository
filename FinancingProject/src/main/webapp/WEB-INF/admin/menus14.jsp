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
<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){
		$("#form1").attr("action","/FinancingProject/Award_records_controller/menus14");
		$("#form1").submit();
		 
     
	});
	   //重置按钮事件 
    $("#resetBtn").off().on("click",function(){  
        $("#member_namem").val("");  
        $("#mobile_Phonem").val("");  
        $("#invitationCodem").val("");
        $("#invitedCodem").val("");
        $("#typem").val("");
        $("#isAwardm").val("");
        $("#form1").attr("action","/FinancingProject/Award_records_controller/menus14");
		$("#form1").submit();
    });
	
});
function fun(id){
	$("#form1").attr("action","/FinancingProject/Award_records_controller/menus26/"+id);
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
			姓名:<input type="text" name="member_namem" value="${ member_namem}" id="member_namem">&nbsp;&nbsp;&nbsp;
			手机号:<input type="text" name="mobile_Phonem" value="${mobile_Phonem }" id="mobile_Phonem"> &nbsp;&nbsp;&nbsp;
			邀请码:<input type="invitationCodem" value="${invitationCodem }" id="invitationCodem">&nbsp;&nbsp;&nbsp;
			被邀请码:<input type="invitedCodem" value="${invitedCodem }" id="invitedCodem">&nbsp;&nbsp;&nbsp;<br><br>
			是否已注册奖励:<select name="typem" value="${typem }" id="typem">
			<option value="0">是</option>
			<option value="1">否</option>
			</select>&nbsp;&nbsp;&nbsp;
			是否已投资奖励:<select name="isAwardm" value="${ isAwardm}"   id="isAwardm">
			<option value="0">是</option>
			<option value="1">否</option>
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
				<th>奖励类型</th>
				<th>是否已奖励</th>
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
				<td>
				<c:if test="${lr.type ==0 }">
				注册
				</c:if>
					<c:if test="${lr.type ==1 }">
				投资
				</c:if>
				</td>
			
				<td><c:if test="${lr.isAward==0}"><font color="red">否</font></c:if>
				<c:if test="${lr.isAward==1}"><font color="green">是</font></c:if>
				</td>
				<td>${lr.addTime}</td>
				<td>不能奖励&nbsp;&nbsp;|&nbsp;&nbsp;<button type="button" class="btn btn-primary" id="btn2" onclick="fun(${lr.member.id})" >奖励记录</button></td>
			</tr>
			</c:forEach>
		</table>
	</form>

</div>
</body>
</html>