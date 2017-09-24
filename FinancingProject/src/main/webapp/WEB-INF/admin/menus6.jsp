<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资讯分类</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>

</head>
<body>
<!--这里写资讯分类  -->
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>资讯分类</b>
</h3>

<hr>


<center>
<form  name="f77"  id="f77"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">名称</label >
              <input type="text" class="form-control" id="news_type_q1"  name="news_type_q1" 
        value="${news_type_q1 }"        placeholder="请输入名称"   style="width: 200px">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">添加人</label >
               <input type="text" class="form-control"   id="news_type_q2"  name="news_type_q2"
          placeholder="请输入添加人姓名"               value="${news_type_q2 }"     style="width: 200px">
 </td>
  <td>
       <button type="button" class="btn btn-primary"  name="se"  id="se"  >
          查询
       </button>
 </td>
 <td>
         <button id="re77"      type="button" class="btn btn-danger"   >  重置 </button>
 </td>
  <td align="right" width="10%">
     <button type="button" class="btn btn-primary" data-toggle="modal" 
   data-target="#my">
  新增
</button>
 </td>
</tr>
</table>
</form>
</center>
<br>


<center>
<div style="width: 95%">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>名称</th>
        <th>上级类别</th>
        <th>简介</th>
         <th>排序</th>
         <th>添加时间</th>
         <th>修改时间</th>
           <th>添加人</th>
          <th>修改人</th>
          <th>操作</th>
       </tr>
       <c:forEach  items="${news_type }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                 <td>${s.name }</td>
                 <td>
                 <script type="text/javascript">
                  var id='${s.id}';
				   $.ajaxSetup({  
					    async : false  
					}); 
				  var news=""; 
				 $.post("/FinancingProject/News_type_Controller/supType",{id:id},function(data){
					 news=data;
				  });
				   document.write(news);
				 </script>
                 </td>
                 <td>${s.info }</td>
                  <td>${s.sort }</td>
                  <td>${s.addTime }</td>
                    <td>${s.updTime }</td>
                      <td>${s.users.user_name }</td>
                        <td>${s.users2.user_name }</td>
                  <td>
                  <button type="button" class="btn btn-primary"  data-toggle="modal"        onclick="edit(${s.id});">
                   编辑
                  </button>
                  &nbsp; &nbsp;
                   <script type="text/javascript">
                  var id='${s.id}';
				   $.ajaxSetup({  
					    async : false  
					}); 
				  var b=""; 
				 $.post("/FinancingProject/News_type_Controller/boo",{id:id},function(data){
		      	b=data;
				  });
				    if(b==1){
				    	  document.write("<button type='button' class='btn btn-danger'  data-toggle='modal'  onclick=fun999('${s.id}')> 删除  </button>");
	
				    }else if(b==0){
				    	  document.write("<button   disabled='disabled'          type='button' class='btn btn-danger'  data-toggle='modal' > 删除  </button>");
				    }
				 
				 
				 </script>
                  </td>
          </tr>
        </c:forEach>
 </table>
 </div>
 </center>
 
 
 
 
 
 <!--  div层-->
