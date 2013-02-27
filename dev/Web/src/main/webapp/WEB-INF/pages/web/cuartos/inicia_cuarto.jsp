<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content> 
	<div>
		Equipo 1
		<label for="club" class="hint">Seleccione un club</label> 
		<select id="clubSelectorEquipo1" name="club" id="club">
			<option data-content="" label="Seleccione Club"
				value="-1" />Seleccione Club
			<c:forEach var="club" items="${clubes}">
				<option data-content="${club.nombre}" label="${club.nombre}"
					value="${club.id}" />${club.nombre}
			</c:forEach>
		</select> 
		
	</div>
	<div>
		Equipo 2
		<label for="club" class="hint">Seleccione un club</label> 
		<select id="clubSelectorEquipo2" name="club" id="club">
			<option data-content="" label="Seleccione Club"
				value="-1" />Seleccione Club
			<c:forEach var="club" items="${clubes}">
				<option data-content="${club.nombre}" label="${club.nombre}"
					value="${club.id}" />${club.nombre}
			</c:forEach>
		</select> 
		
	</div>
	<!-- TODO: validate input according to the number of selected elements -->
	<form:form action="${ctx}/cuartos/iniciar" modelAttribute="iniciaCuartoForm" method="POST">
		<label>Jugadores Disponibles Equipo 1</label>
		<div id="equipo1"></div>
		<label>Jugadores Disponibles Equipo 2</label>
		<div id="equipo2"></div>
		<input name="submit" type="submit" value="Iniciar Cuarto" />
	</form:form>



</content>