<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${pager.pageCount > 1}"> 

	<div class="pagelist">

		<c:choose>
			<c:when test="${pager.pageNumber > 1}">
			
				<a href="${base}${pager.pUrl}?pageNumber=${pager.pageNumber-1}">上一页</a>
			</c:when>
			<c:otherwise>
				<span class="disabled">上一页</span>
			</c:otherwise>
		</c:choose>

		<c:forEach var="p" begin="1" end="${pager.pageCount}" step="1" varStatus="status">
			<c:if test="${status.index==0 && p > 1}"><span>...</span></c:if>
			<c:choose>
				<c:when test="${pager.pageNumber !=p}">
					<a href="${base}${pager.pUrl}?pageNumber=${p}">${p}</a>
					
				</c:when>
				<c:otherwise>
					<span class="current">${p}</span>
				</c:otherwise>
			</c:choose>
			<c:if test="${status.last && p < pager.pageCount}"><span>...</span></c:if>
		</c:forEach>
		
		<c:choose>
			<c:when test="${pager.pageNumber < pager.pageCount}">
			
				<a href="${base}${pager.pUrl}?pageNumber=${pager.pageNumber+1}">下一页</a>
			</c:when>
			<c:otherwise>
				<span class="disabled">下一页</span>
			</c:otherwise>
		</c:choose>
	</div>
	
</c:if>