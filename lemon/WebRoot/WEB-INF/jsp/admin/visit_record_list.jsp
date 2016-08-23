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
  <style type="text/css">
  	.table td,.td{
  		word-break: normal;
  		word-wrap: break-word;
  	}
  	.td{
  		width:600px;
  	}
  </style>
  </head>
  
<body>
<c:if test="${pagen!=null}">
<div style="overflow:hidden;">
	<span style="float:right;">
		<a href="${base}/ucenter/visit_record_statistics.do?pageNumber=${pagen}">返回</a>
	</span>
</div>
</c:if>
<div style="clear:both;"></div>

<form id="tableForm" method="post" style="padding-top:5px">
	
	<table class="table" border="0" width="90%" cellspacing="1" >
		<thead>
			<tr>
				<th width="10%">用户名称</th>
				<th width="10%">来访IP</th>
				<th width="20%">访问来源</th>
				<th width="10%">请求地址</th>
				<th width="10%">访客浏览器类型</th>
				<th width="10%">访问时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.result}" var="item">
			<tr>
				<td align="center">${item.userId}</td>
				<td align="center">${item.ip}</td>
				<td align="center"><div class="td">${item.referer}</div></td>
				<td align="center">${item.requestUrl}</td>
				<td align="center">${item.browser}</td>
				<td align="center">${item.visitTime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</form>


<jsp:include  page="./../common/pager.jsp"/>
<script type="text/javascript">
	
</script>

</body>
</html>
