<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>
</content>
<content tag="jscriptlibs"> <script
	src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script> <script
	type="text/javascript"
	src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script> </content>
<content tag="jscript"> <script>
	function enviarLanzamiento(element) {
		puntos = element.getAttribute("lanzamiento-nro"); //refers to the element actioning this method
		li = element.parentNode;
		jsonData = {
			numeroPuntos : puntos
		}
		$.ajax({
			contentType : 'application/json',
			data : JSON.stringify(jsonData),
			dataType : 'json',
			success : function(data) {
				$("#responseMessage").html(data.message);
			},
			error : function() {
				$("#responseMessage").html(
						"device control failed response: " + data.message);
			},
			processData : false,
			type : 'POST',
			url : '${ctx}/secure/evento/lanzamiento.json'
		});
	}
</script> </content>
<content tag="bodyContent">
<div class="content">
	<div class="row">

	<h1>
		<c:out value="${evento}" />
	</h1>
	<ul>
		<li><button lanzamiento-nro="2"
				onclick="enviarLanzamiento(this); return false;">Enviar
				Lanzamiento Doble</button></li>
		<li><button lanzamiento-nro="3"
				onclick="enviarLanzamiento(this); return false;">Enviar
				Lanzamiento Triple!</button></li>
	</ul>
	<div id="responseMessage"></div>
</div>
</div>
</content>