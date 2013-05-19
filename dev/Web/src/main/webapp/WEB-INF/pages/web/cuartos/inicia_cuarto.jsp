<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscript">
	
	<script>
		$(document).ready(
				function() {
					var config = {
							'jugadoresSeleccionadosEquipo1':0, //nro jugadores seleccionados equipo 1
							'jugadoresSeleccionadosEquipo2':0,
							'maxJugadoresSeleccionados':5 //solo puede seleccionar ese numero de jugadores por equipo
							};
					//this works!!
					$('.chkEquipo1').live('click',function(){
						//could be checked here... and do nothing at all.
						if(config.jugadoresSeleccionadosEquipo1==config.maxJugadoresSeleccionados){
							if(this.checked){
								this.checked = false;
								return ;
								
							}
						}
						
						if(this.checked){
							config.jugadoresSeleccionadosEquipo1++;
						}else{
							config.jugadoresSeleccionadosEquipo1--;
						}
					});
					
					$('.chkEquipo2').live('click',function(){
						//could be checked here... and do nothing at all.
						if(config.jugadoresSeleccionadosEquipo2==config.maxJugadoresSeleccionados){
							if(this.checked){
								this.checked = false;// no lo dejamos seleccionar jaja
								return ;
							}
						}
						if(this.checked){
							config.jugadoresSeleccionadosEquipo2++;
						}else{
							config.jugadoresSeleccionadosEquipo2--;
						}
						if(config.jugadoresSeleccionadosEquipo2==config.maxJugadoresSeleccionados){
							//deshabilitar a los demas (:	
						}
						console.log("currentSelectedElements! "+config.currentSelectedElements);
					});
					// TODO: check numero de jugadores seleccionados
					// TODO: bind event onlick chkbox 
				}
		);
		
	</script>
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
