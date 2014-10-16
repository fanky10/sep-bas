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
			clubId = element.getAttribute("club-id"); //refers to the element actioning this method
			li = element.parentNode;
			$.post("${ctx}/clubes/delete.json", { "id": clubId },
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
					<c:when test="${empty clubes}">
						<div class="twelve columns">
                                                    No se encontraron clubes
			                <hr class="sin-margin-top" />
			            </div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="twelve columns">
                                                        <h2>Clubes</h2>
                                                        <h3>Listado</h3>
							</div>
						</div>
						<c:forEach var="club" items="${clubes}">
							<div class="row">
								<div class="four columns">
									<h4>${club.nombre}</h4>                                                                 
								</div>
                                                                <div class="four columns">
									<h4>${club.localidad}</h4>
								</div>
								<div class="two columns">
									<a href="<c:url value="/clubes/edit/${club.id}" />" class="button" alt="Editar" club-id="${club.id}" >
                                                                        Editar        
                                                                        </a>
								</div>
								<div class="two columns">
									<a href="<c:url value="/clubes/del/${club.id}" />" class="button" alt="Eliminar" club-id="${club.id}" >
                                                                        Eliminar        
                                                                        </a>
								</div>
							</div>
						</c:forEach>
						<div id="deleteResponse"></div>
					</c:otherwise>
				</c:choose>
                                <h3><a href="<c:url value="/clubes/add"/>" class="button"> Nuevo Club</a></h3>
                                <a href="<c:url value="/home"/>" class="button"> Volver</a>                   
			</div>
		</div>
	</div>
</content>