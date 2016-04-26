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
	<%@include file="./../common/common.jsp" %>
	<script type="text/javascript" src="${base}/js/img/scrollimg.js" charset="UTF-8"></script>
</head>
<script type="text/javascript">
	
</script>
<body>

<div class="container">
	
	<div class="article_content">
		
		<div class="article_img mt20">
			<div class="cur_img">
			<div class="showimg-all">
				<div class="showimg-l">
					<c:forEach items="${img.imgurlb}" var="a" varStatus="status">
						<c:if test="${status.index<1}">
							<img height="500" src='${base}${a.bigImagePath}' alt="" />
						</c:if>
					</c:forEach>
				</div>
				<div class="showimg-r ml20 lh30">
					<div>名称：${img.name}</div>
					<div>描述：${img.describe}</div>
					<div>作者名称：${img.user.trueName}</div>
					<div>作者微信：${img.user.weixin}</div>
				</div>
			</div>
				
			</div>
			<div class="box_img pr">
				<a href="javascript:void(0);" class="prev pa"></a>
				<a href="javascript:void(0);" class="next pa"></a>
				<ul class="pa">
					<c:forEach items="${img.imgurlb}" var="a" varStatus="status">
					<c:choose>
						<c:when test="${status.index<1 }">
							<li class="current"><img height="160" src='${base}${a.bigImagePath}' alt="" /></li>
						</c:when>
						<c:otherwise>
							<li><img height="160" src='${base}${a.bigImagePath}' alt="" /></li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

</body>
</html>
