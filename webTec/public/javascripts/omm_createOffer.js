/**
 * 
 */
$(document).ready(function(){
    //write selected text in our input field to make it look nicer
    //could disable the input field as well
	$("#zielAdresseFormSelect").click(function(){
		var selectedText = $("#zielAdresseFormSelect :selected").text();
		if(!$("#zielAdresseFormSelect").children()[0].selected){
			$("#zielAdresseForm").val(selectedText);
		}else{
			if($("#zielAdresseForm").val() === ""){
				$("#zielAdresseForm").val("");
			}
		}
	});
    
	$("#startAdresseFormSelect").click(function(){
		var selectedText = $("#startAdresseFormSelect :selected").text();
		if(!$("#startAdresseFormSelect").children()[0].selected){
			$("#startAdresseForm").val(selectedText);
		}else{
			if($("#startAdresseForm").val() === ""){
				$("#startAdresseForm").val("");
			}
		}
	});
	$("#startAdresseForm").change(function(){
		$("#startAdresseFormSelect").val(this.getAttribute("Bitte auswählen."));
	});
	$("#zielAdresseForm").change(function(){
		$("#zielAdresseFormSelect").val(this.getAttribute("Bitte auswählen."));
	});
	
    //set counter for additional waypoints
    var counter = 0;
    $("#wegPunkteHinzufuegen").click(function(){
    	counter += 1;
    	var html = $("#wegpunkte").html();
    	html += '<div class="clearfix form-group"><label for="wegpunkte'+counter+'">Über</label>';
    	html += '<div class="input"><input class="form-control" name="wegpunkte'+counter+'" id="wegpunkte'+counter+'" type="text" placeholder="Über Adresse"></div>';
    	html += '<span class="help-block">Required</span></div>';
    	$("#wegpunkte").html(html);

    });

    function placeMarker(location, map) {
      var marker = new google.maps.Marker({
          position: location,
          map: map
      });
    }
});