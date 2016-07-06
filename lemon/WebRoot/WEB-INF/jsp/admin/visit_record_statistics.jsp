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
    
    <title>访问量统计</title>
    
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
				<th width="10%">来访IP</th>
				<th width="20%">点击次数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.result}" var="item">
			
			<tr>
				
				<td align="center"><a href="${base}/ucenter/visit_record_list.do?ip=${item[0]}&pagen=${pager.pageNumber}">${item[0]}</a></td>
				<td align="center">${item[1]}</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</form>
<script type="text/javascript">
	
</script>

</body>
</html>
