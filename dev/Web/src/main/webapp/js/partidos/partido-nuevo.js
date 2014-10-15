$(function () {
    var partidoView = new PartidoView(),
            iniciarPartidoForm = $('#iniciarPartidoForm'),
            options = {
                NUMERO_MINIMO_JUGADORES: 4,
                NUMERO_MAXIMO_JUGADORES: 12
            };            
    // events
    $('#clubesLocales').change(clubSeleccionadoEvent);
    $('#clubesVisitantes').change(clubSeleccionadoEvent);
    function clubSeleccionadoEvent(e) {
        var clubesValidated = $('#iniciarPartidoForm').validate().element("#clubesValidation");
        if (clubesValidated) {
            partidoView.loadPlayers();
        }
    }

    $('.button.iniciar').click(function (e) {
        e.preventDefault();
        var validated = iniciarPartidoForm.valid(),
            jugadoresLocalesLength = $('.jugadores-locales-container input:checkbox').length,
            jugadoresVisitantedLength = $('.jugadores-visitantes-container input:checkbox').length,
            idSelectArbitro = $('input:radio:checked').attr('id'),
            arbitroSeleccionado = $("label[for='"+idSelectArbitro+"']").text();
        if(validated){
            $('div label.jugadores-locales').text(jugadoresLocalesLength);
            $('div label.jugadores-visitantes').text(jugadoresVisitantedLength);
            $('div label.arbitro-seleccionado').text(arbitroSeleccionado);
        }
        return validated;
    });
    
    $('#acceptResumenModal').click(function(e){
        var arbitroId = $('input:radio:checked').val();
    });
    
    // modal events:
    $('#closeResumenModal').click(function(e){
        e.preventDefault();
        $('#resumenModal').foundation('reveal', 'close');
    });//

    // validation
    $.validator.setDefaults({
        ignore: [], // ignores hidden elements such as: select
        errorLabelContainer: '#errorsContainer'
    });
    $.validator.addMethod('selectedClub', function (value, element) {
        var selectedClubs = partidoView.getSelectedClubs();
        return (selectedClubs.idClubLocal !== selectedClubs.idClubVisitante);
    }, 'Club local y visitante iguales');
    $.validator.addMethod('tieneJugadoresLocales', function (value, element) {
        var jugadoresLength = $('.jugadores-locales-container input:checkbox').length;
        return jugadoresLength > 0;
    }, 'Seleccione un club con jugadores');
    $.validator.addMethod('tieneJugadoresVisitantes', function (value, element) {
        var jugadoresLength = $('.jugadores-visitantes-container input:checkbox').length;
        return jugadoresLength > 0;
    }, 'Seleccione un club con jugadores');


    $.validator.addMethod('minSelectedPlayer', function (value, element) {
        var selected = $('input[name="' + element.name + '"]').filter(':checked').length;
        return selected >= options.NUMERO_MINIMO_JUGADORES;
    }, 'Cantidad de jugadores seleccionados menor al minimo');

    $.validator.addMethod('maxSelectedPlayer', function (value, element) {
        var selected = $('input[name="' + element.name + '"]').filter(':checked').length;
        return selected <= options.NUMERO_MAXIMO_JUGADORES;
    }, 'Cantidad de jugadores seleccionados mayor al maximo');

    $('#iniciarPartidoForm').validate({
        rules: {
            clubesValidation: {
                selectedClub: true
            },
            clubesLocales: {
                tieneJugadoresLocales: true
            },
            clubesVisitantes: {
                tieneJugadoresVisitantes: true
            },
            equipolocal: {
                minSelectedPlayer: true,
                maxSelectedPlayer: true
            },
            equipovisitante: {
                minSelectedPlayer: true,
                maxSelectedPlayer: true
            },
            radioArbitros: {
                required: true
            }
        },
        messages: {
            clubesLocales: {
                tieneJugadoresLocales: 'Equipo Local: Seleccione un club con jugadores'
            },
            clubesVisitantes: {
                tieneJugadoresVisitantes: 'Equipo Visitante: Seleccione un club con jugadores'
            },
            equipolocal: {
                minSelectedPlayer: 'Equipo Local: Al menos deben seleccionarse ' + options.NUMERO_MINIMO_JUGADORES,
                maxSelectedPlayer: 'Equipo Local: Como maximo deben seleccionarse ' + options.NUMERO_MAXIMO_JUGADORES
            },
            equipovisitante: {
                minSelectedPlayer: 'Equipo Visitante: Al menos deben seleccionarse ' + options.NUMERO_MINIMO_JUGADORES,
                maxSelectedPlayer: 'Equipo Visitante: Como maximo deben seleccionarse ' + options.NUMERO_MAXIMO_JUGADORES
            },
            radioArbitros: {
                required: 'Al menos debe seleccionarse un arbitro'
            }
        }
    });

});

