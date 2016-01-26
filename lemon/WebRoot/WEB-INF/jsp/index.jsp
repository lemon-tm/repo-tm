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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	
	<jsp:include  page="./common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>
 
</head>

<script type="text/javascript">
$(document).ready(function(){
	//var height = $(document).height();
	//$(".container").css("min-height",height-30-60-30-60) ;
　　/* alert($(window).height()); //浏览器当前窗口可视区域高度
　　alert($(document).height()); //浏览器当前窗口文档的高度
　　alert($(document.body).height());//浏览器当前窗口文档body的高度
　　alert($(document.body).outerHeight(true));//浏览器当前窗口文档body的总高度 包括border padding margin

　　alert($(window).width()); //浏览器当前窗口可视区域宽度
　　alert($(document).width());//浏览器当前窗口文档对象宽度
　　alert($(document.body).width());//浏览器当前窗口文档body的宽度
　　alert($(document.body).outerWidth(true));//浏览器当前窗口文档body的总宽度 包括border padding margin */
})


$(function(){
	$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
});
</script>



<body>
<jsp:include  page="./common/head.jsp"/>
<div style="overflow:hidden;padding-top:20px;">
<jsp:include  page="./common/pager.jsp"/>
</div>
<div class="container">
	<ul class="imgbox">
		<c:forEach items="${pager.result}" var="img">
			<c:forEach items="${img.imgurlb}" var="a">
				<li><img src='${base}${a.sourceImagePath}' /></li>
			</c:forEach>
		</c:forEach>
	</ul>
	<div class="clear"></div>
</div>


<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
