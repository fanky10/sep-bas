<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<script type="text/javascript" src="<c:url value="/js/app.js"/>"></script>
</content>
<content tag="jscript">
	<%-- some javascript written --%>
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
						<select style="display: none;" id="customDropdown">
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
						style="display: none;" id="customDropdown">
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