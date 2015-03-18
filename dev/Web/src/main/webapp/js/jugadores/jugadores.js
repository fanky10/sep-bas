$(function () {
    var jqClubSelector = $('.js-clubes');
    var jugadoresView = new JugadoresView();
    
    jqClubSelector.on('change', function (event) {
        var idClub = this.value;
        jugadoresView.renderJugadoresByClub(idClub);
    });
    // carga inicial
    var idClubInicial = jqClubSelector.val();
    jugadoresView.renderJugadoresByClub(idClubInicial);

});

JugadoresView = function () {
    var jugadoresBody = $('.js-jugadores-body');

    function renderJugadoresByClub(idClub) {

        getJugadores(idClub).success(function (response) {
            var jugadores = response.content;
            var content = [];
            $.each(jugadores, function (idx, jugador) {
                content.push('<tr>');
                content.push('<td>' + jugador.nombre + '</td>');
                content.push('<td>' + jugador.apellido + '</td>');
                content.push('<td>' + jugador.club.nombre + '</td>');
                content.push('<td><a href="'+APP_CTX+'/jugadores/edit/'+jugador.id+'" class="button" alt="Editar" jugador-id="'+jugador.id+'" >Editar</a></td>');
                content.push('<td><a href="'+APP_CTX+'/jugadores/del/'+jugador.id+'" class="button" alt="Editar" jugador-id="'+jugador.id+'" >Eliminar</a></td>');
                content.push('</tr>');
            });
            jugadoresBody.html(content.join())
        });
    }

    function getJugadores(idClub) {
        return $.ajax({
            dataType: "json",
            url: APP_CTX + '/secure/api/jugadores/club/' + idClub,
            data: null
        });
    }

    return {
        renderJugadoresByClub: renderJugadoresByClub
    };
}