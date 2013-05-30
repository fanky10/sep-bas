<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<script type="text/javascript" src="<c:url value="/js/app.js"/>"></script>
</content>
<content tag="jscript">
	<%-- some javascript written --%>
	<script>
		var idClubUno = $("#club1").val();
		//TODO: buscar el json.s
		//var juegores = {[{nombre:pepe,apellido:pepe},{nombre..}]}
		$.foreach(function(){
			//loop jugadores,
			$("#selector").append("jugador.id...");
		});
		
		
		function cargarDatos()
		{
			document.getElementById("fecha_reemplaza").innerHTML='<input name="Fecha" disabled type="text" value="'+Date()+'">';
			var l=document.getElementsByName("local");
			
			document.getElementById("equipo_local").innerHTML='<input name="e_local" disabled type="text" value="'+l[0].value+'">';
			var v=document.getElementsByName("visita");
			document.getElementById("equipo_visita").innerHTML='<input name="e_visita" disabled type="text" value="'+v[0].value+'">';
			
			crear_tabla("checkbox_local","jugadores_locales__habilitados","Jugadores en cancha de: " + l[0].value);
			crear_tabla("checkbox_visita","jugadores_visitantes_habilitados","Jugadores en cancha de: " +v[0].value);
			crear_tabla("checkbox_arbitros","arbitros_asignados","Arbitros designados");
			
		}
		
		function crear_tabla(tag_name_origen,tag_id_destino,titulo_tabla)
		{
			var ch_l = document.getElementsByName(tag_name_origen);
			var jugadores = '';
			jugadores +='<table class="twelve">'
			jugadores +='<thead>'
			jugadores +='<tr>'
			jugadores +='<th>'+titulo_tabla+'</th>'
			jugadores +='</tr>'
			jugadores +='</thead>'
			jugadores +='<tbody>'
			
			for (var x=0; x < ch_l.length; x++) 
			{
			  if (ch_l[x].checked) 
			  		{
			  		jugadores += '<tr>';
					jugadores +='<td><input name="e_visita" disabled type="text" value="'+ch_l[x].getAttribute("title")+'"></td>';
					jugadores +='</tr>';
					}
			}
			jugadores +='</tbody>'
			jugadores +='</table>'
			document.getElementById(tag_id_destino).innerHTML=jugadores;
		}
	</script>
