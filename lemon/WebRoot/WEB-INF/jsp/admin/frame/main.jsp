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
</head>
<frameset cols="210,*" frameborder="0" border="0" framespacing="0">
	<frame src="${base }/admin/left.do" name="leftFrame" noresize="noresize" id="leftFrame" />
	<frame src="${base }/admin/right.do" name="rightFrame" id="rightFrame"/>
</frameset>
<noframes><body></body></noframes>
</html>
  
