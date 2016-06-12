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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<jsp:include  page="./common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>

	<link rel="shortcut icon" href="${base}/image/favicon.ico">
<style type="text/css">
ul.homeimg{overflow:hidden; }
ul.homeimg li{float:left; width:100px; height:100px; border:solid 1px red;}
</style> 
</head>

<script type="text/javascript">
$(function(){
	$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
});

</script>


<body>
<jsp:include  page="./common/head.jsp"/>

<div class="clear" style="height:8px;"></div>
<div class="container">
	<ul>
		<li>要么读书，要么旅行，身体和心灵总有一个要在路上</li>
	</ul>
	<ul class="homeimg">
		<c:forEach items="${imgcategoryary}" var="category">
		<li>
			<a href="${base}/photograph.jspx?category=${category.value}">${category.label}</a>
		</li>
		</c:forEach>
	</ul>
	
	<div class="clear"></div>
</div>

<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
