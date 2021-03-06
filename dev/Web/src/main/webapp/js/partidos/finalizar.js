$(function () {
    new ReporteFinPartidoView().render();
});


// function constructora de clase
ReporteFinPartidoView = function () {
    var options = {
        $resultadoLocalContainer: $('.js-resultado.local'),
        $resultadoVisitanteContainer: $('.js-resultado.visitante'),
        $partidoFechaContainer: $('.js-fecha-partido'),
        $partidoEstadioContainer: $('.js-estadio-partido'),
        $partidoArbitroContainer: $('.js-arbitro-partido'),
        $partidoCuartoTabs: $('.js-cuartos-tabs'),
        $tablaJugadoresLocal: $('.js-jugadores-data-local'),
        $tablaJugadoresVisitante: $('.js-jugadores-data-visitante'),
        $canvasContainer: $('.js-canvas-container')
    };

    var partidoActual;

    function render() {
        getPartidoData()
                .success(function (response) {
                    partidoActual = response.content.partido;
                    partidoActual.cuartos = response.content.cuartos;

                    renderCuartosTabs(response.content.cuartos);
                    renderPartidoData(response.content.partido);
                    renderCharts();
                    renderTablaJugadores();
                });
    }

    function getPartidoData() {
        return $.ajax({
            url: APP_CTX + '/secure/api/reportes/partido/' + ID_PARTIDO_PARAM + '.json',
            type: "GET",
            data: {},
            dataType: "json"
        });
    }

    function renderCharts () {
        renderLineChartAcumByCuarto();
        $('.js-chart-cuarto').on('click', function (event) {
            event.preventDefault();

            var type = $(this).attr('data-type');

            $('.js-chart-cuarto').parent().removeClass('active');
            $(this).parent().addClass('active');

            if(type === 'ACUMULADO') {
                renderLineChartAcumByCuarto();
            } else if(type === 'POR_CUARTO') {
                renderBarChartByCuarto();
            }
        });
    }

    function renderBarChartByCuarto() {
        var localData = [];
        var visitanteData = [];
        $.each(partidoActual.cuartos, function (idx, cuarto) {
            localData.push(cuarto.resultadoLocal);
            visitanteData.push(cuarto.resultadoVisitante);
        });

        var lineChartData = {
            labels: ["1er Cuarto", "2do Cuarto", "3er Cuarto", "4to Cuarto"],
            datasets: [
                {
                    label: "Local",
                    fillColor: "rgba(255,50,0,0.2)",
                    strokeColor: "rgba(255,50,0,1)",
                    pointColor: "rgba(255,50,0,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(255,0,0,1)",
                    data: localData
                },
                {
                    label: "Visita",
                    fillColor: "rgba(151,187,205,0.2)",
                    strokeColor: "rgba(151,187,205,1)",
                    pointColor: "rgba(151,187,205,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: visitanteData
                }
            ]
        };
        options.$canvasContainer.html('<canvas id="canvas" height="200" width="600"></canvas>');
        var ctx = document.getElementById("canvas").getContext("2d");
        new Chart(ctx).Bar(lineChartData, {
            responsive: true
        });
    }

    function renderLineChartAcumByCuarto() {
        var localData = [0];
        var visitanteData = [0];
        var sumResultadoLocal = 0;
        var sumResultadoVisitante = 0;
        $.each(partidoActual.cuartos, function (idx, cuarto) {
            sumResultadoLocal += cuarto.resultadoLocal;
            sumResultadoVisitante += cuarto.resultadoVisitante;
            localData.push(sumResultadoLocal);
            visitanteData.push(sumResultadoVisitante);
        });

        var lineChartData = {
            labels: ["Inicio", "1er Cuarto", "2do Cuarto", "3er Cuarto", "4to Cuarto"],
            datasets: [
                {
                    label: "Local",
                    fillColor: "rgba(220,220,220,0)",
                    strokeColor: "rgba(255,50,0,1)",
                    pointColor: "rgba(255,50,0,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(255,0,0,1)",
                    data: localData
                },
                {
                    label: "Visita",
                    fillColor: "rgba(220,220,220,0)",
                    strokeColor: "rgba(151,187,205,1)",
                    pointColor: "rgba(151,187,205,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: visitanteData
                }
            ]
        };
        options.$canvasContainer.html('<canvas id="canvas" height="200" width="600"></canvas>');
        var ctx = document.getElementById("canvas").getContext("2d");
        new Chart(ctx).Line(lineChartData, {
            responsive: true
        });
    }

    function renderCuartosTabs(cuartos) {
        var i = 0;
        var resultadoLocal = 0;
        var resultadoVisitante = 0;
        var numeroCuarto = 1;
        var idCuarto = 0;
        var content = [];
        partidoActual.resultadoLocalCuartos = 0;
        partidoActual.resultadoVisitanteCuartos = 0;
        for (; i < 4; i++) {
            var cuarto = cuartos[i];
            if (cuarto) {
                resultadoLocal = cuarto.resultadoLocal;
                resultadoVisitante = cuarto.resultadoVisitante;
                partidoActual.resultadoLocalCuartos += cuarto.resultadoLocal;
                partidoActual.resultadoVisitanteCuartos += cuarto.resultadoVisitante;
                idCuarto = cuarto.id;
            } else {
                resultadoLocal = 0;
                resultadoVisitante = 0;

            }
            content.push('<li class="tab-title" style="width: 20%;">\n');
            content.push('<a class="js-tab-cuarto" data-numero="' + numeroCuarto + '" data-id="' + idCuarto + '" href="#"><strong>' + numeroCuarto + '&#186; Cuarto</strong>');
            content.push('<br>Local: ' + resultadoLocal + '<br>Visita: ' + resultadoVisitante + '</a></li>');
            numeroCuarto += 1;
        }
        options.$partidoCuartoTabs.append(content.join(''));

        $('.js-tab-cuarto').on('click', function (event) {
            event.preventDefault();

            $('.js-tab-cuarto').parent().removeClass('active');
            $(this).parent().addClass('active');

            renderTablaJugadores($(this).attr('data-id'));
        });
    }

    function renderPartidoData(partido) {
        options.$resultadoLocalContainer.html(partido.clubLocal.nombre + '<br>' + partido.resultadoLocalCuartos);
        options.$resultadoVisitanteContainer.html(partido.clubVisitante.nombre + '<br>' + partido.resultadoVisitanteCuartos);
        options.$partidoFechaContainer.html(moment(partido.fecha).format('DD/MM/YYYY'));
        options.$partidoEstadioContainer.html('Estadio de: ' + partido.clubLocal.nombre);
        options.$partidoArbitroContainer.html('Arbitro: ' + partido.arbitro.nombre);
    }

    function renderTablaJugadores(cuartoId) {
        var url = APP_CTX + '/secure/api/reportes/jugadores/' + partidoActual.id + (cuartoId ? '/' + cuartoId : '') + '.json';
        return $.ajax({
            url: url,
            type: "GET",
            data: {},
            dataType: "json"
        }).success(function (response) {
            var localTableContent = [];
            var visitanteTableContent = [];
            var reporte = response.content;
            $.each(reporte, function (idx, lineaReporte) {
                if (partidoActual.clubLocal.id === lineaReporte.jugador.club.id) {
                    localTableContent.push('<tr>');
                    localTableContent.push('<td align="center">' + lineaReporte.jugador.numero + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.jugador.nombre + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.cantidadSimples + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.cantidadDobles + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.cantidadTriples + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.cantidadAsistencias + '</td>');
                    localTableContent.push('<td align="center">' + lineaReporte.cantidadFaltas + '</td>');
                    localTableContent.push('</tr>');
                } else {
                    visitanteTableContent.push('<tr>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.jugador.numero + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.jugador.nombre + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.cantidadSimples + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.cantidadDobles + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.cantidadTriples + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.cantidadAsistencias + '</td>');
                    visitanteTableContent.push('<td align="center">' + lineaReporte.cantidadFaltas + '</td>');
                    visitanteTableContent.push('</tr>');
                }
            });

            options.$tablaJugadoresLocal.html(localTableContent.join(''));
            options.$tablaJugadoresVisitante.html(visitanteTableContent.join(''));
        });
    }

    return {
        render: render
    };
};