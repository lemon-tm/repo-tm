<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="footer">
	<div class="footer_1"></div>
	<div class="footer_2">
		京ICP备16021391号
		<c:if test="${user.username=='mr_cheng'}">
			<a href="${base}/ucenter/index.do" target="_blank" >后台管理</a>
		</c:if>
	</div>
	
</div>