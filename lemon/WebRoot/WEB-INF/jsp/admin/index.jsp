<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>后台管理</title>
	<link rel="icon" href="${base}/image/rlemon.ico" type="image/x-icon">
</head>
<frameset rows="71,*" frameborder="0" border="0" framespacing="0">
	<frame src="../top.do" name="topFrame" noresize="noresize" id="leftFrame" />
	<frame src="../main.do" name="mainFrame" id="mainFrame" />
</frameset>
<noframes><body></body></noframes>
</html>
  
