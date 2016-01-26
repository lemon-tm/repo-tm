<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include  page="./common/common.jsp"/>
	
</head>
<script type="text/javascript">
	var mark = true ;
	var msg = "" ;
	$(function () {
		$("#password2").blur(function(){
			var password=$("#password").val() ;
			var password2=$("#password2").val() ;
			if(password==password2){
				mark=true ;
			}else{
				mark=false ;
				msg="密码不一致" ;
			}
		});
	
	});
	
	function dosubmit(){
		var username=$("#username").val() ;
		var password=$("#password").val() ;
		var password2=$("#password2").val() ;
		
		if(username){
		
		}else{
			alert("用户名不能为空");
			return ;
		}
		
		if(password){
		
		}else{
			alert("密码不能为空") ;
			return ;
		}
		
		if(password==password2){
			mark=true ;
		}else{
			mark=false ;
			msg="密码不一致" ;
		}
		
		if(mark){
			login.submit() ;
		}else{
			alert(msg) ;
			return ;
		}
	}
	
</script>

<body>
<jsp:include  page="./common/head.jsp"/>
<div class="container">
	<div class="container-in">
		<form name="login" action="${base}/register.jspx" method="post">
			<table>
				<tr>
					<td align="right">注册账户</td>
					<td></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5">*</span>账户名称</td>
					<td><input id="username" name="username" type="text" value="" /><span id="unmsg"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5">*</span>账户密码</td>
					<td><input id="password" name="password" type="password" value="" /><span id="pwmsg"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5">*</span>重复密码</td>
					<td><input id="password2" name="password2" type="password" value=""  /><span id="pwmsga"></span></td>
				</tr>
				<tr>
					<td align="right">手机</td>
					<td><input id="cellPhone" name="cellPhone" type="text" value="" /><span id="unmsg"></span></td>
				</tr>
				<tr>
					<td align="right">微信</td>
					<td><input id="weixin" name="weixin" type="text" value="" /><span id="unmsg" class="red">用于线下交易，请务必填写真实账号</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="javascript:void(0);" onclick="javascript:dosubmit();" class="btn" >注册账户</a></td>
				</tr>
			</table>
	    	
		</form>
	</div>
</div>
<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
