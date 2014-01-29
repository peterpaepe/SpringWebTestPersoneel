<%@page contentType="text/html"	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype>
<html lang='nl'>
<head>
<title>Personeel - Spring 4.0 Test - Werknemershi&euml;rarchy</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<header>
		<h1>Werknemer ${werknemer.naam}</h1>
<!-- 		<h1>Werknemer</h1> -->
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
				Chef<br /> <span class="bold"> <c:url
						value="/werknemershiërarchy.htm" var="id">
						<c:param name="werknemerID" value="${werknemer.chef.id}" />
					</c:url><a href="${id}"
					title="${werknemer.chef.voornaam}&nbsp;${werknemer.chef.familienaam}">${werknemer.chef.voornaam}&nbsp;${werknemer.chef.familienaam}</a></span>

			</p>
		</c:if>
		<c:if test="${not empty werknemer.werknemers}">
			<p>
				Ondergeschikten<br />
				<c:forEach var="werknemer" items="${werknemer.werknemers}">
					<c:url value="/werknemershiërarchy.htm" var="id">
						<c:param name="werknemerID" value="${werknemer.id}" />
					</c:url>
					<span class="bold"><a href="${id}"
						title="${werknemer.voornaam}&nbsp;${werknemer.familienaam}">${werknemer.voornaam}&nbsp;${werknemer.familienaam}</a></span>
					<br />
				</c:forEach>
			</p>
		</c:if>
		<p>
			Foto<br /> <img src="${contextPath}/images/${werknemer.id}.jpg"
				alt="${werknemer.voornaam}&nbsp;${werknemer.familienaam}" />
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