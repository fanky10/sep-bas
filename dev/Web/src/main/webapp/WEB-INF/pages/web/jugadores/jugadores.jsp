<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
    <%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
    <script type="text/javascript" src="<c:url value="/js/jugadores/jugadores.js"/>"></script>
</content>
<content tag="jscript">
    <script>
        function deleteJugador(element) {
            jugadorId = element.getAttribute("jugador-id"); //refers to the element actioning this method
            li = element.parentNode;
            $.post("${ctx}/jugadores/delete.json", {"id": jugadorId},
            function (response) {
                if (response.status == "OK") {//remove it
                    $(li).fadeOut("slow", function () {
                        $(this).remove();
                    });
                } else if (response.status == "ERROR") {
                    $("#deleteResponse").html(response.error);
                }

            }, "json"
                    );
        }
    </script>
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">
            </br>
            <a href="<c:url value="/jugadores/add"/>" class="button" align="center" >NUEVO JUGADOR</a>
        </div>
    </div>

    <div class="content">
        <div class="row">
            <div class="twelve columns">
                <c:choose>
                    <c:when test="${empty jugadores}">
                        <div class="twelve columns">
                            No se encontraron jugadores
                            <hr class="sin-margin-top" />
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="twelve columns">
                                <h2>Jugadores</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="six columns">
                                <h2>Filtro por Club</h2>
                            </div>
                            <div class="six columns">
                                <select class="js-clubes">
                                    <c:forEach var="club" items="${clubes}">
                                        <option class="js-club" label="${club.nombre}" value="${club.id}" />${club.nombre}
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th width="150">Nombre</th>
                                    <th width="150">Apellido</th>
                                    <th width="150">Equipo</th>
                                    <th colspan="2">Acciones</th>
                                </tr>
                            </thead>
                            <tbody class="js-jugadores-body">
                                <c:forEach var="jugador" items="${jugadores}">
                                <tr>
                                    <td>${jugador.nombre}</td>
                                    <td>${jugador.apellido}</td>
                                    <td>${jugador.club.nombre}</td>
                                    <td>
                                        <a href="<c:url value="/jugadores/edit/${jugador.id}" />" class="button" alt="Editar" jugador-id="${jugador.id}" >
                                            Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/jugadores/del/${jugador.id}" />" class="button" alt="Eliminar" jugador-id="${jugador.id}" >
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div id="deleteResponse"></div>
                    </c:otherwise>
                </c:choose>

                <a href="<c:url value="/home"/>" class="button">Volver</a> 
            </div>
        </div>
    </div>
</content>