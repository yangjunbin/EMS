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
  <%@include file="main_nav.jsp"%>

  <!--内容-->
  <div class="container nms">
    <div class="content">
      <form class="form-horizontal" action="UserMsgServlet" method="post">
        <fieldset>
          <legend>新增联系人</legend>
          <div class="control-group">
            <label class="control-label" for="inputEmail">姓名</label>
            <div class="controls">
              <input type="text" id="inputName" name="name" value="" placeholder="输入联系人名称">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputTel">手机号码</label>
            <div class="controls">
              <input type="text" id="inputTel" name="phoneNum" placeholder="输入联系人电话号码" value="">
            </div>
          </div>
          <div class="control-group">
            <div class="controls">
              <input type="hidden" value="add" id="type" name="type"/>
              <button type="submit" class="btn">更新</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>
