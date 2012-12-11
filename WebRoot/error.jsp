<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  #content { width:640px; height:10em; }
  .title { font-size:18px; }
  #download { border-bottom:1px solid #efefef; padding-bottom:10px; margin-bottom:20px; }
  </style>
</head>
<body>
  <%@include file="main_nav.jsp"%>

  <!--内容-->
  <div class="container nms">
    <div class="content">
    ${errorMsg}<br>
  </body>
</html>
