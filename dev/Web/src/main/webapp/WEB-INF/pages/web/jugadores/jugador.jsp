<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Jugador</title>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>

<script>
	$(function() {
		$("#datePickerfechaNacimiento").datepicker({
			onSelect : function(textoFecha, objDatepicker) {
				//on select do something!
			}
		});
	});
</script>
</head>
<body>
	<h1>Agregar Jugador</h1>
	

  <form:form action="${pageContext.request.contextPath}/jugadores/add" modelAttribute="jugadorForm" method="POST">
      <fieldset>
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
	    <label for="numero"> Numero: </label> 
	    <span class="input"> 
	      <form:input path="numero" />
	      <form:errors path="numero" id="numeroError"/>
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
	   <input name="submit" type="submit" value="Guardar" />
     </fieldset>
  </form:form>
</body>
</html>