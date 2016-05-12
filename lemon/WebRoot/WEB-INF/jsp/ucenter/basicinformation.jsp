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
    
    <title>设置基本信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include  page="./../common/common.jsp"/>
	
</head>
<script type="text/javascript">
	
	$(function () {
		var save = '${save}';
		if(save){
			alert("保存成功！") ;
		}
	
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
		
		login.submit() ;
		
	}
	
</script>

<body>

<div class="container">
	<div class="container-in">
		<form name="login" action="${base}/ucenter/saveUser.jspx" method="post">
			<table>
				<tr>
					<td align="right">设置基本信息</td>
					<td></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5"></span>账户名称</td>
					<td><input id="username" name="username" type="text" value="${user.username}" disabled="disabled" /><span id="unmsg"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5"></span>真实姓名</td>
					<td><input id="trueName" name="trueName" type="text" value="${user.trueName}" /><span id="unmsg"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5"></span>邮箱账号</td>
					<td><input id="email" name="email" type="text" value="${user.email }" disabled="disabled" /><span id="emailsg"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5"></span>手机号码</td>
					<td><input id="cellPhone" name="cellPhone" type="text" value="${user.cellPhone}"  /><span id="pwmsga"></span></td>
				</tr>
				<tr>
					<td align="right"><span class="red p5"></span>微信号码</td>
					<td><input id="weixin" name="weixin" type="text" value="${user.weixin}" /><span id="unmsg" class="red">用于线下交易，请务必填写真实账号</span></td>
				</tr>
				<tr>
					<td align="right">QQ</td>
					<td><input id="qq" name="qq" type="text" value="${user.qq}" /><span id="unmsg"></span></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" value="${user.id}" name="id" />
						<a href="javascript:void(0);" onclick="javascript:dosubmit();" class="btn" >保存</a>
					</td>
				</tr>
			</table>
	    	
		</form>
	</div>
</div>
</body>
</html>
