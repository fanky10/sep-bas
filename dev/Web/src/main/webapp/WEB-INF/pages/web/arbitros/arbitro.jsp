<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> <script
	src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script> <script
	type="text/javascript"
	src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script> </content>
<content tag="jscript"> <script>
	$(function() {
		$("#datePickerfechaNacimiento").datepicker({
			onSelect : function(textoFecha, objDatepicker) {
				//on select do something!
			}
		});
	});
</script> </content>
<content tag="bodyContent">
<div class="content">
	<div class="row">
		<div class="twelve columns">
			<h1>Agregar Arbitros</h1>

			<form:form action="${pageContext.request.contextPath}/arbitros/add"
				modelAttribute="arbitroForm" method="POST">
				<fieldset>
					<form:hidden path="id" />
					<label for="name"> Nombre: </label> <span class="input"> <form:input
							path="nombre" /> <form:errors path="nombre" id="nombreError" />
					</span> <br /> <br /> <input name="submit" type="submit" value="Guardar" />
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
</content>
