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
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>新增</b>
</h3>
<hr>



<center>
<form action="/FinancingProject/finance/save" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" width="90%">
<tr height="60">
<td width="20%"  align="right" style="padding-right: 10px;">类别:</td>
<td  width="30%"><select name="type"  class="form-control"   style="width: 300px">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select></td>

<td  width="20%"   align="right" style="padding-right: 10px;">名称:</td>
<td   width="30%"><input type="text" name="name"  class="form-control"   style="width: 300px"  ></td>
</tr>




<tr height="60">
<td    align="right" style="padding-right: 10px;">起投金额:</td>
<td><input type="number" name="floor_amount" class="form-control"     style="width: 300px" ></td>
<td  align="right" style="padding-right: 10px;">年化收益:</td>
<td><input type="number" name="year_rate" class="form-control"    style="width: 300px" ></td>
</tr>





<tr height="60">
<td  align="right" style="padding-right: 10px;">返佣比例:</td>
<td><input type="number" name="ratio" class="form-control"   style="width: 300px"></td>
<td  align="right" style="padding-right: 10px;">状态:</td>
<td><select name="status" class="form-control"    style="width: 300px">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select></td>

</tr>


<tr height="60">
<td  align="right" style="padding-right: 10px;">投资期限:</td>
<td><input    style="width: 300px"   type="number" name="period" class="form-control"></td>
<td></td>
<td></td>
</tr>



<tr height="60">
<td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 关于基金</h3>
<hr>
   	 <script id="editor1" type="text/plain" style="width:100%;height:200px;" name="product_topic "></script>
</td>
</tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶  产品要素</h3><hr>
  <script id="editor2" type="text/plain" style="width:100%;height:200px;" name="product_factor"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶    产品策略</h3><hr>
   	<script id="editor3" type="text/plain" style="width:100%;height:200px;" name="product_strategy"></script>
</td></tr>
<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 基金经理</h3><hr>
</td></tr>

<tr height="60"  >
<td   align="right" style="padding-right: 10px;">基金经理名称:</td>
<td><input type="text" name="product_manager_name" class="form-control"   style="width: 300px;"></td>
<td  align="right" style="padding-right: 10px;">基金经理头衔:</td>
<td><input type="text" name="product_manager_title" class="form-control"    style="width: 300px;"></td>
</tr>







<tr height="60">
<td  align="right" style="padding-right: 10px;">基金经理简介:</td>
<td><input type="text" name="product_manager_desc" class="form-control"   style="width: 300px;"></td>
<td  align="right" style="padding-right: 10px;">基金经理头像:</td>
<td><input   style="width: 300px;"    type="file" name="file" class="form-control"/></td>
</tr>





<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp; ▶基金经理详情</h3><hr>
   	<script id="editor4" type="text/plain" style="width:100%;height:200px;" name="product_manager"></script>
</td>
</tr>


<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶合同内容</h3><hr>
   	<script id="editor5" type="text/plain" style="width:100%;height:200px;" name="contract"></script>
</td>
</tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶   银行账户</h3><hr>
</td>
</tr>
<tr height="60">
<td   align="center">银行账户:</td>
<td  colspan="3"   align="left">
<input   style="width: 500px;"   type="text" name="bank_account" class="form-control">
<font color="red">(格式:xxx支行|银行账号|公司名称)</font>
</td>

</tr>

<tr height="60">
<td colspan="4"  align="center">
<input type="submit" value="保存" class="btn btn-primary"/>
&nbsp;&nbsp;
<button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
</td>
</tr>

 </table>
</form> 
</center>
   <script type="text/javascript">
    var ue = UE.getEditor('editor1');
    var ue = UE.getEditor('editor2');
    var ue = UE.getEditor('editor3');
    var ue = UE.getEditor('editor4');
    var ue = UE.getEditor('editor5');
   </script>
</body>
</html>