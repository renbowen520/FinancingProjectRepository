<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改私募</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#type").val('${finance_product_funds.type}'); 
	  $("#status").val(${finance_product_funds.status}); 
});
</script>
<body>
<form action="/FinancingProject/finance/update" method="post">
<input type="hidden" name="id" value="${finance_product_funds.id}">
类别:<select name="type" id="type">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select><br>
名称:<input type="text" name="name" value="${finance_product_funds.name}"><br>
起投金额:<input type="text" name="floor_amount" value="${finance_product_funds.floor_amount}"><br>
年化收益:<input type="text" name="year_rate" value="${finance_product_funds.year_rate}"><br>
返佣比例:<input type="text" name="ratio" value="${finance_product_funds.ratio}"><br>
状态:<select name="status" id="status">
		<option value="0">未募集</option>
		<option value="1">募集中</option>
		<option value="2">募集结束</option>
		</select><br>
投资期限:<input type="text" name="period" value="${finance_product_funds.period}">
<br>
关于基金
<hr>
  <script id="editor3" type="text/plain" style="width:100%;height:200px;">${finance_product_funds.product_topic}</script>
   
   <br>
   产品要素
  <hr>
  <script id="editor4" type="text/plain" style="width:100%;height:200px;">${finance_product_funds.product_factor}</script>
   <br>
   产品策略
   <hr>
     
   <script id="editor5" type="text/plain" style="width:100%;height:200px;">${finance_product_funds.product_strategy}</script>

   
   <br>
   基金经理
   <hr>
   基金经理名称:<input type="text" name="product_manager_name" value="${finance_product_funds.product_manager_name }"><br>
  基金经理头衔:<input type="text" name="product_manager_title" value="${finance_product_funds.product_manager_title }"><br>
 基金经理简介:<input type="text" name="product_manager_desc" value="${finance_product_funds.product_manager_desc }"><br>
 基金经理头像:<input type="file" name="product_manager_pic" class="form-control"/>
   <br>
   基金经理详情
   <hr>   
    <script id="editor" type="text/plain" style="width:100%;height:200px;">${finance_product_funds.product_manager}</script>
   <br>
   合同内容
   <hr> 
    <script id="editor2" type="text/plain" style="width:100%;height:200px;">${finance_product_funds.contract}</script> 
   <br>
   银行账户
   <hr>
   	银行账户:<input type="text" name="bank_account" value="${finance_product_funds.bank_account }"><br>
   	<input type="submit" value="保存">
</form> 
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    var ue2 = UE.getEditor('editor2');
    var ue3 = UE.getEditor('editor3');
    var ue4 = UE.getEditor('editor4');
    var ue5 = UE.getEditor('editor5');
   </script>	
</body>
</html>