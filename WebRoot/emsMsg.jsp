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
			<td>短信</td>
			<td>联系人</td>
			<td>模板</td>
			<td>状态</td>
			<td>创建时间</td>
			<td colspan="3">操作</td>
		</tr>
		<c:forEach var="emsMsg" items="${emsMsgs}">
			<tr>
				<td>${emsMsg.id}</td>
				<td>${emsMsg.msg}</td>
				<td>${emsMsg.uname}(${emsMsg.uid})</td>
				<td>${emsMsg.tname}(${emsMsg.tid})</td>
				<td>${emsMsg.status}</td>
				<td>${emsMsg.createTime}</td>
				<td><a href="addEmsMsg.jsp">新增</a></td>
				<td><a href="editEmsMsg.jsp?id=${emsMsg.id}&msg=${emsMsg.msg}&uid=${emsMsg.uid}&uname=${emsMsg.uname}&tname=${emsMsg.tname}&tid=${emsMsg.tid}">修改</a></td>
				<td><a href="EmsMsgServlet?type=del&id=${emsMsg.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
