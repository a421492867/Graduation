<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@page import="com.ofo.modules.sys.entity.User" %>
<% HttpSession httpSession = request.getSession(); %>
<% String photo = ((User)httpSession.getAttribute("user")).getPhoto(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>

<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctxStatic}/awesome/4.4/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctxStatic}/sidebar-menu/sidebar-menu.css" />
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/sidebar-menu/sidebar-menu.js"></script>
<script type="text/javascript" src="${ctx}js/modules/sys/index.js"></script>
<style type="text/css">
#mainContent{
	height : 100%
}
.main-sidebar{
	position: fixed;
	top: 0;
	left: 0;
	height: 100%;
	min-height: 100%;
	width: 230px;
	z-index: 810;
	background-color: #222d32;
 }
</style>
</head>
<body style="height:100%">

	<!-- 顶部导航栏开始 -->
	<%@ include file="/webpage/modules/sys/top.jsp"%>
	<!-- 顶部导航栏结束 -->

	
	<!-- 中间部分开始 -->
	<aside class="main-sidebar" style="margin-top:100px">
		<section  class="sidebar">
			<ul class="sidebar-menu">
				<c:forEach items="${menu}" var="menu">
				<!-- 先判断menu的children是否为空 ，若不为空，则加上class：treeview -->
				<c:if test="${not empty menu.children }">
					<li class="treeview">
						<a href="#">
							<i class="${menu.icon}"></i>
								<span>${menu.name}</span>
							<i class="fa fa-angle-right pull-right"></i>
						</a>
						
						<ul class="treeview-menu">
							<c:forEach items="${menu.children}" var="children">
								<li>
									<a class="J_menuItem" href="${children.href}">
										<i class="fa fa-circle-o"></i>
										${children.name}
									</a>
								</li>
							</c:forEach>
						</ul>
					</li>
				</c:if>
				
				<c:if test="${empty menu.children }">
					<li>
						<a class="J_menuItem" href="${menu.href}">
							<i class="${menu.icon}"></i>
							<span>${menu.name}</span>
						</a>
					</li>
				</c:if>
				
				
				</c:forEach>
					
			</ul>
		  </section>
	</aside>
		<!-- 右侧部分 -->
		<div id="mainContent">
			<iframe id="J_iframe" src="webpage/modules/sys/homePage.jsp" style="width:100%;height:100%;padding-top:100px;padding-left:230px" frameborder="0" seamless></iframe>
		</div>
	
	
	
	<!-- 中间部分结束 -->
	
	<!-- 底部开始 -->
	<%-- <%@ include file="/webpage/modules/sys/footer.jsp"%> --%>
	<!-- 底部结束 -->

</body>

<script>
$.sidebarMenu($('.sidebar-menu'))
</script>
</html>