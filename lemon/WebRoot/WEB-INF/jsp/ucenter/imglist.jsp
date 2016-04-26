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

<jsp:include  page="./../common/pager.jsp"/>
<!-- <div>上传图片|批量删除|批量设置</div> -->
	<div class="container">
		<div class="ucontainer-in">
			<c:forEach items="${pager.result}" var="img">
			<ul class="myimg" >
					<li><span>审核状态：</span>${img.isverify.label}</li>
					<li><span>上传时间：</span>${img.createTime}</li>
					<li><span>图片名称：</span>${img.name}</li>
					<li><span>图片描述：</span>${img.describe}</li>
					<li>
					<c:forEach items="${img.imgurlb}" var="a" varStatus="status">
						<a href="${base}/ucenter/uimgshow.jspx?imgId=${img.id}&index=${status.index}"><img style="height:150px;" src='${base}${a.bigImagePath}' alt="${img.name}" /></a>
					</c:forEach>
					</li>
					
			</ul>
			</c:forEach>
		</div>
	</div>

</body>
</html>
