<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <script src="javascripts/jquery.min.js"></script>
  <script src="javascripts/bootstrap.min.js"></script>
  <style>
  .container .inner { width:940px; }
  .title { position:relative; }
  .title h2 { font-size:20px; font-weight:normal; border-bottom:1px solid #efefef; margin-bottom:15px; }
  .title .action { position:absolute; right:0; top:5px; }
  .table .action { width:60px; }
  .table td.index { width:2.5em; text-align:right; padding-right:10px; }
  .table th.index { text-align:center; }
  .dropdown-menu { min-width:80px; }
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
        <li><a href="#">统计</a></li>
        <li><a href="#">管理员</a></li>
      </ul>
    </div>
  </div>

  <!--内容-->
  <!--DownloadTemplate?filename=userMsgs.xlsx-->
  <div class="container nms">
    <div class="title">
      <h2>联系人分组</h2>
      <a class="action btn btn-primary" href="#">创建新分组</a>
    </div>
    <div class="content">
      <table class="table table-bordered table-striped">
        <thead>
          <tr>
            <th class="index">序号</th>
            <th>联系人组名</th>
            <th class="action">操作</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="userGroup" items="${userGroups}">
            <tr>
              <td>${userGroup.name}</td>
              <td>
                <div class="btn-group pull-right">
                  <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    动作
                    <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="UserMsgServlet?type=query&groupId=${userGroup.id}">查看</a></li>
                    <li><a href="UserMsgServlet?type=del&groupId=${userGroup.id}&type=del">删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <!--分页-->
      <div class="pagination">
        <ul>
          <li class="disabled"><span>上一页</span></li>
          <li class="active"><span>1</span></li>
          <li><a href="#"><span>2</span></a></li>
          <li><a href="#"><span>3</span></a></li>
          <li><a href="#"><span>4</span></a></li>
          <li><span>下一页</span></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
