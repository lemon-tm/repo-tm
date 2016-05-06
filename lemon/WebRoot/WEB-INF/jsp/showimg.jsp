<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>显示大图页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./common/common.jsp" %>
	
</head>
<script type="text/javascript">
	
</script>
<body>
<%@include file="./common/head.jsp" %>

<div class="container">
	<div class="showimg-all">
		<div class="showimg-l">
			<img src="${base}${img.imgurlb[index].bigImagePath}" />
		</div>
		<div class="showimg-r ml20 lh30">
			<div>名称：${img.name}</div>
			<div>描述：${img.describe}</div>
			<div>上传时间：<fmt:formatDate value="${img.createTime}" pattern="yyyy-MM-dd HH:mm"/></div>
			<div>作者名称：${img.user.trueName}</div>
			<div>作者微信：${img.user.weixin}</div>
		</div>
	</div>
	
</div>

<%@include file="./common/footer.jsp" %>
</body>
</html>
