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
		
		function valida_clubes(){
			var v=document.getElementsByName("visita");
			var l=document.getElementsByName("local");
			
			
			if (l[0].value.length == 0 || v[0].value.length == 0){
				alert("Debe elegirse algún club");	
				return false;
			} else if (v[0].value == l[0].value){
				alert("Deben elegirse clubes diferentes");	
				return false;
			}
			
			return true;
		}
		
		function valida_jugadores_habilitados()
		{
			valida_jugadores("checkbox_local");
			valida_jugadores("checkbox_visita");
		
		}
		
		
		function valida_jugadores(tag_name_origen){
			
			var checkboxes = document.getElementsByName(tag_name_origen); //Array que contiene los checkbox

			  var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados

			  for (var x=0; x < checkboxes.length; x++) {
			   if (checkboxes[x].checked) {
			    cont = cont + 1;
			   }
			  }
			 
			
						
			if (cont > 4 && cont < 12){
				return true;
			}
			if (tag_name_origen == "checkbox_local"){
			alert("Debe haber entre 5 y 12 jugadores habilitados para jugar en el equipo local");
			}else{alert("Debe haber entre 5 y 12 jugadores habilitados para jugar en el equipo visitante");}
		}
		
		 function valida_arbitros(){
			
			var checkboxes = document.getElementsByName("checkbox_arbitros"); //Array que contiene los checkbox

			  var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados

			  for (var x=0; x < checkboxes.length; x++) {
			   if (checkboxes[x].checked) {
			    cont = cont + 1;
			   }
			  }
			 
			
			  				
			if (cont == 0){
				alert("Debe seleccionarse al menos un árbitro");
				return true;	
			}
			
			
		
		}
		
		function cargarDatos()
		{
			if (valida_arbitros())
				{return false;}
			var meses = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
			var f=new Date();

			document.getElementById("fecha_reemplaza").innerHTML='<input name="Fecha" disabled type="text" value="'+f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear()+'">';
			var l=document.getElementsByName("local");
			var local = $("local");//getElementsByName
			local = $("#local");//getElementsById
			local = $(".local");//getElementsByClass
			("ul li",local).text("pepe");//todos los elementos a dentro de li
			/**
			<div id="local">
				<ul>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			*/
			
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
			jugadores +='<table class="twelve">';
			jugadores +='<thead>';
			jugadores +='<tr>';
			jugadores +='<th>'+titulo_tabla+'</th>';
			jugadores +='</tr>';
			jugadores +='</thead>';
			jugadores +='<tbody>';
			
			for (var x=0; x < ch_l.length; x++) 
			{
			  if (ch_l[x].checked) 
			  		{
			  		jugadores += '<tr>';
					jugadores +='<td><input name="e_visita" disabled type="text" value="'+ch_l[x].getAttribute("title")+'"></td>';
					jugadores +='</tr>';
					}
			}
			jugadores +='</tbody>';
			jugadores +='</table>';
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
						<option></option>
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
						<option></option>
						<c:forEach items="${clubes}" var="club" varStatus="stat">
							<option>${club.nombre}</option>
						</c:forEach>
						</select>
					</select>
					<div class="custom dropdown">
						<a href="#" class="current"> Visita </a> <a href="#" class="selector"></a>
						<ul>
							<li>Equipo 1</li>
							<li>Equipo 2</li>
							<li>Equipo 3</li>
						</ul>
					</div>
				</form>
				<div class="row">
					<div class="two columns offset-by-ten">
						<a class="round button" href="#simple2" onClick="valida_clubes()">Siguiente</a>
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
							<label for="checkbox4"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox5" title="Jugador 5"> Jugador 5</label>
							<label for="checkbox4"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox6" title="Jugador 6"> Jugador 6</label>
							<label for="checkbox4"><input name="checkbox_local" type="checkbox" CHECKED id="checkbox7" title="Jugador 7"> Jugador 7</label>
						</div>
						<div class="five columns end">
							<p>Visita</p>
							<label for="checkbox6"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox66" title="Jugador 1"> Jugador 1</label>
							<label for="checkbox7"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox76" title="Jugador 2"> Jugador 2</label>
							<label for="checkbox8"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox86" title="Jugador 3"> Jugador 3</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox96" title="Jugador 4"> Jugador 4</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox93" title="Jugador 5"> Jugador 5</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox92" title="Jugador 6"> Jugador 6</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox91" title="Jugador 7"> Jugador 7</label>
							<label for="checkbox9"><input name="checkbox_visita" type="checkbox" CHECKED id="checkbox94" title="Jugador 8"> Jugador 8</label>
						</div>
					</div>

						<div class="row">
							<div class="two columns">
								<a class="round button" href="#simple2">Volver</a>
							</div>
							<div class="two columns offset-by-eight">
								<a class="round button" href="#simple2"  onClick="valida_jugadores_habilitados()">Siguiente</a>
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
								<div id="jugadoresLocales" class="twelve columns">
								</div>
								<div id="jugadoresVisita" class="twelve columns">
								</div>
								<div id="arbitros" class="twelve columns">
								</div>
								
								 <p id="jugadores_locales__habilitados">Jugadores locales</p>
								 
								 <p id="jugadores_visitantes_habilitados">Jugadores Visitantes</p>
							 
								<p id="arbitros_asignados">Arbitros desigandos</p>
								
							</div>
						
						</div>
						<div class="row">		
							
							<div class="two columns">
								<a class="alert button" href="<c:url value="/partidos/nuevo" />">Cancelar</a>
								
							</div>
							<div class="two columns offset-by-eight">
								<a class="success button" href="#simple2">Iniciar Partido</a>
							</div>
						</div>

				</li>
		</ul>


	</div>
</div>
</content>