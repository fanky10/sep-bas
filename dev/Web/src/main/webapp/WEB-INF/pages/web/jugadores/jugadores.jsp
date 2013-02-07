<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>Jugadores</title>
</head>
<body>
	<c:if test="${empty jugadores}">
		<h3>
			<c:out value="no hay jugadores" />
		</h3>
	</c:if>
	<c:url var="eliminarJugador" value="/jugadores/del" />
	<ul>
		<c:forEach var="jugador" items="${jugadores}">
			<li>
				${jugador.nombre} 
				${jugador.apellido}
				<button jugador-id="${jugador.id}" onclick="deleteJugador(this); return false;"  >Eliminar Jugador</button>
			</li>
		</c:forEach>
	</ul>
	<div id="deleteResponse"></div>
</body>
</html>