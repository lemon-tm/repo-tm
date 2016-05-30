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
    
    <title>红色柠檬-我的随拍图片网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="keywords" content="照片，图片，旅游照，照起来，ps图片，原创图片，保存照片，上传照片，免费保存图片" />
	<meta name="description" content="红色柠檬网，不一样的柠檬，用于各类用户存储在旅游或外出时随手拍出的图片，或自己创作的图画保存。" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	
	<jsp:include  page="./common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>

	<link rel="shortcut icon" href="${base}/image/favicon.ico">
 
</head>

<script type="text/javascript">
$(function(){
	$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
});
function showimg(imgId){
	var keywords = $("#keywords").val() ;
	window.location.href="${base}/imgshow.jspx?imgId="+imgId+"&keywords="+keywords ;
}

</script>



<body>
<jsp:include  page="./common/head.jsp"/>
<jsp:include  page="./common/pager.jsp"/>
<div class="clear" style="height:8px;"></div>
<div class="container">
	<ul class="imgbox">
		<c:forEach items="${pager.result}" var="img">
			<c:forEach items="${img.imgurlb}" var="a" varStatus="status">
				<li>
					<a href="javascript:void(0);" onclick="showimg('${img.id}')"><img height="200" src='${base}${a.thumbnailImagePath}' /></a>
				</li>
			</c:forEach>
		</c:forEach>
	</ul>
	
	<div class="clear"></div>
</div>

<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
