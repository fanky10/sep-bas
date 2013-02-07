<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<h1 align="center">SEPBas</h1>

<!-- 
	dos formas de decir lo mismo jaja
 -->
<div align="left">
	<c:url var="jugadoresURL" value="/jugadores/list"/>
	<a href="${jugadoresURL}">Ver Jugadores</a> 
	<c:url var="agregarJugador" value="/jugadores/add"/>
	<a href="${agregarJugador}">Agregar Nuevo Jugador</a>
</div>