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
							<div class="four columns">
								<h5>Arbitro</h5>
							</div>
							<div class="four columns"></div>
							<div class="four columns"></div>
						</div>
						<c:forEach var="arbitro" items="${arbitros}">
							<div class="row">
								<div class="four columns">
									<h5>${arbitro.nombre}</h5>
                                                                        <h5>${arbitro.apellido}</h5>
								</div>
								<div class="four columns">
									<a href="<c:url value="/arbitros/edit/${arbitro.id}" />" ><img alt="Editar" arbitro-id="${arbitro.id}"
										src="<c:url value="/images/soft-scraps-edit-icon.png" />"></a>
								</div>
								<div class="four columns">
									<a href="<c:url value="/arbitros/del/${arbitro.id}" />" ><img alt="Eliminar" arbitro-id="${arbitro.id}"
										src="<c:url value="/images/soft-scraps-delete-icon.png" />"></a>
								</div>
							</div>
						</c:forEach>
						<div id="deleteResponse"></div>
					</c:otherwise>
				</c:choose>
	
			</div>
		</div>
	</div>
</content>