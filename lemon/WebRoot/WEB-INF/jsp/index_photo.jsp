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
    
    <title>${webtitle}</title>
    <meta name="keywords" content="${webkeywords}" />
	<meta name="description" content="${webdescription}" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	
	<jsp:include  page="./common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>


</head>

<script type="text/javascript">
//$(function(){
//$(document).ready(function(){
window.onload=function(){
	$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
	
	setTimeout(function(){
		//var height = $(document).height();
		//height = height-60-30-30-60-50-16-5;
		var h = $(".imgbox").height() ;
		$(".container").css("height",h) ;
	}, 0);
}
//);
function showimg(imgId,index){
	var keywords = $("#keywords").val() ;
	//window.location.href="${base}/imgshow.jspx?imgId="+imgId+"&keywords="+encodeURIComponent(keywords)+"&category=${category}" ;
	window.location.href="${base}/photograph.jspx?index="+index+"&imgId="+imgId+"&keywords="+encodeURIComponent(keywords)+"&category=${category}" ;
}

</script>



<body>
<jsp:include  page="./common/head.jsp"/>

<div class="clear" style="height:8px;"></div>
<div class="container">
	<ul class="imgbox">
		<c:forEach items="${pager.result}" var="img"  varStatus="s">
			<c:forEach items="${img.imgurlb}" var="a" varStatus="status">
				<li>
					<a href="javascript:void(0);" onclick="showimg('${img.id}','${s.index }')"><img height="200" src='${base}${a.thumbnailImagePath}' alt="${img.name }" /></a>
				</li>
			</c:forEach>
		</c:forEach>
	</ul>
	<jsp:include  page="./common/pager.jsp"/>
	<div class="clear"></div>
</div>
<script type="text/javascript" src="${base}/js/jquery.row-grid.js" charset="UTF-8"></script>

<jsp:include  page="./common/footer.jsp"/>

</body>
</html>
