<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  	String token = UUID.randomUUID().toString();//生成唯一的令牌
  	request.getSession().setAttribute("token", token);
  	
  	%>
    <form action="${pageContext.request.contextPath}/servlet/ServletDemo1" method="post">
    	<input name="name"/>
    	<input type="hidden" name="token" value="<%=token%>"/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
