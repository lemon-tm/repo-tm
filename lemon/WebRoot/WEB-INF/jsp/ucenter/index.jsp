<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户中心</title>
    
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
	$(function(){
		$(".container-l").find("dt").click(function(){
			$(this).parent().siblings().removeAttr("class");
			$(this).parent().attr("class","open") ;
		});
		$(".container-l").find("dd").click(function(){
			$(this).siblings().removeAttr("class");
			$(this).attr("class","click") ;
		});
	});
	
	
	
	
  

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
	<%@include file="./../common/head.jsp" %>
	<div class="container">
		<div class="container-in">
			<div class="container-l">
				<dl>
					<dt>上传图片</dt>
					<dd><a href="${base}/ucenter/upload.jspx" target="frame">上传图片</a></dd>
					<dd><a href="${base}/ucenter/imglist.jspx" target="frame">我的图片</a></dd>
				</dl>
				<dl>
					<dt>设置</dt>
					<dd><a href="" target="frame">基本设置</a></dd>
					<dd><a href="" target="frame">安全设置</a></dd>
					<dd><a href="" target="frame">退出账户</a></dd>
				</dl>
			</div>
			<div class="container-r">
				<iframe name="frame" class="frame" id="frame" scrolling="no" frameborder="0" onLoad="javascript:iFrameHeight();" ></iframe>
			</div>
			
			<div class="clear"></div>
		</div>
	</div>
	<%@include file="./../common/footer.jsp" %>
</body>
</html>
