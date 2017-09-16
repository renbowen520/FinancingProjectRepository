<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加私募</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>


<body>
<form action="/FinancingProject/finance/save" method="post">
类别:<select name="type">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select><br>
名称:<input type="text" name="name"><br>
起投金额:<input type="text" name="floor_amount"><br>
年化收益:<input type="text" name="year_rate"><br>
返佣比例:<input type="text" name="ratio"><br>
状态:<select name="status">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select><br>
投资期限:<input type="text" name="period">
<br>
关于基金
<hr>
    <script id="editor1" type="text/plain" style="width:1024px;height:200px;"></script>
   <br>
   产品要素
  <hr>
    <script id="editor2" type="text/plain" style="width:1024px;height:200px;"></script>
   
   <br>
   产品策略
   <hr>
    <script id="editor3" type="text/plain" style="width:1024px;height:200px;"></script>
   
   <br>
   基金经理
   <hr>
   基金经理名称:<input type="text" name="product_manager_name"><br>
  基金经理头衔:<input type="text" name="product_manager_title"><br>
 基金经理简介:<input type="text" name="product_manager_desc"><br>
 基金经理头像:<input type="file" name="product_manager_pic" class="form-control"/>
   <br>
   基金经理详情
   <hr>
    <script id="editor4" type="text/plain" style="width:1024px;height:200px;"></script>
   <br>
   合同内容
   <hr>
    <script id="editor5" type="text/plain" style="width:1024px;height:200px;"></script>
   <br>
   银行账户
   <hr>
   	银行账户:<input type="text" name="bank_account"><br>
   	<input type="submit" value="保存">
</form> 

   <script type="text/javascript">
    var ue = UE.getEditor('editor1');
    var ue = UE.getEditor('editor2');
    var ue = UE.getEditor('editor3');
    var ue = UE.getEditor('editor4');
    var ue = UE.getEditor('editor5');
   </script>
</body>
</html>