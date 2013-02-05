<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<title>
	<c:if test="${statusCode < 500}">Perd�n - No hemos podido encontrar la p�gina</c:if>
	<c:if test="${statusCode >= 500}">Perd�n - Estamos teniendo dificultades t�cnicas </c:if>
</title>

</head>
<body>
	<c:if test="${statusCode < 500}">
		<h3>Perd�n - No hemos podido encontrar la p�gina</h3>
		<p>Direcci�n no encontrada.</p>
		
		
	</c:if>
	<c:if test="${statusCode >= 500}">
		<h3>Perd�n - Estamos teniendo dificultades t�cnicas</h3>
		<p>Algo ha pasado de nuestro lado.</p>
	</c:if>
	<p>Por favor vuelva a la pagina de inicio.</p>
	<c:url var="homeURL" value="/home" ></c:url>
	<a class="btn_med_blue" href="${homeURL}"><span>Volver a la p�gina de inicio</span></a>
</body>
</html>