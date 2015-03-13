<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>
</content>
<content tag="jscript">
	<script>
		$(function() {
			$("#datePickerfechaNacimiento").datepicker({
				onSelect : function(textoFecha, objDatepicker) {
					//on select do something!
				}
			});
		
		});
	</script>
	<script>
		$(function() {
			$("#datePickerfechaAlta").datepicker({
				onSelect : function(textoFecha, objDatepicker) {
					//on select do something!
				}
			});
		
		});
	</script>
</content>
<content tag="bodyContent">
<div class="content">
	<div class="row">
		<div class="twelve columns">
			<h3>Nuevo Jugador</h3>
                        <form:form action="${pageContext.request.contextPath}/jugadores/add" modelAttribute="jugadorForm" method="POST">
                            <fieldset>
                            <legend>Datos Personales</legend>
                            <form:hidden path="id" />
                             <label for="name"> Nombre: </label> 
                                <span class="input"> 
                                <form:input path="nombre" />
                                <form:errors path="nombre" id="nombreError"/>
                                </span>
                                <br/>
                                <br/>
                                <label for="apellido"> Apellido: </label> 
                                <span class="input"> 
                                <form:input path="apellido" />
                                <form:errors path="apellido" id="apellidoError"/>
                                </span>
                                <br/>
                                <br/>
                                <label for="fechaNacimiento"> Fecha Nacimiento: </label> 
                                <span class="input"> 
                                <input id="datePickerfechaNacimiento" type="text" name="fechaNacimiento" id="fechaNacimiento">
                                <form:errors path="fechaNacimiento" id="fechaNacimientoError"/>
                                </span>
                                <br/>
                                <br/>
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
                                <br/>
                                
                                <br/>
                             <input name="submit" type="submit" class="button tiny" value="Guardar" />
                             <a href="<c:url value="/jugadores/list"/>" class="button tiny"> Volver</a>
                        </fieldset>
                </form:form>
  </div></div></div>
  </content>