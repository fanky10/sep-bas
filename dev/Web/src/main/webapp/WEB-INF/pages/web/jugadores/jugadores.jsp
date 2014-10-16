<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<%-- some jscript libraries rel to this page in specific --%>	
</content>
<content tag="jscript">
	<script>
		function deleteJugador(element){
			jugadorId = element.getAttribute("jugador-id"); //refers to the element actioning this method
			li = element.parentNode;
			$.post("${ctx}/jugadores/delete.json", { "id": jugadorId },
					function(response){
						if(response.status=="OK"){//remove it
							$(li).fadeOut("slow", function() { 
			                    $(this).remove(); 
			                });
						}else if(response.status=="ERROR"){
							$("#deleteResponse").html(response.error);
						}
					
					}, "json"
			);
		}
	</script>
</content>
<content tag="bodyContent">
	<!-- navigation  -->
	<div class="row">
		<div class="twelve columns">
			</br>
			<a href="<c:url value="/jugadores/add"/>" class="button" align="center" >NUEVO JUGADOR</a>
		</div>
	</div>
	
	<div class="content">
		<div class="row">
			<div class="twelve columns">
				<c:choose>
					<c:when test="${empty jugadores}">
						<div class="twelve columns">
                                                        No se encontraron jugadores
							<hr class="sin-margin-top" />
						</div>
					</c:when>
					<c:otherwise>
                                                <div class="row">
							<div class="twelve columns">
                                                        <h2>Jugadores</h2>
                                                        <h3>Listado</h3>
							</div>
						</div>
						<div class="row">
							<div class="two columns">
								<h5>Nombre</h5>
							</div>
							<div class="two columns">
								<h5>Apellido</h5>
							</div>
							<div class="two columns">
								<h5>Equipo</h5>
							</div>
							<div class="two columns"></div>
							<div class="four columns"></div>
						</div>
						<c:forEach var="jugador" items="${jugadores}">
							<div class="row">
								<div class="two columns">
									<h5>${jugador.nombre}</h5>
								</div>
								<div class="two columns">
									<h5>${jugador.apellido}</h5>
								</div>
								<div class="two columns">
									<h5>${jugador.club.nombre}</h5>
								</div>
								<div class="one column" align="center">
									<a href="<c:url value="/jugadores/edit/${jugador.id}" />" class="button" alt="Editar" jugador-id="${jugador.id}" >
                                                                        Editar        
                                                                        </a>
								</div>
								<div class="one column" align="center">
                                                                        <a href="<c:url value="/jugadores/del/${jugador.id}" />" class="button" alt="Eliminar" jugador-id="${jugador.id}" >
                                                                        Eliminar        
                                                                        </a>									
								</div>
								<div class="four columns" align="center"></div>
							</div>
						</c:forEach>
						<div id="deleteResponse"></div>
					</c:otherwise>
				</c:choose>
                                <h3><a href="<c:url value="/jugadores/add"/>" class="button"> Nuevo Club</a></h3>
                                <a href="<c:url value="/home"/>" class="button">Volver</a> 
			</div>
		</div>
	</div>
</content>