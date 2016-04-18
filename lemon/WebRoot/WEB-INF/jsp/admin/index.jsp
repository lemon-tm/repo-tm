<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片管理页面</title>
    
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
function iFrameHeight() {   
	var ifm= document.getElementById("frame");   
	
	var subWeb = document.frames ? document.frames["frame"].document : ifm.contentDocument;   
	
	if(ifm != null && subWeb != null) {
	
	   ifm.height = subWeb.body.scrollHeight;
	
	   ifm.width = subWeb.body.scrollWidth;
	
	}   

}
</script>
<body>
	<div>欢迎：${user.username}</div>
	<div>
		<div><a href="${base}/ucenter/imglist.do" target="frame">图片管理</a></div>
		<div><iframe name="frame" class="frame" id="frame" scrolling="no" frameborder="0" width="100%" onLoad="javascript:iFrameHeight();" ></iframe></div>
	</div>
</body>

</html>
