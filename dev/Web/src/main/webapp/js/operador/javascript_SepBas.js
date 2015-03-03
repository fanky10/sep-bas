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
var options = {
    equipoLocal: '',
    equipoVisita: '',
    jugadoresLocalesDisponibles: [],
    jugadoresVisitantesDisponibles: [],
    jugadoresLocalesSeleccionados: [],
    jugadoresVisitantesSeleccionados: [],
};


// <!-- Hard Code -->
var v_nroCuarto = 1;
var v_local_primer_cuarto = 0;
var v_local_segundo_cuarto = 0;
var v_local_tercer_cuarto = 0;
var v_local_cuarto_cuarto = 0;
var v_visita_primer_cuarto = 0;
var v_visita_segundo_cuarto = 0;
var v_visita_tercer_cuarto = 0;
var v_visita_cuarto_cuarto = 0;


var clubLocal = {
    id: 0,
    nombre: 'Local',
    puntos: 0
}
var clubVisitante = {
    id: 99,
    nombre: 'Visita',
    puntos: 0
}

var jugadoresLocales = [];

var jugadoresVisita = [];

// <!-- Javascript functions  -->	

var IndiceJugadorLocal = new Array(5);
var IndiceJugadorVisita = new Array(5);
var cant_suplentes_local = 0;
var cant_suplentes_visita = 0;
var Form_suplentes_locales;
var Faltas_Local;
var Faltas_Visita;

function inicializaVariables() {
    console.log("Inicializando el partido");
    $.ajax({
        url: APP_CTX + '/secure/api/partido/get.json',
        type: "GET",
        data: {},
        dataType: "json"
    }).success(function(response) {
        if (response.code == 0) {
            options.jugadoresLocalesDisponibles = response.content.jugadoresLocalesDisponibles;
            options.jugadoresVisitantesDisponibles = response.content.jugadoresVisitantesDisponibles;
            options.jugadoresLocalesSeleccionados = response.content.jugadoresLocalesSeleccionados;
            options.jugadoresVisitantesSeleccionados = response.content.jugadoresVisitantesSeleccionados;
            options.equipoLocal = response.content.cuarto.partido.clubLocal;
            options.equipoVisita = response.content.cuarto.partido.clubVisitante;

            //console.log(options.equipoLocal);

            clubLocal.id = options.equipoLocal.id;
            clubLocal.nombre = options.equipoLocal.nombre;

            clubVisitante.id = options.equipoVisita.id;
            clubVisitante.nombre = options.equipoVisita.nombre;


            $.each(options.jugadoresVisitantesDisponibles, function(idx, el) {
                var juega = 0;
                $.each(options.jugadoresVisitantesSeleccionados, function(idx, ep) {
                    if (el.id == ep.id) {
                        juega = 1;
                    };
                });
                console.log(juega);
                jugadoresVisita.push({
                    id: el.id,
                    equipo: el.club.id,
                    nombre: el.nombre + ' ' + el.apellido,
                    numero: el.numero,
                    enCancha: juega,
                    simples: 0,
                    dobles: 0,
                    triples: 0,
                    rebotes: 0,
                    asistencias: 0,
                    Perdidas: 0,
                    Faltas: 0
                });

            });

            $.each(options.jugadoresLocalesDisponibles, function(idx, el) {
                var juega = 0;
                $.each(options.jugadoresLocalesSeleccionados, function(idx, ep) {
                    if (el.id == ep.id) {
                        juega = 1;
                    };
                });
                jugadoresLocales.push({
                    id: el.id,
                    equipo: el.club.id,
                    nombre: el.nombre + ' ' + el.apellido,
                    numero: el.numero,
                    enCancha: juega,
                    simples: 0,
                    dobles: 0,
                    triples: 0,
                    rebotes: 0,
                    asistencias: 0,
                    Perdidas: 0,
                    Faltas: 0
                });

            });

        }
    });
    alert(jugadoresLocales.length);
    cargaJugadores();
    cargaHTML();
};

function salirCambioCuarto() {
    $('#FinCuarto').trigger('reveal:close');
};

