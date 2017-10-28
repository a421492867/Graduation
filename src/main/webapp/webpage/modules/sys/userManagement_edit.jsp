<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctxStatic}/awesome/4.4/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.3.0/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctx}js/modules/sys/userManagement_edit.js"></script>
<style type="text/css">
	.add-form{
	    padding: 20px;
	}
</style>
</head>
<body>

	<div id="content" class="container">
		<form id="editUser" class="form-horizontal add-form">
		<input type="text"  class="form-control" style="display:none;" name="id"  value="${user.id}"/>
		<input id="thisRole" type="text"  class="form-control" style="display:none;" value="${user.roleId}"/>
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">用户名</span>
				<input type="text" class="form-control" value="${user.userName}" name="userName" readonly>
				<span class="input-group-addon" id="check"></span>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">昵称</span>
				<input type="text" class="form-control" value="${user.nickName}" name="nickName">
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">角色</span>
				<select id="role" class="form-control" name="roleId">
				<c:forEach items="${roleList}" var="roleList">
					<option value="${roleList.id}">${roleList.roleName}</option>
				</c:forEach>
				</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">所在位置</span>
				<input type="text" class="form-control" value="${user.userLocation}" name="userLocation">
				</div>
			</div>
			
			
			
		</form>
	
	</div>

</body>
</html>