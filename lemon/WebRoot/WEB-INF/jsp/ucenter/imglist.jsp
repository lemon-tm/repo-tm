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
</script>
<body>
<!-- <div>上传图片|批量删除|批量设置</div> -->
	<div class="container">
		<div class="ucontainer-in">
		<ul class="myimg">
			<c:forEach items="${page.result}" var="img">
				<li>${img.createTime}</li>
				<li>${img.name}</li>
				<li>${img.describe}</li>
				<li>
				<c:forEach items="${img.imgurlb}" var="a">
					<img style="height:150px;" src='${base}${a.bigImagePath}' />
				</c:forEach>
				</li>
				
			</c:forEach>
		</ul>
		</div>
	</div>

</body>
</html>
