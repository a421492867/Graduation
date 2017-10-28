<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@ attribute name="name" type="java.lang.String" required="false"%>
<%@ attribute name="btnClass" type="java.lang.String" required="false"%>
<%@ attribute name="gridId" type="java.lang.String" required="false"%>
<%@ attribute name="getDataFun" type="java.lang.String" required="false"%>
<%@ attribute name="preFun" type="java.lang.String" required="false"%>
<%@ attribute name="saveUrl" type="java.lang.String" required="false"%>
<%@ attribute name="successFun" type="java.lang.String" required="false"%>
<%@ attribute name="failFun" type="java.lang.String" required="false"%>
<button  class='btn btn-danger' style="margin-left:20px" onclick="deleteRowOfJqgrid('${gridId}','${getDataFun}','${preFun}','${saveUrl}','${successFun}','${failFun}');"><i class="fa fa-minus"></i>    ${not empty name ? name : ''}</button>
