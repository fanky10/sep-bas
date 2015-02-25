<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<%-- some jscript libraries rel to this page in specific --%>	
</content>
<content tag="jscript">
	<script>
		function deleteClub(element){
			clubId = element.getAttribute("arbitro-id"); //refers to the element actioning this method
			li = element.parentNode;
			$.post("${ctx}/arbitros/delete.json", { "id": arbitroId },
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
	<div class="content">
		<div class="row">
			<div class="twelve columns">
				<c:choose>
					<c:when test="${empty arbitros}">
						<div class="twelve columns">
                                                    No se encontraron arbitros
                                                <hr class="sin-margin-top" />
                                                </div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="twelve columns">
                                                        <h2>Arbitros</h2>
                                                        <h3>Listado</h3>
							</div>
							
						</div>
						<c:forEach var="arbitro" items="${arbitros}">
							<div class="row">
								<div class="large-4 columns">
									<h6>${arbitro.nombre}</h6>
                                                                        <h6>${arbitro.apellido}</h6>
								</div>
                                                                <div class="large-4 columns">
									<h6>${arbitro.localidad}</h6>
                                                                </div>
								<div class="large-2 columns">
									<a href="<c:url value="/arbitros/edit/${arbitro.id}" />" class="button" alt="Editar" arbitro-id="${arbitro.id}" >
                                                                        Editar        
                                                                        </a>
								</div>
								<div class="large-2 columns">
									<a href="<c:url value="/arbitros/del/${arbitro.id}" />" class="button" alt="Eliminar" arbitro-id="${arbitro.id}" >
                                                                        Eliminar        
                                                                        </a>
								</div>
							</div>
						</c:forEach>
						<div id="deleteResponse"></div>
					</c:otherwise>
				</c:choose>
                        <h3><a href="<c:url value="/arbitros/add"/>" class="button"> Nuevo Arbitro</a></h3>
                        <a href="<c:url value="/home"/>" class="button"> Volver</a>                            
			</div>
		</div>
	</div>
</content>