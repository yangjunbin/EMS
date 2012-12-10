<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emsSend.jsp' starting page</title>
    
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
    	<table style="text-align: left; width: 100%;" border="1">
		<tr>
			<td>id</td>
			<td>phoneNumber</td>
			<td>status</td>
			<td>recordTime</td>
			<td>sendTime</td>
			<td>sendText</td>
		</tr>
		<c:forEach var="emsSend" items="${emsSends}">
			<tr>
				<td>${emsSend.id}</td>
				<td>${emsSend.phoneNumber}</td>
				<td>${emsSend.status}</td>
				<td>${emsSend.recordTime}</td>
				<td>${emsSend.sendTime}</td>
				<td>${emsSend.sendText}</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
