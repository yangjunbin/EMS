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

  </head>
  
  <body>
  	<form action="EmsMsgServlet">
  		msg:<input type="text" id="msg" name="msg" value="${param.msg}"/><br>
  		uid:<input type="text" id="uid" name="uid" value="${param.uid}"/>(应该默认是当前登陆人)<br>
  		tid:<input type="text" id="tid" name="tid" value="${param.tid}"/>(应该是选择模板列表)<br>
  		<input type="hidden" value="edit" id="type" name="type"/>
  		<input type="hidden" value="${param.id }" id="id" name="id"/>
  		<input type="submit" value="submit"/>
  	</form>
  </body>
</html>
