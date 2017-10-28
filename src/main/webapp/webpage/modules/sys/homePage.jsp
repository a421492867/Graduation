<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Insert title here</title> -->
<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.3.0/css/bootstrap.min.css" />
</head>
<style>
	.introduction{
		text-align : center;
		 height : 230px; 
	}
	.introduction h3{
		font-size : 36px;
		font-weight : 500;
	}
	.introduction p{
		line-height : 15px;
		font-size : 14px;
		color : #8d8d8d;
	}
	.introduction img{
	    height : 230px; 
		width : 460px;
	}
	.footer{
	 	text-align : center;
	 	padding-top : 4%;
	}
	.footer p{
	 	font-size : 20px;
	 	font-weight : 500;
	 	color : #8d8d8d;
	}
	
</style>
<body>

	<div class="row introduction">
		<div class="col-md-6">
			<img src="../../../images/sys/school_ofo.jpg" style="transform:rotate(-5deg);">
		</div>
		<div class="col-md-6" style="transform:rotate(5deg);">
			<h3>在校园</h3>
            <p>ofo 萌起校园，直至 2016 年 10 月，已来到全国22座城市、200 多所高校，累计提供超</p>
            <p>过 4000 万次共享单车出行服务， 目前已成为中国规模最大的校园交通代步解决方案,</p>
            <p>为广大高校师生提供便捷经济、绿色低碳、更高效率的校园共享单车服务。</p>
		</div>
	</div>
	
	<div class="row introduction">
		<div class="col-md-6" style="transform:rotate(-5deg);">
			<h3>在城市</h3>
            <p>低效率的出行状况已经无法满足快节奏的城市生活，两点一线的生活半径和不断加速的城</p>
            <p>市改造，让外来人融不进来，也让原住民忘了城市本来的样子，</p>
            <p>正因如此，ofo 共享单车怀揣“随时随地有车骑”的朴素愿景来到城市，试图满足人们短途</p>
            <p>代步的需求，更用这辆单车，重新丈量人们经过的每一条路线，找寻与城市的全新连接方式。</p>
		</div>
		<div class="col-md-6">
			<img src="../../../images/sys/city_ofo.jpg" style="transform:rotate(5deg);">
		</div>
		
	</div>
	
	<div class="row introduction">
		<div class="col-md-6">
			<img src="../../../images/sys/future_ofo.png">
		</div>
		<div class="col-md-6">
			<h3>在未来</h3>
            <p>ofo 以开放平台和共享精神，欢迎用户共享自己的单车加入 ofo，以互联网创新模式调动</p>
            <p>城市单车存量市场,提高自行车使用效率，为城市节约更多空间；</p>
            <p>在未来， ofo 希望不生产自行车，只连接自行车，让人们在全世界的每一个角落都可以通</p>
            <p>过 ofo 解锁自行车，随时随地有车骑，满足短途代步的需求。</p> 
		</div>
	</div>
	
	<div class="footer">
		<p>For More Information , Please Visit <a href="http://www.ofo.so" target="_blank">http://www.ofo.so</a></p>
	</div>
	
	
	
	

</body>
</html>