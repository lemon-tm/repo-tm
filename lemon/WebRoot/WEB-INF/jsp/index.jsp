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

ul.inbox{ width:830px; margin:150px auto; overflow:hidden; position:relative;  border:solid 1ps red;}
ul.inbox li{position:relative; width:160px; height:140px; float:left;padding-right:10px; }
ul.inbox li span{position:absolute; bottom:5px; left:5px;}

.homeimg {
    position: absolute;
    top: 180px;
    left: 0px;
    width: 860px;
    height: 310px;
    background: #fff;
    opacity: 0.1;
    filter: Alpha(opacity=10);
    zoom: 1;
    z-index: 9;
    overflow: hidden;
    _filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=noscale, src="/image/img_area_bg.png");
    _background: 0 0;
    _background: 0 0;
}

</style> 
</head>

<script type="text/javascript">
$(function(){
	//$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
});

</script>


<body>
<jsp:include  page="./common/head.jsp"/>

<div class="clear" style="height:8px;"></div>
<div class="container">
	<ul>
		<li>要么读书，要么旅行，身体和心灵总有一个要在路上</li>
	</ul>

	<ul class="inbox">
		<c:forEach items="${list}" var="imgmsg">
		<li>
			<a href="${base}/photograph.jspx?category=${imgmsg.category.value}">
				<c:forEach items="${imgmsg.imglist[0].imgurlb}" var="a" varStatus="status">
						<img width="160px" alt="${imgmsg.name}" src='${base}${a.thumbnailImagePath}' />
				</c:forEach>
				<span style="color:#fff;">${imgmsg.category.label}</span>
			</a>
		</li>
		</c:forEach>
	</ul>
	
	<div class="clear"></div>
</div>

<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
