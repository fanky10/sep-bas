<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Jugadores</title>
</head>
<body>
	
	<!-- navigation  -->
	<div class="breadcrums">
		<div class="row">
			<div class="twelve columns">
				<ul class="inline-list">
					<li><a href="#">Home</a></li>
					<li>></li>
					<li>Home</li>
				</ul>
			</div>
		</div>
	</div>
	<c:if test="${empty jugadores}">
		<h3>
			<c:out value="no hay jugadores" />
		</h3>
	</c:if>
	<c:url var="eliminarJugador" value="/jugadores/del" />
	<ul>
		<c:forEach var="jugador" items="${jugadores}">
			<li>
				${jugador.nombre} 
				${jugador.apellido}
				<button jugador-id="${jugador.id}" onclick="deleteJugador(this); return false;"  >Eliminar Jugador</button>
			</li>
		</c:forEach>
	</ul>
	<div id="deleteResponse"></div>
</body>
</html>