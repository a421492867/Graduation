<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Insert title here</title> -->
<link rel="stylesheet"
	href="${ctx}css/modules/sys/top.css" />
<script type="text/javascript" src="${ctx}js/modules/sys/top.js"></script>
</head>
<body>

	<!-- <h1>This Is For Top</h1> -->
	
	<div class="tab-back"  style="position:fixed;height:100px;width:100%;">
		<div style="width: 29%; height: 100%; float: left">
			<div style="width: 100%; height: 55%; float: left">
				<div style="width: 5%; height: 100%; float: left"></div>
				<div style="width: 95%; height: 100%; float: left; padding-top: 8px;cursor:pointer;">
					
						<image
							src="${pageContext.request.contextPath}/images/sys/ofo_logo.png"
							style="height: 45px;"> </image>
				</div>
			</div>
		</div>
		<div style="width: 29%; height: 100%; float: right">
			<div style="width: 100%; height: 55%; float: left">
				<a href="${ctx}logout"> 
			<span><img alt="image" class="img-circle" style="height:15px;width:15px;margin-top:20px;float:right;margin-left:10px;margin-right:10px" src="${pageContext.request.contextPath}/images/sys/icon_logout.png" /></span>
			</a>
			
			<!-- photo在index页定义 -->
				<span><img alt="image"  style="height:35px;width:35px;margin-top:10px;float:right;" src="<%=photo %>" /></span> 
				
			</div>
			<div
				style="width: 100%; height: 45%; float: left; padding-top: 10px; padding-right: 20px;">
				<span id="localtime"
					style="font-size: 18px; font-family: 微软雅黑; color:white; vertical-align: middle; float: right;">00:00:00</span>
				<span
					style="font-size: 18px; font-family: 微软雅黑; color:white; vertical-align: middle; float: right;">当前时间&nbsp;&nbsp;</span>
			</div>
		</div>
	</div>

</body>
</html>