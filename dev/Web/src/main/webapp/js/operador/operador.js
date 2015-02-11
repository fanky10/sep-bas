$(function () {
    new OperadorView().render();
});

OperadorView = function () {
    var options = {
//		jugadoresLocalesContainer: $('.js-jugadores-equipo[data-tipo="local"]'),
//    	jugadoresVisitantesContainer: $('.js-jugadores-equipo[data-tipo="visitante"]'),
    	jugadoresLocalesJSON: [],
    	jugadoresVisitaJSON: [],

    	jugadoresLocalesSELECCIONADOSJSON: [],
    	jugadoresVisitasSELECCIONADOSJSON: [],
    	
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
                options.jugadoresLocalesJSON = response.content.jugadoresLocalesDisponibles;
                options.jugadoresVisitaJSON = response.content.jugadoresVisitantesDisponibles;
                options.jugadoresLocalesSELECCIONADOSJSON = response.content.jugadoresLocalesSeleccionados;
                options.jugadoresVisitasSELECCIONADOSJSON = response.content.jugadoresVisitantesSeleccionados;
                
//                $.each(options.jugadoresLocalesDisponibles, function (idx, el) {
//                    options.jugadoresLocalesContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>')
//                });
//
//                $.each(options.jugadoresVisitantesDisponibles, function (idx, el) {
//                    options.jugadoresVisitantesContainer.append('<option value="' + el.id + '">' + el.nombre + ' ' + el.apellido + '</option>')
//                });
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
            $.ajax({
                contentType : 'application/json',
                dataType : 'json',
                url: APP_CTX + '/secure/api/evento/post.json',
                type: "POST",
                data : JSON.stringify(data)
            }).success(function (response) {
                options.responseContainer.html('Response: '+ response.code + ' msg: '+response.message);
            });
        }
    }

    return {
        render: render
    };
};


