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
			                <hr class="sin-margin-top" />
			            </div>
			            <div class="twelve columns">
			                <h3>Proximamente Clubes...</h3>
			            </div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="four columns">
								<h5>Nombre</h5>
							</div>
							<div class="four columns"></div>
							<div class="four columns"></div>
						</div>
						<c:forEach var="club" items="${clubes}">
							<div class="row">
								<div class="four columns">
									<h5>${club.nombre}</h5>
								</div>
								<div class="four columns">
									<a href="#"><img alt="Editar" club-id="${club.id}"
										src="<c:url value="/images/soft-scraps-edit-icon.png" />"></a>
								</div>
								<div class="four columns">
									<a href="#"><img alt="Eliminar" club-id="${club.id}"
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