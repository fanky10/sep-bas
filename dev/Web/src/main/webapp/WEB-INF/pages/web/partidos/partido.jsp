<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles">
	<%-- some link rel to this page in specific --%>	
</content>
<content tag="jscriptlibs">
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>
</content>
<content tag="jscript">
	<%-- some javascript written --%>
</content>
<content tag="bodyContent">
<div class="content">
	<div class="row">
		<div class="tree columns">
			<h1>Nuevo Partido</h1>

			<form:form action="${pageContext.request.contextPath}/partidos/add"
				method="POST" modelAttribute="partidoForm">
				<fieldset>
					<div>
						<form:select path="clubLocal" id="clubLocal" name="clubLocal">
							<option value="">Seleccione Club Local</option>
							<form:options items="${clubes}" itemLabel="nombre" itemValue="id" />
						</form:select>
					</div>
					<div>
						<form:select path="clubVisitante" id="clubVisitante"
							name="clubVisitante">
							<option value="">Seleccione Club Visitante</option>
							<form:options items="${clubes}" itemLabel="nombre" itemValue="id" />
						</form:select>
					</div>
					<input name="submit" type="submit" value="Generar nuevo partido" />
				</fieldset>
			</form:form>
			<div class="nine columns"></div>
		</div>
	</div>
</div>
</content>
