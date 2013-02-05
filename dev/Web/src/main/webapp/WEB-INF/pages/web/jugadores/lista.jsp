<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jugadores</title>
</head>
<body>
	<c:if test="${empty jugadores}">
		<h3><c:out value="no hay jugadores"/></h3>
	</c:if>
	<!-- for now just a simple list<String> -->
	<c:forEach var="jugador" items="${jugadores}">
        <tr>
          <td>${jugador.nombre}</td>
          <td>${jugador.apellido}</td>
        </tr>
      </c:forEach>
</body>
</html>