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
    
    <title>留言列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./../../admin/acommon.jsp" %>
  </head>
  
<body>
	<jsp:include  page="./../../common/pager.jsp"/>
<form id="tableForm" method="post" style="padding-top:5px">
	
	<table class="table" border="0" width="100%" cellspacing="1">
		<thead>
			<tr>
				<th width="10%">留言用户</th>
				<th width="20%">标题</th>
				<th width="15%">邮箱</th>
				<th width="5%">状态</th>
				<th width="15%">留言时间</th>
				<th width="15%">查看时间</th>
				<th width="15%">回复时间</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.result}" var="item">
			
			<tr>
				<td align="center">${item.userId}<br/>${item.username}</td>
				<td align="center">${item.title}</td>
				<td align="center">${item.email}</td>
				<td align="center"><span style="color:#1A94E6;">${item.states.label}</span></td>
				<td align="center">${item.createTime}</td>
				<td align="center">${item.readTime}</td>
				<td align="center">${item.replayTime}</td>
				<td align="center">
					<a href="${base}/ucenter/showmsg.do?msgId=${item.id}">查看</a>
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
