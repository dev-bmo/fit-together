<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${empty title }">
		<title>핏투게더</title>
	</c:when>
	<c:otherwise>
		<title>${title }::핏투게더</title>
	</c:otherwise>
</c:choose>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<div class="container px-1">

		<div>
			<span>체육행사등록</span> &gt; <span class="warning">체육시설 선택</span>
		</div>
		<h2 class="my-2">시작하기: 체육시설 선택</h2>
		<p>
			원하는 <span class="warning">체육시설</span>을 선택하고 자세한 정보를 입력하세요.
		</p>
		<form action="${pageContext.servletContext.contextPath }/events/new">
			<select name="type" class="w-50 text-center p-2 border-rounded fs-3">
				<c:forEach var="one" items="${types }">
					<option>${one }</option>
				</c:forEach>
			</select>
			<button type="submit" class="p-2 border-rounded fs-3">선 택</button>
		</form>

	</div>
</body>
</html>