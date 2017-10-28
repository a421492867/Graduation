<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${ctx}css/modules/sys/login.css" />
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
 <script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}js/modules/sys/login.js"></script>
</head>
<body>
	<input type="hidden" id="error" value="${error}"/>

	 <div id="login">  
        <h1>Login</h1>  
        <form id="loginForm" action="${pageContext.request.contextPath }/login" method="post">  
            <input type="text" required="required" placeholder="用户名" name="userName"></input> 
            <input type="password" required="required" placeholder="密码" name="password"></input>  
              <button class="but" id="submit" type="submit">登录</button>
        </form> 
        
         
    </div> 
    
   
    
    

</body>
</html>