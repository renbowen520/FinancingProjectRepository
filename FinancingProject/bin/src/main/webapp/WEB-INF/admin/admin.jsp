<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>孔明理财后台管理</title>
    <link rel="stylesheet" href="/FinancingProject/plugins/layui/css/layui.css" media="all">
    
    <!--图标样式  -->
	 <link rel="stylesheet" type="text/css" href="/FinancingProject/css/font-awesome.css">
    <link rel="stylesheet" href="/FinancingProject/build/css/app.css" media="all">
    <link rel="stylesheet" href="/FinancingProject/build/css/themes/blue.css" media="all">
</head>
<body class="kit-theme">
    <div class="layui-layout layui-layout-admin kit-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">Menus</div>
            <div class="layui-logo kit-logo-mobile">K</div>
            <ul class="layui-nav layui-layout-left kit-nav" kit-one-level>
                <li class="layui-nav-item"><a href="javascript:;">首页</a></li>
            </ul>
            <ul class="layui-nav layui-layout-right kit-nav">
              
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="/FinancingProject/images/0.jpg" class="layui-nav-img"> Admin
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">基本资料</a></dd>
              
                        <dd><a href="javascript:;"><i class=" fa fa-refresh"></i>&nbsp;注销</a></dd>

                    </dl>
                </li>

      <li class="layui-nav-item"><a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i> 退出</a></li>
            </ul>
        </div>


        <div class="layui-side layui-bg-black kit-side">
            <div class="layui-side-scroll">
                <div class="kit-side-fold"  ><i class="fa fa-bars" aria-hidden="true"></i></div>
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span> 理财产品</span></a>
                        <dl class="layui-nav-child">
                              <dd>
                                     <a href="javascript:;" data-url="/FinancingProject/AdminController/menus1" data-icon="&#xe614;" data-title="固收类/P2P" kit-target data-id='2'><i class="layui-icon">&#xe614;</i><span>&nbsp; 固收类/P2P</span></a>
                                  
                              </dd>
                              <dd>
                                    <a href="javascript:;" data-url="/FinancingProject/AdminController/menus2" data-icon="&#xe614;" data-title="私募基金" kit-target data-id='3'><i class="layui-icon">&#xe614;</i><span>&nbsp;私募基金</span></a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus3" data-icon="&#xe614;" data-title="股权基金" kit-target data-id='4'><i class="layui-icon">&#xe614;</i><span>&nbsp;股权基金</span></a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus4" data-icon="&#xe614;" data-title="海外配置" kit-target data-id='5'><i class="layui-icon">&#xe614;</i><span> &nbsp;海外配置</span></a>
                            </dd>
                        
                        </dl>
                    </li>

                 <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 钱包管理</span></a>
                   <dl class="layui-nav-child">
                    
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus5" data-icon="&#xe614;" data-title="缴费记录" kit-target data-id='6'><i class="layui-icon">&#xe614;</i><span> &nbsp;缴费记录</span></a>
                            </dd>
                        </dl>
                    </li>


                    <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 学院管理</span></a>
                   <dl class="layui-nav-child">
                     
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus6" data-icon="&#xe614;" data-title="资讯分类" kit-target data-id='7'><i class="layui-icon">&#xe614;</i><span> &nbsp;资讯分类</span></a>
                            </dd>
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus7" data-icon="&#xe614;" data-title="资讯管理" kit-target data-id='8'><i class="layui-icon">&#xe614;</i><span> &nbsp;资讯管理</span></a>
                            </dd>
                        </dl>
					
					</li>



                  <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 会员管理</span></a>
                   <dl class="layui-nav-child">
                     
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus8" data-icon="&#xe614;" data-title="账号管理" kit-target data-id='9'><i class="layui-icon">&#xe614;</i><span> &nbsp;账号管理</span></a>
                            </dd>
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus9" data-icon="&#xe614;" data-title="理财师审核" kit-target data-id='10'><i class="layui-icon">&#xe614;</i><span> &nbsp;理财师审核</span></a>
                            </dd>
								    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus10" data-icon="&#xe614;" data-title="绑卡管理" kit-target data-id='11'><i class="layui-icon">&#xe614;</i><span> &nbsp;绑卡管理</span></a>
                            </dd>
								    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus11" data-icon="&#xe614;" data-title="付息计划" kit-target data-id='12'><i class="layui-icon">&#xe614;</i><span> &nbsp;付息计划</span></a>
                            </dd>
								    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus12" data-icon="&#xe614;" data-title="充值管理" kit-target data-id='13'><i class="layui-icon">&#xe614;</i><span> &nbsp;充值管理</span></a>
                            </dd>
								    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus13" data-icon="&#xe614;" data-title="提现管理" kit-target data-id='14'><i class="layui-icon">&#xe614;</i><span> &nbsp;提现管理</span></a>
                            </dd>
								    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus14" data-icon="&#xe614;" data-title="邀请奖励" kit-target data-id='15'><i class="layui-icon">&#xe614;</i><span> &nbsp;邀请奖励</span></a>
                            </dd>
                        </dl>
					
					</li>


         <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 理财统计</span></a>
                   <dl class="layui-nav-child">
                     
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus15" data-icon="&#xe614;" data-title="财务统计" kit-target data-id='16'><i class="layui-icon">&#xe614;</i><span> &nbsp;财务统计</span></a>
                            </dd>
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus16" data-icon="&#xe614;" data-title="用户综合统计" kit-target data-id='17'><i class="layui-icon">&#xe614;</i><span> &nbsp;用户综合统计</span></a>
                            </dd>
                        </dl>
					
					</li>

               <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 理财设置</span></a>
                   <dl class="layui-nav-child">
                     
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus17" data-icon="&#xe614;" data-title="发布公告" kit-target data-id='18'><i class="layui-icon">&#xe614;</i><span> &nbsp;发布公告</span></a>
                            </dd>
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus18" data-icon="&#xe614;" data-title="意见反馈" kit-target data-id='19'><i class="layui-icon">&#xe614;</i><span> &nbsp;意见反馈</span></a>
                            </dd>
                        </dl>
					
					</li>

     <li class="layui-nav-item">
                        <a href="javascript:;"  data-name="table" kit-loader><i class="fa fa-plug" aria-hidden="true"></i><span> 系统管理</span></a>
                   <dl class="layui-nav-child">
                     
                              
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus19" data-icon="&#xe614;" data-title="账号管理" kit-target data-id='20'><i class="layui-icon">&#xe614;</i><span> &nbsp;账号管理</span></a>
                            </dd>
							    <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus20" data-icon="&#xe614;" data-title="角色管理" kit-target data-id='21'><i class="layui-icon">&#xe614;</i><span> &nbsp;角色管理</span></a>
                            </dd>
							  <dd>
                                <a href="javascript:;" data-url="/FinancingProject/AdminController/menus21" data-icon="&#xe614;" data-title="修改密码" kit-target data-id='22'><i class="layui-icon">&#xe614;</i><span> &nbsp;修改密码</span></a>
                            </dd>
                        </dl>
					
					</li>


                </ul>
            </div>
        </div>
        <div class="layui-body" id="container">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">主体内容加载中,请稍等...</div>
        </div>

        <div class="layui-footer" >
            <!-- 底部固定区域 -->
            2017 &copy;  ----All right reserved. Template by(版权所有):襄阳孔明投资管理有限公司
			&nbsp;&nbsp;&nbsp;&nbsp;
                <span id="ssss" style="text-align:right;"></span>
       
        </div>
 
    </div>
 <script>
	 setInterval("ssss.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000); 
 </script> 


<!--     <script type="text/javascript">
        var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
    </script>
 -->
   <script src="/FinancingProject/js/jquery-3.2.0.min.js"></script>
    <script src="/FinancingProject/plugins/layui/layui.js"></script>
    <script>
        var message;
        layui.config({
            base: '/FinancingProject/build/js/'
        }).use(['app', 'message'], function() {
            var app = layui.app,
                $ = layui.jquery,
                layer = layui.layer;
            //将message设置为全局以便子页面调用
            message = layui.message;
            //主入口
            app.set({
                type: 'iframe'
            }).init();
           
        });
    </script>
</body>
</html>