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
<script src="javascripts/jquery.min.js"></script>
<script src="javascripts/bootstrap.min.js"></script>
<style>
.container .inner {
	width: 940px;
}

.title {
	position: relative;
}

.title h2 {
	font-size: 20px;
	font-weight: normal;
	border-bottom: 1px solid #efefef;
	margin-bottom: 15px;
}

.title .action {
	position: absolute;
	right: 0;
	top: 5px;
}

.table .action {
	width: 60px;
}

.table td.index {
	width: 2.5em;
	text-align: right;
	padding-right: 10px;
}

.table th.index {
	text-align: center;
}

.dropdown-menu {
	min-width: 80px;
}

.last_login_date {
	width: 100px;
}
</style>
</head>
<body>
	<%@include file="main_nav.jsp"%>

	<!--内容-->
	<div class="container nms">
		<div class="title">
			<h2>管理员列表</h2>
			<a class="action btn btn-primary" href="addLoginUser.jsp">创建新管理员</a>
		</div>
		<div class="content">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>用户名</th>
						<th>姓名</th>
						<th>性别</th>
						<th>状态</th>
						<th>注册时间</th>
						<th class="last_login_date">登陆时间</th>
						<th>错误登陆次数</th>
						<th class="action">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="loginUser" items="${loginUsers}">
						<tr>
							<td>${loginUser.user}</td>
							<td>${loginUser.name}</td>
							<c:if test="${loginUser.sex=='1'}">
								<td>男</td>
							</c:if>
							<c:if test="${loginUser.sex=='2'}">
								<td>女</td>
							</c:if>
							<c:if test="${loginUser.status=='1'}">
								<td>正常</td>
							</c:if>
							<c:if test="${loginUser.status=='2'}">
								<td>冻结</td>
							</c:if>
							<td>${loginUser.regTime}</td>
							<td>${loginUser.loginTime}</td>
							<td>${loginUser.errorCount}</td>
							<td>
								<div class="btn-group pull-right">
									<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
										动作 <span class="caret"></span> </a>
									<ul class="dropdown-menu" role="menu">
										<li><a
											href="editLoginUser.jsp?user=${loginUser.user}&name=${loginUser.name}&sex=${loginUser.sex}&pwd=${loginUser.pwd}&id=${loginUser.id}">修改</a>
										</li>
										<li><a
											href="LoginUserServlet?type=del&id=${loginUser.id}">删除</a>
										</li>
									</ul>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!--分页-->
			<div class="pagination">
				<ul>
					<li class="disabled"><span>上一页</span>
					</li>
					<li class="active"><span>1</span>
					</li>
					<li><a href="#"><span>2</span>
					</a>
					</li>
					<li><a href="#"><span>3</span>
					</a>
					</li>
					<li><a href="#"><span>4</span>
					</a>
					</li>
					<li><span>下一页</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

