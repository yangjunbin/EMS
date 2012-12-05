<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(!"success".equals(request.getSession().getAttribute("status")))
{
	request.setAttribute("errorMsg", "请先登陆");
	request.getRequestDispatcher("/error.jsp").forward(request, response);
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <a href="UserGroupServlet?type=query">联系人</a><br>
    <a href="LoginUserServlet?type=query">用户</a><br>
    <a href="EmsSendServlet?type=query">发送信息</a><br>
    <a href="EmsMsgServlet?type=query">网信信息</a><br>
    <a href="QuestionBankServlet?type=query">题库</a>
  </body>
</html>