PartidoModel = function(idArbitro, idClubLocal, idClubVisitante, jugadoresLocales, jugadoresVisitantes){
    var data = {
        arbitro: idArbitro,
        clubLocal: idClubLocal,
        clubVisitante: idClubVisitante
    }
}

PartidoView = function () {
    var options = {
        jugadoresLocalesContainer: '.jugadores-locales-container',
        jugadoresVisitantesContainer: '.jugadores-visitantes-container'
    }
    function showNextTab() {
        var activeTab = $('.tabs .active'),
                idxActiveTab = parseInt(activeTab.find('a').attr('data-idx')),
                nextTab = $('.tabs').find('a[data-idx=' + (idxActiveTab + 1) + ']');
        if (nextTab && nextTab.length > 0) {
            nextTab.click();
        }
    }
    function getClubesSeleccionados() {
        var clubLocal = $('#clubesLocales :selected').val(),
                clubVisitante = $('#clubesVisitantes :selected').val();
        return {
            idClubLocal: clubLocal,
            idClubVisitante: clubVisitante
        };
    }
    function cargaJugadores() {
        $(".jugadores h5").text("");
        $(options.jugadoresLocalesContainer).text("Cargando Jugadores...");
        $(options.jugadoresVisitantesContainer).text("Cargando Jugadores...");
        var _self = this, clubes = getClubesSeleccionados(), clubLocal = clubes.idClubLocal, clubVisitante = clubes.idClubVisitante;
        $.ajax({
            dataType: "json",
            url: APP_CTX + '/secure/api/jugadores/club/' + clubLocal,
            data: null,
            success: function (response) {
                if (response.code === "0") {
                    _self.renderJugadores('Equipo Local', options.jugadoresLocalesContainer, response.content);
                }
            }
        });
        $.ajax({
            dataType: "json",
            url: APP_CTX + '/secure/api/jugadores/club/' + clubVisitante,
            data: null,
            success: function (response) {
                if (response.code === "0") {
                    _self.renderJugadores('Equipo Visitante', options.jugadoresVisitantesContainer, response.content);
                }
            }
        });
    }
    function renderJugadores(label, container, jugadores) {
        var content = ['<p>' + label + '</p>'], checkboxName = label.replace(/\s+/g, '').toLowerCase();
        if (!jugadores || jugadores.length < 1) {
            content.push('Sin jugadores habilitados');
        }
        $.each(jugadores, function (idx, jugador) {
            content.push('<label for="checkbox_' + label + '_' + idx + '">');
            content.push('<input name="' + checkboxName + '" type="checkbox" data-jugador=id="' + jugador.id + '" id="checkbox_' + label + '_' + idx + '" title="Jugador ' + jugador.nombre + '">');
            content.push(jugador.nombre + '</label>');
        });
        $(container).html(content.join('\n'));

    }

    return {
        nextTab: showNextTab,
        getSelectedClubs: getClubesSeleccionados,
        loadPlayers: cargaJugadores,
        renderJugadores: renderJugadores
    };
}