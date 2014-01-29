<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Personeel - Spring 4.0 Test - Opslag</title>
<link rel='stylesheet' href='${contextPath}/stylesheets/default.css' />
</head>
<body>
	<header>
		<h1>Opslag voor ${werknemer.naam}</h1>
	</header>
	<section>
		<p>
			Huidig salaris<br />
			<fmt:formatNumber value="${werknemer.salaris}" />
		</p>
		<label for="bedrag">Bedrag</label>
		<form action="" method="post">
			<input type="number" name="bedrag" id="bedrag" min="0" max="50000"
				maxlength="5" autofocus required /><br /> <input type="hidden"
				name="werknemerID" id="werknemerID" value="${werknemer.id}" /><input
				type="submit" name="submit" id="submit" value="Opslag" />
		</form>
	</section>
</body>
</html>