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
    
    <title>用户列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./../admin/acommon.jsp" %>
  </head>
  
<body>
	<jsp:include  page="./../common/pager.jsp"/>
<form id="tableForm" method="post" style="padding-top:5px">
	
	<table class="table" border="0" width="100%" cellspacing="1">
		<thead>
			<tr>
				<th width="10%">用户名称</th>
				<th width="10%">微信号码</th>
				<th width="10%">手机号码</th>
				<th width="10%">QQ号码</th>
				<th width="10%">Email</th>
				<th width="10%">用户状态</th>
				<th width="10%">注册时间</th>
				<th width="10%">用户组</th>
				<th width="10%">用户级别</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.result}" var="item">
			
			<tr>
				
				<td align="center">${item.username}</td>
				<td align="center">${item.weixin}</td>
				<td align="center">${item.cellPhone}</td>
				<td align="center">${item.qq}</td>
				<td align="center">${item.email}</td>
				<td align="center">${item.status}</td>
				<td align="center">${item.registTime}</td>
				<td align="center">${item.userGroup}</td>
				<td align="center">${item.userLevel}</td>
				<td align="center">
					<%-- 
					<a href="javascript:void(0);" onclick="verify(1,'${item.id}')">通过</a>
					<a href="javascript:void(0);" onclick="verify(0,'${item.id}')">不通过</a> 
					--%>
				</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</form>
<script type="text/javascript">
	
</script>

</body>
</html>