<div class="modal fade" id="my999" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
             <form   action="/FinancingProject/News_type_Controller/de"   name="f999"  id="f999"    class="form-horizontal" role="form"    method="post">    
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h3 class="modal-title" id="myModalLabel">
           <font color="red">  警告</font>  
             </h3>
         </div>
         
         <div class="modal-body">
       <b>  确定删除该分类?</b>
            <input  name="id999"   type="hidden"  id="id999">
         
        </div>
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
            <button  id=""   type="submit" class="btn btn-primary"  >
               确定</button>
               
         </div>
          </form>    
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 
 
 
 
 
 
 
 
 
 
 
 <div class="modal fade" id="my" tabindex="-1" role="dialog" 
    aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 新增 资讯分类  </h4>
         </div>
         
       <form  name="f1"  id="f1"    class="form-horizontal" role="form"  action="/FinancingProject/News_type_Controller/add"  method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">名称</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="name"  name="name"
                 placeholder="请输入名称" required="required">
               </div>
          </div>
   <div class="form-group">
         <label for="lastname" class="col-sm-2 control-label">上级目录</label>
           <div class="col-sm-10">
              <select  name="supType"  id="xiala" class="form-control">
            </select> 
         </div>
   </div>
   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">简介</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="info"  name="info"
                 placeholder="请输入简介"  required="required">
               </div>
          </div>
   
       <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">排序</label>
               <div class="col-sm-10">
               <input type="number" class="form-control"  id="sort"  name="sort"
                value="1"    min="1"  required="required" >
               </div>
          </div>
   
          
   </div>
         
         <div class="modal-footer">
         
           <div id="yc" style="margin-bottom:1px;color: red;display: none">请填写完整信息</div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
              <button type="button" id="re88" class="btn btn-danger">重置</button> 
               
            <button  id="ok"   type="submit" class="btn btn-primary" >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 
 

 
  
 <div class="modal fade" id="ed" tabindex="-1" role="dialog" 
    aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 编辑 资讯分类  </h4>
         </div>
         
       <form  name="f2"  id="f2"    class="form-horizontal" role="form"  action="/FinancingProject/News_type_Controller/update"  method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">名称</label>
               <div class="col-sm-10">
               <input type="hidden" id="id2" name="id2" >
            
               <input type="text" class="form-control" id="name2"  name="name2"
                 placeholder="请输入名称" required="required">
               </div>
          </div>
   <div class="form-group">
         <label for="lastname" class="col-sm-2 control-label">上级目录</label>
         <div class="col-sm-10">
              <select     name="x2"     id="x2" class="form-control">
             </select> 
         </div>
   </div>
   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">简介</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="info2"  name="info2"
                 placeholder="请输入简介"  required="required">
               </div>
          </div>
   
       <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">排序</label>
               <div class="col-sm-10">
               <input type="number" class="form-control"  id="sort2"  name="sort2"
                value="1"    min="1"  required="required" >
               </div>
          </div>
   
          
   </div>
         
         <div class="modal-footer">
           <div id="yc2" style="margin-bottom:1px;color: red;display: none">请填写完整信息</div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal"  >关闭</button>
              
               
            <button  id="ok88"   type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  ed  -->
 
 
 
 <script type="text/javascript">

 
 function fun999(id){
	  $('#id999').val(id);
	  $('#my999').modal('show');
 }
 
 
 $('#ed').on('hide.bs.modal', function () {
	 $('#f2').data('bootstrapValidator').resetForm(true);
 
 });
 

 
 $("#se").click(function(){ //查询
			$("#f77").attr("action","/FinancingProject/AdminController/menus6");
			$("#f77").submit();
			});

 $("#re77").click(function(){ //重置
	 $("#news_type_q1").val("");
     $("#news_type_q2").val("");
		$("#f77").attr("action","/FinancingProject/AdminController/menus6");
		$("#f77").submit();
		});
 $("#re88").click(function(){ //重置 
	 $('#f1').data('bootstrapValidator').resetForm(true);
	 
	});	 
	 

 function edit(id){ //显示编辑框
 // 异步请求内容
	    $.post("/FinancingProject/News_type_Controller/getById",{id:id},
	    function(msg){
	    	    $("#id2").val(msg.id);
	    	    $("#name2").val(msg.name);
	    	    $("#info2").val(msg.info);
	    	    $("#sort2").val(msg.sort);
	    	    $("#x2  option[value='"+msg.supType+"']").attr("selected", true);    //设置Select的Text值为jQuery的项选中
	    	    $("#x2  option[value='"+msg.id+"']").remove();   //删除Select中Value=自己的Option
	    });
	    $('#ed').modal('show');
 }
 
 
 //这个是当窗口打开时的事件 异步请求下拉列表
 $(function(){  
	 $.post("/FinancingProject/News_type_Controller/list",function(msg){
		  var s2="根类别";
		  $("#x2").append("<option value="+0+">"+s2+"</option>");	
		  $("#xiala").append("<option value="+0+">"+s2+"</option>");	
		  for(var i=0;i<msg.length;i++){
		 	      s=msg[i];
		 	      $("#x2").append("<option value="+s.id+">"+s.name+"</option>");
				  $("#xiala").append("<option value="+s.id+">"+s.name+"</option>");	
		  }
		 }); 
	 
	
	 
	//验证
	    $('#f1').bootstrapValidator({
	          message: 'This value is not valid',
	          feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields: {
	                 name: {
	                  message: '',
	                  validators: {
	                      notEmpty: { //非空验证
	                          message: '标题不能为空!'
	                      },
	                      stringLength: {  //长度验证
	                          min: 2,
	                          max: 100,
	                          message: '标题长度为2-30个字符!'
	                      }
	                  }
	              },
	             info: {
	                  message: '',
	                  validators: {
	                      notEmpty: { //非空验证
	                          message: '简介不能为空!'
	                      },
	                      stringLength: {  //长度验证
	                          min: 2,
	                          max: 100,
	                          message: '简介长度为2-50个字符!'
	                      }
	                  }
	              }
	             
	             
	        
	          }//验证
	      });
	    //////////////////////
		 
	 	//验证
	    $('#f2').bootstrapValidator({
	          message: 'This value is not valid',
	          feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields: {
	                 name2: {
	                  message: '',
	                  validators: {
	                      notEmpty: { //非空验证
	                          message: '标题不能为空!'
	                      },
	                      stringLength: {  //长度验证
	                          min: 2,
	                          max: 100,
	                          message: '标题长度为2-30个字符!'
	                      }
	                  }
	              },
	             info2: {
	                  message: '',
	                  validators: {
	                      notEmpty: { //非空验证
	                          message: '简介不能为空!'
	                      },
	                      stringLength: {  //长度验证
	                          min: 2,
	                          max: 100,
	                          message: '简介长度为2-50个字符!'
	                      }
	                  }
	              }
	             
	             
	        
	          }//验证
	      });
	    //////////////////////
	 
	 
 });
 
 </script>
</body>
</html>