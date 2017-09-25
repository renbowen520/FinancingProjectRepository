<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>


<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>
<link href="/FinancingProject/zTree_v3/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css" /> 
 <script src="/FinancingProject/zTree_v3/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="/FinancingProject/zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/FinancingProject/zTree_v3/js/jquery.ztree.excheck.js"></script>



</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>角色管理</b>
</h3>
<hr>


<div   style="width: 95%;text-align: right;">
   <button type="button" class="btn btn-primary"     data-toggle="modal"       onclick="fun()"  >
                  新增
    </button>
</div>



<center>
<br>
<div   style="width: 95%">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>角色名</th>
         <th>角色描述</th>
          <th>状态</th>
         <th>创建时间</th>
         <th>更新时间</th>
          <th>操作</th>
       </tr>
       
       <c:forEach  items="${list_user_role }" var="s"   varStatus="va">
           <tr>
                  <td>${va.index+1 }</td>
                  <td>${s.cname}</td>
                  <td>${s.remark }</td>
                   <td>
                  <c:if test="${s.delFlag==0 }">
                   <font color="blue">   正常</font>
                  </c:if>
                     <c:if test="${s.delFlag==1 }">
                   <font color="red"> 已删除</font>
                  </c:if>
                  </td>
                  <td>${s.create_date }</td>
                  <td>${s.update_date }</td>
                
             
                
                  <td>
                  <button type="button" class="btn btn-primary"     data-toggle="modal"       onclick="fun2(${s.id},${s.delFlag})"  >
                    权限配置
                   </button>
                   &nbsp; &nbsp;
                   
                   <script type="text/javascript">
                  var id='${s.id}';
				   $.ajaxSetup({  
					    async : false  
					}); 
				  var b=""; 
				 $.post("/FinancingProject/UsersController/boo",{id:id},function(data){
		      	 b=data;
				  });
				    if(b==1){
				    	  document.write("   <button type='button' class='btn btn-danger'     data-toggle='modal'       onclick='fun3(${s.id})'  > 删除</button>");
				    }else if(b==0){
				    	  document.write("   <button     disabled='disabled'        type='button' class='btn btn-danger'     data-toggle='modal'       onclick='fun3(${s.id})'  > 删除</button>");
				    }
				 </script>
           
                  </td>
          </tr>
        </c:forEach>
 </table>
 </div>
 </center>
 

<!--  编辑的div层-->
<div class="modal fade" id="my2" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 权限配置  </h4>
         </div>
       <form  action=""     name="f2"  id="f2"    class="form-horizontal" role="form"    method="post">    
    
    <div class="modal-body" style="background-color: #F0F6E4;">
            <input type="text"  id="rid"  name="rid" >
           
           <ul id="treeDemo" class="ztree" ></ul>
          
         <hr>
           <div class="form-group"  id="aaa">
           <label for="firstname" class="col-sm-2 control-label">重新启用:</label>
               <div class="col-sm-10">
                                <input disabled="disabled"   type="checkbox"  name="zd" id="zd"  value="0" checked="checked" >
               </div>
          </div>
         
       </div>
       
       
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
            <button  type="submit" class="btn btn-primary"   onclick="okok();">
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 



<!--  编辑的div层-->
<div class="modal fade" id="my" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel">新增角色  </h4>
         </div>
         
       <form  action="/FinancingProject/UsersController/add_role"     name="f1"  id="f1"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色名:</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="cname"  name="cname"
                 placeholder="请输入角色名" required="required">
               </div>
          </div>
          <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色描述:</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="remark"  name="remark"
                 placeholder="请输入角色描述" required="required">
               </div>
          </div>
   
   </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              <button type="button"       id="but2" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->




<!--  div层-->
<div class="modal fade" id="my3" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h3 class="modal-title" id="myModalLabel">
           <font color="red">  警告</font>  
             </h3>
         </div>
         
         <div class="modal-body">
         确定删除该角色?
          <form action="/FinancingProject/UsersController/de_role"    name="f3"  id="f3"    class="form-horizontal" role="form"    method="post">    
            <input  name="delete_id"   type="hidden"  id="delete_id">
            
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
 



<script type="text/javascript">
function okok(){   //提交权限配置
	
	
	
}




function fun(){   //新增
	// $(location).attr('href', '/FinancingProject/UsersController/show_add');
   $('#my').modal('show'); //显示
}


   function fun2(id,del){//编辑
	   $("#aaa").hide();
   $("#rid").val(id);
     if(del==1){
	     $("#aaa").show();
     }
	      //显示树形菜单
	      var setting = {
		view: {
			fontCss : {color:"blue"}
		},
		
	   async: {   //异步加载
			enable: true,
	         url:"/FinancingProject/UsersController/permission",
				autoParam:["id", "name"], //异步加载时需要自动提交父节点属性的参数。[setting.async.enable = true 时生效]
		 	  otherParam:{"id":id}, //Ajax 请求提交的静态参数键值对。[setting.async.enable = true 时生效]
			//	dataFilter: filter 用于对 Ajax 返回数据进行预处理的函数
		},
		check: {
			enable: true,//节点的 checkBox / radio 的 勾选状态
			chkStyle: "checkbox",//chkStyle = "checkbox" 时，显示 checkbox 选择框，setting.check.chkboxType 属性有效。 
			chkboxType: { "Y": "ps", "N": "ps" }  //勾选 checkbox 对于父子节点的关联关系
		},
		data: {  
			simpleData: {
				enable: true,
			   idKey : "id",  //节点数据中保存唯一标识的属性名称。[setting.data.simpleData.enable = true 时生效]
            pIdKey : "pid", //节点数据中保存其父节点唯一标识的属性名称。[setting.data.simpleData.enable = true 时生效]  
           rootId : 0  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
			}
		 }

	};

	  	$.fn.zTree.init($("#treeDemo"), setting);
	      $('#my2').modal('show'); //显示
   }
   
   function fun3(id){//删除
	   $("#delete_id").val(id);
	    $('#my3').modal('show'); //显示
 }
   
   
   $("#but2").click(function(){
	    $('#f1').data('bootstrapValidator').resetForm(true);
   });
   
   
  $(function(){
	//验证
	    $('#f1').bootstrapValidator({
	          message: 'This value is not valid',
	          feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields: {
	        	  cname: {
	                  message: '',
	                  validators: {
	                      notEmpty: { //非空验证
	                          message: '角色名不能为空!'
	                      },
	                      stringLength: {  //长度验证
	                          min: 2,
	                          max: 10,
	                          message: '角色名长度为2-10个字符!'
	                      }
	                  }
	              },
	              remark: {
                  message: '',
                  validators: {
                      notEmpty: { //非空验证
                          message: '角色描述不能为空!'
                      },
                      stringLength: {  //长度验证
                          min: 2,
                          max: 30,
                          message: '角色描述长度为2-30个字符!'
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