<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Jugador</title>
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
	    <label for="name"> Apellido: </label> 
	    <span class="input"> 
	      <form:input path="apellido" />
	      <form:errors path="apellido" id="apellidoError"/>
	    </span>  
	    <br/>
	    <br/>
	   <input name="submit" type="submit" value="Guardar" />
     </fieldset>
  </form:form>
</body>
</html>