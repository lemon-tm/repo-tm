<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="top">
	<div class="fl tellus">18601253417</div>
	<c:if test="${empty user.username}">
	<div class="fr mr15"><a href="${base}/login.jspx">登录</a></div>
	<div class="fr mr15"><a href="${base}/to_register.jspx">注册</a></div>
	</c:if>
	<c:if test="${!empty user.username}">
	<div class="fr login"><a href="${base}/ucenter/index.jspx">${user.username}</a></div>
	</c:if>
</div>
<div class="navigation-box">
	<ul>
		<li><a href="${base}/home.jspx">首页</a></li>
		<li>照片</li>
	</ul>
	<div class="searchdi">
		<form action="" method="post">
			<input type="text" value="" name="" id=""  class="searchin" />
			<input type="button" value="search" name="" id="" class="searchbu" />
		</form>
	</div>
</div>

