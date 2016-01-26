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
	
</script>
<body>

	<div class="container">
		<div class="ucontainer-in">
		<form>
			<div class="pb10">
				<span class="blue2 fl">照片名称：</span>
				<input class="fl" type="text" name="name" />
				</textarea>
				<div class="clear"></div>
			</div>
			<div>
				<span class="blue2 fl">照片描述：</span>
				<textarea name="describes" class="textareaf fl"></textarea>
				<div class="clear"></div>
			</div>
			<div style="text-align:center;">
				<input style="width:100px; margin-top:20px; font-size:14px;" class="bg-blue2" type="submit" value="保存">
			</div>
		</form>
		</div>
	</div>

</body>
</html>
