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
        jugadoresVisitantesContainer: $('.js-jugadores-equipo[data-tipo="visitante"]'),
        jugadoresVisitantesDisponibles: [],
        numeroCuartoContainer: $('.js-numero-cuarto'),
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
                    var opt = '<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>';
                    options.jugadoresLocalesContainer.append(opt);
                    options.jugadoresLocalesCambioContainer.append(opt);
                    options.jugadoresLocalesAsistenciaContainer.append(opt);
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

        $('.js-enviar-evento-asistencia').on('click', function (evt) {
            var origenEvento = $(this).attr('data-tipo');
            var tipoEventoLanzamiento = $('.js-eventos-equipo[data-tipo="' + origenEvento + '"]').val();;
            var tipoEventoAsistencia = 'ASISTENCIA_JUGADOR';
            var lanzadorJugadorId = $('.js-jugadores-equipo[data-tipo="' + origenEvento + '"]').val();
            var asisteJugadorId = $('.js-jugadores-equipo-asistencia[data-tipo="' + origenEvento + '"]').val();
            var eventoAsistencia = {nombreEvento: tipoEventoAsistencia, idJugador: asisteJugadorId};
            var eventoLanzamiento = {nombreEvento: tipoEventoLanzamiento, idJugador: lanzadorJugadorId, eventoGenerador: eventoAsistencia};
            eviarEventoEntero(eventoLanzamiento);
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

        if (jugadorSeleccionado && tipoEvento && tipoEvento.length) {
            var data = {nombreEvento: tipoEvento, idJugador: jugadorSeleccionado.id}; //data : JSON.stringify(jsonData),
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


