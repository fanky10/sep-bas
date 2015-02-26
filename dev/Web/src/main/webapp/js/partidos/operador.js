$(function () {
    new OperadorView().render();
});
// function constructora de clase
OperadorView = function () {
    var options = {
        jugadoresLocalesContainer: $('.js-jugadores-equipo[data-tipo="local"]'),
        jugadoresLocalesCambioContainer: $('.js-jugadores-equipo-cambio[data-tipo="local"]'),
        jugadoresLocalesDisponibles: [],
        jugadoresVisitantesContainer: $('.js-jugadores-equipo[data-tipo="visitante"]'),
        jugadoresVisitantesDisponibles: [],
        responseContainer: $('.js-response'),
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
                options.jugadoresLocalesDisponibles = response.content.jugadoresLocalesDisponibles;
                options.jugadoresVisitantesDisponibles = response.content.jugadoresVisitantesDisponibles;

                $.each(options.jugadoresLocalesDisponibles, function (idx, el) {
                    options.jugadoresLocalesContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>');
                    options.jugadoresLocalesCambioContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>');
                });

                $.each(options.jugadoresVisitantesDisponibles, function (idx, el) {
                    options.jugadoresVisitantesContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>');
                });
            }
        });
    }

    function loadEvents() {
        $('.js-enviar-evento').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEvento = $('.js-eventos-equipo[data-tipo="' + origenEvento + '"]').val();
            var jugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            enviarEvento(jugadorId, origenEvento, tipoEvento);
        });
        $('.js-enviar-evento-cambio').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEventoIngreso = 'INGRESA_JUGADOR';
            var tipoEventoSalida = 'SALIDA_JUGADOR';
            var saleJugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            var entraJugadorId = $('.js-jugadores-equipo-cambio[data-tipo="' + origenEvento + '"]').val();
            var eventoSalida = {nombreEvento: tipoEventoSalida, idJugador: saleJugadorId};
            var eventoEntrada = {nombreEvento: tipoEventoIngreso, idJugador: entraJugadorId, eventoGenerador: eventoSalida};
            eviarEventoEntero(eventoEntrada);
        });
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
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
            });
    }

    return {
        render: render
    };
};


