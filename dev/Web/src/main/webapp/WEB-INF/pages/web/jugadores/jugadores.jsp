<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Jugadores</title>
</head>
<body>
	
	<!-- navigation  -->
	<div class="breadcrums">
		<div class="row">
			<div class="twelve columns">
				<ul class="inline-list">
					<li><a href="#">Home</a></li>
					<li>></li>
					<li>Home</li>
				</ul>
			</div>
		</div>
	</div>
	
    <div class="content">
    <div class="row">
    <div class="twelve columns">
		<c:if test="${empty jugadores}">
			<div class="twelve columns">
                <hr class="sin-margin-top" />

            </div>
            <div class="twelve columns">
                <h3>Proximamente Jugadores...</h3>
            </div>
		</c:if>
		<div class="row">
	        <div class="two columns">
	            <h5>Nombre</h5>
	        </div>
	        <div class="two columns">
	            <h5>Apellido</h5>
	        </div>
	        <div class="four columns">
	        </div>
	        <div class="four columns">
	        </div>
	    </div>
		<c:forEach var="jugador" items="${jugadores}">
			<div class="row">
			        <div class="two columns">
			            <h5>${jugador.nombre}</h5>
			        </div>
			        <div class="two columns">
			            <h5>${jugador.apellido}</h5>
			        </div>
			        <div class="two columns" align="center">
			        	<a href="#"><img alt="Editar" jugador-id="${jugador.id}" src="<c:url value="/images/soft-scraps-edit-icon.png" />" ></a>
			        </div>
			        <div class="two columns" align="center">
			        	<a href="#"><img alt="Editar" jugador-id="${jugador.id}" onclick="deleteJugador(this); return false;" src="<c:url value="/images/soft-scraps-delete-icon.png" />" ></a>
			        </div>
			        <div class="four columns" align="center">
			        	
			        </div>
			    </div>
		</c:forEach>
		
		<div id="deleteResponse"></div>
	</div>
	</div>
	</div>
</body>
</html>