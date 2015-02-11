$(document).ready(function() {
	$("#BotonSustitucionesLocal").click(function() {
		$("#SustitucionesLocal").reveal();
	});
	
	$("#BotonSustitucionesVisita").click(function() {
		$("#SustitucionesVisita").reveal();
	});
	
	$("#BotonFinCuarto").click(function() {
		$("#FinCuarto").reveal();
	});
	$("#botonEstadisticasLocal").click(function() {
		cargaHtmlEstadisticasLocal();
		$("#estadisticasLocal").reveal();
	});
	$("#botonEstadisticasVisita").click(function() {
		cargaHtmlEstadisticasVisita();
		$("#estadisticasVisita").reveal();
	});
	
	$("#volverEntreCuartosLocal").click(function() {
		$("#FinCuarto").reveal();
	});
		$("#volverEntreCuartosVisita").click(function() {
		$("#FinCuarto").reveal();
	});
	
	$("#cancelaFinPartido").click(function() {
		$("#FinCuarto").reveal();
	});

});

<!-- HARD CODE JSON -->
var jugadoresLocalesJSON = [
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Randy",
	"apellido":"Brown",
	"numero":1,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":1

},
{	
		'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Jud",
	"apellido":"Buechler",
	"numero":30,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":2
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Burrel",
	"apellido":"Scott",
	"numero":24,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":3
},
{	
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Ron",
	"apellido":"Harper",
	"numero":9,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":4
	
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Jordan",
	"apellido":"Michael",
	"numero":23,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":5
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Steve",
	"apellido":"Kerr",
	"numero":25,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":6
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Toni",
	"apellido":"Kukoc",
	"numero":7,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":7
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Luc",
	"apellido":"Longley",
	"numero":13,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":8
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Scottie",
	"apellido":"Pippen",
	"numero":33,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":9
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Dennis",
	"apellido":"Rodman",
	"numero":91,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":10
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Dickey",
	"apellido":"Simpkins",
	"numero":8,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":11
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Bill",
	"apellido":"Wennington",
	"numero":34,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":12
}
];
<!-- Hard Code  jugadoresVisita:id,nombre,numero,enCancha,simples,dobles,triples,rebotes,asistencias,Perdidas  -->
var jugadoresVisitaJSON = [
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Kobe",
	"apellido":"Bryant",
	"numero":8,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":13
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	
	"nombre":"Derek",
	"apellido":"Fisher",
	"numero":2,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":14
	
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Greg",
	"apellido":"Foster",
	"numero":40,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":15
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Rick",
	"apellido":"Fox",
	"numero":17,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":16
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	
		"nombre":"Devean",
	"apellido":"George",
	"numero":3,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":17
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	
		"nombre":"Horace",
	"apellido":"Grant",
	"numero":54,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":18
	
	
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Ron",
	"apellido":"Harper",
	"numero":4,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":19
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Robert",
	"apellido":"Horry",
	"numero":5,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":20
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Tyronn",
	"apellido":"Lue",
	"numero":10,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":21
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Mark",
	"apellido":"Madsen",
	"numero":35,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":22
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Shaquille",
	"apellido":"O&#44;Neal",
	"numero":34,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":23
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Brian",
	"apellido":"Shaw",
	"numero":20,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":24
}
];


var jugadoresLocalesSELECCIONADOSJSON = [
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Dennis",
	"apellido":"Rodman",
	"numero":91,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":10
},{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Scottie",
	"apellido":"Pippen",
	"numero":33,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":9
},{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Toni",
	"apellido":"Kukoc",
	"numero":7,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":7
},{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Jordan",
	"apellido":"Michael",
	"numero":23,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":5
},{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
	"nombre":"Randy",
	"apellido":"Brown",
	"numero":1,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":1

}
];
<!-- Hard Code  jugadoresVisita:id,nombre,numero,enCancha,simples,dobles,triples,rebotes,asistencias,Perdidas  -->
var jugadoresVisitasSELECCIONADOSJSON = [
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Mark",
	"apellido":"Madsen",
	"numero":35,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":22
},{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
		"nombre":"Shaquille",
	"apellido":"O&#44;Neal",
	"numero":34,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":23
},{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	
		"nombre":"Horace",
	"apellido":"Grant",
	"numero":54,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":18
	
	
},{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Greg",
	"apellido":"Foster",
	"numero":40,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":15
},{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	"nombre":"Kobe",
	"apellido":"Bryant",
	"numero":8,
	"fechaNacimiento":"2013-03-15",
	"estado":"HABILITADO",
	"id":13
}
];
<!-- FIN HARD CODE JSON -->

<!-- Hard Code -->
var v_nroCuarto = 1;

