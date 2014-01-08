var omm_mapCanvases = new omm_mapCanvases();
//var omm_createOffer = new omm_createOffer();

$(document).ready(function(){
    if(!$(document).find('div').hasClass("panel-group")){
	    var eventID=$(".omm_value-offer").val();
	    omm_mapCanvases.initialize(eventID);
    }

});
