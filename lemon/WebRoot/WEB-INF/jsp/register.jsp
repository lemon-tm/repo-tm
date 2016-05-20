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



var sign = true ;
function checkusername(username){
	$.ajax({
          type:"POST",
          async : false,
          //url:"${base}/weplatform/saveproduct.jspx",
          url:"${base}/checkUser.jspx",
          data : {username:username,date:new Date()},
          datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
          beforeSend:function(){
          },
          success:function(data){
	         	data = eval(data);
		    	sign = data ;
          },
          complete: function(XMLHttpRequest, textStatus){
          },
          error: function(){
          }         
       }); 
	return sign ;
}

	function dosubmit(){
		var username=$("#username").val() ;
		var password=$("#password").val() ;
		var password2=$("#password2").val() ;
		var email = $("#email").val() ;
		
		if(username){
			if(username.length<6){
				alert("请使用大于等于6位的用户名！") ;
				return ;
			}else{
				checkusername(username) ;
				if(sign){
					alert("用户名已存在！") ;
					return ;
				}
			}
		}else{
			alert("用户名不能为空！");
			return ;
		}
		
		if(password){
			if(password.length<6){
				alert("请使用大于等于6位的密码！") ;
				return ;
			}
		}else{
			alert("密码不能为空！") ;
			return ;
		}
		
		if(email){
			var re =/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!re.test(email)){
				alert("邮箱格式不正确，请填写近期使用的邮箱！");
				return;
			}
		}else{
			alert("邮箱不能为空，请填写近期使用的邮箱！") ;
			return ;
		}
		if(password==password2){
			mark=true ;
		}else{
			mark=false ;
			msg="重复密码不一致！" ;
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
					<td><input id="username" name="username" type="text" value="" /><span id="unmsg" class="tishi">提示：登录要用哦！</span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5">*</span>邮箱地址</td>
					<td><input id="email" name="email" type="text" value=""  /><span id="emailsg"></span></td>
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
					<td><input id="weixin" name="weixin" type="text" value="" /><span id="unmsg" class="tishi">提示：用于线下交易，请务必填写真实账号</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" value="0" name="status" />
						<a href="javascript:void(0);" onclick="javascript:dosubmit();" class="btn" >注册账户</a>
					</td>
				</tr>
			</table>
	    	
		</form>
	</div>
</div>
<jsp:include  page="./common/footer.jsp"/>
</body>
</html>
