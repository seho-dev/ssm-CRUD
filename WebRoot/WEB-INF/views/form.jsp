<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
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
  	  <c:if test="${itemForm != null}">
      	<form action="user/addUser" method="post">
      </c:if>
      <c:if test="${itemForm == null}">
      	<form action="update" method="post">
      </c:if>
      	 <input type="hidden" name="id" value="${userlist.id}">
      	  用户名:<input type="text" name="username" value="${userlist.username}">
      	  <br>
      	  密码：<input type="password" name="password" value="${userlist.password}">
      	  <br>
      	 详情:<input type="text" name="account" value="${userlist.account}">
      	 <br>
      	 
      	 <c:if test="${itemForm != null}">
      	 	<input type="submit" value="添加">
      	 </c:if>
      	 
      	 <c:if test="${itemForm == null}">
      	 	<input type="submit" value="修改">
      	 </c:if>
      	 
      </form>
  </body>
</html>
