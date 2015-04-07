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
        $partidoCuartoTabs: $('.js-cuartos-tabs')
    };

    function render() {
        getPartidoData()
                .success(function (response) {
                    renderPartidoData(response.content.partido);
                    renderChart(response.content.cuartos);
                    renderCuartosTabs(response.content.cuartos);
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

    function renderPartidoData(partido) {
        options.$resultadoLocalContainer.html(partido.clubLocal.nombre + '<br>' + partido.resultadoLocal);
        options.$resultadoVisitanteContainer.html(partido.clubVisitante.nombre + '<br>' + partido.resultadoVisitante);
        options.$partidoFechaContainer.html(moment(partido.fecha).format('DD/MM/YYYY'));
        options.$partidoEstadioContainer.html('Estadio de: ' + partido.clubLocal.nombre);
        options.$partidoArbitroContainer.html('Arbitro: ' + partido.arbitro.nombre);
    }

    function renderChart(cuartos) {
        var localData = [0];
        var visitanteData = [0];
        $.each(cuartos, function (idx, cuarto) {
            localData.push(cuarto.resultadoLocal);
            visitanteData.push(cuarto.resultadoVisitante);
        });

        var lineChartData = {
            labels: ["Inicio", "1er Cuarto", "2do Cuarto", "3er Cuarto", "4to Cuarto"],
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

        }
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
        var content = [];
        for (; i < 4; i++) {
            var cuarto = cuartos[i];
            if (cuarto) {
                resultadoLocal = cuarto.resultadoLocal;
                resultadoVisitante = cuarto.resultadoVisitante;
            } else {
                resultadoLocal = 0;
                resultadoVisitante = 0;
        
            }
            content.push('<li class="tab-title" style="width: 20%;">\n');
            content.push('<a class="js-tab-cuarto" data-numero="' + numeroCuarto + '" href="#"><strong>' + numeroCuarto + '&#186; Cuarto</strong>');
            content.push('<br>Local: ' + resultadoLocal + '<br>Visita: ' + resultadoVisitante + '</a></li>');
            numeroCuarto += 1;
        }
        options.$partidoCuartoTabs.append(content.join(''))
    }


    return {
        render: render
    };
};
