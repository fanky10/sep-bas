<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Club</title>
</head>
<body>
	<h1>Agregar Club</h1>
	

  <form:form action="${pageContext.request.contextPath}/clubes/add" modelAttribute="clubForm" method="POST">
      <fieldset>
      	<form:hidden path="id" />
	    <label for="name"> Nombre: </label> 
	    <span class="input"> 
	      <form:input path="nombre" />
	      <form:errors path="nombre" id="nombreError"/>
	    </span>  
	    <br/>
	    <br/>
	   <input name="submit" type="submit" value="Guardar" />
     </fieldset>
  </form:form>
</body>
</html>