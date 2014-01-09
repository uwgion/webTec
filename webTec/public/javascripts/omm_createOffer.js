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
    	html += '<div class="waypoints"><div class="clearfix col-md-6"><label for="wegpunkte'+counter+'">Über</label>';
    	html += '<div class="input"><input class="form-control" name="wegpunkte'+counter+'" id="wegpunkte'+counter+'" type="text" placeholder="Über Adresse">';
    	html += '<span class="help-inline"></span><span class="help-block"></span></div>'
    	html += '</div><div class="clearfix col-md-6" id="wegpunkte'+counter+'Select_field"><label for="wegpunkte'+counter+'Select">Über</label><div class="input" id="wegpunkte'+counter+'"Select>';
    	html += '<select class="form-control" id="wegpunkte'+counter+'Select" disabled="disabled"><option>test</option></select><span class="help-inline"></span><span class="help-block"></span></div></div>'
    	html += '</div>';
    	$("#wegpunkte").html(html);

    });
	$(":submit").click(function(){
		console.log("suchen");
		$(document).find(".waypoints").each(function(key, value){
			console.log(value);
			if($(value).find(":input").val()==""){
				$(this).remove();
			}
		});
	});
    function placeMarker(location, map) {
      var marker = new google.maps.Marker({
          position: location,
          map: map
      });
    }
});