//this is my superScript plugin!!
(function ($) {
    $.fn.extend({
        //pass the options variable to the function
        customDropdown: function (options) {
            //Set the default values, use comma to separate the settings, example:
            var defaults = {
                opt: 1,
                targetLabel: $("#divClubLocal a.current"),
                targetSelect: $('#clubLocal')
            }

            var options = $.extend(defaults, options);
            return this.each(function () {
                var o = options;
                var obj = $(this);
                obj.bind('keyup', function (e) {
                    if (e.keyCode == 13) {//enter
                        o.targetSelect.trigger('change');
                        return false;
                    }

                    var searching = String.fromCharCode(e.keyCode);
                    var selectedElements = $("ul li.selected", obj);
                    selectedElements.removeClass("selected");
                    var filtered = $("ul li", obj).filter(function () {
                        var currentText = $(this).text();
                        var found = $(this).text().slice(0, searching.length).toLowerCase() == searching.toLowerCase();
                        return found;
                    });

                    //we have everything found, but if there's something selected then select the next one
                    var length = filtered.length;
                    filtered.each(function (index, element) {
                        var isSelected = $(element).attr("isselected") == 'true';

                        if (isSelected && index == length - 1) {//we are the last one and we are selected!
                            $(element).attr("class", "selected");
                            return false;//nothing to do
                        } else if (isSelected && index < length - 1) {//selected but not the last one
                            //remove properties
                            $(element).attr("isselected", false);//i'm not the last one, give me another!
                            //continue (:
                        } else {//not selected first one --> first timer!
                            $(element).attr("isselected", true);
                            $(element).attr("class", "selected");
                            return false;
                        }
                    });
                    //in case there are several
                    var current = filtered.filter(".selected").filter(':first');
                    o.targetLabel.text(current.text());

                });

            });
        }
    });
})(jQuery);



function validaJugadoresHabilitados() {
    validaJugadores("checkbox_local");
    validaJugadores("checkbox_visita");
}


function validaJugadores(tagNameOrigen) {
    var checkboxes = document.getElementsByName(tagNameOrigen); //Array que contiene los checkbox
    var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados
    for (var x = 0; x < checkboxes.length; x++) {
        if (checkboxes[x].checked) {
            cont = cont + 1;
        }
    }

    if (cont > 4 && cont < 12) {
        return true;
    }
    if (tagNameOrigen == "checkbox_local") {
        alert("Debe haber entre 5 y 12 jugadores habilitados para jugar en el equipo local");
    } else {
        alert("Debe haber entre 5 y 12 jugadores habilitados para jugar en el equipo visitante");
    }
}

function validaArbitros() {

    var checkboxes = document.getElementsByName("checkbox_arbitros"); //Array que contiene los checkbox	
    var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados

    for (var x = 0; x < checkboxes.length; x++) {
        if (checkboxes[x].checked) {
            cont = cont + 1;
        }
    }
    if (cont == 0) {
        alert("Debe seleccionarse al menos un árbitro");
        return true;
    }
}

function cargarDatos() {
    if (validaArbitros()) {
        return false;
    }
    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    var f = new Date();

    document.getElementById("fecha_reemplaza").innerHTML = '<input name="Fecha" disabled type="text" value="' + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear() + '">';
    var l = document.getElementsByName("local");
    var local = $("local");//getElementsByName
    local = $("#local");//getElementsById
    local = $(".local");//getElementsByClass


    document.getElementById("equipo_local").innerHTML = '<input name="e_local" disabled type="text" value="' + l[0].value + '">';
    var v = document.getElementsByName("visita");
    document.getElementById("equipo_visita").innerHTML = '<input name="e_visita" disabled type="text" value="' + v[0].value + '">';

    crearTabla("checkbox_local", "jugadores_locales__habilitados", "Jugadores en cancha de: " + l[0].value);
    crearTabla("checkbox_visita", "jugadores_visitantes_habilitados", "Jugadores en cancha de: " + v[0].value);
    crearTabla("checkbox_arbitros", "arbitros_asignados", "Arbitros designados");
}

