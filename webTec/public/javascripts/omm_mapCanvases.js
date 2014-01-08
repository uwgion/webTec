function omm_mapCanvases(){
	var that=this;
	var map;
    this.initialize = function(eventID) {
        var mapOptions = {
        center: new google.maps.LatLng(47.693934,8.946791),
        zoom: 13,
            mapTypeId: google.maps.MapTypeId.ROADMAP
    	};
		
       	map = new google.maps.Map(document.getElementById("map-canvas"+eventID), mapOptions);
		var tempAddress= $("#"+eventID).find('.omm_start-address').val().split("/");
		
		var lat = tempAddress[0];
		var lng = tempAddress[1];
		var start = new google.maps.LatLng(lng, lat);
		tempAddress= $("#"+eventID).find(".omm_destination-address").val().split("/");

		lat = tempAddress[0];
		lng = tempAddress[1];
		var end = new google.maps.LatLng(lng, lat);

		var waypointsLatLng = $("#"+eventID).find('.omm_waypoints-address').val().split("//");

		var waypoints = new Array();

		 //iterate over markers for routes
		for (var i=0;i<waypointsLatLng.length-1;i++){
			var waypoint = waypointsLatLng[i].split("/");
			waypoints.push({location:new google.maps.LatLng(waypoint[1], waypoint[0]),stopover:true})
		}
		var request = {
			origin:start,
			destination:end,
			waypoints: waypoints,
			travelMode: google.maps.TravelMode.DRIVING
		};
		that.calcRoute(request, map);
    }


	this.calcRoute = function(request, map){
		 var directionsDisplay;
		 var directionsService = new google.maps.DirectionsService();
		  
		 directionsDisplay = new google.maps.DirectionsRenderer();
		 directionsDisplay.setMap(map);
		 directionsService.route(request, function(result, status) {
			    if (status == google.maps.DirectionsStatus.OK) {
			      	directionsDisplay.setDirections(result);
			      	
			       		google.maps.event.addListenerOnce(map, 'idle', function() {
		       	   		google.maps.event.trigger(map, 'resize');
		       	   		var bounds = result.routes[0].bounds;
			      		map.fitBounds(bounds);
			      		map.setCenter(bounds.getCenter());
		       		});
			    }else{
			       console.log("route failed. status:" +status +" result:" +result);
			    }
		  });
	}
}