<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
    <%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
    <%-- some jscript libraries rel to this page in specific --%>	
</content>
<content tag="jscript">
    <script>
        function deleteClub(element) {
            clubId = element.getAttribute("club-id"); //refers to the element actioning this method
            li = element.parentNode;
            $.post("${ctx}/clubes/delete.json", {"id": clubId},
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
            <h3><a href="<c:url value="/clubes/add"/>" class="button"> NUEVO CLUB</a></h3>
        </div>
    </div>
    <div class="content">
        <div class="row">
            <div class="twelve columns">
                <c:choose>
                    <c:when test="${empty clubes}">
                        <div class="twelve columns">
                            No se encontraron clubes
                            <hr class="sin-margin-top" />
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="twelve columns">
                                <h2>Clubes</h2>
                            </div>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th width="150">Nombre</th>
                                    <th width="150">Localidad</th>
                                    <th colspan="2">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="club" items="${clubes}">
                                <div class="row">
                                    <tr>
                                        <td>${club.nombre}</td>
                                        <td>${club.localidad}</td>
                                        <td>
                                            <a href="<c:url value="/clubes/edit/${club.id}" />" class="button" alt="Editar" club-id="${club.id}" >
                                                Editar
                                            </a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/clubes/del/${club.id}" />" class="button" alt="Eliminar" club-id="${club.id}" >
                                                Eliminar
                                            </a>
                                        </td>
                                    </tr>
                                </div>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div id="deleteResponse"></div>
                    </c:otherwise>
                </c:choose>

                <a href="<c:url value="/home"/>" class="button"> Volver</a>                   
            </div>
        </div>
    </div>
</content>