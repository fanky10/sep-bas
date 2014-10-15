<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> 
    <script type="text/javascript" src="<c:url value="/js/foundation/foundation.forms.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/vendor/jquery.validate.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/partidos/partido-nuevo.js"/>"></script> 
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">

            <h3>Iniciar Partido</h3>
            <form id="iniciarPartidoForm" class="custom">
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
                                name="radioArbitros" type="radio" id="radio${stat.count}">${arbitro.nombre}
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
    <div id="resumenModal" class="reveal-modal medium" data-hello="hello-data" data-reveal-id="resumenModal" data-reveal >
        <a class="close-reveal-modal">&#215;</a>
        <h5>Super Resumen</h5>
        <div class="row">
            <div class="four mobile-one columns">
                <label class="left inline">Fecha:</label>
                <label class="right inline fecha">10/10/2014</label>
            </div>
        </div>
        <div class="row">
            <div class="four mobile-one columns">
                <label class="left inline">Local: Cantidad Jugadores Seleccionados:</label>
                <label class="right inline fecha">20</label>
            </div>
        </div>
        <div class="row">
            <div class="four mobile-one columns">
                <label class="left inline">Visitante: Cantidad Jugadores Seleccionados:</label>
                <label class="right inline fecha">20</label>
            </div>
        </div>
        <div class="row">
            <div class="four mobile-one columns">
                <label class="left inline">Arbitro Asignado</label>
                <label class="right inline fecha">Juan Perez</label>
            </div>
        </div>
        <div class="row">
            <div class="two columns">
                <a href="#" id="closeResumenModal" class="">Cancelar</a>
            </div>
            <div class="two columns">
                <a class="success button" href="#">Iniciar Partido</a>
            </div>
        </div>
    </div>
</content>