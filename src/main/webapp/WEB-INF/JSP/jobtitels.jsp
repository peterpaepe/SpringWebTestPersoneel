<%@page contentType="text/html"	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%> 
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
	<head>
		<title>Personeel - Spring Test - Jobtitels</title>
		<link rel='stylesheet'	href='${contextPath}/styles/default.css'>
	</head>
	<body>
		<a href="<c:url value='/'/>"><fmt:message key='menu'/></a>
		<header>
			<h1>Jobtitels</h1>
		</header>
		<nav>
			<ul class="menu">
				<c:forEach items="${jobtitels}" var="jobtitel" >
					<spring:url var='url' value='/jobtitels/{id}'>
						<spring:param name='id' value='${jobtitel.id}' />
					</spring:url>
					<li><a href="${url}" title="${jobtitel.naam}">${jobtitel.naam}</a></li>
				</c:forEach>
			</ul>
		</nav>
		<c:if test="${not empty jobtitel}">
			<section>
				<h2>
					<c:out value="${jobtitel.naam}" />
				</h2>
				<c:forEach items="${jobtitel.werknemers}" var="werknemer" >
					<ul>

						<spring:url var='url' value='/werknemer/{id}'>
							<spring:param name='id' value='${werknemer.id}' />
						</spring:url>

<%-- 						<c:url var="url" value="/werknemer"> --%>
<%-- 							<c:param name="id" value="${werknemer.id}" /> --%>
<%-- 						</c:url> --%>
						<li><a href="${url}" title="${werknemer.voornaam}&nbsp;${werknemer.familienaam}">${werknemer.voornaam}&nbsp;${werknemer.familienaam}</a></li>
					</ul>
				</c:forEach>
			</section>
		</c:if>
	</body>
</html>