function cargaHtmlEstadisticasLocal() {
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

    for (var n in jugadoresLocales) {
        EstadisticasLocal += '<tr>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].numero + '</td>';
        EstadisticasLocal += '<td>' + jugadoresLocales[n].nombre + '</td>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].simples + '</td>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].dobles + '</td>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].triples + '</td>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].asistencias + '</td>';
        EstadisticasLocal += '<td align="center">' + jugadoresLocales[n].Faltas + '</td>';
        EstadisticasLocal += '</tr>';

    };
    EstadisticasLocal += '</table>';

    document.getElementById('TablaEstadisticasLocal').innerHTML = EstadisticasLocal;
}
function enviarEvento(jugadorId, origenEvento, tipoEvento) {
    var jugadorSeleccionado = null;
    var jugadores = options.jugadoresLocalesDisponibles;
    if(origenEvento === 'visitante') {
        jugadores = options.jugadoresVisitantesDisponibles;
    }
    $.each(jugadores, function(idx, jugador){
       if(jugadorId == jugador.id) {
           jugadorSeleccionado = jugador;
       }
    });
    var evento = {};
    if (tipoEvento.indexOf('evt=') === 0) {
        evento.tipo = tipoEvento.substring('evt='.length, tipoEvento.length);
    }
    if (jugadorSeleccionado && evento.tipo && evento.tipo.length) {
        var data = {nombreEvento: evento.tipo, idJugador: jugadorSeleccionado.id}; //data : JSON.stringify(jsonData),
        eviarEventoEntero(data);
    }
}

function eviarEventoEntero(evento) {
    $.ajax({
            contentType : 'application/json',
            dataType : 'json',
            url: APP_CTX + '/secure/api/evento/post.json',
            type: "POST",
            data : JSON.stringify(evento)
        }).success(function (response) {
            //options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
        	alert('todo ok aguante central !!');
        });
}

function imprSelec(muestra)

{
		var ficha=document.getElementById(muestra);
		var ventimp=window.open(' ','popimpr');
		ventimp.document.write(ficha.innerHTML);
		ventimp.document.close();
		ventimp.print();
		ventimp.close();
		var css = ventimp.document.createElement("link");
		css.setAttribute("href", "/Web/css/operador/imprimir.css");
		css.setAttribute("rel", "stylesheet");
		css.setAttribute("type", "text/css");
		ventimp.document.head.appendChild(css);
}

function cargaHtmlEstadisticasVisita() {
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

    for (var n in jugadoresVisita) {
        EstadisticasVisita += '<tr>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].numero + '</td>';
        EstadisticasVisita += '<td>' + jugadoresVisita[n].nombre + '</td>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].simples + '</td>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].dobles + '</td>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].triples + '</td>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].asistencias + '</td>';
        EstadisticasVisita += '<td align="center">' + jugadoresVisita[n].Faltas + '</td>';
        EstadisticasVisita += '</tr>';

    };
    EstadisticasVisita += '</table>';
    document.getElementById('TablaEstadisticasVisita').innerHTML = EstadisticasVisita;
}

function cargaJugadores() {
    
    
    // Cargo los jugadores locales
    var j = 0;
    for (var i in jugadoresLocales) {
        if (jugadoresLocales[i].enCancha == 1) {
            IndiceJugadorLocal[j] = i;
            j++;
        } else {
            cant_suplentes_local++;
        }
    }
    // Cargo los jugadores visitantes
    j = 0;

  //  console.log(jugadoresVisita);
    for (i in jugadoresVisita) {
        if (jugadoresVisita[i].enCancha == 1) {
            IndiceJugadorVisita[j] = i;
            j++;
        } else {
            cant_suplentes_visita++;
        }

    }
   // console.log('Jugadores Cargados');

    //console.log('Suplentes Locales ' + cant_suplentes_local);
    //console.log('Suplentes Visita  ' + cant_suplentes_visita);
}

