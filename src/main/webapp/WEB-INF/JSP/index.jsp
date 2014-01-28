<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%> 
<!doctype html>
<html lang="${pageContext.response.locale.language}">
	<head>
		<title>Personeel - Spring Test - Welcome</title>
		<link rel='stylesheet'   href='${pageContext.servletContext.contextPath}/styles/default.css'> 
	</head>
	<body>
		<h1><fmt:message key='menu'/></h1>
		<nav>
			<ul>
				<li><a href="<c:url value='/werknemer'/>">Werknemershiërarchie</a></li>
				<li><a href="<c:url value='/jobtitels'/>">Jobtitels</a></li>
			</ul>
		</nav>
	</body>
</html>