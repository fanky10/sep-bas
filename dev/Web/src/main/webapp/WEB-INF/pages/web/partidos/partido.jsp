<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<div class="content">
	<div class="row">
		<div class="tree columns">
<h1>Nuevo Partido</h1>

<form:form action="${pageContext.request.contextPath}/partidos/add" method="POST" modelAttribute="partidoForm">
	<fieldset>
		<div>
			<form:select path="clubLocal" 
				id="clubLocal" name="clubLocal">
				<option value="">Seleccione Club Local</option>
				<form:options items="${clubes}" itemLabel="nombre"
					itemValue="id" />
			</form:select>
		</div>
		<div>
			<form:select path="clubVisitante" 
				id="clubVisitante" name="clubVisitante">
				<option value="">Seleccione Club Visitante</option>
				<form:options items="${clubes}" itemLabel="nombre"
					itemValue="id" />
			</form:select> 
		</div>
		<input name="submit" type="submit" value="Generar nuevo partido" />
	</fieldset>
</form:form>
<div class="nine columns"></div>
</div>
</div>
</div>
