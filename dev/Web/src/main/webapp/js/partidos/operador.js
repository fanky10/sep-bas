$(function () {
    new OperadorView().render();
});
// function constructora de clase
OperadorView = function () {
    var options = {
        jugadoresLocalesAsistenciaContainer: $('.js-jugadores-equipo-asistencia[data-tipo="local"]'),
        jugadoresLocalesContainer: $('.js-jugadores-equipo[data-tipo="local"]'),
        jugadoresLocalesCambioContainer: $('.js-jugadores-equipo-cambio[data-tipo="local"]'),
        jugadoresLocalesDisponibles: [],
        jugadoresLocalesSeleccionados: [],
        jugadoresVisitantesContainer: $('.js-jugadores-equipo[data-tipo="visitante"]'),
        jugadoresVisitantesDisponibles: [],
        jugadoresVisitantesSeleccionados: [],
        numeroCuartoContainer: $('.js-numero-cuarto'),
        responseContainer: $('.js-response'),
    };
    
    var puntos = {
        local: 0,
        visitante: 0
    };

    function render() {
        loadData();
        loadEvents();
    }

    function loadData() {
        $.ajax({
            url: APP_CTX + '/secure/api/partido/get.json',
            type: "GET",
            data: {},
            dataType: "json"
        }).success(function (response) {
            if (response.code == 0) {
                // todos los jugadores
                options.jugadoresLocalesDisponibles = response.content.jugadoresLocalesDisponibles;
                options.jugadoresVisitantesDisponibles = response.content.jugadoresVisitantesDisponibles;
                // los seleccionados
                options.jugadoresLocalesSeleccionados = response.content.jugadoresLocalesSeleccionados;
                options.jugadoresVisitantesSeleccionados = response.content.jugadoresVisitantesSeleccionados;
                
                $.each(options.jugadoresLocalesSeleccionados, function (idx, el) {
                    var opt = '<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>';
                    options.jugadoresLocalesContainer.append(opt);
                    options.jugadoresLocalesAsistenciaContainer.append(opt);
                });
                
                $.each(options.jugadoresLocalesDisponibles, function (idx, elDisp){
                    var shouldAdd = true;
                    $.each(options.jugadoresLocalesSeleccionados, function (idx, elSel) {
                        if(elDisp.id === elSel.id) {
                            shouldAdd = false;
                        }
                    });
                    if(shouldAdd) {
                        options.jugadoresLocalesCambioContainer.append('<option value="' + elDisp.id + '">' + elDisp.nombre + ' ' + elDisp.apellido + '</option>');
                    }
                });

                $.each(options.jugadoresVisitantesSeleccionados, function (idx, el) {
                    options.jugadoresVisitantesContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>');
                });
            }
        });
    }

    function loadEvents() {
        $('.js-enviar-evento-lanzamiento').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEvento = $('.js-eventos-equipo[data-tipo="' + origenEvento + '"]').val();
            var jugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            enviarEventoLanzamiento(jugadorId, origenEvento, tipoEvento);
        });

        $('.js-enviar-evento-cambio').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEventoIngreso = 'INGRESA_JUGADOR';
            var tipoEventoSalida = 'SALIDA_JUGADOR';
            var saleJugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            var entraJugadorId = $('.js-jugadores-equipo-cambio[data-tipo="' + origenEvento + '"]').val();
            var eventoSalida = {nombreEvento: tipoEventoSalida, idJugador: saleJugadorId};
            var eventoEntrada = {nombreEvento: tipoEventoIngreso, idJugador: entraJugadorId, eventoGenerador: eventoSalida};
            eviarEvento(eventoEntrada).success(function (response) {
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
            });
        });

        $('.js-enviar-evento-asistencia').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEventoLanzamiento = $('.js-eventos-equipo[data-tipo="' + origenEvento + '"]').val();;
            var tipoEventoAsistencia = 'ASISTENCIA_JUGADOR';
            var lanzadorJugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            var asisteJugadorId = $('.js-jugadores-equipo-asistencia[data-tipo="' + origenEvento + '"]').val();
            var eventoAsistencia = {nombreEvento: tipoEventoAsistencia, idJugador: asisteJugadorId};
            var eventoLanzamiento = {nombreEvento: tipoEventoLanzamiento, idJugador: lanzadorJugadorId, eventoGenerador: eventoAsistencia};
            eviarEvento(eventoLanzamiento).success(function (response) {
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
            });
        });

        $('.js-nuevo-cuarto').on('click', function (evt) {
            $.ajax({
                contentType : 'application/json',
                dataType : 'json',
                url: APP_CTX + '/secure/api/cuarto/nuevo',
                type: "POST"
            }).success(function (response) {
                var cuarto = response.content;
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
                options.numeroCuartoContainer.html(cuarto.numero);
            });
        });
        
        $('.js-fin-partido').on('click', function (evt) {
            var puntaje = {
                resultadoLocal: puntos.local,
                resultadoVisitante: puntos.visitante
            };
            
            $.ajax({
                contentType : 'application/json',
                dataType : 'json',
                url: APP_CTX + '/secure/api/partido/finalizar',
                type: "POST",
                data : JSON.stringify(puntaje)
            }).success(function (response) {
                var cuarto = response.content;
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
                options.numeroCuartoContainer.html(cuarto.numero);
            });
        });
        
    }

    function enviarEventoLanzamiento(jugadorId, origenEvento, tipoEvento) {
        var jugadorSeleccionado = null;
        var jugadores = options.jugadoresLocalesDisponibles;
        var puntaje = tipoEvento === 'LANZAMIENTO_JUGADOR_UN_PUNTO' ? 1 : (tipoEvento === 'LANZAMIENTO_JUGADOR_DOS_PUNTOS' ? 2 : (tipoEvento === 'LANZAMIENTO_JUGADOR_TRES_PUNTOS' ? 3 : 0 ) )

        if(origenEvento === 'visitante') {
            jugadores = options.jugadoresVisitantesDisponibles;
        }

        $.each(jugadores, function(idx, jugador){
           if(jugadorId == jugador.id) {
               jugadorSeleccionado = jugador;
           }
        });

        if (jugadorSeleccionado && tipoEvento && tipoEvento.length) {
            var data = {nombreEvento: tipoEvento, idJugador: jugadorSeleccionado.id}; //data : JSON.stringify(jsonData),
            eviarEvento(data).success(function (response) {
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
                puntos[origenEvento] += puntaje;
                $('.js-puntos[data-tipo="' + origenEvento + '"]').html(puntos[origenEvento]);
            });
        }
    }
    
    function eviarEvento(evento) {
        return $.ajax({
            contentType : 'application/json',
            dataType : 'json',
            url: APP_CTX + '/secure/api/evento/post.json',
            type: "POST",
            data : JSON.stringify(evento)
        });
    }

    return {
        render: render
    };
};


