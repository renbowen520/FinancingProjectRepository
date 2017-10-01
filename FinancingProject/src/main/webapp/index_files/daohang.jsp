<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/FinancingProject/css/jq22.css" rel="stylesheet" type="text/css">
<script src="/FinancingProject/js/jquery-3.2.0.min.js"></script>
<script src="/FinancingProject/js/jquery.movebg.js"></script>

</head>
<body>

<!-- 代码 开始 -->


<center>
    <div class="nav"  >

        <ul>
            <li class="nav-item"><a   target="_parent"></a></li>
            <li class="nav-item"><a target="_parent"></a></li>
            <li class="nav-item"><a  href="http://127.0.0.1:8080/FinancingProject/IndexController/index"  target="_parent">网站首页</a></li>

            <li class="nav-item cur"><a href="/FinancingProject/IndexController/Online_experience_center" target="_parent">网上体验中心</a></li>

            <li class="nav-item"><a  href="/FinancingProject/IndexController/product" target="_parent">产品中心</a></li>

            <li class="nav-item"><a  href="/FinancingProject/IndexController/news" target="_parent">新闻中心</a></li> 

            <li class="nav-item"><a href="/FinancingProject/IndexController/download" target="_parent">下载中心</a></li> 

            <li class="nav-item"><a  href="/FinancingProject/IndexController/help" target="_parent">孔明商学院</a></li>

            <li class="nav-item"><a  href="/FinancingProject/IndexController/investment_research"   target="_parent">投研中心</a></li>
            <li class="nav-item"><a     href="/FinancingProject/IndexController/personal_center"    target="_parent">个人中心</a></li>
          <li class="nav-item"><a target="_parent"></a></li>
        </ul>

        <!--移动的滑动-->

        <div class="move-bg" style="display: block; left: 120px;"></div>

        <!--移动的滑动 end-->

    </div>
</center>


<script>

$(function(){

	$(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});

})

</script>

<!-- 代码 结束 -->






</body>
</html>