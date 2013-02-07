<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	
		<h1><c:out value="Mensaje configurado: ${mensaje}" /></h1>
		<br/>
		<c:url var="jugadoresURL" value="/jugadores/list" ></c:url>
		<a href="${jugadoresURL}">ver lista jugadores</a>
	
</body>
</html>