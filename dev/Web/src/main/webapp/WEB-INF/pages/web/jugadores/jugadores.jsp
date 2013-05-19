<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<!-- some link rel to this page in specific -->	
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
	
	<div class="content">
		<div class="row">
			<div class="twelve columns">
				<c:choose>
					<c:when test="${empty jugadores}">
						<div class="twelve columns">
							<hr class="sin-margin-top" />
						</div>
						<div class="twelve columns">
							<h3>Proximamente Jugadores...</h3>
						</div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="two columns">
								<h5>Nombre</h5>
							</div>
							<div class="two columns">
								<h5>Apellido</h5>
							</div>
							<div class="four columns"></div>
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
								<div class="two columns" align="center">
									<a href="#"><img alt="Editar" jugador-id="${jugador.id}"
										src="<c:url value="/images/soft-scraps-edit-icon.png" />"></a>
								</div>
								<div class="two columns" align="center">
									<a href="#"><img alt="Editar" jugador-id="${jugador.id}"
										onclick="deleteJugador(this); return false;"
										src="<c:url value="/images/soft-scraps-delete-icon.png" />"></a>
								</div>
								<div class="four columns" align="center"></div>
							</div>
						</c:forEach>
	
						<div id="deleteResponse"></div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</content>