var v_local_primer_cuarto = 0;
var v_local_segundo_cuarto = 0;
var v_local_tercer_cuarto = 0;
var v_local_cuarto_cuarto = 0;
var v_visita_primer_cuarto = 0;
var v_visita_segundo_cuarto = 0;
var v_visita_tercer_cuarto = 0;
var v_visita_cuarto_cuarto = 0;

					
var clubLocal=
{
	id:1,
	nombre:'Chicago Bulls',
	puntos:0
}
var clubVisitante=
{
	id:2,
	nombre:'Angeles Lakers',
	puntos:0
}

var jugadoresLocales = [];
/* var jugadoresLocales = [
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{	
		'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{	
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Chicago Bulls',
               "localidad":"Chicago",
               "id":1
            },
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
	'Perdidas':0,
	'Faltas':0
}
];*/
<!-- Hard Code  jugadoresVisita:id,nombre,numero,enCancha,simples,dobles,triples,rebotes,asistencias,Perdidas  -->

var jugadoresVisita = [];

/*var jugadoresVisita = [
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
	'id':11,
	'equipo':2,
	'nombre':'Andr&eacute;s Nocioni',
	'numero':'15',
	'enCancha':1,
	'simples':0,
	'dobles':0,
	'triples':0,
	'rebotes':0,
	'asistencias':0,
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
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
	'Perdidas':0,
	'Faltas':0
},
{
	'club':{
               'nombre':'Angeles Lakers',
               'localidad':'Los Angeles',
               'id':2
            },
			
	'id':13,
	'equipo':2,
	'nombre':'Ricardo Iorio',
	'numero':'32',
	'enCancha':0,
	'simples':0,
	'dobles':0,
	'triples':0,
	'rebotes':0,
	'asistencias':0,
	'Perdidas':0,
	'Faltas':0
}
];*/

<!-- Javascript functions  -->	

var IndiceJugadorLocal = new Array(5); 
var IndiceJugadorVisita = new Array(5); 
var cant_suplentes_local = 0;
var cant_suplentes_visita = 0;
var Form_suplentes_locales;
var Faltas_Local;
var Faltas_Visita;	
function inicializaVariables()
{
	console.log("Inicializando el partido");	
	cargaJugadores();		
	cargaHTML();
};

function salirCambioCuarto()
{
$('#FinCuarto').trigger('reveal:close');
};
function cargaHtmlEstadisticasLocal()
{
var EstadisticasLocal = '';
EstadisticasLocal += '<table width="100%" border="0">';
EstadisticasLocal += '<tr>';
EstadisticasLocal += '<th scope="col">Numero</th>';
EstadisticasLocal += '<th scope="col">Nombre</th>';
EstadisticasLocal += '<th scope="col">Simples</th>';
EstadisticasLocal += '<th scope="col">Dobles</th>';
EstadisticasLocal += '<th scope="col">Triples</th>';
EstadisticasLocal += '<th scope="col">Asistencias</th>';
EstadisticasLocal += '<th scope="col">Faltas</th>';
EstadisticasLocal += '</tr>';

	for (var n in jugadoresLocales) 
	{
			EstadisticasLocal += '<tr>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].numero+'</td>';
			EstadisticasLocal += '<td>'+jugadoresLocales[n].nombre+'</td>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].simples+'</td>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].dobles+'</td>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].triples+'</td>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].asistencias+'</td>';
			EstadisticasLocal += '<td align="center">'+jugadoresLocales[n].Faltas+'</td>';
			EstadisticasLocal += '</tr>';
		
	};
EstadisticasLocal += '</table>';

document.getElementById('TablaEstadisticasLocal').innerHTML= EstadisticasLocal;
}


function imprSelec(muestra)
{var ficha=document.getElementById(muestra);var ventimp=window.open(' ','popimpr');ventimp.document.write(ficha.innerHTML);ventimp.document.close();ventimp.print();ventimp.close();}

function cargaHtmlEstadisticasVisita()
{
var EstadisticasVisita = '';
EstadisticasVisita += '<table width="100%" border="0">';
EstadisticasVisita += '<tr>';
EstadisticasVisita += '<th scope="col">Numero</th>';
EstadisticasVisita += '<th scope="col">Nombre</th>';
EstadisticasVisita += '<th scope="col">Simples</th>';
EstadisticasVisita += '<th scope="col">Dobles</th>';
EstadisticasVisita += '<th scope="col">Triples</th>';
EstadisticasVisita += '<th scope="col">Asistencias</th>';
EstadisticasVisita += '<th scope="col">Faltas</th>';
EstadisticasVisita += '</tr>';

	for (var n in jugadoresVisita) 
	{
			EstadisticasVisita += '<tr>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].numero+'</td>';
			EstadisticasVisita += '<td>'+jugadoresVisita[n].nombre+'</td>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].simples+'</td>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].dobles+'</td>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].triples+'</td>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].asistencias+'</td>';
			EstadisticasVisita += '<td align="center">'+jugadoresVisita[n].Faltas+'</td>';
			EstadisticasVisita += '</tr>';
		
	};
