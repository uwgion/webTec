var omm_mapCanvases = new omm_mapCanvases();
$(document).ready(function(){
	$(".omm_delete-entry").click(function(event){
		if (confirm('Diese Mitfahrgelegenheit wirklich löschen?')) {
			var id = $(this).parent().parent().find(".omm_value-offer").val();

			jsRoutes.controllers.Angebote.destroyOffer(id).ajax({
		        type:"DELETE",
		        success: function(){
		        		$("#"+id).remove();
		        		$(".alert-success").remove();
		        		$(".omm_content").prepend('<div class="alert alert-success"><i class="glyphicon glyphicon-remove"></i> &nbsp;Angebot erfolgreich gelöscht.</div>');
		        	}
		        });
			}
	});

	$(".panel-title").click(function(event){
		var map;
		var eventID = $(event.target).parents(".panel.panel-default").attr('id');
		omm_mapCanvases.initialize(eventID);
	});
});
