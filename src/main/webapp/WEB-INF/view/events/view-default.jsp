<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		
		<div class="border-rounded p-2 text-center">
			<p class="fs-3">
				<span class="warning">${ev.hostId }</span> 의 체육행사 <small>✍${ev.registerAt }</small>
			</p>
			<h1>
				<span class="warning">[${ev.tag } ]</span>
				<c:out value="${ev.title }" />
			</h1>
			<p class="fs-3">
				<c:out value="${ev.description }" />
			</p>
			<p class="fs-3">
				<span>📆 ${ev.openAt }</span> <span>🚩 ${g.name }
					(${g.location })</span> <span>😊 ${ev.attendee } / ${ev.capacity }</span>
			</p>
		</div>
		<div class="my-2 text-right">
			<c:choose>
				<c:when test="${flag }">
					이미 참가중인 이벤트입니다.
				</c:when>
				<c:otherwise>
					<a
						href="${pageContext.servletContext.contextPath }/events/join/${ev.id}">
						<button class="p-2 fs-4 border-rounded">참가신청</button>
					</a>
				</c:otherwise>
			</c:choose>
		</div>
		<h3 class="my-2">참가자들(${fn:length(p) }) | 전체댓글</h3>
		<div>
			<ul style="list-style: none">
				<li><c:forEach items="${p }" var="one">
						<c:choose>
							<c:when test="${one.participant.userId == ev.hostId }">
								<div>
									<span class="warning">${one.participant.userId } (주최자)</span>
									<span> ${one.user.gender } (${one.user.birth })</span>
									 -
									${one.participant.joinAt } 에 참가신청
								</div>
							</c:when>
							<c:otherwise>
								<div>${one.participant.userId }-${one.participant.joinAt } 에 참가신청
								<span> ${one.user.gender } (${one.user.birth })</span>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach></li>

			</ul>

		</div>


	</div>
</body>
</html>