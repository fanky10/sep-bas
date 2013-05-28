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
	var config = {
			'vecesTyped':0, //nro jugadores seleccionados equipo 1
			};
		$(document).ready(function(){
			
			$('#clubLocal').on('change',function(e){
				$(this).attr("isselected",true);
				$(this).attr("class","selected");
			});
			
			$('#divClubLocal').bind('keyup', function(e) {
				changeSelectedValue(e);
			 });
			
			function changeSelectedValue(e){
				config.vecesTyped++;
				console.log('typed: '+config.vecesTyped);
				if(config.vecesTyped%2 == 0){
					console.log('end!');
					return false;
				}
				if(e.keyCode == 13){//enter
					$('#clubLocal').trigger('change');
					return false;
				}
				var searching = String.fromCharCode(e.keyCode);
				var selectedElements = $("#divClubLocal ul li.selected");
				$("#divClubLocal ul li.selected").removeClass("selected");
				var filtered = $("#divClubLocal ul li").filter(function(){
					var currentText = $(this).text();
					var found = $(this).text().slice(0, searching.length).toLowerCase() == searching.toLowerCase(); 
					return found;
				});
				//we have everything found, but if there's something selected then select the next one
				var length = filtered.length;
				filtered.each(function(index,element){
					var isSelected = $(element).attr("isselected") == 'true';
					console.log('current element: '+$(element).text() + " isSelected: "+isSelected+" from: "+length+" idx "+index);
					
					if(isSelected && index == length-1){//we are the last one and we are selected!
						console.log('soy la unica opc');
						$(element).attr("class","selected");
						return false;//nothing to do
					}else if(isSelected && index<length-1){//selected but not the last one
						//remove properties
						$(element).attr("isselected",false);	
						console.log('not the last one! give me another');
						//continue (:
					}else{//not selected first one
						console.log('first timer!');
						$(element).attr("isselected",true);
						$(element).attr("class","selected");
						return false;
					}
				});
				var current = filtered.filter(".selected").filter(':first');
		        $("#divClubLocal a.current").text(current.text());
		        e.stopPropagation();
		        e.preventDefault();
		        
			}
			
		});
		
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
		</dl>

		<ul class="tabs-content">
			<li class="active" id="simple1Tab">
				<h5>Aquí seleccionaremos el local y el visitante</h5>

				<form class="custom">
					<!-- Equipo local-->
					<label for="customDropdown">Local</label> 
					<select id="clubLocal" style="display: none;" id="customDropdown">						
					<c:forEach items="${clubes}" var="club" varStatus="stat">
						<option value="${club.nombre}">${club.nombre}</option>
					</c:forEach>
					</select>
					<div id="divClubLocal" class="custom dropdown">
						<a id="currentClubLocal" href="#" class="current"> Local </a> 
						<a href="#" class="selector"></a>
						<ul>
							<li>Equipo 1</li>
							<li>Equipo 2</li>
							<li>Equipo 3</li>
						</ul>
					</div>
					

					<!-- Equipo visitante-->
					<label for="customDropdown">Visita</label> 
						<select style="display: none;" id="customDropdown">
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
			</li>
			<li id="simple2Tab">
				<h5>Jugadores Habilitados</h5>
				<div class="row">
					<div class="six columns">
						<p>Local</p>
						<label for="checkbox1"><input name="l1" type="checkbox"
							CHECKED id="checkbox1"> Jugador 1</label> <label for="checkbox2"><input
							name="l2" type="checkbox" CHECKED id="checkbox2"> Jugador
							2</label> <label for="checkbox3"><input name="l3" type="checkbox"
							CHECKED id="checkbox3"> Jugador 3</label> <label for="checkbox4"><input
							name="l4" type="checkbox" CHECKED id="checkbox4"> Jugador
							4</label>
					</div>
					<div class="end">
						<p>Visita</p>
						<label for="checkbox6"><input name="v1" type="checkbox"
							CHECKED id="checkbox6"> Jugador 1</label> <label for="checkbox7"><input
							name="V2" type="checkbox" CHECKED id="checkbox7"> Jugador
							2</label> <label for="checkbox8"><input name="V3" type="checkbox"
							CHECKED id="checkbox8"> Jugador 3</label> <label for="checkbox9"><input
							name="V4" type="checkbox" CHECKED id="checkbox9"> Jugador
							4</label>
					</div>
				</div>
			</li>
			<li id="simple3Tab">
				<h5>Aquí seleccionaremos los árbitros del encuentro</h5> <label
				for="radio4"><input name="radio2" type="radio" id="radio4">
					Arbitro 1</label> <label for="radio5"><input name="radio2"
					type="radio" id="radio5"> Arbitro 2</label> <label for="radio6"><input
					name="radio2" type="radio" id="radio6"> Arbitro 3</label> <input
				name="" type="submit" value="Iniciar partido">
				</form>
			</li>
		</ul>


	</div>
</div>
</content>