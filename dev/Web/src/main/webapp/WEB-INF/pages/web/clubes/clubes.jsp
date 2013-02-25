<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content>
	<c:if test="${empty clubes}">
		<h3>
			<c:out value="no hay clubes" />
		</h3>
	</c:if>
	<c:url var="eliminarClub" value="/jugadores/del" />
	<ul>
		 <label for="club" class="hint">Seleccione un club</label>
	    <span class="input">
			<form:select path="club">
				<!-- 
				<c:set var="optionSelected" value=""></c:set>
				
				<c:if test="${selectedFilterLocation == 'All'}">
					<c:set var="optionSelected" value="selected='selected'"></c:set>
				</c:if>
				<option data-content="1" value="-1" ${optionSelected}>All Locations</option>
					-->
				<c:forEach var="club" items="${clubes}">
					<option data-content="${club.nombre}" label="${club.nombre}"
						value="${club.id}" />${club.nombre}
					</c:forEach>
			</form:select>
	    </span>
	</ul>
	<div id="deleteResponse"></div>
</content>