EstadisticasVisita += '</table>';

document.getElementById('TablaEstadisticasVisita').innerHTML= EstadisticasVisita;
}
function cargaJugadores()
{



//               'nombre':'Chicago Bulls',
//               "localidad":"Chicago",
 //              "id":1
//            },
//	"nombre":"Malone",
//	"apellido":"Karl",
//	"numero":11,
//	"fechaNacimiento":"2013-03-15",
//	"estado":"HABILITADO",
//	"id":1

//alert();

//jugadoresLocalesSELECCIONADOSJSON


for (var i = 0; i < jugadoresLocalesJSON.length; i++) {
    var juega = 0;
    for (var l = 0; l < jugadoresLocalesSELECCIONADOSJSON.length; l++) {
			if(jugadoresLocalesSELECCIONADOSJSON[l].id == jugadoresLocalesJSON[i].id)
				{
					juega = 1;
				};
		};
    jugadoresLocales.push({
       
		id: jugadoresLocalesJSON[i].id,
		equipo: jugadoresLocalesJSON[i].club.id,
		nombre: jugadoresLocalesJSON[i].nombre + ' ' + jugadoresLocalesJSON[i].apellido,
		numero:jugadoresLocalesJSON[i].numero,	
		enCancha:juega,
		simples:0,
		dobles:0,
		triples:0,
		rebotes:0,
		asistencias:0,
		Perdidas:0,
		Faltas:0

       // key: oFullResponse.results[i].label,
        //sortable: true,
        //resizeable: true
    });
};




for (var i = 0; i < jugadoresVisitaJSON.length; i++) {
    var juega = 0;
    for (var l = 0; l < jugadoresVisitasSELECCIONADOSJSON.length; l++) {
			if(jugadoresVisitasSELECCIONADOSJSON[l].id == jugadoresVisitaJSON[i].id)
				{
					juega = 1;
				};
		};
    jugadoresVisita.push({
       
		id: jugadoresVisitaJSON[i].id,
		equipo: jugadoresVisitaJSON[i].club.id,
		nombre: jugadoresVisitaJSON[i].nombre + ' ' + jugadoresVisitaJSON[i].apellido,
		numero:jugadoresVisitaJSON[i].numero,	
		enCancha:juega,
		simples:0,
		dobles:0,
		triples:0,
		rebotes:0,
		asistencias:0,
		Perdidas:0,
		Faltas:0

       // key: oFullResponse.results[i].label,
        //sortable: true,
        //resizeable: true
    });
};

// Cargo los jugadores locales
	var j=0;
	for(i in jugadoresLocales) 
	{
		if (jugadoresLocales[i].enCancha == 1) 
		{ 
			IndiceJugadorLocal[j] = i;
			j++;
		}
		else 
		{
			cant_suplentes_local++;
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
		else
		{
		cant_suplentes_visita++;
		}
		
	}
	console.log('Jugadores Cargados');
	
	console.log('Suplentes Locales ' + cant_suplentes_local);
	console.log('Suplentes Visita  ' + cant_suplentes_visita);
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
					document.getElementById('jugadorLocal_'+a+b+c).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "','" + IndiceJugadorLocal[c] + "','"+ jugadoresLocales[IndiceJugadorLocal[c]].equipo + "','"+ IndiceJugadorLocal[b] +  "'" +')">' + jugadoresLocales[IndiceJugadorLocal[c]].nombre + '</a>';void 0;							
				
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
					document.getElementById('jugadorVisita_'+a+b+c).innerHTML= '<a href="javascript:lanzamienmto(' + "'" +  Tipo + "','" + IndiceJugadorVisita[c] + "','"+ jugadoresVisita[IndiceJugadorVisita[c]].equipo + "','"+ IndiceJugadorVisita[b] +  "'" +')">' + jugadoresVisita[IndiceJugadorVisita[c]].nombre + '</a>';void 0;							
				
				}
			}
								
		}	
	}	
//console.log("Html cargado");	