function crearTabla(tagNameOrigen, tagIdDestino, tituloTabla) {
    var checboxes = document.getElementsByName(tagNameOrigen);
    var tabla = '';
    tabla += '<table class="twelve">';
    tabla += '<thead>';
    tabla += '<tr>';
    tabla += '<th>' + tituloTabla + '</th>';
    tabla += '</tr>';
    tabla += '</thead>';
    tabla += '<tbody>';

    for (var x = 0; x < checboxes.length; x++) {
        if (checboxes[x].checked) {
            tabla += '<tr>';
            tabla += '<td><input name="e_visita" disabled type="text" value="' + checboxes[x].getAttribute("title") + '"></td>';
            tabla += '</tr>';
        }
    }
    tabla += '</tbody>';
    tabla += '</table>';
    document.getElementById(tagIdDestino).innerHTML = tabla;
}

$(function () {
    var partidoView = new PartidoView(),
            iniciarPartidoForm = $('#iniciarPartidoForm'),
            options = {
                NUMERO_MINIMO_JUGADORES: 4,
                NUMERO_MAXIMO_JUGADORES: 12
            };
    $('#clubesLocales').change(clubSeleccionadoEvent);
    $('#clubesVisitantes').change(clubSeleccionadoEvent);
    function clubSeleccionadoEvent(e) {
        if (iniciarPartidoForm.valid()) {
            $('#errorsContainer').html('');
            partidoView.loadPlayers();
        }
    }
    
    $('.button.iniciar').click(function (e) {
        e.preventDefault();
        return iniciarPartidoForm.valid();
    });

    // validation
    $.validator.setDefaults({
        ignore: [], // ignores hidden elements such as: select
        errorPlacement: function (error, element) {
            error.appendTo('#errorsContainer');
        }
    });
    $.validator.addMethod('selectedClub', function (value, element) {
        var selectedClubs = partidoView.getSelectedClubs();
        return (selectedClubs.idClubLocal !== selectedClubs.idClubVisitante);
    }, 'Club local y visitante iguales');

    $('#iniciarPartidoForm').validate({
        rules: {
            clubesLocales: {
                selectedClub: true
            },
            equipolocal: {
                required: false,
                minlength: options.NUMERO_MINIMO_JUGADORES,
                maxlength: options.NUMERO_MAXIMO_JUGADORES
            },
            equipovisitante: {
                required: false,
                minlength: options.NUMERO_MINIMO_JUGADORES,
                maxlength: options.NUMERO_MAXIMO_JUGADORES
            }
        },
        messages:{
            equipolocal: {
                required: 'Al menos deben seleccionarse '+options.NUMERO_MINIMO_JUGADORES,
                minlength: 'Minimo de jugadores de equipo local {0}',
                maxlength: 'Maximo de jugadores de equipo local {0}'
            },
            equipovisitante: {
                required: 'Al menos deben seleccionarse  '+options.NUMERO_MINIMO_JUGADORES,
                minlength: 'Minimo de jugadores de equipo visitante {0}',
                maxlength: 'Maximo de jugadores de equipo visitante {0}'
            }
        }
    });

});

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
                    _self.jugadoresValidation(options.jugadoresLocalesContainer);
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
                    _self.jugadoresValidation(options.jugadoresVisitantesContainer);
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
            content.push('<input name="' + checkboxName + '" type="checkbox" data-jugador=id="' + jugador.id + '" id="checkbox_' + label + '_' + idx + '" title="Jugador '+jugador.nombre+'">');
            content.push(jugador.nombre + '</label>');
        });
        $(container).html(content.join('\n'));
        
    }
    
    function jugadoresValidation(container){
        $(container+' input:checkbox').click(function(){
           $('#errorsContainer').html('');
           $('#iniciarPartidoForm').valid();
        });
    }

    return {
        nextTab: showNextTab,
        getSelectedClubs: getClubesSeleccionados,
        loadPlayers: cargaJugadores,
        renderJugadores: renderJugadores,
        jugadoresValidation: jugadoresValidation
    };
}