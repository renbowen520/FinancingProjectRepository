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
	  var rate="${subscribe.finance_product_funds.year_rate}"/100;
	  var period=${subscribe.finance_product_funds.period};
	   var num=((money*rate)/365)*period;
	  $("#interest").val(parseFloat(num).toFixed(2));
 }
</script>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>签署合约</b>
</h3>
<hr>



<center>
<form action="/FinancingProject/finance/savesubscribe" method="post" id="form1">
<table width="50%"  border="0">
<tr  height="70px;">
<td  align="right"   style="padding-right: 10px;">真实姓名:</td>
<td>
<input type="hidden" name="id" value="${subscribe.id }"/>
<input      style="width: 400px;"      readonly="readonly"   class="form-control"       type="text" name="member_name" value="${subscribe.member.member_name}"> 
</td>
</tr>


<tr height="70px;">
<td align="right"   style="padding-right: 10px;">身份证信息:</td>
<td>
<input        style="width: 400px;"      readonly="readonly"   class="form-control"              type="text" name="identity" value="${subscribe.member.identity}"> 
</td>
</tr>

<tr height="70px;">
<td align="right"   style="padding-right: 10px;">购买金额:</td>
<td>
<input     style="width: 400px;"     class="form-control"            type="text" name="amount" onkeyup="fun(this)">
</td>
</tr>

<tr height="70px;">
<td align="right"   style="padding-right: 10px;">利息收益:</td>
<td>
<input         style="width: 400px;"      readonly="readonly"   class="form-control"                    type="text" name="interest" id="interest" readonly="true">
</td>
</tr>

<tr height="70px;">
<td align="right"   style="padding-right: 10px;">开始时间:</td>
<td>
<input       style="width: 400px;"     class="form-control"       readonly="readonly"         type="text" name="start" id="start" >
</td>
</tr>

<tr height="70px;">
<td  align="right"   style="padding-right: 10px;">截止时间:</td>
<td>
<input       style="width: 400px;"      readonly="readonly"   class="form-control"               type="text" name="end" id="end" >
</td>
</tr>

<!-- 私募合同:<input type="file" name="contract"/><br>
风险揭示书:<input type="file" name="risk_reveal" /><br> -->
<tr height="70px;">
<td colspan="2"  align="center">
    <button type="submit" class="btn btn-primary"  onclick="test1(${subscribe.finance_product_funds.id})">签署合同</button>
&nbsp;&nbsp;
    <button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
</td>
</tr>
</table>
</form>
</center>
</body>
</html>