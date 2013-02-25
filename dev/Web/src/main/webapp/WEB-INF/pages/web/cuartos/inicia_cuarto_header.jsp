<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script>

	
	$(document).ready(
			function() {
				$('#clubSelector').bind(
						'change onchange',
						function() {
							//post something
							idClub = $(this).val();
							$.ajax({
								data : "club_id=" + idClub,
								success : function(data) {
									renderJugadores(data);
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
	function renderJugadores(data) {
		//super cool rendering here ajajaj
		
		var jugadoresList = data.resultList;
		$("#jugadoresClub").html("");
		$("#jugadoresClub").append("<li>");
		$.each(jugadoresList,function(idx,item){
			$("#jugadoresClub").append("<ul>"+item.nombre+"</ul>");
		});
		$("#jugadoresClub").append("</li>");
		
	}
</script>