<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-es.js" />"></script>

<script>
	$(function() {
		$("#datePickerfechaNacimiento").datepicker({
			onSelect : function(textoFecha, objDatepicker) {
				//on select do something!
			}
		});
	});
</script>