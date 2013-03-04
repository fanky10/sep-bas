<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script>
	
	$(document).ready(
			function() {
				var config = {
						'jugadoresSeleccionadosEquipo1':0, //nro jugadores seleccionados equipo 1
						'jugadoresSeleccionadosEquipo2':0,
						'maxJugadoresSeleccionados':5 //solo puede seleccionar ese numero de jugadores por equipo
						};
				//this works!!
				$('.chkEquipo1').live('click',function(){
					//could be checked here... and do nothing at all.
					if(config.jugadoresSeleccionadosEquipo1==config.maxJugadoresSeleccionados){
						if(this.checked){
							this.checked = false;
							return ;
							
						}
					}
					
					if(this.checked){
						config.jugadoresSeleccionadosEquipo1++;
					}else{
						config.jugadoresSeleccionadosEquipo1--;
					}
				});
				
				$('.chkEquipo2').live('click',function(){
					//could be checked here... and do nothing at all.
					if(config.jugadoresSeleccionadosEquipo2==config.maxJugadoresSeleccionados){
						if(this.checked){
							this.checked = false;// no lo dejamos seleccionar jaja
							return ;
						}
					}
					if(this.checked){
						config.jugadoresSeleccionadosEquipo2++;
					}else{
						config.jugadoresSeleccionadosEquipo2--;
					}
					if(config.jugadoresSeleccionadosEquipo2==config.maxJugadoresSeleccionados){
						//deshabilitar a los demas (:	
					}
					console.log("currentSelectedElements! "+config.currentSelectedElements);
				});
				// TODO: check numero de jugadores seleccionados
				// TODO: bind event onlick chkbox 
			}
	);
	
</script>