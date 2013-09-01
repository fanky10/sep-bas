<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	 <link rel="stylesheet" href="/Web/css/estiloOperador.css"> 
</content>
<content tag="jscriptlibs">
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>
</content>
<content tag="jscript">
	<%-- some javascript written --%>
</content>
<content tag="bodyContent">
	<%-- some html written --%>
	
	
	<div class="row">
		
		<div class="two columns"><img src="/Web/images/foundation/orbit/Logo SEPBas sin cintas.png" height="91" width="91"></div>
		<div class="one columns"></div>
		<div class="six columns" >
	
			<table class="twelve">
				 <tr>
				  <th>Equipos</th>
				  <th>1º Cuarto</th>
				  <th>2º Cuarto</th>
				  <th>3º Cuarto</th>
				  <th>4º Cuarto</th>
				  <th>Total</th>
				</tr>
			  <tbody>
				<tr>
				  <th class="local">EE UU</th>
				  <td >23</td>
				  <td >20</td>
				  <td >0</td>
				  <td >0</td>
				  <td class="local"><strong>43</strong></td>
				</tr>
				  <tbody>
				<tr>
				  <th class="visita">Argentina</th>
				  <td >15</td>
				  <td >25</td>
				  <td >0</td>
				  <td >0</td>
				  <td class="visita"><strong>40</strong></td>
				</tr>
			  </tbody>
			</table>


		</div>
		
		
		<div class="one columns"></div>
		<div class="two columns"><h1>11:42</h1></div>
	</div>

	<div class = "row">
		<div class = "two columns">
				<h4 class="local"> Local</h4>
				<table class="two">
			  <thead>
				<tr>
				  <th colspan="2" class="local">Totales</th>
			    </tr>
			  </thead>
			  <tbody>
				<tr>
				  <td>Perdidas</td>
				  <td>0</td>
				 </tr>
				<tr>
				  <td>Recuperos</td>
				  <td>0</td>
				</tr>
				<tr>
				  <td>Faltas</td>
				  <td>0</td>
				</tr>
				<tr>
				  <td>Sust.</td>
				  <td>0</td>
				</tr>
			  </tbody>
			</table>
			</div>
			
			<div class = "eight columns">
				<div class="fondo_cancha">
					<div class="semi_circulo_izquierda"></div>
					<div class="semi_circulo_derecha"></div>
					
				</div>			
			</div>
			
			<div class = "two columns">
				<h4 class = "visita"> Visita </h4>
				<table class="two" >
				  <thead>
					<tr>
					  <th colspan="2" class="visita">Totales</th>
				    </tr>
				  </thead>
				  <tbody>
					<tr>
					  <td>Perdidas</td>
					  <td>0</td>
					 </tr>
					<tr>
					  <td>Recuperos</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>Faltas</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>Sust.</td>
					  <td>0</td>
					</tr>
				  </tbody>
				</table>

			</div>
		</div>
		<div class="row">
			<div class="five columns">
				<table >
				 
					<tr>
					  <th class="local">Nº</th>
					  <th class="local">Equipo</th>
					  <th class="local">PTS</th>
					  <th class="local">REB</th>
					  <th class="local">AS</th>
						<th class="local">PR</th>
						<th class="local">PP</th>
						<th class="local">FR</th>  
					</tr>
				  
					<tr>
					  <td>99</td>
					  <td>Karl Malone</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>33</td>
					  <td>Scottie Pippen</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					   <td>68</td>
					  <td>Magic Johnson</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>32</td>
					  <td>Michael Jordan</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>15</td>
					  <td>Horace Grant</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
				  
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
						<th class="visita">PR</th>
						<th class="visita">PP</th>
						<th class="visita">FR</th>  
					</tr>
				  
					<tr>
					  <td>99</td>
					  <td>Luis Scola</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>33</td>
					  <td>Emanuel Ginobili</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					   <td>68</td>
					  <td>Pablo Prigioni</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>32</td>
					  <td>Carlos Delfino</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
					<tr>
					  <td>15</td>
					  <td>Andrés Nocioni</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					  <td>0</td>
					</tr>
				  
				</table>
			</div>	
		</div>
	
	
</content>
