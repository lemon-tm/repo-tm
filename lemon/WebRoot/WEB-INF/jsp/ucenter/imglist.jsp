<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>我的图片列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./../common/common.jsp" %>
  </head>
<script type="text/javascript">
/* $(function(){
	$(".container").rowGrid({itemSelector: ".container ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
}); */
$(function(){
	$(".scrollTop").click(function(){
		parent.scrollTop(); //调用父窗口中的scrollTop函数
		//$('.container', parent.document).animate({scrollTop:0}, 'slow');
		//$(window.parent.document.body).animate({scrollTop:0}, 'slow');
	});
});
</script>
<body>

<jsp:include  page="./../common/pager.jsp"/>
<!-- <div>上传图片|批量删除|批量设置</div> -->
	<div class="container">
		<div class="ucontainer-in">
			<c:forEach items="${pager.result}" var="img">
			<ul class="myimg" >
				<li><span>图片类型：</span>${img.category.label}</li>
				<li style="overflow:hidden;">
					<div class="fl"><span>图片名称：</span>${img.name}</div>
					<div class="fr">
						<a href="${base}/ucenter/deleteImg.jspx?imgId=${img.id}" onclick="return confirm('确定删除吗？');">删除</a>
					</div>
				</li>
				
				<li><span>图片描述：</span>${img.describes}</li>
				<li><span>上传时间：</span>${img.createTime}</li>
				<li>
				<c:forEach items="${img.imglist}" var="l" varStatus="status">
					<c:forEach items="${l.imgurlb}" var="a" >
						<a href="${base}/ucenter/uimgshow.jspx?imgId=${img.id}&index=${status.index}" class="scrollTop">
							<img style="height:150px;" src='${base}${a.bigImagePath}' alt="${img.name}" />
						</a>
					</c:forEach>
				</c:forEach>
				</li>
					
			</ul>
			</c:forEach>
		</div>
	</div>

</body>
</html>
