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
	var a = "${statusm}";
	var b = "${typem}";
	    $("#statusm  option[value='"+a+"']").attr("selected", true);
	    $("#typem  option[value='"+b+"']").attr("selected", true);
	
	

	$("#btn1").click(function(){ //模糊查询按钮
		 $("#form1").attr("action","/FinancingProject/AdminController/menus11");
		 $("#form1").submit();
	});
	
	
	$("#ree").click(function(){ //重置
	     $("#namem").val("");
	     $("#statusm  option[value='']").attr("selected", true);
	    $("#typem    option[value='']").attr("selected", true);
		$("#form1").attr("action","/FinancingProject/AdminController/menus11");
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
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>付息计划</b>
</h3>
<hr>

	<center>
<form method="post" id="form1" role="form"    class="form-horizontal">
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-3 control-label">名称</label >
  <input     id="namem"  style="width: 160px"     type="text"  class="form-control"    placeholder="请输入名称" name="namem" value="${namem}">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">状态</label >
                     <select style="width: 160px"     id="statusm"  name="statusm"    class="form-control"  >
							<option value="">全部</option>
							<option value="0">未发布</option>
							<option value="1">募集中</option>
							<option value="2">回款中</option>
							<option value="3">还款完成</option>
						</select>
 </td>
 <td>
  <label for="firstname" class="col-sm-3 control-label">类型</label >
 	   <select   id="typem"   name="typem"  style="width: 160px"  class="form-control"  >
							<option value="">全部</option>
							<option value="0">固收类</option>
							<option value="1">P2P车贷</option>
							<option value="2">P2P房贷</option>
						</select>
 </td>
 
  <td>
  		<button type="button" class="btn btn-primary" id="btn1">查询</button>
 </td>
 <td>
	   <button  id="ree" type="button" class="btn btn-danger">重置</button>
 </td>
</tr>
</table>
<br>	
         
         <div style="width: 95%">
		<table  class="table table-striped  table-hover"  >
			<tr>
				<th>序号</th>
				<th>合同编号</th>
				<th>标的类别</th>
				<th>标的名称</th>
				<th>已投金额(RMB)</th>
				<th>已投人数</th>
				<th>标的期限(天)</th>
				<th>年化收益(%)</th>
				<th>标的状态</th>
				<th>可用体检金</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${listSubject }" var="ls" varStatus="stat">
			<tr>
		
				<td>
					<input type="hidden" name="subject_id"  value="${ls.id }">
				${stat.index+1}
				</td>
				<td>${ls.serial_no }</td>
				<td><c:if test="${ls.type==0 }">固收类</c:if>
				<c:if test="${ls.type==1 }">P2P车贷</c:if>
				<c:if test="${ls.type==2 }">P2P房贷</c:if>
				</td>
				<td>${ls.name }</td>
				<td>
				    <script type="text/javascript">
				       var id="${ls.id }";		
				     $.ajaxSetup({  
					    async : false  
					}); 
				  var num1=0;
				  $.post("/FinancingProject/MemberController/getTotalMoney",{id:id},function(data){
					 num1=data;
				  });
				  document.write(num1);
				 </script>
				  </td>
				<td>
				 <script type="text/javascript">
				          var id="${ls.id }";	
              				      $.ajaxSetup({  
              					    async : false  
              				 	  }); 
              				    var m;
                                $.post("/FinancingProject/IndexController/count",{id:id},
                              		    function(msg){
                              		    	m = msg;
                              		    });
                               document.write(m);
                                </script>
				</td>
				<td>${ls.period }</td>
				<td>${ls.year_rate }</td>
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
		 </div>
		
		
	</form>
</center>
</body>
</html>