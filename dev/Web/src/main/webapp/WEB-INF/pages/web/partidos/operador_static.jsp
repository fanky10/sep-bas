<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<!DOCTYPE html>
<!-- Head -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Set the viewport width to device width for mobile -->
<meta name="viewport" content="width=device-width" />
<title>SEP-Bas Sistema estadistico de partidos de basquet</title>
<link href="images/foundation/orbit/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
<link rel="stylesheet" href="<c:url value="/css/operador/foundation.css"/>">
<!-- Included CSS Files (Compressed) -->
<link rel="stylesheet" href="<c:url value="/css/operador/app.css"/>">
<link rel="stylesheet" href="<c:url value="/css/operador/estiloOperador.css"/>">
<link rel="stylesheet" href="<c:url value="/css/operador/jquery-ui.css"/>">
<script type="text/javascript">
	APP_CTX = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="<c:url value="/js/operador/vendor/jquery-1.9.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/operador/vendor/jquery-ui.js"/>"></script>



<script type="text/javascript" src="<c:url value="/js/operador/vendor/jquery.foundation.reveal.js"/>"></script>

<!-- Fin cod de prueba -->
<!--<script src="javascripts/jquery.js"></script> -->
<!--<script src="javascripts/foundation.min.js"></script> ESTE JODE Y MUCHO -->
<script type="text/javascript" src="<c:url value="/js/operador/app.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/operador/vendor/modernizr.foundation.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/operador/javascript_SepBas.js"/>"></script>
<style>
	.ui-menu { width: 150px; z-index:1000; }
</style>
</head>
<body onLoad="inicializaVariables();">
<!--</script>-->
<!-- HEADER -->
<div class="row">
  <div class="two columns"><img src="Logo_SEPBas_sin_cintas.png" alt="Sistema Estadistico de Partidos de Basquet" height="91" width="91"></div>
  <div class="one columns"></div>
  <div class="six columns" >
    <table class="twelve">
      <tr>
        <th>Equipos</th>
        <th>1&ordm; Cuarto</th>
        <th>2&ordm; Cuarto</th>
        <th>3&ordm; Cuarto</th>
        <th>4&ordm;Cuarto</th>
        <th>Total</th>
      </tr>
      <tbody>
        <tr>
          <th class="local"><script>document.write(clubLocal.nombre);</script></th>
          <td ><div id="local_primer_cuarto">0</div></td>
          <td ><div id="local_segundo_cuarto">0</div></td>
          <td ><div id="local_tercer_cuarto">0</div></td>
          <td ><div id="local_cuarto_cuarto">0</div></td>
          <td class="local"><strong>
            <div id="puntosLocal">0</div>
            </strong></td>
        </tr>
      <tbody>
        <tr>
          <th class="visita"><script>document.write(clubVisitante.nombre);</script></th>
          <td ><div id="visita_primer_cuarto">0</div></td>
          <td ><div id="visita_segundo_cuarto">0</div></td>
          <td ><div id="visita_tercer_cuarto">0</div></td>
          <td ><div id="visita_cuarto_cuarto">0</div></td>
          <td class="visita"><strong>
            <div id="puntosVisitante"> 0</div>
            </strong></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="one columns"></div>
  <div class="two columns" id="nroCuarto">
    <h1>
      <script>document.write(v_nroCuarto + "er-C");</script>
    </h1>
  </div>
