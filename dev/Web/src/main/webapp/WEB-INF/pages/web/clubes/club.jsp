<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"></content>
<content tag="bodyContent">
<div class="content">
	<div class="row">
		<div class="twelve columns">
			<h3>Clubes</h3>
                            <form:form action="${pageContext.request.contextPath}/clubes/add"
				modelAttribute="clubForm" method="POST">
				<fieldset>
                                        <legend>Datos institucionales</legend>
					<form:hidden path="id" />
                                        <label for="name"> Nombre: </label> 
                                        <span class="input"> 
                                        <form:input path="nombre" />
                                        <form:errors path="nombre" id="nombre-error"/>
                                        </span>
                                        <br/>
                                        <br/>
                                        <label for="localidad"> Localidad: </label> 
                                        <span class="input"> 
                                        <form:input path="localidad" />
                                        <form:errors path="localidad" id="localidad-error"/>
                                        </span>
                                        <br/>
                                        <br/>    
                                        <input name="submit" type="submit" class="button tiny" value="Guardar" />
                                        <a href="<c:url value="/clubes/list"/>" class="button tiny"> Volver</a>
                                </fieldset>
			</form:form>
		</div>
	</div>
</div>
</content>
