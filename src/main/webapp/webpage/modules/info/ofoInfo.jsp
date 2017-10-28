<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>

<% String colNames = "Id,编号,密码,位置,操作"; 
String colModel = "{name:\"id\",width:80,resizable:false, sortable:false,hidden:true},{name:\"ofoCode\", editable:false,width:80,resizable:false, sortable:false},{name:\"ofoPass\", editable:false,width:80 ,resizable:false, sortable:false},{name:\"location\", editable:false,width:80 ,resizable:false, sortable:false},{name:\"operation\", editable:false,width:80 ,resizable:false, sortable:false}";
request.setAttribute("colNames", colNames);
request.setAttribute("colModel", colModel);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Base Info</title>
<link rel="stylesheet" href="${ctxStatic}/jqGrid/ui.jqgrid.css" />
<link rel="stylesheet" href="${ctxStatic}/jqGrid/jqGrid-ofo.css" />
<link rel="stylesheet" href="${ctxStatic}/awesome/4.4/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.3.0/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/jqGrid-ofo.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/i18n/grid.locale-en.js"></script>
<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
<!-- 高德地图API -->
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=b13d7bac875a4735b1b41ab984ec42c0"></script>

<script type="text/javascript" src="${ctx}js/modules/info/ofoInfo.js"></script>

</head>
<body style="background:#e6e6e8">

	<!-- <h3>This Is For Baseinfo!</h3> -->
		<div id="searchBox" style="padding-top:20px; padding-left:20px">
			<span style="font-size:15px;font-weight:600">
				所在位置:&nbsp;
			</span>
			<input id="location" type="text" style="height:34px">
			
			<button id="searchBtn" class="btn btn-primary" onclick="search();"><i class="fa fa-search"></i>   查询</button>
		
		</div>
	
	<div id="operationBox" style="padding-top:14px; padding-left:20px">
	  <button id="add" class="btn btn-primary" onclick="openAdd();"><i class="fa fa-plus"></i>    增加</button>
	  <jqGrid:deleteRow saveUrl="${basePath}info/delete" name="删除" successFun="refreshGrid"></jqGrid:deleteRow>
	</div>
	<div id="widget-body" style="padding-top:14px;">
	<jqGrid:initGrid url="${basePath}info/getData" colModel="${colModel}" colNames="${colNames}" extendFun="reform"></jqGrid:initGrid>
	</div>
	
	
	<div id="logo" style="position:fixed;bottom:40px;right:30px;transform:rotate(-30deg)">
		<h3 style="color:white">随时随地有车骑</h3>
		<h3 style="color:white">ANYTIME</h3>
		<h3 style="color:white">ANYWHERE</h3>
	</div>
	
	
	
	

</body>

<script type="text/javascript">
	var basePathPix = "<%=basePath%>"
</script>
</html>