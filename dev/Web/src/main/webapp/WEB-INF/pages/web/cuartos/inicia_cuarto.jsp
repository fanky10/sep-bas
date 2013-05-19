<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>
</content>
<content tag="jscript">
	<%-- some javascript written --%>
</content>
<content tag="bodyContent">
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
						<input class="chkEquipo1" id="equipo1${status.index}" name="jugadoresEquipo1" type="checkbox" value="${jugador.id}"/>${jugador.nombre}
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
						<input class="chkEquipo2" id="equipo2${status.index}" name="jugadoresEquipo2" type="checkbox" value="${jugador.id}"/>${jugador.nombre}
						</ul>
					</c:forEach>
					</li>
				</div>
				<input name="submit" type="submit" value="Iniciar Cuarto" />
			</form:form>
		</div>
	</div>
</div>
