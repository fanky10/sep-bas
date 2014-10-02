<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> 
    <script type="text/javascript" src="<c:url value="/js/app.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/partidos/partido-nuevo.js"/>"></script> 
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">
            <h3>Inicializar Partido</h3>

            <dl class="tabs">
                <dd class="active">
                    <a href="#simple1"> Equipos</a>
                </dd>
                <dd>
                    <a href="#simple2"> Jugadores Habilitados</a>
                </dd>
                <dd>
                    <a href="#simple3"> Árbitros</a>
                </dd>
                <dd>
                    <a href="#simple4"> Resumen</a>
                </dd>
            </dl>

            <ul class="tabs-content">
                <!-- inicio tab clubes --> 
                <li class="active" id="simple1Tab">
                    <h5>Aquí seleccionaremos el local y el visitante</h5>
                    <form class="custom">
                        <div class="row">
                            <div class="large-4 columns">
                                <label for="clubesLocales">Local</label> 
                                <select id="clubesLocales" class="medium">
                                    <c:forEach items="${clubes}" var="club" varStatus="stat">
                                        <option value="${club.nombre}">${club.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-4 columns">
                                <label for="clubesVisitantes">Visitante</label> 
                                <select id="clubesVisitantes" class="medium">
                                    <c:forEach items="${clubes}" var="club" varStatus="stat">
                                        <option value="${club.nombre}">${club.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    </form>
                    <div class="row">
                        <div class="two columns offset-by-ten">
                            <a class="round button" href="#simple2" onClick="validaClubes()">Siguiente</a>
                        </div>
                    </div>
                </li>
                <!-- fin tab clubes --> 
                <li id="simple2Tab">
                    <h5>Jugadores Habilitados</h5>
                    <div class="row">
                        <div class="six columns">
                            <p>Local</p>
                            <label for="checkbox1"><input name="checkbox_local"
                                                          type="checkbox" CHECKED id="checkbox1" title="Jugador 1">
                                Jugador 1</label> <label for="checkbox2"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox2"
                                    title="Jugador 2"> Jugador 2</label> <label for="checkbox3"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox3"
                                    title="Jugador 3"> Jugador 3</label> <label for="checkbox4"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox4"
                                    title="Jugador 4"> Jugador 4</label> <label for="checkbox4"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox5"
                                    title="Jugador 5"> Jugador 5</label> <label for="checkbox4"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox6"
                                    title="Jugador 6"> Jugador 6</label> <label for="checkbox4"><input
                                    name="checkbox_local" type="checkbox" CHECKED id="checkbox7"
                                    title="Jugador 7"> Jugador 7</label>
                        </div>
                        <div class="five columns end">
                            <p>Visita</p>
                            <label for="checkbox6"><input name="checkbox_visita"
                                                          type="checkbox" CHECKED id="checkbox66" title="Jugador 1">
                                Jugador 1</label> <label for="checkbox7"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox76"
                                    title="Jugador 2"> Jugador 2</label> <label for="checkbox8"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox86"
                                    title="Jugador 3"> Jugador 3</label> <label for="checkbox9"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox96"
                                    title="Jugador 4"> Jugador 4</label> <label for="checkbox9"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox93"
                                    title="Jugador 5"> Jugador 5</label> <label for="checkbox9"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox92"
                                    title="Jugador 6"> Jugador 6</label> <label for="checkbox9"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox91"
                                    title="Jugador 7"> Jugador 7</label> <label for="checkbox9"><input
                                    name="checkbox_visita" type="checkbox" CHECKED id="checkbox94"
                                    title="Jugador 8"> Jugador 8</label>
                        </div>
                    </div>
                </li>
                <!-- fin tab jugadores --> 
                <li id="simple3Tab">
                    <h5>Aquí seleccionaremos los árbitros del encuentro</h5> <c:forEach
                        items="${arbitros}" var="arbitro" varStatus="stat">
                        <label for="radio${stat.count}"> <input
                                name="radio${stat.count}" type="radio" id="radio${stat.count}">${arbitro.nombre}
                            ${arbitro.apellido}
                        </label>
                    </c:forEach>

                    </form>
                    <div class="row">
                        <div class="two columns">
                            <a class="round button" href="#simple2">Volver</a>
                        </div>
                        <div class="two columns offset-by-eight">
                            <a class="round button" href="#simple2"
                               onClick="validaJugadoresHabilitados()">Siguiente</a>
                        </div>
                    </div>
                </li>
                <li id="simple3Tab">
                    <h5>Aquí seleccionaremos los árbitros del encuentro</h5> <label
                        for="checkbox6"> <input name="checkbox_arbitros"
                                            type="checkbox" CHECKED id="checkbox10" title="Arbitro 1">Árbitro
                        1
                    </label> <label for="checkbox7"> <input name="checkbox_arbitros"
                                                            type="checkbox" CHECKED id="checkbox11" title="Arbitro 2">Árbitro
                        2
                    </label> <label for="checkbox8"> <input name="checkbox_arbitros"
                                                            type="checkbox" CHECKED id="checkbox12" title="Arbitro 3">Árbitro
                        3
                    </label> <label for="checkbox9"> <input name="checkbox_arbitros"
                                                            type="checkbox" CHECKED id="checkbox113" title="Arbitro 4">Árbitro
                        4
                    </label> <!--<input name="" type="submit" value="Iniciar partido"> --> <!--</form>	 -->
                    <div class="row">
                        <div class="two columns">
                            <a class="round button" href="#simple2">Volver</a>
                        </div>
                        <div class="two columns offset-by-eight">
                            <a class="round button" href="#simple2" onClick="cargarDatos()">Finalizar</a>
                        </div>
                    </div>

                </li>
                <li id="simple4Tab">
                    <h5>Resumen</h5>
                    <div class="row">
                        <div class="two mobile-one columns">
                            <label class="right inline">Fecha :</label>
                        </div>
                        <div class="ten mobile-three columns">
                            <p id="fecha_reemplaza">Fecha del partido</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="two mobile-one columns">
                            <label class="right inline">Local :</label>
                        </div>
                        <div class="ten mobile-three columns">
                            <p id="equipo_local">Local</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="two mobile-one columns">
                            <label class="right inline">Visita :</label>
                        </div>
                        <div class="ten mobile-three columns">
                            <p id="equipo_visita">Visita</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="twelve columns">
                            <div id="jugadoresLocales" class="twelve columns"></div>
                            <div id="jugadoresVisita" class="twelve columns"></div>
                            <div id="arbitros" class="twelve columns"></div>

                            <p id="jugadores_locales__habilitados">Jugadores locales</p>

                            <p id="jugadores_visitantes_habilitados">Jugadores Visitantes</p>

                            <p id="arbitros_asignados">Arbitros desigandos</p>

                        </div>

                    </div>
                    <div class="row">

                        <div class="two columns">
                            <a class="alert button" href="<c:url value="/partidos/nuevo" />">Cancelar</a>

                        </div>
                        <div class="two columns offset-by-eight">
                            <a class="success button" href="#simple2">Iniciar Partido</a>
                        </div>
                    </div>

                </li>
            </ul>


        </div>
    </div>
</content>