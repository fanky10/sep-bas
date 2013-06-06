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
	//this is my superScript plugin!!
	    (function($){
	        $.fn.extend({	            
	            //pass the options variable to the function
	            customDropdown: function(options) {
					//Set the default values, use comma to separate the settings, example:
  					var defaults = {
      					opt:1,
      					targetLabel:$("#divClubLocal a.current"),
      					targetSelect:$('#clubLocal')      						
					}
      
      				var options = $.extend(defaults, options);
					return this.each(function() {
					        var o = options;
					        var obj = $(this);
					        obj.bind('keyup',function(e){
					        	if(e.keyCode == 13){//enter
									o.targetSelect.trigger('change');
									return false;
								}
								
								var searching = String.fromCharCode(e.keyCode);
								var selectedElements = $("ul li.selected",obj);
								selectedElements.removeClass("selected");
								var filtered = $("ul li",obj).filter(function(){
									var currentText = $(this).text();
									var found = $(this).text().slice(0, searching.length).toLowerCase() == searching.toLowerCase(); 
									return found;
								});
								
								//we have everything found, but if there's something selected then select the next one
								var length = filtered.length;
								filtered.each(function(index,element){
									var isSelected = $(element).attr("isselected") == 'true';
									
									if(isSelected && index == length-1){//we are the last one and we are selected!
										$(element).attr("class","selected");
										return false;//nothing to do
									}else if(isSelected && index<length-1){//selected but not the last one
										//remove properties
										$(element).attr("isselected",false);//i'm not the last one, give me another!
										//continue (:
									}else{//not selected first one --> first timer!
										$(element).attr("isselected",true);
										$(element).attr("class","selected");
										return false;
									}
								});
								//in case there are several
								var current = filtered.filter(".selected").filter(':first');
						        o.targetLabel.text(current.text());
								
					        });
					    
					});
	        	}
	        });
    	})(jQuery);
	</script>
	
	<script>
		$('#divClubLocal').customDropdown({targetLabel:$("#divClubLocal a.current"),
				targetSelect:$('#clubLocal')});
		$('#divClubVisita').customDropdown({targetLabel:$("#divClubVisita a.current"),
			targetSelect:$('#clubLocal')});
		$('#clubLocal').on('change',function(e){
			var element = $("#divClubLocal ul li.selected");
			$(element).attr("isselected",true);
			//TODO: change clubVisita values, avoid select same element
			//TODO: get listed players! --> ajax request
		});
		$(document).ready(function(){
			
			
			
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
					<select style="display: none;" id="customDropdown">						
						<c:forEach items="${clubes}" var="club" varStatus="stat">
							<option value="${club.nombre}">${club.nombre}</option>
						</c:forEach>
					</select>
					<div id="divClubLocal" class="custom dropdown">
						<a id="currentClubLocal" href="#" class="current"> Local </a> 
						<a href="#" class="selector"></a>
						<ul>
							<c:forEach items="${clubes}" var="club" varStatus="stat">
							<li>${club.nombre}</li>
							</c:forEach>
						</ul>
					</div>
					
					<!-- Equipo visitante-->
					<label for="customDropdown">Visita</label>
					<select style="display: none;" id="customDropdown">						
						<c:forEach items="${clubes}" var="club" varStatus="stat">
							<option value="${club.nombre}">${club.nombre}</option>
						</c:forEach>
					</select>
					<div id="divClubVisita" class="custom dropdown">
						<a href="#" class="current"> Visita </a> <a href="#"
							class="selector"></a>
						<ul>
							<c:forEach items="${clubes}" var="club" varStatus="stat">
								<li>${club.nombre}</li>
							</c:forEach>
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