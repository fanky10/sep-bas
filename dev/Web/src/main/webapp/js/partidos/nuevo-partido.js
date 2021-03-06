$(function () {
    var partidoView = new PartidoView();
    var iniciarPartidoForm = $('#iniciarPartidoForm');
    var options = {
        NUMERO_MINIMO_JUGADORES: 5,
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
                jugadoresLocalesLength = $('.jugadores-locales-container input:checkbox:checked').length,
                jugadoresVisitantedLength = $('.jugadores-visitantes-container input:checkbox:checked').length,
                idSelectArbitro = $('input:radio:checked').attr('id'),
                arbitroSeleccionado = $("label[for='" + idSelectArbitro + "']").text();
        if (validated) {
            $('div label.jugadores-locales').text(jugadoresLocalesLength);
            $('div label.jugadores-visitantes').text(jugadoresVisitantedLength);
            $('div label.arbitro-seleccionado').text(arbitroSeleccionado);
            var mDate = moment().format('DD/MM/YYYY');
            $('.js-fecha-encuentro').text(mDate);
        }
        return validated;
    });

    // modal events:
    $('#acceptResumenModal').click(function (e) {
        if (!iniciarPartidoForm.valid()) {
            return false;
        }
        iniciarPartidoForm.submit();
    });

    $('#closeResumenModal').click(function (e) {
        e.preventDefault();
        $('#resumenModal').foundation('reveal', 'close');
    });

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
            jugadoresLocales: {
                minSelectedPlayer: true,
                maxSelectedPlayer: true
            },
            jugadoresVisitantes: {
                minSelectedPlayer: true,
                maxSelectedPlayer: true
            },
            arbitro: {
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
            jugadoresLocales: {
                minSelectedPlayer: 'Equipo Local: Al menos deben seleccionarse ' + options.NUMERO_MINIMO_JUGADORES,
                maxSelectedPlayer: 'Equipo Local: Como maximo deben seleccionarse ' + options.NUMERO_MAXIMO_JUGADORES
            },
            jugadoresVisitantes: {
                minSelectedPlayer: 'Equipo Visitante: Al menos deben seleccionarse ' + options.NUMERO_MINIMO_JUGADORES,
                maxSelectedPlayer: 'Equipo Visitante: Como maximo deben seleccionarse ' + options.NUMERO_MAXIMO_JUGADORES
            },
            arbitro: {
                required: 'Al menos debe seleccionarse un arbitro'
            }
        }
    });

});


PartidoView = function () {
    var options = {
        jugadoresLocalesContainer: '.jugadores-locales-container',
        jugadoresVisitantesContainer: '.jugadores-visitantes-container'
    };

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
                    _self.renderJugadores('LOCAL', options.jugadoresLocalesContainer, response.content);
                }
            }
        });
        $.ajax({
            dataType: "json",
            url: APP_CTX + '/secure/api/jugadores/club/' + clubVisitante,
            data: null,
            success: function (response) {
                if (response.code === "0") {
                    _self.renderJugadores('VISITANTE', options.jugadoresVisitantesContainer, response.content);
                }
            }
        });
    }
    function renderJugadores(type, container, jugadores) {
        var label = 'Equipo Local';
        var inputName = 'jugadoresLocales';
        if (type === 'VISITANTE') {
            label = 'Equipo Visitante';
            inputName = 'jugadoresVisitantes';
        }

        var content = ['<p>' + label + '</p>'];
        if (!jugadores || jugadores.length < 1) {
            content.push('Sin jugadores habilitados');
        }
        $.each(jugadores, function (idx, jugador) {
            content.push('<label for="checkbox_' + label + '_' + idx + '">');
            content.push('<input value="' + jugador.id + '"name="' + inputName + '" type="checkbox" data-jugador-id="' + jugador.id + '" id="checkbox_' + label + '_' + idx + '" title="Jugador ' + jugador.nombre + '">');
            content.push('('+jugador.numero +')'+  jugador.nombre + ' ' + jugador.apellido+'</label>');
        });
        $(container).html(content.join('\n'));

    }

    function getJugadoresSeleccionados() {
        var jugadoresSeleccionados = {
            jugadoresLocales: [],
            jugadoresVisitantes: []
        }, equipoLocalSeleccionado = $('input[name="equipolocal"]').filter(':checked'),
                equipoVisitanteSeleccionado = $('input[name="equipovisitante"]').filter(':checked');

        $.each(equipoLocalSeleccionado, function () {
            jugadoresSeleccionados.jugadoresLocales.push($(this).attr('data-jugador-id'));
        });
        $.each(equipoVisitanteSeleccionado, function () {
            jugadoresSeleccionados.jugadoresVisitantes.push($(this).attr('data-jugador-id'));
        });
        return jugadoresSeleccionados;
    }

    return {
        nextTab: showNextTab,
        getSelectedClubs: getClubesSeleccionados,
        loadPlayers: cargaJugadores,
        renderJugadores: renderJugadores,
        getSelectedJugadores: getJugadoresSeleccionados
    };
}