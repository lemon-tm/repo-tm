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
    
    <title>后台显示大图页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./../common/common.jsp" %>
	<script type="text/javascript" src="${base}/js/img/scrollimg.js" charset="UTF-8"></script>
</head>
<script type="text/javascript">

</script>
<body>

<div class="container">
	
	<div class="article_content">
		
		<div class="article_img mt20">
			<div class="cur_img" style="height:500px;overflow:hidden;">
				<div class="showimg-all">
					<div class="showimg-l">
					
						<c:forEach items="${img.imglist}" var="l" varStatus="status">
							<c:if test="${status.index==index}">
								<c:forEach items="${l.imgurlb}" var="a" >
									<img style="max-height:500px; width:400px;" src='${base}${a.bigImagePath}' alt="${img.name}" />
									<input id="state" type="hidden" value="${l.isverify.label}"/>
									<input id="imgId" type="hidden" value="${l.id}"/>
									<input id="index" type="hidden" value="${status.index}"/>
								</c:forEach>
							</c:if>
						</c:forEach>
					</div>
					<div class="showimg-r ml20 lh30">
						<div>审核状态：<span id="stateshow"></span></div>
						<div>名称：${img.name}</div>
						<div>描述：${img.describes}</div>
						<div>作者名称：${img.user.trueName}</div>
						<div>作者微信：${img.user.weixin}</div>
						<div>审核操作：
							<a href="javascript:void(0);" onclick="verify(1)">通过</a>
							<a href="javascript:void(0);" onclick="verify(0)">不通过</a>
						</div>
					</div>
				</div>
				
			</div>
			<div class="box_img pr">
				<a href="javascript:void(0);" class="prev pa"></a>
				<a href="javascript:void(0);" class="next pa"></a>
				<ul class="pa" style="height:171px; overflow:hidden;">
					<c:forEach items="${img.imglist}" var="l" varStatus="status">
						<c:forEach items="${l.imgurlb}" var="a">
						
						<c:choose>
							<c:when test="${status.index==index }">
								<li class="current">
									<img height="160" src='${base}${a.bigImagePath}' alt="" />
									<input id="" class="state" type="hidden" value="${l.isverify.label}"/>
									<input id="" class="imgId" type="hidden" value="${l.id}"/>
									<input id="" class="index" type="hidden" value="${status.index}"/>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<img height="160" src='${base}${a.bigImagePath}' alt="" />
									<input id="" class="state" type="hidden" value="${l.isverify.label}"/>
									<input id="" class="imgId" type="hidden" value="${l.id}"/>
									<input id="" class="index" type="hidden" value="${status.index}"/>
								</li>
							</c:otherwise>
						</c:choose>
						</c:forEach>
					</c:forEach>
				</ul>
				
			</div>
		</div>
		
	</div>
</div>
<script type="text/javascript">
function verify(value){
	var id = $("#imgId").val() ;
	$.ajax({
        type:"POST",
        async : false,
        url:"${base}/ucenter/isverifyimg.do",
        data : {imgId:id, verify:value},
        datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
        beforeSend:function(){
        },
        success:function(data){
       		data = eval(data);
       		if(data.verify){
       			$("#stateshow").html("审核通过") ;
       			alert("审核通过操作完成！") ;
       		}else{
       			$("#stateshow").html("审核不通过") ;
       			alert("审核不通过操作完成！") ;
       		}
       		var index = $("#index").val() ;
       		window.location.href="${base}/ucenter/showImglist.do?imgId=${img.id}&index="+index+"&pageNumber=${pager.pageNumber}";
	    	
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
