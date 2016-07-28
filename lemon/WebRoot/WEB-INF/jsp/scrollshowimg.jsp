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
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./common/common.jsp" %>
	<script type="text/javascript" src="${base}/js/img/scrollimg.js" charset="UTF-8"></script>
	
</head>
<script type="text/javascript">

</script>
<body>
<%@include file="./common/head.jsp" %>
<div class="container">
	
	<div class="article_content">
		
		<div class="article_img mt20">
			<div class="cur_img" style="height:500px;overflow:hidden;">
				<c:forEach items="${pager.result}" var="l" varStatus="status">
					<c:if test="${imgId==l.id}">
					<div class="showimg-all" style="width:700px;">
						<div class="showimg-l">
						
							<c:forEach items="${l.imgurlb}" var="a">
								<img style="max-height:500px; width:400px;" src='${base}${a.bigImagePath}' alt="${l.name}" />
							</c:forEach>
						</div>
						<div class="showimg-r ml20 lh30" id="imgmsg" style="width:280px;overflow:hidden;">
							<div>名称：${l.name}</div>
							<div>描述：${l.describes}</div>
							<div>作者名称：${l.trueName}</div>
							<div>${l.createTime}</div>
						</div>
					</div>
					</c:if>
				</c:forEach>
				
			</div>
			<div class="box_img pr">
				<a href="javascript:void(0);" class="prev pa" onclick="ajaxData(1)"></a>
				<a href="javascript:void(0);" class="next pa" onclick="ajaxData(2)"></a>
				<ul class="pa" style="">
					<c:forEach items="${pager.result}" var="l" varStatus="status">
						<c:forEach items="${l.imgurlb}" var="a">
						<c:choose>
							<c:when test="${imgId==l.id}">
								<li class="current" onclick="ajaxData(this)">
									<input type="hidden" id="imgId" value="${l.id }" />
									<input type="hidden" id="indexfs" value="${index }" />
									<img height="160" src='${base}${a.bigImagePath}' alt="${l.name}" />
								</li>
							</c:when>
							<c:otherwise>
								<li onclick="ajaxData(this)">
									<input type="hidden" id="imgId" value="${l.id }" />
									<img height="160"  src='${base}${a.bigImagePath}' alt="${l.name}" />
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
<%@include file="./common/footer.jsp" %>

<script type="text/javascript" src="${base}/js/jsviews.js" charset="UTF-8"></script>

<script id="tmpl" type="text/x-jsrender">

	<div>名称：{{:name}}</div>
	<div>描述：{{:describes}}</div>
	<div>作者名称：{{:trueName}}</div>
	<div>{{:createTime}}</div>
</script>
<script type="text/javascript">

function ajaxData(p){
	var imgId = $(p).children("#imgId").val() ; 
	
	if(imgId){
		
	}else{
		if(p==1){
			var imgId = $(".box_img ul>li[class='current']").prev().children("#imgId").val() ;
		}
		if(p==2){
			var imgId = $(".box_img ul>li[class='current']").next().children("#imgId").val() ;
		}
	}
	if(imgId){
	}else{
		return ;
	}
	//var params = {pageNumber:1,pageSize:5};
	$.ajax({
          //提交数据的类型POST GET
          type:"POST",
          async : false,
          //提交的网址
          url:"scroll_imgmsg.jspx",
          //提交的数据
          data:{imgId:imgId,date:new Date()},
          //返回数据的格式
          datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
          //在请求之前调用的函数
          beforeSend:function(){
        	  $("#imgmsg").empty() ;
          },
          //成功返回之后调用的函数
          success:function(data){
        	    var tmpl = $("#tmpl").render(data);
				$("#imgmsg").append(tmpl);
          },
          //调用执行后调用的函数
          complete: function(XMLHttpRequest, textStatus){
          	    //activateEvent();  //激活事件
          },
          //调用出错执行的函数
          error: function(){
              //请求出错处理
          }         
       });
       
}
</script>
</body>
</html>
