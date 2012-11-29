<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addLoginUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function init()
		{
			
		}
	</script>
  </head>
  
  <body onload="init()">
  	<form action="LoginUserServlet">
  		user:<input type="text" id="user" name="user" value="${param.user}"/><br>
  		pwd:<input type="text" id="pwd" name="pwd" value="${param.pwd}"><br>
  		name:<input type="text" id="name" name="name" value="${param.name}"/><br>
  		sex:<input type="text" id="sex" name="sex" value="${param.sex}"/><br>
  		<input type="hidden" value="edit" id="type" name="type"/>
  		<input type="hidden" value="${param.id}" id="id" name="id"/>
  		<input type="submit" value="submit"/>
  	</form>
  </body>
</html>
