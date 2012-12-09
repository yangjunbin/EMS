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
  .choose_template { overflow:hidden; }
  .choose_template li { float:left; list-style:none; width:200px; margin:0 10px; }
  .preview { width:200px; height:240px; border:1px solid #e2e2e2; background:#efefef; }
  .template_name, .action { text-align:center; }
  #step-two { margin:10px 0 30px; overflow:hidden; }
  #step-two .control-group { margin:20px 0; }
  </style>
</head>
<body>
  <!--导航-->
  <div class="navbar">
    <div class="navbar-inner container">
      <a class="brand" href="#">网信平台</a>
      <ul class="nav">
        <li><a href="#">首页</a></li>
        <li class="active"><a href="#">网信管理</a></li>
        <li><a href="#">模板</a></li>
        <li><a href="#">联系人</a></li>
        <li><a href="#">管理员</a></li>
      </ul>
    </div>
  </div>

  <div class="container">
    <form action="" method="post">
      <fieldset id="step-two">
        <legend>创建普通模板</legend>
        <div class="control-group">
          <label class="control-label" for="inputEmail">名称</label>
          <div class="controls">
            <input type="text" id="inputName" placeholder="输入模板名称">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="inputEmail">上传头图</label>
          <div class="controls">
            <input type="file" id="inputName">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="content">专题介绍</label>
          <div class="controls">
            <textarea id="content" name="desc"></textarea>
          </div>
        </div>
        <div class="control-group">
          <div class="controls">
            <button type="submit" class="btn btn-primary">创建</button>
          </div>
        </div>
      </fieldset>
    </form>
  </div>
</body>
</html>