</div>
<!-- CABCHA Y BOTONERA -->
<div class="row">
  <!-- BOTONERA VISITA -->
  <div class = "two columns" id="Link_Faltas_Local"> </div>
  <div class="eight columns">
    <div class="fondo_cancha">
      <div class="media_cancha_izquierda">
        <ul id="menu_visita">
          <!--	<li> -->
          <script>
								for (var n=0;n<3;n++)
								{ 
									switch(n)
									{
										case 0:var Tipo = "SIMPLE"
										break;
										case 1:var Tipo = "DOBLE"
										break;
										default:var Tipo = "TRIPLE"
									}
									document.write('<li><a href="#">' + Tipo + '</a>');	
									document.write('<ul>');
									for (var i=0;i<5;i++)
									{ 
										document.write('<li>');
										document.write('<div id="jugadorVisita_'+n+i+'"><a href="#">Jugador Visita '+i+'</a></div>');
										document.write('<ul>');
										for (var j=0;j<5;j++)
										{ 
											if (i !=j)
											{
												document.write('<li>');
												document.write('<div id="jugadorVisita_'+n+i+j+'"><a href="#">Jugador Visita '+j+'</a></div>');
												document.write('</li>');
											}															
										}
										document.write('</ul>');
										document.write('</li>');
									}
									document.write('</ul>');
									document.write('</li>');
								}
								</script>
        </ul>
      </div>
      <div class="media_cancha_derecha">
        <ul id="menu_local" style="z-index:100">
          <!--<li> -->
          <script>							
									for (var n=0;n<3;n++){ 
										switch(n)
										{
											case 0:var Tipo = "SIMPLE"
											break;
											case 1:var Tipo = "DOBLE"
											break;
											default:var Tipo = "TRIPLE"
										}
										document.write('<li><a href="#">' + Tipo + '</a>');	
										document.write('<ul>');
										for (var i=0;i<5;i++){ 
											document.write('<li>');
											document.write('<div id="jugadorLocal_'+n+i+'"><a href="#">Jugador Local '+i+'</a></div>');
											document.write('<ul>');
												for (var j=0;j<5;j++){ 
													if (i !=j){
													document.write('<li>');
													document.write('<div id="jugadorLocal_'+n+i+j+'"><a href="#">Jugador Local '+j+'</a></div>');
													document.write('</li>');
													}															
												}
										document.write('</ul>');
										document.write('</li>');
										}
									document.write('</ul>');
									document.write('</li>');
									}
								</script>
        </ul>
      </div>
    </div>
  </div>
  <!-- BOTONERA VISITA -->
  <div class="two columns" id="Link_Faltas_Visita"> </div>
</div>
<div class="row">
  <div class="row">
    <div class="twelve columns"><br>
    </div>
  </div>
  <div class="row">
    <div class="four columns"><a href="#"  id="BotonSustitucionesLocal" class="button" data-reveal-id="SustitucionesLocal">Cambios local</a></div>
    <div class="four columns"><a id="BotonFinCuarto" class="button" data-reveal-id="FinCuarto">Finalizar de cuarto</a></div>
    <div class="four columns"><a href="#"  id="BotonSustitucionesVisita" class="button" data-reveal-id="SustitucionesVisita">Cambios Visita</a></div>
  </div>
</div>
<div class="row">
    <div class="twelve columns"><br>
    </div>
  </div>
<div class="row">
<table width="100%" border="0">
  <tr>
    <th><div id="EquipoFila1">...</div></th>
    <th><div id="JugadaFila1">...</div></th>
    <th><div id="EliminaFila1">...</div></th>
  </tr>
  <tr>
    <th><div id="EquipoFila2"></div></th>
    <th><div id="JugadaFila2"></div></th>
    <th><div id="EliminaFila2"></div></th>
  </tr>
  <tr>
   <th><div id="EquipoFila3"></div></th>
    <th><div id="JugadaFila3"></div></th>
    <th><div id="EliminaFila3"></div></th>
  </tr>
</table>

</div>

<!--<a href="#" onClick="javascript:Evento('Equipoo','Un doblee','Eliminarr')">Prueba Eventooos</a>-->
<!-- FOOTER -->
<!-- 	<div class="row">
			<div class="five columns">
				<table >
				 
					<tr>
					  <th class="local">Nº</th>
					  <th class="local">Equipo</th>
					  <th class="local">PTS</th>
					  <th class="local">REB</th>
					  <th class="local">AS</th>
			 
					</tr>
				  
					<script>
						$.each( jugadoresLocales, function(k,v){
						if(v.enCancha == 1){
						var puntos = v.dobles  *  2  +  v.triples * 3 + v.simples
						document.write("<tr>");
						document.write("<td>" + v.numero + "</td>");
						document.write("<td>" + v.nombre + "</td>");
						document.write("<td>" +  puntos  +  "</td>");
						document.write("<td>" + v.rebotes + "</td>");
						document.write("<td>" + v.asistencias + "</td>");
						document.write("</tr>");
						}
						});
					</script>
				  
				  
				</table>
				

			
			</div>
			
			<div class="two columns">
				<br>	
				<p><a href="#" class="tiny button boton_local">Sustituciones</a></p>
				<p><a href="#" class="tiny button boton_local">Planilla</a></p>
				<p><a href="#" class="tiny button boton_local">Jugada a jugada</a></p>
				
			</div>
			<div class="five columns" >
				<table>
				  	<tr>
					  <th class="visita">Nº</th>
					  <th class="visita">Equipo</th>
					  <th class="visita">PTS</th>
					  <th class="visita">REB</th>
					  <th class="visita">AS</th>
				
					</tr>
				  	<script>
						$.each( jugadoresVisita, function(k,v){
						if(v.enCancha == 1){
						var puntos = v.dobles  *  2  +  v.triples * 3 + v.simples
						document.write("<tr>");
						document.write("<td>" + v.numero + "</td>");
						document.write("<td>" + v.nombre + "</td>");
						document.write("<td>" +  puntos  +  "</td>");
						document.write("<td>" + v.rebotes + "</td>");
						document.write("<td>" + v.asistencias + "</td>");
						document.write("</tr>");
						}
						});
					</script>
				  
				</table>
			</div>	
		</div> -->
