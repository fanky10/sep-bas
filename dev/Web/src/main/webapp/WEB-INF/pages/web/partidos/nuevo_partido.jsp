<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> 
    <script type="text/javascript" src="<c:url value="/js/vendor/jquery.validate.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/partidos/partido-nuevo.js"/>"></script> 
</content>
<content tag="jscript">
    <script>
        $(document).foundation();
    </script>
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">

            <h3>Iniciar Partido</h3>
            <form id="iniciarPartidoForm" class="custom" method="POST" action="<c:url value="/partidos/iniciar"/>">
                <input id="clubesValidation" name="clubesValidation" hidden="true" />
                <div class="clubes">
                    <h5>Aquí seleccionaremos el local y el visitante</h5>
                    <div class="row">
                        <div class="large-4 columns">
                            <label for="clubesLocales">Local</label> 
                            <select id="clubesLocales" name="clubesLocales" class="medium">
                                <c:forEach items="${clubes}" var="club" varStatus="stat">
                                    <option value="${club.id}">${club.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="large-4 columns">
                            <label for="clubesVisitantes">Visitante</label> 
                            <select id="clubesVisitantes" name="clubesVisitantes" class="medium">
                                <c:forEach items="${clubes}" var="club" varStatus="stat">
                                    <option value="${club.id}">${club.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                </div>
                <div class="jugadores">
                    <h5>Seleccione Clubes</h5>
                    <div class="row jugadores-content" >
                        <div class="six columns jugadores-locales-container">
                        </div>
                        <div class="six columns end jugadores-visitantes-container">
                        </div>
                    </div>
                </div>

                <div class="arbitros">
                    <h5>Seleccione el árbitro del encuentro</h5> 
                    <c:forEach items="${arbitros}" var="arbitro" varStatus="stat">
                        <label for="radio${stat.count}"> <input
                                name="radioArbitros" type="radio" id="radio${stat.count}" value="${arbitro.id}">${arbitro.nombre}
                            ${arbitro.apellido}
                        </label>
                    </c:forEach>
                </div>
            </form>
            <div id="errorsContainer"></div>
            <div class="row">
                <div class="two columns offset-by-ten">
                    <a href="#" data-reveal-id="resumenModal" class="round button iniciar">Iniciar</a>
                </div>
            </div>


        </div>
    </div>
    <div id="resumenModal" class="reveal-modal medium" data-reveal >
        <a class="close-reveal-modal">&#215;</a>
        <h5>Resumen</h5>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Fecha:</label>
                <label class="right inline fecha">10/10/2014</label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Local: Cantidad Jugadores Seleccionados:</label>
                <label class="right inline jugadores-locales">20</label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Visitante: Cantidad Jugadores Seleccionados:</label>
                <label class="right inline jugadores-visitantes">20</label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Arbitro Asignado:</label>
                <label class="right inline arbitro-seleccionado">Juan Perez</label>
            </div>
        </div>
        <div>
            <div class="six columns">
                <a href="#" id="closeResumenModal" class="left button">Cancelar</a>
                <a href="#" id="acceptResumenModal" class="right success button">Aceptar</a>
            </div>
        </div>
    </div>
</content>