Form_suplentes_locales='<div class="row">';
Form_suplentes_locales+='<div class="row">';
Form_suplentes_locales+='<div class="four columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>';
Form_suplentes_locales+='<div class="four columns">';
Form_suplentes_locales+='<h4 style="text-align:center">Sustituciones ' + clubLocal.nombre+'</h4>';
Form_suplentes_locales+='</div>';
Form_suplentes_locales+='<div class="four columns"></div>';
Form_suplentes_locales+='</div>';


	Form_suplentes_locales+='<div class="row">';
	Form_suplentes_locales+='<form class="custom" name="SustitucionLocal">';
	Form_suplentes_locales+='<div class="six columns" style="text-align:left" id="formSustLocal">';
	for (var n in jugadoresLocales) {
				if(jugadoresLocales[n].enCancha == 1){
					Form_suplentes_locales+='<label for="JugadorLocalSale"><input name="JugadorLocalSale" type="radio" value="'+ n +'">('+ jugadoresLocales[n].numero +') '+ jugadoresLocales[n].nombre +'</label>';
					};
			};
	Form_suplentes_locales+='</div>';
	Form_suplentes_locales+='<div class="six columns" style="text-align:left">';
	for (var n in jugadoresLocales) {
				if(jugadoresLocales[n].enCancha != 1){
				Form_suplentes_locales+='<label for="JugadorLocalEntra"><input name="JugadorLocalEntra" type="radio" value="'+ n +'">('+  jugadoresLocales[n].numero +') '+ jugadoresLocales[n].nombre +'</label>' 
				};	
		};
	Form_suplentes_locales+='</div>';
	Form_suplentes_locales+='</div>';
	Form_suplentes_locales+='<div class="row"><input onClick="Sustitucion(' + "'" + 'Local'+ "'" + ')" name="Realizar Cambio" class="button" type="button" value="Realizar Sustituci&oacute;n"></form></div>';
	Form_suplentes_locales+='</div>';
		Form_suplentes_locales+='</div>';

	document.getElementById('SustitucionesLocal').innerHTML=Form_suplentes_locales;
	
Form_suplentes_visitantes='<div class="row">';
Form_suplentes_visitantes+='<div class="row">';
Form_suplentes_visitantes+='<div class="four columns"><img src="Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>';
Form_suplentes_visitantes+='<div class="four columns">';
Form_suplentes_visitantes+='<h4 style="text-align:center">Sustituciones ' + clubVisitante.nombre+'</h4>';
Form_suplentes_visitantes+='</div>';
Form_suplentes_visitantes+='<div class="four columns"></div>';
Form_suplentes_visitantes+='</div>';


	Form_suplentes_visitantes+='<div class="row">';
	Form_suplentes_visitantes+='<form class="custom" name="SustitucionVisita">';
	Form_suplentes_visitantes+='<div class="six columns" style="text-align:left" id="formSustVisita">';
	for (var n in jugadoresVisita) {
				if(jugadoresVisita[n].enCancha == 1){
					Form_suplentes_visitantes+='<label for="JugadorVisitaSale"><input name="JugadorVisitaSale" type="radio" value="'+ n +'">('+ jugadoresVisita[n].numero +') '+ jugadoresVisita[n].nombre +'</label>';
					};
			};
	Form_suplentes_visitantes+='</div>';
	Form_suplentes_visitantes+='<div class="six columns" style="text-align:left">';
	for (var n in jugadoresVisita) {
				if(jugadoresVisita[n].enCancha != 1){
				Form_suplentes_visitantes+='<label for="JugadorVisitaEntra"><input name="JugadorVisitaEntra" type="radio" value="'+ n +'">('+ jugadoresVisita[n].numero +') '+ jugadoresVisita[n].nombre +'</label>' 
				};	
		};
	Form_suplentes_visitantes+='</div>';
	Form_suplentes_visitantes+='</div>';
	Form_suplentes_visitantes+='<div class="row"><input onClick="Sustitucion('+ "'"+'Visita'+"'"+')" name="Realizar Cambio" type="button" class="button" value="Realizar Sustituci&oacute;n"></form></div>';
	Form_suplentes_visitantes+='</div>';
	Form_suplentes_visitantes+='</div>';
	document.getElementById('SustitucionesVisita').innerHTML=Form_suplentes_visitantes;
	

Faltas_Local = '<h4 class="local">'+clubLocal.nombre+'</h4>';
for(var b=0;b<5;b++) 
		{
			Faltas_Local+= '<p class="menuFaltas"><a href="javascript:Falta('+ "'"  + jugadoresLocales[IndiceJugadorLocal[b]].equipo + "','"+ IndiceJugadorLocal[b] +  "'" +')">(' +jugadoresLocales[IndiceJugadorLocal[b]].numero +') '+ jugadoresLocales[IndiceJugadorLocal[b]].nombre + '</a></p>';		
		}
document.getElementById('Link_Faltas_Local').innerHTML=Faltas_Local;
	
	
	Faltas_Visita = '<h4 class="visita">'+clubVisitante.nombre+'</h4>';
for(var b=0;b<5;b++) 
		{
			Faltas_Visita+= '<p class="menuFaltas"><a href="javascript:Falta('+ "'"  + jugadoresVisita[IndiceJugadorVisita[b]].equipo + "','"+ IndiceJugadorVisita[b] +  "'" +')">(' + jugadoresVisita[IndiceJugadorVisita[b]].numero +') '+ jugadoresVisita[IndiceJugadorVisita[b]].nombre + '</a></p>';		
		}
