<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Personeel - Jobtitels</title>
<link rel='stylesheet' href='${contextPath}/stylesheets/default.css' />
</head>
<body>
	<header>
		<h1>Jobtitels</h1>
	</header>
	<nav>
		<ul class="menu">
			<c:forEach var="jobtitel" items="${jobtitels}">
				<c:url value="/jobtitels.htm" var="id">
					<c:param name="jobtitelID" value="${jobtitel.id}" />
				</c:url>
				<li><a href="${id}" title="${jobtitel.naam}">${jobtitel.naam}</a></li>
			</c:forEach>
		</ul>
	</nav>
	<c:if test="${not empty jobtitel}">
		<section>
				<h2>
					<c:out value="${jobtitel.naam}" />
				</h2>
			<c:forEach var="werknemer" items="${jobtitel.werknemers}">
				<ul>
					<c:url value="/werknemershierarchy.htm" var="id">
						<c:param name="werknemerID" value="${werknemer.id}" />
					</c:url>
					<li><a href="${id}"
						title="${werknemer.naam}">${werknemer.naam}</a></li>
				</ul>
			</c:forEach>
		</section>
	</c:if>
</body>
</html>