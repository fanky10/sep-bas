<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<!DOCTYPE html>

<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8" />

<!-- Set the viewport width to device width for mobile -->
<meta name="viewport" content="width=device-width" />

<title>SEPBas | Home</title>

<!-- Included CSS Files (Compressed) -->
<link rel="stylesheet" href="<c:url value="/css/foundation.css" />">
<link rel="stylesheet" href="<c:url value="/css/app.css" />">


<!-- Author -->
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/modernizr.foundation.js" />"></script>

</head>
<body>

	<!-- head -->
	<div class="logo">
		<div class="row">
			<div class="one columns isotipo">
				<a href="#" title="Sistema De estadisticos locos">
					<img src="/una/imagen.png" /></a>
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
					<li><a href="#" title="Nuevo Cuarto">Nuevo Cuarto</a></li>
					<li>|</li>
					<li><a href="#" title="Opcion 1">Opcion 1</a></li>
					<li>|</li>
					<li><a href="#" title="Opcion 2">Opcion 2</a></li>
					<li>|</li>
				</ul>
			</div>
		</div>
	</div>
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
</body>
</html>