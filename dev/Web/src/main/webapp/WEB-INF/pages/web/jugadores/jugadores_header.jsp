<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
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