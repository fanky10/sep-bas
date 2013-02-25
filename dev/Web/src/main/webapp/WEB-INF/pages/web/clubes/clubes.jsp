<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content> 
	<c:if test="${empty clubes}">
		<h3>
			<c:out value="no hay clubes" />
		</h3>
	</c:if> <c:url var="eliminarClub" value="/jugadores/del" />
	<ul>
		<c:forEach var="club" items="${clubes}">
			<li>${club.nombre}
				<button club-id="${club.id}"
					onclick="deleteClub(this); return false;">Eliminar Club</button>
			</li>
		</c:forEach>
	</ul>
	<div id="deleteResponse"></div>
</content>