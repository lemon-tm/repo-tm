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
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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
			<div class="cur_img" style="height:500px;overflow:hidden;">
				<div class="showimg-all">
					<div class="showimg-l">
					
						<c:forEach items="${img.imglist}" var="l" varStatus="status">
							<c:forEach items="${l.imgurlb}" var="a">
								<c:if test="${status.index==index}">
									<img style="max-height:500px; width:400px;" src='${base}${a.bigImagePath}' alt="${img.name}" />
									<input id="state" type="hidden" value="${l.isverify.label}"/>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
					<div class="showimg-r ml20 lh30">
						<div>审核状态：<span id="stateshow"></span></div>
						<div>名称：${img.name}</div>
						<div>描述：${img.describes}</div>
						<div>作者名称：${img.user.trueName}</div>
						<div>作者微信：${img.user.weixin}</div>
					</div>
				</div>
				
			</div>
			<div class="box_img pr">
				<a href="javascript:void(0);" class="prev pa"></a>
				<a href="javascript:void(0);" class="next pa"></a>
				<ul class="pa" style="height:171px; overflow:hidden;">
					<c:forEach items="${img.imglist}" var="l" varStatus="status">
						<c:forEach items="${l.imgurlb}" var="a">
						<input class="state" type="hidden" value="${l.isverify.label}"/>
						<c:choose>
							<c:when test="${status.index==index }">
								<li class="current">
									<img height="160" src='${base}${a.bigImagePath}' alt="" />
									<input class="state" type="hidden" value="${l.isverify.label}"/>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<img height="160" src='${base}${a.bigImagePath}' alt="" />
									<input class="state" type="hidden" value="${l.isverify.label}"/>
								</li>
							</c:otherwise>
						</c:choose>
						</c:forEach>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

</body>
</html>