function cargaHTML() {

    document.getElementById('equipoLocal').innerHTML = clubLocal.nombre;
    void 0;
    document.getElementById('equipoVisita').innerHTML = clubVisitante.nombre;
    void 0;
    for (var a = 0; a < 3; a++) {
        switch (a) {
            case 0:
                var Tipo = "SIMPLE"
                break;
            case 1:
                var Tipo = "DOBLE"
                break;
            default:
                var Tipo = "TRIPLE"
        }
        for (var b = 0; b < 5; b++) {
            document.getElementById('jugadorLocal_' + a + b).innerHTML = '<a href="javascript:lanzamienmto(' + "'" + Tipo + "',' -1 ','" + jugadoresLocales[IndiceJugadorLocal[b]].equipo + "','" + IndiceJugadorLocal[b] + "'" + ')">' + jugadoresLocales[IndiceJugadorLocal[b]].nombre + '</a>';
            void 0;
            for (var c = 0; c < 5; c++) {
                if (b != c) {
                    document.getElementById('jugadorLocal_' + a + b + c).innerHTML = '<a href="javascript:lanzamienmto(' + "'" + Tipo + "','" + IndiceJugadorLocal[c] + "','" + jugadoresLocales[IndiceJugadorLocal[c]].equipo + "','" + IndiceJugadorLocal[b] + "'" + ')">' + jugadoresLocales[IndiceJugadorLocal[c]].nombre + '</a>';
                    void 0;

                }
            }
        }
        for (var b = 0; b < 5; b++) {
            document.getElementById('jugadorVisita_' + a + b).innerHTML = '<a href="javascript:lanzamienmto(' + "'" + Tipo + "',' -1 ','" + jugadoresVisita[IndiceJugadorVisita[b]].equipo + "','" + IndiceJugadorVisita[b] + "'" + ')">' + jugadoresVisita[IndiceJugadorVisita[b]].nombre + '</a>';
            void 0;
            for (var c = 0; c < 5; c++) {
                if (b != c) {
                    document.getElementById('jugadorVisita_' + a + b + c).innerHTML = '<a href="javascript:lanzamienmto(' + "'" + Tipo + "','" + IndiceJugadorVisita[c] + "','" + jugadoresVisita[IndiceJugadorVisita[c]].equipo + "','" + IndiceJugadorVisita[b] + "'" + ')">' + jugadoresVisita[IndiceJugadorVisita[c]].nombre + '</a>';
                    void 0;
                }
            }

        }
    }
    //console.log("Html cargado");	

    console.log('Armando el form de suplentes!!');
    Form_suplentes_locales = '<div class="row">';
    Form_suplentes_locales += '<div class="row">';
    Form_suplentes_locales += '<div class="four columns"><img src="/Web/images/Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>';
    Form_suplentes_locales += '<div class="four columns">';
    Form_suplentes_locales += '<h4 style="text-align:center">Sustituciones ' + clubLocal.nombre + '</h4>';
    Form_suplentes_locales += '</div>';
    Form_suplentes_locales += '<div class="four columns"></div>';
    Form_suplentes_locales += '</div>';


    Form_suplentes_locales += '<div class="row">';
    Form_suplentes_locales += '<form class="custom" name="SustitucionLocal">';
    Form_suplentes_locales += '<div class="six columns" style="text-align:left" id="formSustLocal">';
    for (var n in jugadoresLocales) {
        
    	alert('Jugador local en cancga ?? ' + jugadoresLocales[n].enCancha);
    	if (jugadoresLocales[n].enCancha == 1) {
           
        	Form_suplentes_locales += '<label for="JugadorLocalSale"><input name="JugadorLocalSale" type="radio" value="' + n + '">(' + jugadoresLocales[n].numero + ') ' + jugadoresLocales[n].nombre + '</label>';
        };
    };
    Form_suplentes_locales += '</div>';
    Form_suplentes_locales += '<div class="six columns" style="text-align:left">';
    for (var n in jugadoresLocales) {
        if (jugadoresLocales[n].enCancha != 1) {
            Form_suplentes_locales += '<label for="JugadorLocalEntra"><input name="JugadorLocalEntra" type="radio" value="' + n + '">(' + jugadoresLocales[n].numero + ') ' + jugadoresLocales[n].nombre + '</label>'
        };
    };
    Form_suplentes_locales += '</div>';
    Form_suplentes_locales += '</div>';
    Form_suplentes_locales += '<div class="row"><input onClick="Sustitucion(' + "'" + 'Local' + "'" + ')" name="Realizar Cambio" class="button" type="button" value="Realizar Sustituci&oacute;n"></form></div>';
    Form_suplentes_locales += '</div>';
    Form_suplentes_locales += '</div>';

    document.getElementById('SustitucionesLocal').innerHTML = Form_suplentes_locales;

    Form_suplentes_visitantes = '<div class="row">';
    Form_suplentes_visitantes += '<div class="row">';
    Form_suplentes_visitantes += '<div class="four columns"><img src="/Web/images/Logo_SEPBas_sin_cintas.png" height="50" width="50"></div>';
    Form_suplentes_visitantes += '<div class="four columns">';
    Form_suplentes_visitantes += '<h4 style="text-align:center">Sustituciones ' + clubVisitante.nombre + '</h4>';
    Form_suplentes_visitantes += '</div>';
    Form_suplentes_visitantes += '<div class="four columns"></div>';
    Form_suplentes_visitantes += '</div>';


    Form_suplentes_visitantes += '<div class="row">';
    Form_suplentes_visitantes += '<form class="custom" name="SustitucionVisita">';
    Form_suplentes_visitantes += '<div class="six columns" style="text-align:left" id="formSustVisita">';
    for (var n in jugadoresVisita) {
        if (jugadoresVisita[n].enCancha == 1) {
            Form_suplentes_visitantes += '<label for="JugadorVisitaSale"><input name="JugadorVisitaSale" type="radio" value="' + n + '">(' + jugadoresVisita[n].numero + ') ' + jugadoresVisita[n].nombre + '</label>';
        };
    };
    Form_suplentes_visitantes += '</div>';
    Form_suplentes_visitantes += '<div class="six columns" style="text-align:left">';
    for (var n in jugadoresVisita) {
        if (jugadoresVisita[n].enCancha != 1) {
            Form_suplentes_visitantes += '<label for="JugadorVisitaEntra"><input name="JugadorVisitaEntra" type="radio" value="' + n + '">(' + jugadoresVisita[n].numero + ') ' + jugadoresVisita[n].nombre + '</label>'
        };
    };
    Form_suplentes_visitantes += '</div>';
    Form_suplentes_visitantes += '</div>';
    Form_suplentes_visitantes += '<div class="row"><input onClick="Sustitucion(' + "'" + 'Visita' + "'" + ')" name="Realizar Cambio" type="button" class="button" value="Realizar Sustituci&oacute;n"></form></div>';
    Form_suplentes_visitantes += '</div>';
    Form_suplentes_visitantes += '</div>';
    document.getElementById('SustitucionesVisita').innerHTML = Form_suplentes_visitantes;


    Faltas_Local = '<h4 class="local">' + clubLocal.nombre + '</h4>';
    for (var b = 0; b < 5; b++) {
        Faltas_Local += '<p class="menuFaltas"><a href="javascript:Falta(' + "'" + jugadoresLocales[IndiceJugadorLocal[b]].equipo + "','" + IndiceJugadorLocal[b] + "'" + ')">(' + jugadoresLocales[IndiceJugadorLocal[b]].numero + ') ' + jugadoresLocales[IndiceJugadorLocal[b]].nombre + '</a></p>';
    }
    document.getElementById('Link_Faltas_Local').innerHTML = Faltas_Local;


    Faltas_Visita = '<h4 class="visita">' + clubVisitante.nombre + '</h4>';
    for (var b = 0; b < 5; b++) {
        Faltas_Visita += '<p class="menuFaltas"><a href="javascript:Falta(' + "'" + jugadoresVisita[IndiceJugadorVisita[b]].equipo + "','" + IndiceJugadorVisita[b] + "'" + ')">(' + jugadoresVisita[IndiceJugadorVisita[b]].numero + ') ' + jugadoresVisita[IndiceJugadorVisita[b]].nombre + '</a></p>';
    }
    document.getElementById('Link_Faltas_Visita').innerHTML = Faltas_Visita;
    cargaCuarto();

}

