<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
    <%-- some link rel to this page in specific --%>	
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">
            <h3>Iniciar Cuarto #${cuartoNumero}</h3>
            <c:url value="/cuarto/iniciar" var="iniciarCuartoFormAction"/>
            <form:form id="iniciarCuartoForm" action="${iniciarCuartoFormAction}" modelAttribute="iniciarCuartoForm" method="POST">
                <input name="cuartoNumero" hidden="true" value="${cuartoNumero}"/>
                <div class="clubes">
                    <div class="row">
                        <div class="large-6 columns">
                            <h2>Local ${clubLocal.nombre}</h2> 
                        </div>
                        <div class="large-6 columns">
                            <h2>Visitante ${clubVisitante.nombre}</h2> 
                        </div>
                    </div>
                </div>
                <div class="jugadores">
                    <div class="row jugadores-content" >
                        <div class="large-6 columns jugadores-locales-container">
                            <c:forEach items="${jugadoresClubLocal}" var="jugador" varStatus="stat">
                                <c:set var="checked" value=""></c:set>
                                <c:if test="${allChecked && stat.count <=5}">
                                    <c:set var="checked" value="checked"></c:set>
                                </c:if>
                                <label for="chkLocal${stat.count}">
                                    <input name="jugadoresLocales" type="checkbox" id="chkLocal${stat.count}" value="${jugador.id}" ${checked} />
                                    ${jugador.nombre} ${jugador.apellido}
                                </label>
                            </c:forEach>
                        </div>
                        <div class="large-6 columns jugadores-visitantes-container">
                            <c:forEach items="${jugadoresClubVisitante}" var="jugador" varStatus="stat">
                                <c:set var="checked" value=""></c:set>
                                <c:if test="${allChecked && stat.count <=5}">
                                    <c:set var="checked" value="checked"></c:set>
                                </c:if>
                                <label for="chkVisita${stat.count}">
                                    <input name="jugadoresVisitantes" type="checkbox" id="chkVisita${stat.count}" value="${jugador.id}" ${checked} />
                                    ${jugador.nombre} ${jugador.apellido}
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <input name="submit" type="submit" class="round button iniciar" value="Iniciar Nuevo Cuarto"/>
                <form:errors path="*" cssClass="errorsContainer" element="div"/>
            </form:form>
            <div id="errorsContainer"></div>
        </div>
    </div>
</content>