<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<html>
<head>
<title>Eventos!</title>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script>
	function enviarLanzamiento(element){
		puntos = element.getAttribute("lanzamiento-nro"); //refers to the element actioning this method
		li = element.parentNode;
		jsonData = {numeroPuntos:puntos}
		$.ajax({
		    contentType: 'application/json',
		    data:JSON.stringify(jsonData),
		    dataType: 'json',
		    success: function(data){
		        $("responseMessage").html(data.message);
		    },
		    error: function(){
		    	console.log("device control failed response: "+data.message);
		    },
		    processData: false,
		    type: 'POST',
		    url: '${ctx}/secure/evento/lanzamiento.json'
		});
	}
</script>
</head>
<body>

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

</body>
</html>