function cargaCuarto() {
    document.getElementById('nroCuarto').innerHTML = '<h1>' + v_nroCuarto + '&ordm; -C</h1>';
};

function cambioCuarto() {
    if (v_nroCuarto < 4) {
        v_nroCuarto++;
        cargaCuarto();
        $('#FinCuarto').trigger('reveal:close')
    } else {
        document.getElementById('PuntosTotalLocal').innerHTML = '<h1>' + clubLocal.puntos + '</h1>';
        void 0;
        document.getElementById('PuntosTotalVisita').innerHTML = '<h1>' + clubVisitante.puntos + '</h1>';
        void 0;

        $("#FinPartido").reveal();
    };
};

function Sustitucion(Tipo) {
    var EventoEquipo = '';
    var EventoMensaje = '';
    var marcadoSale = -1;
    var marcadoEntra = -1;
    
    var origenEvento = '';
    var tipoEventoIngreso = 'INGRESA_JUGADOR';
    var tipoEventoSalida = 'SALIDA_JUGADOR';
    var saleJugadorId = -1;
    var entraJugadorId = -1;
    
    if (Tipo == 'Local') {
    	origenEvento= 'local';
        EventoEquipo = clubLocal.nombre;
        $('#SustitucionesLocal').trigger('reveal:close');
        //Recupero el indice del jugador que sale	
        for (i = 0; i < document.SustitucionLocal.JugadorLocalSale.length; i++) {
            if (document.SustitucionLocal.JugadorLocalSale[i].checked) {
                marcadoSale = i;
            };
        };
        //Recupero el indice del jugador que entra
        for (i = 0; i < document.SustitucionLocal.JugadorLocalEntra.length; i++) {
            if (document.SustitucionLocal.JugadorLocalEntra[i].checked) {
                marcadoEntra = i;
            };
        };

        if (marcadoSale != -1 && marcadoEntra != -1) {
            var IndiceJugadorSale = document.SustitucionLocal.JugadorLocalSale[marcadoSale].value;
            var IndiceJugadorEntra = document.SustitucionLocal.JugadorLocalEntra[marcadoEntra].value;
            EventoMensaje = 'Sustitucion: Sale (' + jugadoresLocales[IndiceJugadorSale].numero + ') ' + jugadoresLocales[IndiceJugadorSale].nombre + ' Entra (' + jugadoresLocales[IndiceJugadorEntra].numero + ') ' + jugadoresLocales[IndiceJugadorEntra].nombre;
            Evento(EventoEquipo, EventoMensaje, '...');
            jugadoresLocales[IndiceJugadorSale].enCancha = 0;
            jugadoresLocales[IndiceJugadorEntra].enCancha = 1;
            
            saleJugadorId = jugadoresLocales[IndiceJugadorSale].id;
            entraJugadorId = jugadoresLocales[IndiceJugadorEntra].id;
        };

    } else {
    	origenEvento= 'visitante';
        EventoEquipo = clubVisitante.nombre;
        $('#SustitucionesVisita').trigger('reveal:close');
        for (i = 0; i < document.SustitucionVisita.JugadorVisitaSale.length; i++) {
            //alert(i);
            //alert(document.SustitucionVisita.JugadorVisitaSale[i].checked);
            if (document.SustitucionVisita.JugadorVisitaSale[i].checked) {
                marcadoSale = i;

            };
        };

        //Recupero el indice del jugador que entra
        for (i = 0; i < document.SustitucionVisita.JugadorVisitaEntra.length; i++) {
            if (document.SustitucionVisita.JugadorVisitaEntra[i].checked) {
                marcadoEntra = i;

            };
        };

        if (marcadoSale != -1 && marcadoEntra != -1) {

            var IndiceJugadorSale = document.SustitucionVisita.JugadorVisitaSale[marcadoSale].value;
            var IndiceJugadorEntra = document.SustitucionVisita.JugadorVisitaEntra[marcadoEntra].value;
            EventoMensaje = 'Sustitucion: Sale (' + jugadoresVisita[IndiceJugadorSale].numero + ') ' + jugadoresVisita[IndiceJugadorSale].nombre + ' Entra (' + jugadoresVisita[IndiceJugadorEntra].numero + ') ' + jugadoresVisita[IndiceJugadorEntra].nombre;
            jugadoresVisita[IndiceJugadorSale].enCancha = 0;
            jugadoresVisita[IndiceJugadorEntra].enCancha = 1;
            
            saleJugadorId = jugadoresVisita[IndiceJugadorSale].id;
            entraJugadorId =jugadoresVisita[IndiceJugadorEntra].id;
            Evento(EventoEquipo, EventoMensaje, '...');
        };

    };

    if (marcadoSale != -1 && marcadoEntra != -1) {
    	var eventoSalida = {nombreEvento: tipoEventoSalida, idJugador: saleJugadorId};
        var eventoEntrada = {nombreEvento: tipoEventoIngreso, idJugador: entraJugadorId, eventoGenerador: eventoSalida};
        eviarEventoEntero(eventoEntrada);
//	 	console.log(origenEvento);
//		console.log(tipoEventoIngreso);
//		console.log(tipoEventoSalida);
//		console.log(saleJugadorId);
//		console.log(entraJugadorId);
//		console.log(eventoSalida);
//		console.log(eventoEntrada); 
    	cargaJugadores();
        cargaHTML();
    };
};

