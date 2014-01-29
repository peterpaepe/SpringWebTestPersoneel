<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
	<head>
		<title>Personeel - Spring Test - Werknemer</title>
		<link rel='stylesheet'   href='${contextPath}/styles/default.css'> 
	</head>
	<body>
<%-- 		<a href="<c:url value='/'/>"><fmt:message key='menu'/></a> --%>
		<h1>Werknemer</h1>
<%-- 		<spring:eval expression='werknemer.salaris'/> --%>

		<c:forEach items='${werknemers}' var='werknemer'>
				<div>${werknemer.familienaam}</div>
		</c:forEach>
	</body>
</html>