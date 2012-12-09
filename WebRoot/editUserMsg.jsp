<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  #content { width:640px; height:10em; }
  </style>
</head>
<body>
  <!--导航-->
  <div class="navbar">
    <div class="navbar-inner container">
      <a class="brand" href="#">网信平台</a>
      <ul class="nav">
        <li><a href="#">首页</a></li>
        <li><a href="#">网信管理</a></li>
        <li><a href="#">模板</a></li>
        <li class="active"><a href="#">联系人</a></li>
        <li><a href="#">管理员</a></li>
      </ul>
    </div>
  </div>

  <!--内容-->
  <div class="container nms">
    <div class="content">
      <form class="form-horizontal">
        <fieldset>
          <legend>更新联系人</legend>
          <div class="control-group">
            <label class="control-label" for="inputEmail">姓名</label>
            <div class="controls">
              <input type="text" id="inputName" value="#{param.username}" placeholder="输入联系人名称">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputTel">手机号码</label>
            <div class="controls">
              <input type="text" id="inputTel" placeholder="输入联系人电话号码" value="${param.tel}">
            </div>
          </div>
          <div class="control-group">
            <div class="controls">
              <input type="hidden" value="edit" id="type" name="type"/>
              <input type="hidden" value="${param.id}" id="id" name="id"/>
              <button type="submit" class="btn">更新</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>
