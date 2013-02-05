<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jugadores</title>
</head>
<body>
	<c:if test="${empty jugadores}">
		<h3>
			<c:out value="no hay jugadores" />
		</h3>
	</c:if>
	<!-- for now just a simple list<String> -->
	<c:url var="jugadoresURL" value="/jugadores/add"></c:url>
	<a href="${jugadoresURL}">Agregar Nuevo Jugador</a>
	<ul>
		<c:forEach var="jugador" items="${jugadores}">
			<li>
				${jugador.nombre}
				${jugador.apellido}
			</li>
		</c:forEach>
	</ul>
</body>
</html>