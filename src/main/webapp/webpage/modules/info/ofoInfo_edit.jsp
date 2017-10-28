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
<script type="text/javascript" src="${ctx}js/modules/info/ofoInfo_edit.js"></script>
<style type="text/css">
	.add-form{
	    padding: 20px;
	}
</style>
</head>
<body>

	<div id="content" class="container">
		<form id="editInfo" class="form-horizontal add-form">
		
		<input type="text"  class="form-control" style="display:none;" name="id"  value="${info.id}"  readonly>
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">车辆编号</span>
				<input type="text" class="form-control" value="${info.ofoCode}" onBlur="validate(this.value);" name="ofoCode" readonly>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">密码</span>
				<input type="text" class="form-control" value="${info.ofoPass}" name="ofoPass">
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">位置</span>
				<input type="text" class="form-control" value="${info.location}" name="location">
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">经度</span>
				<input type="text" class="form-control" value="${info.lng}" name="lng">
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
				<span class="input-group-addon">纬度</span>
				<input type="text" class="form-control" value="${info.lat}" name="lat">
				</div>
			</div>
			
			
			
		</form>
	
	</div>

</body>
</html>