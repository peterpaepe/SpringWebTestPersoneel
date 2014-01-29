<%@page contentType="text/html"	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype>
<html lang='nl'>
<head>
<title>Personeel - Spring 4.0 Test - Werknemershi&euml;rarchy</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<a href="<c:url value='/'/>"><fmt:message key='menu'/></a>
	<header>
		<h1>Werknemer ${werknemer.naam}</h1>
	</header>
	<section>
		<p>
			Voornaam<br /> <span class="bold">${werknemer.voornaam}</span>
		</p>
		<p>
			Familienaam<br /> <span class="bold">${werknemer.familienaam}</span>
		</p>
		<p>
			Email adres<br /> <span class="bold">${werknemer.email}</span>
		</p>
		<p>
			Salaris<br /> <span class="bold"><fmt:formatNumber
					value="${werknemer.salaris}" /></span>
		</p>
		<p>
			Jobtitel<br /> <span class="bold">${werknemer.jobtitel.naam}</span>
		</p>
		<c:if test="${not empty werknemer.chef}">
			<p>
				Chef<br />  
				<spring:url value='/werknemer/{id}' var='url'>
					<spring:param name='id' value='${werknemer.chef.id}' />
				</spring:url>
				<span class="bold">
					<a href="${url}"
						title="${werknemer.chef.naam}">${werknemer.chef.naam}
					</a>
				</span>
				
			</p>
		</c:if>
		<c:if test="${not empty werknemer.werknemers}">
			<p>
				Ondergeschikten<br />
				<c:forEach var="werknemer" items="${werknemer.werknemers}">
					<spring:url value='/werknemer/{id}' var='url'>
						<spring:param name='id' value='${werknemer.id}' />
					</spring:url>
					<span class="bold">
						<a href="${url}"
							title="${werknemer.naam}">${werknemer.naam}
						</a>
					</span>
					<br />
				</c:forEach>
			</p>
		</c:if>
		<p>
			Foto<br /> <img src="${contextPath}/images/${werknemer.id}.jpg"
				alt="${werknemer.naam}" />
		</p>
		<p>
			<c:url value="/opslag.htm" var="id">
				<c:param name="werknemerID" value="${werknemer.id}" />
			</c:url>
			<a href="${id}" title="Opslag">Opslag</a>
		</p>
	</section>
</body>
</html>