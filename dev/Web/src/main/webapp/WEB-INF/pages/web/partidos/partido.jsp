<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content>
<h1>Agregar Club</h1>

<form:form action="${pageContext.request.contextPath}/partidos/add" method="POST">
	<fieldset>
		<input name="submit" type="submit" value="Generar nuevo partido" />
	</fieldset>
</form:form>
</content>