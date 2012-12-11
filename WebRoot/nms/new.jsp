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
  <link rel="stylesheet" href="../stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  #content { width:640px; height:10em; }
  .choose_template { overflow:hidden; }
  .choose_template li { float:left; list-style:none; width:200px; margin:0 10px; }
  .preview { width:200px; height:240px; border:1px solid #e2e2e2; background:#efefef; }
  .template_name, .action { text-align:center; }
  #step-two { margin:10px 0 30px; overflow:hidden; }
  #step-two .control-group { margin:20px 0; text-align:center; }
  .form-horizontal #step-two .controls { margin:0; }
  #step-two ul { margin:0 auto; width:665px; }
  .preview-choosed { border-color:#f23; }
  </style>
</head>
<body>
  <%@include file="../main_nav.jsp"%>

  <!--内容-->
  <div class="container nms">
    <div class="content">
      <form class="form-horizontal" action="/EMS/EmsMsgServlet" method="post">
        <fieldset id="step-one">
          <legend>1. 创建短信</legend>
          <div class="control-group">
            <label class="control-label" for="name">名称</label>
            <div class="controls">
              <input type="text" id="name" name="name" placeholder="输入网信名称">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputPassword">短信内容</label>
            <div class="controls">
              <textarea id="content" name="msg"></textarea>
            </div>
          </div>
        </fieldset>

        <fieldset id="step-two">
          <legend>2. 选择模板类型</legend>
          <div class="choose_template">
            <ul>
              <li>
                <p class="preview"><img src=""></p>
                <p class="template_name">普通模板</p>
                <p class="template_desc"></p>
                <p class="action">
                  <a href="#" class="btn" data-type="4">使用</a>
                </p>
              </li>
              <li>
                <p class="preview"><img src=""></p>
                <p class="template_name">宣传模板</p>
                <p class="template_desc"></p>
                <p class="action">
                  <a href="#" class="btn" data-type="3">使用</a>
                </p>
              </li>
              <li>
                <p class="preview"><img src=""></p>
                <p class="template_name">问答模板</p>
                <p class="template_desc"></p>
                <p class="action">
                  <a href="#" class="btn" data-type="1">使用</a>
                </p>
              </li>
            </ul>
          </div>
          <div class="control-group">
            <div class="controls">
              <input type="hidden" name="tempType" id="tempType" value="" />
              <input type="hidden" name="type" id="type" value="add" />
              <button type="submit" class="btn btn-primary">去创建模板内容</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>

  <script src="../javascripts/jquery.min.js"></script>
  <script>
    $('.choose_template .btn').click(function() {
      var me = $(this);
      $("#tempType").val(me.data("type"));
      $('.preview-choosed').removeClass("preview-choosed");
      me.closest("li").find(".preview").addClass("preview-choosed");
      return false;
    });
  </script>
</body>
</html>
