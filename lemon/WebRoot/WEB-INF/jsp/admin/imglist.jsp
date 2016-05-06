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
    
    <title>图片列表页面</title>
    
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
				<th width="5%">图片名称</th>
				<th width="35%">图片描述</th>
				<th width="15%">上传用户</th>
				<th width="5%">审核状态</th>
				<th width="10%">创建时间</th>
				<th width="15%">图片路径</th>
				<th width="10%">审核</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.result}" var="item">
			
			<tr>
				
				<td align="center">${item.name}</td>
				<td align="center">${item.describe}</td>
				<td align="center">${item.userId}</td>
				<td align="center">${item.isverify}</td>
				<td align="center">${item.createTime}</td>
				<td align="center">
					<a href="${base}/ucenter/showImglist.do?imgId=${item.id}">点击查看图片</a>
					<%-- <c:forEach items="${item.imgurlb}" var="a" varStatus="status">
							<img src='${base}${a.smallImagePath}' />
					</c:forEach> --%>
				</td>
				<td align="center">
					<a href="javascript:void(0);" onclick="verify(1,'${item.id}')">通过</a>
					<a href="javascript:void(0);" onclick="verify(0,'${item.id}')">不通过</a>
				</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</form>
<script type="text/javascript">
function verify(value,id){
	$.ajax({
        type:"POST",
       // async : false,
        url:"${base}/ucenter/isverify.do",
        data : {imgId:id, verify:value},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend:function(){
        },
        success:function(data){
       		data = eval(data);
       		if(null!=data.verify){
       			window.location.href="${base}/ucenter/imglist.do";
       		}
	    	
        },
        complete: function(XMLHttpRequest, textStatus){
        },
        error: function(){
        }         
     });
}
	
</script>

</body>
</html>
