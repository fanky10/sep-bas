<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.js" />"></script>
<script>
	function deleteClub(element){
		clubId = element.getAttribute("club-id"); //refers to the element actioning this method
		li = element.parentNode;
		$.post("${ctx}/clubes/delete.json", { "id": clubId },
				function(response){
					if(response.status=="OK"){//remove it
						$(li).fadeOut("slow", function() { 
		                    $(this).remove(); 
		                });
					}else if(response.status=="ERROR"){
						$("#deleteResponse").html(response.error);
					}
				
				}, "json"
		);
	}
</script>