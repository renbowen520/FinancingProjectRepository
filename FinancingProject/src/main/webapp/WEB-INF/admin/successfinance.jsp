<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>私募签署合约</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css"/>
</head>
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	var date=new Date();
	var d=date.toDateString();
	$("#start").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
	var perior=${subscribe.finance_product_funds.period};
	date.setDate(date.getDate()+perior);
	$("#end").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
 });
function test1(pid){//签署状态
	 $("#form1").attr("action","/FinancingProject/finance/savesubscribe/"+pid);
		$("#form1").submit();
}
 function fun(obj){
	 var money=obj.value;
	 var rate=${subscribe.finance_product_funds.year_rate}/100;
	 var period=${subscribe.finance_product_funds.period};
	 var num=((money*rate)/365)*period;
	 $("#interest").val(parseFloat(num).toFixed(2));
 }
</script>
<body>
<center>
<form action="/FinancingProject/finance/savesubscribe" method="post" id="form1">
<input type="hidden" name="id" value="${subscribe.id }"/>
真实姓名:<input type="text" name="member_name" value="${subscribe.member.member_name}"> <br>
身份证信息:<input type="text" name="identity" value="${subscribe.member.identity}"> <br>
购买金额:<input type="text" name="amount" onkeyup="fun(this)"><br>
利息收益:<input type="text" name="interest" id="interest" readonly="true"><br>
开始时间:<input type="text" name="start" id="start" readonly="true"><br>
截止时间:<input type="text" name="end" id="end" readonly="true"><br>
<!-- 私募合同:<input type="file" name="contract"/><br>
风险揭示书:<input type="file" name="risk_reveal" /><br> -->
  <button type="submit" class="btn btn-primary"  onclick="test1(${subscribe.finance_product_funds.id})">签署合同</button>
</form>
</center>
</body>
</html>