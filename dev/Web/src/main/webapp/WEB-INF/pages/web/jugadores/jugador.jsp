<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
    <%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
    <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>
</content>
<content tag="jscript">
    <script>
        $(function () {
            $("#datePickerfechaNacimiento").datepicker({
                dateFormat: 'dd/mm/yy',
                onSelect: function (textoFecha, objDatepicker) {
                    //on select do something!
                }
            });

        });
    </script>
</content>
<content tag="bodyContent">
    <div class="content">
        <div class="row">
            <div class="twelve columns">
                <h3>Nuevo Jugador</h3>
                <form:form action="${pageContext.request.contextPath}/jugadores/save" modelAttribute="jugadorForm" method="POST">
                    <fieldset>
                        <legend>Datos Personales</legend>
                        <form:hidden path="id" />
                        <label for="name"> Nombre: </label> 
                        <span class="input"> 
                            <form:input path="nombre" />
                            <form:errors path="nombre" id="nombreError"/>
                        </span>
                        <br/>
                        <br/>
                        <label for="apellido"> Apellido: </label> 
                        <span class="input"> 
                            <form:input path="apellido" />
                            <form:errors path="apellido" id="apellidoError"/>
                        </span>
                        <br/>
                        <br/>
                        <label for="apellido"> Numero: </label> 
                        <span class="input"> 
                            <form:input path="numero" />
                            <form:errors path="numero" id="apellidoError"/>
                        </span>
                        <br/>
                        <br/>
                        <label for="fechaNacimiento"> Fecha Nacimiento: </label> 
                        <span class="input"> 
                            <fmt:formatDate value="${jugadorForm.fechaNacimiento}" var="dateString" pattern="dd/MM/yyyy" />
                            <form:input id="datePickerfechaNacimiento" type="text" path="fechaNacimiento" value="${dateString}"/>
                            <form:errors path="fechaNacimiento" id="fechaNacimientoError"/>
                        </span>
                        <br/>
                        <br/>
                        <label for="club" class="hint">Seleccione un club</label>
                        <span class="input">
                            <form:select path="club">
                                <form:options items="${clubes}" itemValue="id" itemLabel="nombre"></form:options>
                            </form:select>
                        </span>
                        <br/>

                        <br/>
                        <input name="submit" type="submit" class="button tiny" value="Guardar" />
                        <a href="<c:url value="/jugadores/list"/>" class="button tiny"> Volver</a>
                    </fieldset>
                </form:form>
            </div></div></div>
</content>