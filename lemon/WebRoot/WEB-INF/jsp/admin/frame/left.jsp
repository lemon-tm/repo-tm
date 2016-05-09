<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>admin-left</title>

<%@include file="../acommon.jsp" %>
</head>
<body>
	<ul class="left-m">
		<li><a href="${base}/ucenter/imglist.do" target="rightFrame">图片管理</a></li>
		<li><a href="${base}/ucenter/userlist.do" target="rightFrame">用户管理</a></li>
	</ul>
</body>
</html>