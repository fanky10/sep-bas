<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<div class="content">
	<div class="row">
		<div class="tree columns">
			<form:form action="${ctx}/cuartos/iniciar"
				modelAttribute="iniciaCuartoForm" method="POST">
				<label>Jugadores Disponibles Club Local ${clubLocal.nombre}</label>
				<div id="equipo1">
					<li style="list-style-type:none">
					<c:forEach var="jugador" items="${jugadoresClubLocal}" varStatus="status">
						<ul>
						<input id="equipo1${status.index}" name="jugadoresEquipo1" type="checkbox" value="${jugador.id}"/>${jugador.nombre}
						</ul>
					</c:forEach>
					</li>
				</div>
				<label>Jugadores Disponibles Club Visitante
					${clubVisitante.nombre}</label>
				<div id="equipo2">
					<li style="list-style-type:none">
					<c:forEach var="jugador" items="${jugadoresClubVisitante}" varStatus="status">
						<ul>
						<input id="equipo2${status.index}" name="jugadoresEquipo2" type="checkbox" value="${jugador.id}"/>${jugador.nombre}
						</ul>
					</c:forEach>
					</li>
				</div>
				<input name="submit" type="submit" value="Iniciar Cuarto" />
			</form:form>
		</div>
	</div>
</div>
