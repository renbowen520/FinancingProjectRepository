<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){ //保存固收
		$("#form1").attr("action","/FinancingProject/subject/save");
		$("#form1").submit();
	});
	});

 </script>


<body>
<p><h3>&nbsp;&nbsp;▶ 产品信息详细表</h3>
<form id="form1" action="/FinancingProject/subject/save" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" width="100%">
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;名称:</td><td><input type="text" name="name" class="form-control"></td><td>&nbsp;&nbsp;类型:</td><td><select class="form-control" name="type"><option value="0">固收类</option><option value="1">P2P车贷</option><option value="2">P2P房贷</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;合同编号:</td><td><input type="text" name="serial_no" class="form-control"></td><td>&nbsp;&nbsp;借款用途:</td><td><input type="text" name="purpose"  class="form-control"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;起投金额(元):</td><td><input type="text" name="floor_amount" class="form-control"></td><td>&nbsp;&nbsp;保障方式:</td><td><select name="safeGuard_way" class="form-control"><option value="0">企业担保</option><option value="1">银行监管</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;年化收益(%):</td><td><input type="text" name="year_rate" class="form-control"></td><td>&nbsp;&nbsp;可使用体验金:</td><td><select name="experStatus" class="form-control"><option value="0">否</option><option value="1">是</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;状态:</td><td><select class="form-control" name="status">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select></td><td>&nbsp;&nbsp;已购人数:</td><td><input type="text" class="form-control" name="bought"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;投资期限(天):</td><td><input type="text" class="form-control" name="period"></td><td colspan="2"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;借款人姓名:</td><td><input type="text" name="borrowername" class="form-control"></td><td colspan="2"></td>
</tr>
<tr height="60">
<td colspan="4"><h3>&nbsp;&nbsp;▶ 特定属性</h3><hr></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;债权编号:</td><td><input type="text" name="borrowerid" class="form-control"></td><td>&nbsp;&nbsp;&nbsp;债权人:</td><td><input type="text" name="borrowername" class="form-control" ></td>
</tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 产品速览</h3><hr>
   	 <script id="editor" type="text/plain" style="width:100%;height:200px;" name="comment"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 项目详情</h3><hr>
  <script id="editor2" type="text/plain" style="width:100%;height:200px;" name="projectDetails"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 安全保障</h3><hr>
   	<script id="editor3" type="text/plain" style="width:100%;height:200px;" name="safetyControl"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr>
</td></tr>
<tr height="60"><td colspan="2">&nbsp;&nbsp;&nbsp;图片预览 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td colspan="2">
<input type="file" name="file_name" class="form-control"/></td>
<td>
</tr>
<tr height="60">
<td colspan="4"  align="center">

<input type="submit" class="btn btn-primary" id="btn1" value="保存">
<a href="/FinancingProject/AdminController/menus1">返回固收首页</a>
</td>
</tr>
</table>
</form>





		


 <form action="/uploadFile" method="post"  enctype="multipart/form-data">
<table border="0" cellspacing="0" width="100%">
<tr height="60"><td colspan="4"><p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr></td></tr>
<tr height="60"><td colspan="2">&nbsp;&nbsp;&nbsp;图片预览 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td>
<input type="file" name="file_name" class="form-control"/></td>
<td>
<input type="submit" value="上传"  class="btn btn-primary"/></td>
</tr>
</table>
</form>

  <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    var ue2 = UE.getEditor('editor2');
    var ue3 = UE.getEditor('editor3');
   </script>				
		
		
</body>
</html>