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
    
    <title>登录界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./common/common.jsp" %>
	
</head>
<script type="text/javascript">
	function dosubmit(){
		var username=$("#username").val() ;
		var password=$("#password").val() ;
		var message =false ;
		
		$.ajax({
			url:"<%=basePath%>login.jspx",
			async: false,
			//data:$("login").serialize(),
			type:"post",
			dataType:"json",
			data: {username:username, password:password, now:new Date()},
			success: function (data) {
				message = eval(data.message);
				
			}
		});
		
		if(message){
			login.submit() ;
		}else{
			window.location.href="${base}/to_register.jspx" ;
		}
	}
	
</script>
<body>
<%@include file="./common/head.jsp" %>

<div class="container">
	<div class="container-in">
		<form name="login" action="<%=basePath%>home.jspx" method="post">
			<table>
				<tr>
					<td align="right">登录账户</td>
					<td></td>
				</tr>
				<tr>
					<td>账户名称</td>
					<td><input id="username" name="username" type="text" value="" /></td>
				</tr>
				<tr>
					<td>账户密码</td>
					<td><input id="password" name="password" type="password" value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="javascript:void(0);" onclick="javascript:dosubmit();" class="btn" >登录账户</a>
					</td>
				</tr>
			</table>	
		</form>
		
	</div>
</div>

<%@include file="./common/footer.jsp" %>
</body>
</html>
