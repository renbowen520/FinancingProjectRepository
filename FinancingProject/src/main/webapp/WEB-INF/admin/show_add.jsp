<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增角色</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<link href="/FinancingProject/zTree_v3/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css" /> 
 
 <script src="/FinancingProject/zTree_v3/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="/FinancingProject/zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/FinancingProject/zTree_v3/js/jquery.ztree.excheck.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>角色管理
<span class=" glyphicon glyphicon-menu-right" aria-hidden="true"></span>
新增角色</b>
</h3>
<hr>

<script type="text/javascript">
var setting = {
		check: {
			enable: true,//节点的 checkBox / radio 的 勾选状态
			chkStyle: "checkbox",//chkStyle = "checkbox" 时，显示 checkbox 选择框，setting.check.chkboxType 属性有效。 
			chkboxType: { "Y": "ps", "N": "ps" }  //勾选 checkbox 对于父子节点的关联关系
		},
		data: {
			simpleData: {
				enable: true
			 }
		 }
   
	};



var zNodes =[
	{ id:1, pId:0, name:"随意勾选 1", open:true},
	{ id:11, pId:1, name:"随意勾选 1-1", open:true},
	{ id:111, pId:11, name:"随意勾选 1-1-1"},
	{ id:112, pId:11, name:"随意勾选 1-1-2"},
	{ id:12, pId:1, name:"随意勾选 1-2", open:true},
	{ id:121, pId:12, name:"随意勾选 1-2-1"},
	{ id:122, pId:12, name:"随意勾选 1-2-2"},
	{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
	{ id:21, pId:2, name:"随意勾选 2-1"},
	{ id:22, pId:2, name:"随意勾选 2-2", open:true},
	{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
	{ id:222, pId:22, name:"随意勾选 2-2-2"},
	{ id:23, pId:2, name:"随意勾选 2-3"}
];


$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
/* 	setCheck();
	$("#py").bind("change", setCheck);
	$("#sy").bind("change", setCheck);
	$("#pn").bind("change", setCheck);
	$("#sn").bind("change", setCheck); */
});
</script>
 <div>
	<ul id="treeDemo" class="ztree"></ul>
</div>

</body>
</html>