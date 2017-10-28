<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="jqGrid" tagdir="/WEB-INF/tags/jqgrid" %>
<c:set var="ctx" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>