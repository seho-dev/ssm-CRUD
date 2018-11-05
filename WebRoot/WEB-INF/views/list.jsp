<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>list</title>

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
	<a href="user/addready">添加用户</a>
	<table>
	 <thead>
	   <tr>
		 <th>id</th>
		 <th>用户</th>
		 <th>密码</th>
		 <th>详情</th>
		 <th>操作</th>
		</tr>
	 </thead>
	 <tbody>
	  <c:forEach items="${requestScope.allList}" var="list">
	 	<tr>
	 	    <c:if test="${requestScope.allList==''}">
	 	    	<td>暂无记录</td>
	 	    </c:if>
	 		<td>${list.id}</td>
	 		<td>${list.username}</td>
	 		<td>${list.password}</td>
	 		<td>${list.account}</td>
	 		<td><a href="deleteById?id=${list.id}">删除</a></td>
	 		<td><a href="updateById?id=${list.id}">修改</a></td>
	 	</tr>
	 	</c:forEach>
	 </tbody>
	</table>
	<a href="user/all/1">首页</a>
	<c:if test="${index != 1}">
		<a href="user/all/${index-1}">上一页</a>
	</c:if>
	<c:if test="${index != lastnum}">
		<a href="user/all/${index+1}">下一页</a>
	</c:if>
		<a href="user/all/${lastnum}">末页</a>
	
	
</body>
</html>
