<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> 
    <script type="text/javascript" src="<c:url value="/js/partidos/operador.js"/>"></script>
</content>
<content tag="jscript">
    <script>
        $(document).foundation();
    </script>
</content>
<content tag="bodyContent">
    <div class="row">
        <div class="twelve columns">
            <h3>Consola Operador</h3>
            <h5>Equipo Local</h5>
            <select class="js-jugadores-equipo" data-tipo="local"></select>
            <h5>Eventos</h5>
            <select class="js-eventos-equipo" data-tipo="local">
                <optgroup label="Lanzamientos">
                    <option value="evt=LANZAMIENTO_JUGADOR_UN_PUNTO">Lanzamiento - 1</option>
                    <option value="evt=LANZAMIENTO_JUGADOR_DOS_PUNTOS">Lanzamiento - 2</option>
                    <option value="evt=LANZAMIENTO_JUGADOR_TRES_PUNTOS">Lanzamiento - 3</option>
                </optgroup>
            </select>
            <button class="js-enviar-evento" data-tipo="local">Enviar Lanzamiento</button>
            
            <h5>Cambiar por</h5>
            <select class="js-jugadores-equipo-cambio" data-tipo="local"></select>
            <button class="js-enviar-evento-cambio" data-tipo="local">Realizar Cambio</button>
            
            <h5>Equipo Visitante</h5>
            <select class="js-jugadores-equipo" data-tipo="visitante"></select>
            <h5>Eventos</h5>
            <select class="js-eventos-equipo" data-tipo="visitante">
                <optgroup label="Lanzamientos">
                    <option value="evt=LANZAMIENTO_JUGADOR_UN_PUNTO">Lanzamiento - 1</option>
                    <option value="evt=LANZAMIENTO_JUGADOR_DOS_PUNTOS">Lanzamiento - 2</option>
                    <option value="evt=LANZAMIENTO_JUGADOR_TRES_PUNTOS">Lanzamiento - 3</option>
                </optgroup>
            </select>
            <button class="js-enviar-evento" data-tipo="visitante">Enviar Lanzamiento</button>
        </div>
        <div class="js-response"></div>
    </div>
    
</content>