<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content>
	 <label for="club" class="hint">Seleccione un club</label>
	    
	    <select id="clubSelector" name="club" id="club">
				<c:forEach var="club" items="${clubes}">
					<option data-content="${club.nombre}" label="${club.nombre}"
						value="${club.id}" />${club.nombre}
				</c:forEach>
		</select>
		
		<div id="jugadoresClub"></div>
	    

</content>