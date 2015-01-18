<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
    <%-- some link rel to this page in specific --%>	
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">
            <h3>Iniciar Cuarto #${cuartoNumero}</h3>
            <c:url value="/cuartos/iniciar" var="iniciarCuartoFormAction"/>
            <form:form id="iniciarCuartoForm" action="${iniciarCuartoFormAction}" modelAttribute="iniciarCuartoForm" method="POST">
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
                                <label for="chkLocal${stat.count}">
                                    <input name="jugador" type="checkbox" id="chkLocal${stat.count}" value="${jugador.id}">
                                    ${jugador.nombre} ${jugador.apellido}
                                </label>
                            </c:forEach>
                        </div>
                        <div class="large-6 columns jugadores-visitantes-container">
                            <c:forEach items="${jugadoresClubVisitante}" var="jugador" varStatus="stat">
                                <label for="chkVisita${stat.count}"> 
                                    <input name="jugador" type="checkbox" id="chkVisita${stat.count}" value="${jugador.id}">
                                    ${jugador.nombre} ${jugador.apellido}
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <form:errors path="*" cssClass="errorsContainer" element="div"/>
            </form:form>
            <div id="errorsContainer"></div>
        </div>
        <div class="row">
            <div class="two columns offset-by-ten">
                    <a href="#" data-reveal-id="resumenModal" class="round button iniciar">Iniciar Nuevo Cuarto</a>
            </div>
        </div>
    </div>
</content>