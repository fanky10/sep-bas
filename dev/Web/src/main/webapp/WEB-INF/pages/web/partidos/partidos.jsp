<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="bodyContent">
    <div class="content">
        <div class="row">
            <div class="twelve columns">
                <c:choose>
                    <c:when test="${empty partidos}">
                        <div class="twelve columns">
                            No se encontraron partidos
                            <hr class="sin-margin-top" />
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="twelve columns">
                                <h2>Partidos</h2>
                            </div>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th colspan="2">Partido</th>
                                    <th>Juez</th>
                                    <th colspan="2">Fecha</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="partido" items="${partidos}">
                                <div class="row">
                                    <tr>
                                        <td>${partido.clubLocal.nombre} VS ${partido.clubVisitante.nombre}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${empty partido.resultadoLocal || empty partido.resultadoVisitante}">
                                                    Partido No Finalizado
                                                </c:when>
                                                <c:otherwise>
                                                    ${partido.resultadoLocal} VS ${partido.resultadoVisitante}
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${partido.arbitro.nombre}</td>
                                        <td>
                                            <fmt:formatDate value="${partido.fecha}" var="dateString" pattern="dd/MM/yyyy" />
                                            ${dateString}
                                        </td>
                                        <td>
                                            <a href="<c:url value="/partido/${partido.id}" />" class="button tiny" style="margin-bottom: 0px">Ver Estadisticas</a>
                                        </td>
                                    </tr>
                                </div>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>              
            </div>
        </div>
    </div>
</content>