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
    
    <title>红色柠檬-我的随拍图片网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="keywords" content="照片，图片，旅游照，照起来，ps图片，原创图片，保存照片，上传照片，免费保存图片" />
	<meta name="description" content="红色柠檬网，不一样的柠檬，用于各类用户存储在旅游或外出时随手拍出的图片，或自己创作的图画保存。" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	
	<jsp:include  page="./../common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>

	<link rel="shortcut icon" href="${base}/image/favicon.ico">
 
</head>
<script type="text/javascript">

function dosubmit(){
	var title=$("#title").val() ;
	var content=$("#content").val() ;
	var email = $("#email").val() ;
	var user = '${user}';
	
	if(title){
		if(title.length<6){
			alert("输入标题不能小于6个字符！") ;
			return ;
		}else{
		
		}
	}else{
		alert("标题名不能为空！");
		return ;
	}
	
	if(content){
		if(content.length<6){
			alert("输入内容不能小于6个字符！") ;
			return ;
		}
	}else{
		alert("内容不能为空！") ;
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
	if(user){
		
	}else{
		alert("没有登录就留言，我也不知道哪里能查看哦！等待邮件回复吧！");
	}
	msg.submit() ;
}
	
</script>

<body>
<jsp:include  page="./../common/head.jsp"/>
<jsp:include  page="./../common/pager.jsp"/>

<div class="container">
<span class="tishi">提示：登录后留言，才有地方查看哦！</span>
	<form name="msg" action="${base}/savemsg.jspx" method="post">
	<ul class="msg-box">
		
		<li>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题：</span>
			<input id="title" name="title" type="text" value="" />
		</li>
		<li>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内容：</span>
			<textarea id="content" name="content" rows="10" cols="30"></textarea>
		</li>
		<li>
			<span>联系邮箱：</span>
			<input id="email" name="email" type="text" value="${email }" />
		</li>
		<li>
			<a href="javascript:void(0);" onclick="javascript:dosubmit();" class="btn" >确定留言</a>
			
		</li>
	</ul>
	</form>
	
	<div class="clear"></div>
</div>


<jsp:include  page="./../common/footer.jsp"/>
</body>
</html>