</content>
<content tag="bodyContent">
<div class="row">
	<div class="twelve columns">
		<h3>Inicializar Partido</h3>

		<dl class="tabs">
			<dd class="active">
				<a href="#simple1"> Equipos</a>
			</dd>
			<dd>
				<a href="#simple2"> Jugadores Habilitados</a>
			</dd>
			<dd class="hide-for-small">
				<a href="#simple3"> Árbitros</a>
			</dd>
			<dd class="hide-for-small">
				<a href="#simple4" > Resumen</a>
			</dd>
		</dl>

		<ul class="tabs-content">
			<li class="active" id="simple1Tab">
				<h5>Aquí seleccionaremos el local y el visitante</h5>

				<form class="custom">


					<!-- Equipo local-->
					<label for="customDropdown">Local</label> 
						<select style="display: none;" id="customDropdown" name="local">
						<c:forEach items="${clubes}" var="club" varStatus="stat">
							<option>${club.nombre}</option>
						</c:forEach>
						</select>
					<div class="custom dropdown">
						<a href="#" class="current"> Local </a> <a href="#"
							class="selector"></a>
						<ul>
							<li>Equipo 1</li>
							<li>Equipo 2</li>
							<li>Equipo 3</li>
						</ul>
					</div>

					<!-- Equipo visitante-->
					<label for="customDropdown">Visita</label> <select
						style="display: none;" id="customDropdown" name="visita">
						<option SELECTED>Equipo 1</option>
						<option>Equipo 2</option>
						<option>Equipo 3</option>
					</select>
					<div class="custom dropdown">
						<a href="#" class="current"> Visita </a> <a href="#"
							class="selector"></a>
						<ul>
							<li>Equipo 1</li>
							<li>Equipo 2</li>
							<li>Equipo 3</li>
						</ul>
					</div>
				</form>
				<div class="row">
					<div class="two columns offset-by-ten">
						<a class="round button" href="#simple2">Siguiente</a>
					</div>
				</div>
			</li>
			<li id="simple2Tab">
				<h5>Jugadores Habilitados</h5>
				<div class="row">
						<div class="six columns">
							<p>Local</p>
							<label for="checkbox1"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox1" title="Jugador 1"> Jugador 1</label>
							<label for="checkbox2"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox2" title="Jugador 2"> Jugador 2</label>
							<label for="checkbox3"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox3" title="Jugador 3"> Jugador 3</label>
							<label for="checkbox4"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox4" title="Jugador 4"> Jugador 4</label>
						</div>
						<div class="five columns end">
							<p>Visita</p>
							<label for="checkbox6"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox6" title="Jugador 1"> Jugador 1</label>
							<label for="checkbox7"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox7" title="Jugador 2"> Jugador 2</label>
							<label for="checkbox8"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox8" title="Jugador 3"> Jugador 3</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox9" title="Jugador 4"> Jugador 4</label>
						</div>
					</div>

						<div class="row">
							<div class="two columns">
								<a class="round button" href="#simple2">Volver</a>
							</div>
							<div class="two columns offset-by-eight">
								<a class="round button" href="#simple2">Siguiente</a>
							</div>
						</div>
			</li>
			<li id="simple3Tab"> 
					<h5> Aquí seleccionaremos los árbitros del encuentro</h5>
							<label for="checkbox6"> <input name="checkbox_arbitros" type="checkbox" CHECKED id="checkbox10" title="Arbitro 1">Árbitro 1</label>
							<label for="checkbox7"> <input name="checkbox_arbitros" type="checkbox" CHECKED id="checkbox11" title="Arbitro 2">Árbitro 2</label>
							<label for="checkbox8"> <input name="checkbox_arbitros" type="checkbox" CHECKED id="checkbox12" title="Arbitro 3">Árbitro 3</label>
							<label for="checkbox9"> <input name="checkbox_arbitros" type="checkbox" CHECKED id="checkbox113" title="Arbitro 4">Árbitro 4 </label>
					<!--<input name="" type="submit" value="Iniciar partido"> -->
					<!--</form>	 -->			
						<div class="row">
							<div class="two columns">
								<a class="round button" href="#simple2">Volver</a>
							</div>
							<div class="two columns offset-by-eight">
								<a class="round button" href="#simple2" onClick="cargarDatos()">Finalizar</a>
							</div>
						</div>

				</li>
				<li id="simple4Tab"> 
					<h5> Resumen </h5>
						<div class="row">
							<div class="two mobile-one columns">
								<label class="right inline">Fecha :</label>
							</div>
							<div class="ten mobile-three columns">
								<p id="fecha_reemplaza">Fecha del partido</p>
							</div>	
								
						</div>
						<div class="row">
							<div class="two mobile-one columns">
								<label class="right inline">Local :</label>
							</div>
							<div class="ten mobile-three columns">
								<p id="equipo_local">Local</p>
							</div>	
								
						</div>
						<div class="row">
							<div class="two mobile-one columns">
								<label class="right inline">Visita :</label>
							</div>
							<div class="ten mobile-three columns">
								<p id="equipo_visita">Visita</p>
							</div>	
								
						</div>
						<div class="row">
							<div class="twelve columns">
								 <p id="jugadores_locales__habilitados">Jugadores locales</p>
								 
								 <p id="jugadores_visitantes_habilitados">Jugadores Visitantes</p>
							 
								<p id="arbitros_asignados">Arbitros desigandos</p>
								
							</div>
						
						</div>
						<div class="row">		
							
							<div class="two columns">
								<a class="round button" href="#simple2">Volver</a>
							</div>
							<div class="two columns offset-by-eight">
								<a class="alert button" href="#simple2">Iniciar Partido</a>
							</div>
						</div>

				</li>
		</ul>


	</div>
</div>
</content>