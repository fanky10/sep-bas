<script type="text/javascript">
  $(document).ready(function() {
    $("#BotonSustitucionesLocal").click(function() {
		
      $("#SustitucionesLocal").reveal();
	  
    });
  });
</script>



	<script>
	<!-- Hard Code  clubLocal:id,nombre  ; clubVisitante:id,nombre -->
	var nroCuarto = 1;	
	var clubLocal=
		{
			id:1,
			nombre:'Estados Unidos',
			puntos:0
		
		}
		var clubVisitante=
		{
			id:2,
			nombre:'Argentina',
			puntos:0
		}
	<!-- Hard Code  jugadoresLocales:id,nombre,numero,enCancha,simples,dobles,triples,rebotes,asistencias,Perdidas  -->
	var jugadoresLocales = [
   {
		'id':1,
		'equipo':1,
		'nombre':'Karl Malone',
		'numero':'39',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':2,
		'equipo':1,
		'nombre':'Scottie Pippen',
		'numero':'33',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':3,
		'equipo':1,
		'nombre':'Magic Johnson',
		'numero':'98',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':4,
		'equipo':1,
		'nombre':'Michael Jordan',
		'numero':'32',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
   {
		'id':5,
		'equipo':1,
		'nombre':'Horace Grant',
		'numero':'15',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
   {
		'id':6,
		'equipo':1,
		'nombre':'El jugador suplente',
		'numero':'15',
		'enCancha':0,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
   {
		'id':7,
		'equipo':1,
		'nombre':'El jugador suplente 2',
		'numero':'15',
		'enCancha':0,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   }
	];
	<!-- Hard Code  jugadoresVisita:id,nombre,numero,enCancha,simples,dobles,triples,rebotes,asistencias,Perdidas  -->
	var jugadoresVisita = [
   {
		'id':7,
		'equipo':2,
		'nombre':' 	Luis Scola',
		'numero':'86',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':8,
		'equipo':2,
		'nombre':'Emanuel Ginobili',
		'numero':'87',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':9,
		'equipo':2,
		'nombre':'Pablo Prigioni',
		'numero':'65',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
    {
		'id':10,
		'equipo':2,
		'nombre':'Carlos Delfino',
		'numero':'32',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
   {
		'id':11,
		'equipo':2,
		'nombre':'Andrés Nocioni',
		'numero':'15',
		'enCancha':1,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   },
   {
		'id':12,
		'equipo':2,
		'nombre':'Matias Fernandez',
		'numero':'21',
		'enCancha':0,
		'simples':0,
		'dobles':0,
		'triples':0,
		'rebotes':0,
		'asistencias':0,
		'Perdidas':0
   }
	];
	<!-- Javascript functions  -->	

	var IndiceJugadorLocal = new Array(5); 
	var IndiceJugadorVisita = new Array(5); 
	function inicializaVariables()
	{
		console.log("Inicializando el partido");	
		cargaJugadores();		
		cargaHTML();
	};
	
	function cargaJugadores()
	{
	// Cargo los jugadores locales
	var j=0;
	for(i in jugadoresLocales) 
	{
		if (jugadoresLocales[i].enCancha == 1) 
		{ 
			IndiceJugadorLocal[j] = i;
			j++;
		}
	}
	// Cargo los jugadores visitantes
	j=0;
	for(i in jugadoresVisita) 
	{
		if (jugadoresVisita[i].enCancha == 1) 
		{ 
			IndiceJugadorVisita[j] = i;
			j++;
		}
	}
	console.log('Jugadores Cargados');
	}
	function cargaHTML()
	{
	for (var a=0;a<3;a++)
	{ 		
		switch(a)
		{
			case 0:var Tipo = "SIMPLE"
			break;
			case 1:var Tipo = "DOBLE"
			break;
			default:var Tipo = "TRIPLE"
		}
		for(var b=0;b<5;b++) 
		{
			document.getElementById('jugadorLocal_'+a+b).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "',' -1 ','"+ jugadoresLocales[IndiceJugadorLocal[b]].equipo + "','"+ IndiceJugadorLocal[b] +  "'" +')">' + jugadoresLocales[IndiceJugadorLocal[b]].nombre + '</a>';void 0;			
			for(var c=0;c<5;c++)
			{
				if (b != c ) 
				{ 
					document.getElementById('jugadorLocal_'+a+b+c).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "','" + IndiceJugadorLocal[b] + "','"+ jugadoresLocales[IndiceJugadorLocal[c]].equipo + "','"+ IndiceJugadorLocal[c] +  "'" +')">' + jugadoresLocales[IndiceJugadorLocal[c]].nombre + '</a>';void 0;							
				
				}
			}
		}
		for(var b=0;b<5;b++) 
		{
			document.getElementById('jugadorVisita_'+a+b).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "',' -1 ','"+ jugadoresVisita[IndiceJugadorVisita[b]].equipo + "','"+ IndiceJugadorVisita[b] +  "'" +')">' + jugadoresVisita[IndiceJugadorVisita[b]].nombre + '</a>';void 0;			
			for(var c=0;c<5;c++)
			{
				if (b != c ) 
				{ 
					document.getElementById('jugadorVisita_'+a+b+c).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "','" + IndiceJugadorVisita[b] + "','"+ jugadoresVisita[IndiceJugadorVisita[c]].equipo + "','"+ IndiceJugadorVisita[c] +  "'" +')">' + jugadoresVisita[IndiceJugadorVisita[c]].nombre + '</a>';void 0;							
				
				}
			}
					
		}				
	}	
	console.log("Html cargado");	
};
	
	
	function Sustitucion()
	{
		$('#SustitucionesLocal').trigger('reveal:close');
		//Recupero el indice del jugador que sale
		for(i=0;i<document.SustitucionLocal.JugadorLocalSale.length;i++){
			if(document.SustitucionLocal.JugadorLocalSale[i].checked) {
				marcado=i;
			};
		};
		var IndiceJugadorSale = document.SustitucionLocal.JugadorLocalSale[marcado].value;
		//Recupero el indice del jugador que entra
		for(i=0;i<document.SustitucionLocal.JugadorLocalEntra.length;i++){
			if(document.SustitucionLocal.JugadorLocalEntra[i].checked){
				marcado=i;
				
			};
		};
		var IndiceJugadorEntra = document.SustitucionLocal.JugadorLocalEntra[marcado].value;
		
		jugadoresLocales[IndiceJugadorSale].enCancha =0;
		jugadoresLocales[IndiceJugadorEntra].enCancha =1;
		cargaJugadores();		
		cargaHTML();
		};
	
	function lanzamienmto(TipoLanzamiento, IDAsistencia, Equipo, posicion) {
		  console.log("Tipo de lanzamiento: " + TipoLanzamiento + ", Asistencia: " + IDAsistencia + ",Equipo: "+ Equipo + ",Posicion: "+ posicion);
		  var CantPuntosLanzamiento = 0;
		  	  switch (Equipo) {
					case "1":
					 switch (TipoLanzamiento) {
							case "SIMPLE":
								CantPuntosLanzamiento = 1;
								jugadoresLocales[posicion].simples++; 
								break;
							case "DOBLE":
								CantPuntosLanzamiento = 2;
								jugadoresLocales[posicion].simples++; 
								break;
							case "TRIPLE":
								CantPuntosLanzamiento = 3;
								jugadoresLocales[posicion].simples++; 
								break;
							
						};	
						
						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") {
							jugadoresLocales[IDAsistencia].asistencias++;
						};				
						clubLocal.puntos += CantPuntosLanzamiento;
						document.getElementById('puntosLocal').innerHTML= clubLocal.puntos;void 0
						break;	
						
					case "2":
						
						 switch (TipoLanzamiento) {
							case "SIMPLE":
								CantPuntosLanzamiento = 1;
								jugadoresVisita[posicion].simples++; 
								break;
							case "DOBLE":
								CantPuntosLanzamiento = 2;
								jugadoresVisita[posicion].simples++; 
								break;
							case "TRIPLE":
								CantPuntosLanzamiento = 3;
								jugadoresVisita[posicion].simples++; 
								break;
							
						};	
						
						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") {
							jugadoresVisita[IDAsistencia].asistencias++;
						};				
						clubVisitante.puntos += CantPuntosLanzamiento;
						document.getElementById('puntosVisitante').innerHTML= clubVisitante.puntos;void 0
						break;	
				};			
		};
  
  	//semi_circulo_izquierda
		$(function(){ 
		// arma el menu on ready
			$("#menu_visita" ).menu();
			$('#menu_local').menu();
			$('#menu_visita').hide();
			$('#menu_local').hide();
		
        var menuStatus = 0;	
		
		
		
		jQuery(".media_cancha_izquierda").click(function(e){
			
			
			if($('#menu_local').css("display") != "none"){ 	
				$('#menu_local').hide();
			};
			
			var menu = $('div ul',$(this));
			if(menu.css("display") == "none"){
				var posX = $(this).offset().left;
				var	posY = $(this).offset().top;					
				var pX = (e.pageX - posX);
				var pY = (e.pageY - posY);
				menu.show('fast', function() { 	
					menu.css("position","absolute").css("top", pY).css("left", pX); 
				}); 
			}else {
				
				menu.hide();
			}
		
		});
		jQuery(".media_cancha_derecha").click(function(e){
			
			if($('#menu_visita').css("display") != "none"){ 	
				$('#menu_visita').hide();
			};
			
			var menu = $('div ul',$(this));
			if(menu.css("display") == "none"){
				var mediaCanchaIzqWidth = $('.media_cancha_izquierda').width(); 
				var posX = $(this).offset().left;
				var	posY = $(this).offset().top;					
				var pX = (e.pageX - posX + mediaCanchaIzqWidth);
				var pY = (e.pageY - posY);
					menu.show('fast', function() { 	
						menu.css("position","absolute").css("top", pY).css("left", pX); 
					}); 
			}else {
				
				menu.hide();
			}
		
		});
		
		
		
		
  	//semi_circulo_izquierda
		
	
		<!-- NO BORRAR SIRVE PARA HACER PRUEBAS !-->
		/*  $('#menu_local').on({
            click: function() {
            event.preventDefault();
            console.log('item clicked');
          },
          mouseenter: function() {
            console.log('enter!');
            menustatus = 1;
          },
          mouseleave: function() {
            console.log('leave!');
            menustatus = 0;
          }
        });  */
		
		/*$('#menu_local a').click(function(){
		// alert("click on a");
		
		}); */
	
		

		


	});// Cierro document ready
  </script>