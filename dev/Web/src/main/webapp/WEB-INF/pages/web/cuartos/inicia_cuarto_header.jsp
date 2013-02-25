<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script>

	
	$(document).ready(
			function() {
				$('#clubSelectorEquipo1').bind(
						'change onchange',
						function() {
							//post something
							idClub = $(this).val();
							$.ajax({
								data : "club_id=" + idClub,
								success : function(data) {
									renderJugadores(data,'jugadoresEquipo1','equipo1');
								},
								error : function() {
									$("#jugadoresClub").html(
											"device control failed response: "
													+ data.message);
								},
								processData : false,
								type : 'GET',
								url : '${ctx}/jugadores/club/' + idClub
										+ '/list.json'
							});
						});
				$('#clubSelectorEquipo2').bind(
						'change onchange',
						function() {
							//post something
							idClub = $(this).val();
							$.ajax({
								data : "club_id=" + idClub,
								success : function(data) {
									renderJugadores(data,'jugadoresEquipo2','equipo2');
								},
								error : function() {
									$("#jugadoresClub").html(
											"device control failed response: "
													+ data.message);
								},
								processData : false,
								type : 'GET',
								url : '${ctx}/jugadores/club/' + idClub
										+ '/list.json'
							});
						});
			});
	
	function renderJugadores(data,inputId,divId) {
		//super cool rendering here ajajaj

		var jugadoresList = data.resultList;
		if (jugadoresList.length == 0) {
			$("#"+divId).html("Sin jugadores.");
		} else {
			var htmlResult = [];
			htmlResult.push('<li style="list-style-type:none">');
			$.each(jugadoresList, function(idx, item) {
				htmlResult.push("<ul>");
				htmlResult.push('<input id="'+(inputId+idx)+'" name="'+inputId+'" type="checkbox" value="'+item.id+'"/>'+item.nombre);
				htmlResult.push("</ul>");
			});
			htmlResult.push("</li>");
			console.log(htmlResult.join(''));
			$("#"+divId).html(htmlResult.join(''));
		}
	}
</script>