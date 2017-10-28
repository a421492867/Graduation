<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@ attribute name="url" type="java.lang.String" required="true"%>
<%@ attribute name="editUrl" type="java.lang.String" required="false"%>
<%@ attribute name="gridId" type="java.lang.String" required="false"%>
<%@ attribute name="pagerId" type="java.lang.String" required="false"%>
<%@ attribute name="loadui" type="java.lang.String" required="false"%>
<!-- colNames 将所有的列名用逗号拼接成一个字符串 -->
<%@ attribute name="colNames" type="java.lang.String" required="true"%>
<!-- colModel 将所有字段设置用分号拼接成一个字符串 -->
<%@ attribute name="colModel" type="java.lang.String" required="true"%>
<%@ attribute name="multiselect" type="java.lang.Boolean" required="false"%>
<%@ attribute name="extendFun" type="java.lang.String" required="false"%>
<table id="${not empty gridId ? gridId : 'grid-table'}"></table>
<div id="${not empty pagerId ? pagerId : 'grid-pager'}"></div>
<script type="text/javascript">
jQuery(function($){
	initJqgridForTag('${gridId}','${pagerId}','${colNames}','${colModel}','${multiselect}','${url}','${editUrl}','${not empty loadui?loadui:"disable"}','${extendFun}');
});
</script>