<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
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
<title>Clubes</title>
</head>
<body>
	<c:if test="${empty clubes}">
		<h3>
			<c:out value="no hay clubes" />
		</h3>
	</c:if>
	<c:url var="eliminarClub" value="/jugadores/del" />
	<ul>
		<c:forEach var="club" items="${clubes}">
			<li>
				${club.nombre} 
				<button club-id="${club.id}" onclick="deleteClub(this); return false;"  >Eliminar Club</button>
			</li>
		</c:forEach>
	</ul>
	<div id="deleteResponse"></div>
</body>
</html>