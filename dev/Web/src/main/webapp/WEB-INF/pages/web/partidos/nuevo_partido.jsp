<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> 
    <script type="text/javascript" src="<c:url value="/js/vendor/jquery.validate.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/partidos/nuevo-partido.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/vendor/moment-with-locales.js"/>"></script> 
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
            <c:url value="/partido/iniciar" var="iniciarPartidoFormAction"/>
            <form:form id="iniciarPartidoForm" action="${iniciarPartidoFormAction}" modelAttribute="iniciarPartidoForm" method="POST">
                <input id="clubesValidation" name="clubesValidation" hidden="true" />
                <div class="arbitros">
                    <h5>Seleccione el árbitro del encuentro</h5> 
                    <span class="input">
                        <form:select path="arbitro">
                            <form:options items="${arbitros}" itemValue="id" itemLabel="nombre"></form:options>
                        </form:select>
                    </span>
                </div>
                <div class="clubes">
                    <h5>Aquí seleccionaremos el local y el visitante</h5>
                    <div class="row">
                        <div class="large-6 columns">
                            <label for="clubesLocales">Local</label> 
                            <select id="clubesLocales" name="clubLocal" class="medium">
                                <c:forEach items="${clubes}" var="club" varStatus="stat">
                                    <option value="${club.id}">${club.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="large-6 columns">
                            <label for="clubesVisitantes">Visitante</label> 
                            <select id="clubesVisitantes" name="clubVisitante" class="medium">
                                <c:forEach items="${clubes}" var="club" varStatus="stat">
                                    <option value="${club.id}">${club.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        
                    </div>


                </div>
                <div class="jugadores">
                    <h5>Seleccione Clubes</h5>
                    <div class="row jugadores-content" >
                        <div class="large-6 columns jugadores-locales-container">
                        </div>
                        <div class="large-6 columns jugadores-visitantes-container">
                        </div>
                    </div>
                </div>
                <form:errors path="*" cssClass="errorsContainer" element="div"/>
            </form:form>
            <div id="errorsContainer"></div>
        </div>
        <div class="row">
            <div class="two columns offset-by-ten">
                    <a href="#" data-reveal-id="resumenModal" class="round button iniciar">Iniciar</a>
            </div>
        </div>
    </div>
    <div id="resumenModal" class="reveal-modal medium" data-reveal >
        <a class="close-reveal-modal">&#215;</a>
        <h5>Resumen</h5>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Fecha:</label>
                <label class="js-fecha-encuentro right inline fecha"></label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Local: Cantidad Jugadores Seleccionados:</label>
                <label class="js-jugadores-locales-count right inline jugadores-locales"></label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Visitante: Cantidad Jugadores Seleccionados:</label>
                <label class="js-jugadores-visitantes-count right inline jugadores-visitantes"></label>
            </div>
        </div>
        <div>
            <div class="six mobile-one columns">
                <label class="left inline">Arbitro Asignado:</label>
                <label class="js-arbitro right inline arbitro-seleccionado"></label>
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