<div id="SustitucionesLocal" class="reveal-modal xlarge">
</div>
<div id="SustitucionesVisita" class="reveal-modal xlarge"> </div>
<div id="FinCuarto" class="reveal-modal xlarge">
  <div class="row">
    <div class="row">
      <div class="two columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>
      <div class="two columns"></div>
      <div class="four columns">
        <h4 style="text-align:center">Cuarto Finalizado</h4>
      </div>
      <div class="four columns"></div>
    </div>
  </div>
  <div class="row">
    <div class="twelve columns"><br>
    </div>
  </div>
  <div class="row">
    <div class="four columns"><a href="#" class="button" id="botonEstadisticasLocal">Estadisticas
      <script> document.write(clubLocal.nombre); </script>
      </a></div>
    <div class="four columns"></div>
    <div class="four columns"><a href="#" class="button" id="botonEstadisticasVisita">Estadisticas
      <script> document.write(clubVisitante.nombre); </script>
      </a></div>
  </div>
  <div class="row">
    <div class="twelve columns"><br>
    </div>
  </div>
  <div class="row">
    <div class="two columns"><a href="#" class="alert button" onClick="salirCambioCuarto()">Cancelar</a></div>
    <div class="ten columns"></div>
    <div class="two columns"><a href="#" class="button" onClick="cambioCuarto()">Aceptar</a></div>
  </div>
</div>
</div>
<div id="estadisticasLocal" class="reveal-modal xlarge">
  <div class="row">
    <div class="row">
      <div class="four columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>
      <div class="four columns">
        <h5 style="text-align:center">Estadisticas
          <script> document.write(clubLocal.nombre); </script>
        </h5>
      </div>
      <div class="four columns"><a href="javascript:imprSelec('estadisticasLocal')"><img src="images/imprimir.jpg" height="38" width="130"></a></div>
    </div>
    <div class="row">
      <div id="TablaEstadisticasLocal"></div>
    </div>
    <div class="row">
      <div class="twelve columns"><a href="#" class="button" id="volverEntreCuartosLocal">Volver</a></div>
    </div>
  </div>
</div>
<div id="estadisticasVisita" class="reveal-modal xlarge">
  <div class="row">
    <div class="row">
      <div class="four columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>
      <div class="four columns">
        <h5 style="text-align:center">
        Estadisticas
        <script> document.write(clubVisitante.nombre); </script>
        </h5>
      </div>
      <div class="four columns"><a href="javascript:imprSelec('estadisticasVisita')"><img src="images/imprimir.jpg" height="38" width="130"></a></div>
    </div>
    <div class="row">
      <div id="TablaEstadisticasVisita"></div>
    </div>
    <div class="row">
      <div class="twelve columns"><a href="#" class="button" id="volverEntreCuartosVisita">Volver</a></div>
    </div>
  </div>
</div>

<div id="FinPartido" class="reveal-modal xlarge"> 
<div class="row">
  <div class="row">
    <div class="four columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>
    <div class="four columns">
      <h4 style="text-align:center">Partido Finalizado </h4>
    </div>
    <div class="four columns"></div>
  </div>
</div>
<div class="row">
  <div class="twelve columns"><br>
  </div>
</div>
<div class="row">
  <div class="four columns"><h2><script> document.write(clubLocal.nombre); </script></h2></div>
  <div class="four columns"></div>
  <div class="four columns"><h2><script> document.write(clubVisitante.nombre); </script></h2></div>
</div>
<div class="row">
  <div class="four columns"><div id="PuntosTotalLocal"><h1>69</h1></div></div>
  <div class="four columns"><h1>-</h1></div>
  <div class="four columns"><div id="PuntosTotalVisita"><h1>104</h1></div></h1></div>
</div>
<div class="row">
  <div class="twelve columns"><br>
  </div>
</div>
<div class="row">
  <div class="two columns"><a href="#" class="alert button" id="cancelaFinPartido">Cancelar</a></div>
  <div class="ten columns"></div>
  <div class="two columns"><a href="#" class="button" onClick="finPartido()">Aceptar</a></div>
</div>
</div>
</div>

</body>
</html>