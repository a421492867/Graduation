<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Base Info</title>
<link rel="stylesheet" href="${ctxStatic}/jqGrid/ui.jqgrid.css" />
<link rel="stylesheet" href="${ctxStatic}/jqGrid/jqGrid-ofo.css" />
<link rel="stylesheet" href="${ctxStatic}/awesome/4.4/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctxStatic}/common/animate.css" />
<link rel="stylesheet" href="${ctxStatic}/common/style.css" />
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/jqGrid-ofo.js"></script>
<script type="text/javascript" src="${ctxStatic}/jqGrid/i18n/grid.locale-en.js"></script>
<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}js/modules/message/user_message.js"></script>

</head>
<body style="background:#e6e6e8">

	
	<div class="row">
        <div class="col-sm-12">
            <div class="wrapper wrapper-content animated fadeInUp">
                <ul class="notes">
                	<c:forEach items="${messageList}" var="messageList">
	                     <li>
	                        <div>
	                            <small>${messageList.convertData}</small>
	                            <h4>${messageList.messageTitle}</h4>
	                            <p>${messageList.messageContent}</p>
	                            <p style="padding-left:60%">----&nbsp;By ${messageList.createBy}</p>
	                        </div>
	                    </li>
                    </c:forEach>
                </ul>
                
            </div>
        </div>
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