<%@page contentType="text/html"
	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Personeel - Pagina niet gevonden</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<nav>
		<h1>
			<a href="${contextPath}/index.jsp">Hoofdpagina</a>
		</h1>
	</nav>
	<header>
		<h1>Pagina niet gevonden</h1>
	</header>
	<section>
		<p class="fouten">De pagina die u zocht bestaat helaas niet op	deze website.</p>
	</section>
</body>
</html>