document.getElementById('Link_Faltas_Visita').innerHTML=Faltas_Visita;
cargaCuarto();
		
}
	function cargaCuarto()
	{
		document.getElementById('nroCuarto').innerHTML='<h1>' + v_nroCuarto + '&ordm; -C</h1>';
	};
	function cambioCuarto()
	{
		if(v_nroCuarto < 4){
		v_nroCuarto ++;
		cargaCuarto();
		$('#FinCuarto').trigger('reveal:close')}
		else{
			document.getElementById('PuntosTotalLocal').innerHTML= '<h1>' + clubLocal.puntos + '</h1>' ;void 0;
			document.getElementById('PuntosTotalVisita').innerHTML= '<h1>' + clubVisitante.puntos + '</h1>';void 0;

			$("#FinPartido").reveal();
		};
	};
	function Sustitucion(Tipo)
	{	
	var EventoEquipo = '';
	var EventoMensaje = '';
	var marcadoSale = -1;
	var marcadoEntra = -1;
	
	if (Tipo == 'Local'){	
		EventoEquipo = clubLocal.nombre;
		$('#SustitucionesLocal').trigger('reveal:close');
		//Recupero el indice del jugador que sale	
		for(i=0;i<document.SustitucionLocal.JugadorLocalSale.length;i++){
			if(document.SustitucionLocal.JugadorLocalSale[i].checked) {
				marcadoSale=i;
			};
		};
		//Recupero el indice del jugador que entra
		for(i=0;i<document.SustitucionLocal.JugadorLocalEntra.length;i++){
			if(document.SustitucionLocal.JugadorLocalEntra[i].checked){
				marcadoEntra=i;		
			};
		};

		if (marcadoSale != -1 && marcadoEntra !=-1)
		{
			var IndiceJugadorSale = document.SustitucionLocal.JugadorLocalSale[marcadoSale].value;
			var IndiceJugadorEntra = document.SustitucionLocal.JugadorLocalEntra[marcadoEntra].value;
			EventoMensaje = 'Sustitucion: Sale (' +jugadoresLocales[IndiceJugadorSale].numero +') '+jugadoresLocales[IndiceJugadorSale].nombre + ' Entra (' +jugadoresLocales[IndiceJugadorEntra].numero+') '+jugadoresLocales[IndiceJugadorEntra].nombre;
			Evento(EventoEquipo,EventoMensaje,'...');
			jugadoresLocales[IndiceJugadorSale].enCancha =0;
			jugadoresLocales[IndiceJugadorEntra].enCancha =1;
		};

		}else{

		EventoEquipo = clubVisitante.nombre;
		$('#SustitucionesVisita').trigger('reveal:close');
			for(i=0;i<document.SustitucionVisita.JugadorVisitaSale.length;i++){
			//alert(i);
			//alert(document.SustitucionVisita.JugadorVisitaSale[i].checked);
			if(document.SustitucionVisita.JugadorVisitaSale[i].checked) {
				marcadoSale=i;
				
			};
		};
		
		//Recupero el indice del jugador que entra
		for(i=0;i<document.SustitucionVisita.JugadorVisitaEntra.length;i++){
			if(document.SustitucionVisita.JugadorVisitaEntra[i].checked){
				marcadoEntra=i;
				
			};
		};

		if (marcadoSale != -1 && marcadoEntra !=-1)
		{

		var IndiceJugadorSale = document.SustitucionVisita.JugadorVisitaSale[marcadoSale].value;
		var IndiceJugadorEntra = document.SustitucionVisita.JugadorVisitaEntra[marcadoEntra].value;
		EventoMensaje = 'Sustitucion: Sale (' +jugadoresVisita[IndiceJugadorSale].numero+') '+jugadoresVisita[IndiceJugadorSale].nombre + ' Entra ('+jugadoresVisita[IndiceJugadorEntra].numero+') ' +jugadoresVisita[IndiceJugadorEntra].nombre;
		jugadoresVisita[IndiceJugadorSale].enCancha =0;
		jugadoresVisita[IndiceJugadorEntra].enCancha =1;	
		Evento(EventoEquipo,EventoMensaje,'...');
		};

		};
		
		if (marcadoSale != -1 && marcadoEntra !=-1)
		{
		cargaJugadores();		
		cargaHTML();
		};	
	};

	function cancelaEvento(TipoEvento,TipoLanzamiento,IDAsistencia,Equipo,posicion)//tipoEvento,tipoLanzamiento, IDAsistencia, Equipo, posicion
	{
		switch (TipoEvento)
			{
			case "1":
				
				var EventoEquipo = '';
				var EventoMensaje = '';
				var EventoElimina = '...';
				//alert('Hasta aca funco');
				//alert(Equipo);
				
				switch (Equipo) 
				{
					case "1":
						EventoEquipo = clubLocal.nombre;
						EventoMensaje = 'Cancela ' + TipoLanzamiento + ' ('+jugadoresLocales[posicion].numero+') ' + jugadoresLocales[posicion].nombre;
						switch (TipoLanzamiento) 
						{
							case "SIMPLE":
								CantPuntosLanzamiento = 1;
								jugadoresLocales[posicion].simples--; 
								switch(v_nroCuarto){
									case 1:
										v_local_primer_cuarto --;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto --;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto --;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto --;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
										break;
									}
							break;
							case "DOBLE":
								CantPuntosLanzamiento = 2;
								jugadoresLocales[posicion].dobles--; 
								switch(v_nroCuarto){
									case 1:
										v_local_primer_cuarto -= 2;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto -= 2;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto -= 2;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto -= 2;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
										break;
								}
							break;
							case "TRIPLE":
								CantPuntosLanzamiento = 3;
								jugadoresLocales[posicion].triples--; 
								switch(v_nroCuarto)
									{
									case 1:
										v_local_primer_cuarto -= 3;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto -= 3;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto -= 3;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto -= 3;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
									break;
									}
								break;
							}


						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") 
						{
							jugadoresLocales[IDAsistencia].asistencias--;
							EventoMensaje += ' Asistencia ('+jugadoresLocales[IDAsistencia].numero+') ' +jugadoresLocales[IDAsistencia].nombre;		
						};				
						clubLocal.puntos -= CantPuntosLanzamiento;
						document.getElementById('puntosLocal').innerHTML= clubLocal.puntos;void 0
						break;	
														
					case "2":

						EventoEquipo = clubVisitante.nombre;
						EventoMensaje = 'Cancela ' + TipoLanzamiento + ' (' +jugadoresVisita[posicion].numero+') '+ jugadoresVisita[posicion].nombre;
							switch (TipoLanzamiento) {
								case "SIMPLE":
									CantPuntosLanzamiento = 1;
									jugadoresVisita[posicion].simples--; 
										switch(v_nroCuarto)
										{
											case 1:
												v_visita_primer_cuarto --;
												document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
												break;
											case 2:
												v_visita_segundo_cuarto --;
												document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
												break;
											case 3:
												v_visita_tercer_cuarto --;
												document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
												break;
											case 4:
												v_visita_cuarto_cuarto --;
												document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
												break;
										}
								break;
								case "DOBLE":
									CantPuntosLanzamiento = 2;
									jugadoresVisita[posicion].dobles--; 
										switch(v_nroCuarto){
										case 1:
											v_visita_primer_cuarto -= 2;
											document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
											break;
										case 2:
											v_visita_segundo_cuarto -= 2;
											document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
											break;
										case 3:
											v_visita_tercer_cuarto -= 2;
											document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
											break;
										case 4:
											v_visita_cuarto_cuarto -= 2;
											document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
											break;
										}
								break;
								case "TRIPLE":
									CantPuntosLanzamiento = 3;
									jugadoresVisita[posicion].triples--; 

										switch(v_nroCuarto)
										{
										case 1:
											v_visita_primer_cuarto -= 3;
											document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
											break;
										case 2:
											v_visita_segundo_cuarto -= 3;
											document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
											break;
										case 3:
											v_visita_tercer_cuarto -= 3;
											document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
											break;
										case 4:
											v_visita_cuarto_cuarto -= 3;
											document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
											break;
										}
								break;
								}	


						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") 
						{
							jugadoresVisita[IDAsistencia].asistencias--;
							EventoMensaje += ' Asistencia ('+jugadoresVisita[IDAsistencia].numero+') ' +jugadoresVisita[IDAsistencia].nombre;					
						};				
						clubVisitante.puntos -= CantPuntosLanzamiento;
						document.getElementById('puntosVisitante').innerHTML= clubVisitante.puntos;void 0;
						
						break;
							
					}
				Evento(EventoEquipo,EventoMensaje,EventoElimina);
				break;	
			case "2":
				alert('Cancela Sustitucion !!!');
				break;
			case "3":
				var EventoEquipo = '';
				 var EventoMensaje = '';
				 EventoElimina = '...'
		 // var CantPuntosLanzamiento = 0;
		  	  switch (Equipo) {
		  
					case "1":
						EventoEquipo = clubLocal.nombre;
						jugadoresLocales[posicion].Faltas--;
						EventoMensaje = 'Cancela Falta de ('+jugadoresLocales[posicion].numero+') ' + jugadoresLocales[posicion].nombre + ' a ' + jugadoresLocales[posicion].Faltas;
						break;	
				
						
					case "2":
					 	EventoEquipo = clubVisitante.nombre;
						jugadoresVisita[posicion].Faltas--; 
						EventoMensaje = 'Cancela Falta de ('+jugadoresVisita[posicion].numero+') ' + jugadoresVisita[posicion].nombre + ' a ' + jugadoresVisita[posicion].Faltas;				
						break;	
				};		
			Evento(EventoEquipo,EventoMensaje,EventoElimina);
				break;



			}

	};
	
	
	
	function lanzamienmto(TipoLanzamiento, IDAsistencia, Equipo, posicion) {
		  console.log("Tipo de lanzamiento: " + TipoLanzamiento + ", Asistencia: " + IDAsistencia + ",Equipo: "+ Equipo + ",Posicion: "+ posicion);
		  var EventoEquipo = '';
		  var EventoMensaje = '';
		  var EventoElimina = '';
		 EventoElimina = '<a href="javascript:' +"cancelaEvento('"+1+"','"+ TipoLanzamiento +"','"+ IDAsistencia+"','"+ Equipo+"','"+ posicion+"')" +'">Eliminar</a>'
		  var CantPuntosLanzamiento = 0;
		  	  switch (Equipo) {
					case "1":
					EventoEquipo = clubLocal.nombre;
					EventoMensaje = TipoLanzamiento + ' ('+jugadoresLocales[posicion].numero+') ' + jugadoresLocales[posicion].nombre;
					 switch (TipoLanzamiento) {
							case "SIMPLE":
								CantPuntosLanzamiento = 1;
								jugadoresLocales[posicion].simples++; 
								switch(v_nroCuarto){
									case 1:
										v_local_primer_cuarto ++;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto ++;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto ++;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto ++;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
										break;
								}
								break;
							case "DOBLE":
								CantPuntosLanzamiento = 2;
								jugadoresLocales[posicion].dobles++; 
								switch(v_nroCuarto){
									case 1:
										v_local_primer_cuarto += 2;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto += 2;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto += 2;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto += 2;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
										break;
								}
								break;
							case "TRIPLE":
								CantPuntosLanzamiento = 3;
								jugadoresLocales[posicion].triples++; 
								switch(v_nroCuarto){
									case 1:
										v_local_primer_cuarto += 3;
										document.getElementById('local_primer_cuarto').innerHTML= v_local_primer_cuarto;void 0;
										break;
									case 2:
										v_local_segundo_cuarto += 3;
										document.getElementById('local_segundo_cuarto').innerHTML= v_local_segundo_cuarto;void 0;
										break;
									case 3:
										v_local_tercer_cuarto += 3;
										document.getElementById('local_tercer_cuarto').innerHTML= v_local_tercer_cuarto;void 0;
										break;
									case 4:
										v_local_cuarto_cuarto += 3;
										document.getElementById('local_cuarto_cuarto').innerHTML= v_local_cuarto_cuarto;void 0;
										break;
								}
								break;
							
						};	
						
						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") {
							jugadoresLocales[IDAsistencia].asistencias++;
							EventoMensaje += ' Asistencia ('+jugadoresLocales[IDAsistencia].numero+') ' +jugadoresLocales[IDAsistencia].nombre;		
						};				
						clubLocal.puntos += CantPuntosLanzamiento;
						document.getElementById('puntosLocal').innerHTML= clubLocal.puntos;void 0;
						break;	
						
					case "2":
					
					EventoEquipo = clubVisitante.nombre;
					EventoMensaje = TipoLanzamiento + ' ('+ jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre;
						 switch (TipoLanzamiento) {
							case "SIMPLE":
								CantPuntosLanzamiento = 1;
								jugadoresVisita[posicion].simples++; 
								switch(v_nroCuarto){
									case 1:
										v_visita_primer_cuarto ++;
										document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
										break;
									case 2:
										v_visita_segundo_cuarto ++;
										document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
										break;
									case 3:
										v_visita_tercer_cuarto ++;
										document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
										break;
									case 4:
										v_visita_cuarto_cuarto ++;
										document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
										break;
								}
								break;
							case "DOBLE":
								CantPuntosLanzamiento = 2;
								jugadoresVisita[posicion].dobles++; 
								switch(v_nroCuarto){
									case 1:
										v_visita_primer_cuarto += 2;
										document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
										break;
									case 2:
										v_visita_segundo_cuarto += 2;
										document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
										break;
									case 3:
										v_visita_tercer_cuarto += 2;
										document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
										break;
									case 4:
										v_visita_cuarto_cuarto += 2;
										document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
										break;
								}
								break;
							case "TRIPLE":
								CantPuntosLanzamiento = 3;
								jugadoresVisita[posicion].triples++; 
								//case "TRIPLE":
								//CantPuntosLanzamiento = 3;
								//jugadoresLocales[posicion].simples++; 
								switch(v_nroCuarto){
									case 1:
										v_visita_primer_cuarto += 3;
										document.getElementById('visita_primer_cuarto').innerHTML= v_visita_primer_cuarto;void 0;
										break;
									case 2:
										v_visita_segundo_cuarto += 3;
										document.getElementById('visita_segundo_cuarto').innerHTML= v_visita_segundo_cuarto;void 0;
										break;
									case 3:
										v_visita_tercer_cuarto += 3;
										document.getElementById('visita_tercer_cuarto').innerHTML= v_visita_tercer_cuarto;void 0;
										break;
									case 4:
										v_visita_cuarto_cuarto += 3;
										document.getElementById('visita_cuarto_cuarto').innerHTML= v_visita_cuarto_cuarto;void 0;
										break;
								}
								break;
							
						};	
						
						
						var ASISTENCIA = IDAsistencia;
						if(ASISTENCIA.trim() != "-1") {
							jugadoresVisita[IDAsistencia].asistencias++;
							EventoMensaje += ' Asistencia ('+ jugadoresVisita[IDAsistencia].numero+ ') ' +jugadoresVisita[IDAsistencia].nombre;					
						};				
						clubVisitante.puntos += CantPuntosLanzamiento;
						document.getElementById('puntosVisitante').innerHTML= clubVisitante.puntos;void 0;
						break;	
				};
		Evento(EventoEquipo,EventoMensaje,EventoElimina);
		};
	function Evento(Equipo,Mensaje,Eliminar){
	document.getElementById('EquipoFila3').innerHTML = document.getElementById('EquipoFila2').innerHTML;
	document.getElementById('JugadaFila3').innerHTML = document.getElementById('JugadaFila2').innerHTML;
	document.getElementById('EliminaFila3').innerHTML = document.getElementById('EliminaFila2').innerHTML;

	document.getElementById('EquipoFila2').innerHTML = document.getElementById('EquipoFila1').innerHTML;
	document.getElementById('JugadaFila2').innerHTML = document.getElementById('JugadaFila1').innerHTML;
	document.getElementById('EliminaFila2').innerHTML = document.getElementById('EliminaFila1').innerHTML;
				
	document.getElementById('EquipoFila1').innerHTML = Equipo;
	document.getElementById('JugadaFila1').innerHTML = Mensaje;
	document.getElementById('EliminaFila1').innerHTML = Eliminar;
	};
	function Falta(Equipo, posicion) {
		 var EventoEquipo = '';
		 var EventoMensaje = '';
		 EventoElimina = '<a href="javascript:' +"cancelaEvento('"+3+"','"+ -1 +"','"+ -1+"','"+ Equipo+"','"+ posicion+"')" +'">Eliminar</a>'
		 // var CantPuntosLanzamiento = 0;
		  	  switch (Equipo) {
		  
					case "1":
						EventoEquipo = clubLocal.nombre;
						jugadoresLocales[posicion].Faltas++;
						EventoMensaje = jugadoresLocales[posicion].Faltas +' Falta de (' +jugadoresLocales[posicion].numero+') '+ jugadoresLocales[posicion].nombre;
						if(jugadoresLocales[posicion].Faltas == 5)
						{alert('('+jugadoresLocales[posicion].numero+') '+jugadoresLocales[posicion].nombre + ' ha llegado a su 5° falta y debe ser sustuido');
						$("#SustitucionesLocal").reveal();
						};
						
						break;	
				
						
					case "2":
					 EventoEquipo = clubVisitante.nombre;
						jugadoresVisita[posicion].Faltas++; 
						EventoMensaje = jugadoresVisita[posicion].Faltas +' Falta de (' + jugadoresVisita[posicion].numero+') '+jugadoresVisita[posicion].nombre;
						if(jugadoresVisita[posicion].Faltas == 5)
						{alert('('+jugadoresVisita[posicion].numero+') '+jugadoresVisita[posicion].nombre + ' ha llegado a su 5° falta y debe ser sustuido');
						$("#SustitucionesVisita").reveal();};
					
						break;	
				};		
			Evento(EventoEquipo,EventoMensaje,EventoElimina);
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
			
			var menu = $('ul',$(this));
		
			if(menu.css("display") == "none"){
				var posX = $(this).offset().left;
				var	posY = $(this).offset().top;					
				var pX = (e.pageX - posX);
				var pY = (e.pageY - posY);
				
				menu.show('normal', function() { 	
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
			
			var menu = $('ul',$(this));
			if(menu.css("display") == "none"){
				var mediaCanchaIzqWidth = $('.media_cancha_izquierda').width(); 
				var posX = $(this).offset().left;
				var	posY = $(this).offset().top;				
				var pX = (e.pageX - posX + mediaCanchaIzqWidth);
				var pY = (e.pageY - posY);
					menu.show('normal', function() { 	
					menu.css("position","absolute").css("top", pY).css("left", pX); 
					}); 
			}else {
				
				menu.hide();
			}
		
		});
		
		
		
		
  	//semi_circulo_izquierda
		
	
		/*-- NO BORRAR SIRVE PARA HACER PRUEBAS */
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