function cancelaEvento(TipoEvento, TipoLanzamiento, IDAsistencia, Equipo, posicion) //tipoEvento,tipoLanzamiento, IDAsistencia, Equipo, posicion
    {
        switch (TipoEvento) {
            case "1":

                var EventoEquipo = '';
                var EventoMensaje = '';
                var EventoElimina = '...';
                //alert('Hasta aca funco');
                //alert(Equipo);

                switch (Equipo) {
                    case String(clubLocal.id):
                        EventoEquipo = clubLocal.nombre;
                        EventoMensaje = 'Cancela ' + TipoLanzamiento + ' (' + jugadoresLocales[posicion].numero + ') ' + jugadoresLocales[posicion].nombre;
                        switch (TipoLanzamiento) {
                            case "SIMPLE":
                                CantPuntosLanzamiento = 1;
                                jugadoresLocales[posicion].simples--;
                                switch (v_nroCuarto) {
                                    case 1:
                                        v_local_primer_cuarto--;
                                        document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_local_segundo_cuarto--;
                                        document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_local_tercer_cuarto--;
                                        document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_local_cuarto_cuarto--;
                                        document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                            case "DOBLE":
                                CantPuntosLanzamiento = 2;
                                jugadoresLocales[posicion].dobles--;
                                switch (v_nroCuarto) {
                                    case 1:
                                        v_local_primer_cuarto -= 2;
                                        document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_local_segundo_cuarto -= 2;
                                        document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_local_tercer_cuarto -= 2;
                                        document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_local_cuarto_cuarto -= 2;
                                        document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                            case "TRIPLE":
                                CantPuntosLanzamiento = 3;
                                jugadoresLocales[posicion].triples--;
                                switch (v_nroCuarto) {
                                    case 1:
                                        v_local_primer_cuarto -= 3;
                                        document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_local_segundo_cuarto -= 3;
                                        document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_local_tercer_cuarto -= 3;
                                        document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_local_cuarto_cuarto -= 3;
                                        document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                        }


                        var ASISTENCIA = IDAsistencia;
                        if (ASISTENCIA.trim() != "-1") {
                            jugadoresLocales[IDAsistencia].asistencias--;
                            EventoMensaje += ' Asistencia (' + jugadoresLocales[IDAsistencia].numero + ') ' + jugadoresLocales[IDAsistencia].nombre;
                        };
                        clubLocal.puntos -= CantPuntosLanzamiento;
                        document.getElementById('puntosLocal').innerHTML = clubLocal.puntos;
                        void 0
                        break;

                    case String(clubVisitante.id):

                        EventoEquipo = clubVisitante.nombre;
                        EventoMensaje = 'Cancela ' + TipoLanzamiento + ' (' + jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre;
                        switch (TipoLanzamiento) {
                            case "SIMPLE":
                                CantPuntosLanzamiento = 1;
                                jugadoresVisita[posicion].simples--;
                                switch (v_nroCuarto) {
                                    case 1:
                                        v_visita_primer_cuarto--;
                                        document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_visita_segundo_cuarto--;
                                        document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_visita_tercer_cuarto--;
                                        document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_visita_cuarto_cuarto--;
                                        document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                            case "DOBLE":
                                CantPuntosLanzamiento = 2;
                                jugadoresVisita[posicion].dobles--;
                                switch (v_nroCuarto) {
                                    case 1:
                                        v_visita_primer_cuarto -= 2;
                                        document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_visita_segundo_cuarto -= 2;
                                        document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_visita_tercer_cuarto -= 2;
                                        document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_visita_cuarto_cuarto -= 2;
                                        document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                            case "TRIPLE":
                                CantPuntosLanzamiento = 3;
                                jugadoresVisita[posicion].triples--;

                                switch (v_nroCuarto) {
                                    case 1:
                                        v_visita_primer_cuarto -= 3;
                                        document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                                        void 0;
                                        break;
                                    case 2:
                                        v_visita_segundo_cuarto -= 3;
                                        document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                                        void 0;
                                        break;
                                    case 3:
                                        v_visita_tercer_cuarto -= 3;
                                        document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                                        void 0;
                                        break;
                                    case 4:
                                        v_visita_cuarto_cuarto -= 3;
                                        document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                                        void 0;
                                        break;
                                }
                                break;
                        }


                        var ASISTENCIA = IDAsistencia;
                        if (ASISTENCIA.trim() != "-1") {
                            jugadoresVisita[IDAsistencia].asistencias--;
                            EventoMensaje += ' Asistencia (' + jugadoresVisita[IDAsistencia].numero + ') ' + jugadoresVisita[IDAsistencia].nombre;
                        };
                        clubVisitante.puntos -= CantPuntosLanzamiento;
                        document.getElementById('puntosVisitante').innerHTML = clubVisitante.puntos;
                        void 0;

                        break;

                }
                Evento(EventoEquipo, EventoMensaje, EventoElimina);
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

                    case String(clubLocal.id):
                        EventoEquipo = clubLocal.nombre;
                        jugadoresLocales[posicion].Faltas--;
                        EventoMensaje = 'Cancela Falta de (' + jugadoresLocales[posicion].numero + ') ' + jugadoresLocales[posicion].nombre + ' a ' + jugadoresLocales[posicion].Faltas;
                        break;


                    case String(clubVisitante.id):
                        EventoEquipo = clubVisitante.nombre;
                        jugadoresVisita[posicion].Faltas--;
                        EventoMensaje = 'Cancela Falta de (' + jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre + ' a ' + jugadoresVisita[posicion].Faltas;
                        break;
                };
                Evento(EventoEquipo, EventoMensaje, EventoElimina);
                break;



        }

    };



function lanzamienmto(TipoLanzamiento, IDAsistencia, Equipo, posicion) {
    console.log("Tipo de lanzamiento: " + TipoLanzamiento + ", Asistencia: " + IDAsistencia + ",Equipo: " + Equipo + ",Posicion: " + posicion);
    var origenEvento= '';
    var jugadorId=jugadoresLocales[posicion].id;
    var tipoEvento = '';    
    var EventoEquipo = '';
    var EventoMensaje = '';
    var EventoElimina = '';
    EventoElimina = '<a href="javascript:' + "cancelaEvento('" + 1 + "','" + TipoLanzamiento + "','" + IDAsistencia + "','" + Equipo + "','" + posicion + "')" + '">Eliminar</a>'
    var CantPuntosLanzamiento = 0;
    switch (Equipo) {
        case String(clubLocal.id):
            EventoEquipo = clubLocal.nombre;
        	origenEvento= 'local';
            EventoMensaje = TipoLanzamiento + ' (' + jugadoresLocales[posicion].numero + ') ' + jugadoresLocales[posicion].nombre;
            switch (TipoLanzamiento) {
                case "SIMPLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_UN_PUNTO';
                    CantPuntosLanzamiento = 1;
                    jugadoresLocales[posicion].simples++;
                    switch (v_nroCuarto) {
                        case 1:
                            v_local_primer_cuarto++;
                            document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_local_segundo_cuarto++;
                            document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_local_tercer_cuarto++;
                            document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_local_cuarto_cuarto++;
                            document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;
                case "DOBLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_DOS_PUNTOS';
                    CantPuntosLanzamiento = 2;
                    jugadoresLocales[posicion].dobles++;
                    switch (v_nroCuarto) {
                        case 1:
                            v_local_primer_cuarto += 2;
                            document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_local_segundo_cuarto += 2;
                            document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_local_tercer_cuarto += 2;
                            document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_local_cuarto_cuarto += 2;
                            document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;
                case "TRIPLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_TRES_PUNTOS';
                    CantPuntosLanzamiento = 3;
                    jugadoresLocales[posicion].triples++;
                    switch (v_nroCuarto) {
                        case 1:
                            v_local_primer_cuarto += 3;
                            document.getElementById('local_primer_cuarto').innerHTML = v_local_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_local_segundo_cuarto += 3;
                            document.getElementById('local_segundo_cuarto').innerHTML = v_local_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_local_tercer_cuarto += 3;
                            document.getElementById('local_tercer_cuarto').innerHTML = v_local_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_local_cuarto_cuarto += 3;
                            document.getElementById('local_cuarto_cuarto').innerHTML = v_local_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;

            };

            var ASISTENCIA = IDAsistencia;
            if (ASISTENCIA.trim() != "-1") {
                jugadoresLocales[IDAsistencia].asistencias++;
                EventoMensaje += ' Asistencia (' + jugadoresLocales[IDAsistencia].numero + ') ' + jugadoresLocales[IDAsistencia].nombre;
                var tipoEventoAsistencia = 'ASISTENCIA_JUGADOR';
                var asisteJugadorId = jugadoresLocales[IDAsistencia].id;
                var eventoAsistencia = {nombreEvento: tipoEventoAsistencia , idJugador: asisteJugadorId};
                var eventoLanzamiento = {nombreEvento: tipoEvento, idJugador: jugadorId, eventoGenerador: eventoAsistencia};
                eviarEventoEntero(eventoLanzamiento);
            }else{
            	alert('Fue lo que debia ser!');
            	enviarEvento(jugadorId, origenEvento, tipoEvento);
            }         	           
            ;
            clubLocal.puntos += CantPuntosLanzamiento;
            document.getElementById('puntosLocal').innerHTML = clubLocal.puntos;
            void 0;
            break;

        case String(clubVisitante.id):
        	origenEvento= 'visitante';
            EventoEquipo = clubVisitante.nombre;
            EventoMensaje = TipoLanzamiento + ' (' + jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre;
            switch (TipoLanzamiento) {
                case "SIMPLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_UN_PUNTO';
                    CantPuntosLanzamiento = 1;
                    jugadoresVisita[posicion].simples++;
                    switch (v_nroCuarto) {
                        case 1:
                            v_visita_primer_cuarto++;
                            document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_visita_segundo_cuarto++;
                            document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_visita_tercer_cuarto++;
                            document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_visita_cuarto_cuarto++;
                            document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;
                case "DOBLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_DOS_PUNTOS';
                    CantPuntosLanzamiento = 2;
                    jugadoresVisita[posicion].dobles++;
                    switch (v_nroCuarto) {
                        case 1:
                            v_visita_primer_cuarto += 2;
                            document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_visita_segundo_cuarto += 2;
                            document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_visita_tercer_cuarto += 2;
                            document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_visita_cuarto_cuarto += 2;
                            document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;
                case "TRIPLE":
                	tipoEvento ='evt=LANZAMIENTO_JUGADOR_TRES_PUNTOS';
                    CantPuntosLanzamiento = 3;
                    jugadoresVisita[posicion].triples++;

                    switch (v_nroCuarto) {
                        case 1:
                            v_visita_primer_cuarto += 3;
                            document.getElementById('visita_primer_cuarto').innerHTML = v_visita_primer_cuarto;
                            void 0;
                            break;
                        case 2:
                            v_visita_segundo_cuarto += 3;
                            document.getElementById('visita_segundo_cuarto').innerHTML = v_visita_segundo_cuarto;
                            void 0;
                            break;
                        case 3:
                            v_visita_tercer_cuarto += 3;
                            document.getElementById('visita_tercer_cuarto').innerHTML = v_visita_tercer_cuarto;
                            void 0;
                            break;
                        case 4:
                            v_visita_cuarto_cuarto += 3;
                            document.getElementById('visita_cuarto_cuarto').innerHTML = v_visita_cuarto_cuarto;
                            void 0;
                            break;
                    }
                    break;

            };


            var ASISTENCIA = IDAsistencia;
            if (ASISTENCIA.trim() != "-1") {
                jugadoresVisita[IDAsistencia].asistencias++;
                EventoMensaje += ' Asistencia (' + jugadoresVisita[IDAsistencia].numero + ') ' + jugadoresVisita[IDAsistencia].nombre;
            }else{
            	alert('Fue lo que debia ser!');
            	enviarEvento(jugadorId, origenEvento, tipoEvento);
            }
            	           
            ;
            clubVisitante.puntos += CantPuntosLanzamiento;
            document.getElementById('puntosVisitante').innerHTML = clubVisitante.puntos;
            void 0;
            break;
    };
    
    console.log(origenEvento);
    console.log(tipoEvento);
    console.log(jugadorId);
    
    Evento(EventoEquipo, EventoMensaje, EventoElimina);
};

function Evento(Equipo, Mensaje, Eliminar) {
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
    EventoElimina = '<a href="javascript:' + "cancelaEvento('" + 3 + "','" + -1 + "','" + -1 + "','" + Equipo + "','" + posicion + "')" + '">Eliminar</a>';
    console.log('Equipo enviado' + Equipo + ', Local ' +clubLocal.id);
    switch (Equipo) {

        case String(clubLocal.id):
            EventoEquipo = clubLocal.nombre;
            jugadoresLocales[posicion].Faltas++;
            EventoMensaje = jugadoresLocales[posicion].Faltas + ' Falta de (' + jugadoresLocales[posicion].numero + ') ' + jugadoresLocales[posicion].nombre;
            if (jugadoresLocales[posicion].Faltas == 5) {
                alert('(' + jugadoresLocales[posicion].numero + ') ' + jugadoresLocales[posicion].nombre + ' ha llegado a su 5� falta y debe ser sustuido');
                $("#SustitucionesLocal").reveal();
            };
            break;

        case String(clubVisitante.id):
            EventoEquipo = clubVisitante.nombre;
            jugadoresVisita[posicion].Faltas++;
            EventoMensaje = jugadoresVisita[posicion].Faltas + ' Falta de (' + jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre;
            if (jugadoresVisita[posicion].Faltas == 5) {
                alert('(' + jugadoresVisita[posicion].numero + ') ' + jugadoresVisita[posicion].nombre + ' ha llegado a su 5� falta y debe ser sustuido');
                $("#SustitucionesVisita").reveal();
            };
            break;
    };
    Evento(EventoEquipo, EventoMensaje, EventoElimina);
};

//semi_circulo_izquierda
$(function() {
    // arma el menu on ready
    $("#menu_visita").menu();
    $('#menu_local').menu();
    $('#menu_visita').hide();
    $('#menu_local').hide();

    var menuStatus = 0;

    jQuery(".media_cancha_izquierda").click(function(e) {


        if ($('#menu_local').css("display") != "none") {
            $('#menu_local').hide();
        };

        var menu = $('ul', $(this));

        if (menu.css("display") == "none") {
            var posX = $(this).offset().left;
            var posY = $(this).offset().top;
            var pX = (e.pageX - posX);
            var pY = (e.pageY - posY);

            menu.show('normal', function() {
                menu.css("position", "absolute").css("top", pY).css("left", pX);
            });
        } else {

            menu.hide();
        }

    });
    jQuery(".media_cancha_derecha").click(function(e) {

        if ($('#menu_visita').css("display") != "none") {
            $('#menu_visita').hide();
        };

        var menu = $('ul', $(this));
        if (menu.css("display") == "none") {
            var mediaCanchaIzqWidth = $('.media_cancha_izquierda').width();
            var posX = $(this).offset().left;
            var posY = $(this).offset().top;
            var pX = (e.pageX - posX + mediaCanchaIzqWidth);
            var pY = (e.pageY - posY);
            menu.show('normal', function() {
                menu.css("position", "absolute").css("top", pY).css("left", pX);
            });
        } else {

            menu.hide();
        }

    });




}); // Cierro document ready