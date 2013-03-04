<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<!-- 
	dos formas de decir lo mismo jaja
 -->
<!-- head -->
<div class="logo">
	<div class="row">
		<div class="one columns isotipo">
			<a href="#" title="Sistema De estadisticos locos"> <img
				src="/una/imagen.png" /></a>
		</div>
		<div class="eleven columns">
			<h2 class="slogan">Contribuyendo estadisticas desde 2013</h2>
			<h1 class="logotipo">Sistema Estadistico de Partidos de Basquet</h1>
		</div>
	</div>
</div>

<!-- menu  -->
<div class="menu">
	<div class="row">
		<div class="twelve columns menu-wrapper">
			<ul class="nav link-list">
				<li><a href="<c:url value="/jugadores/list" />" title="Ver Jugadores">Ver Jugadores</a></li>
				<li>|</li>
				<li><a href="<c:url value="/clubes/list" />" title="Ver Clubes">Ver Clubes</a></li>
				<li>|</li>
				<li><a href="<c:url value="/partidos/add" />" title="Nuevo Partido">Nuevo Partido</a></li>
				<li>|</li>
				<li><a href="<c:url value="/cuartos/iniciar" />" title="Nuevo Partido">Nuevo Cuarto</a></li>
			</ul>
		</div>
	</div>
</div>