package helpers;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import models.Marker;
import models.Route;

import org.mongojack.DBCursor;
import org.mongojack.DBRef;

import play.Logger;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.BasicDBObject;

import db.FixedPointDB;
import db.MarkerDB;
import db.RouteDB;

public class RouteAndMarkerHelpers {
	private static DateAndTimeHelpers dateHelper = new DateAndTimeHelpers();
	
	/**
	 * Method to build a list of routes, containg a list of markers for each
	 * route.
	 * @return A list of routes with their markers.
	 */
	public LinkedList<LinkedList<Marker>> buildMarkerListForRoutesFromDatabase(){

    	RouteDB routes = RouteDB.getInstance();
		DBCursor<Route> cursor =  routes.findNative(new BasicDBObject());
		LinkedList<LinkedList<Marker>> routesWithMarkers = new LinkedList<LinkedList<Marker>>();
		
		//iterate over all routes
		while(cursor.hasNext()){			
			Route tempRoute = cursor.next();
			java.util.List<DBRef<Marker, String>> tempList = tempRoute.wegpunkte;
			Iterator<DBRef<Marker, String>> it = tempList.iterator();
			
			//create a list with the markers
			LinkedList<Marker> tempMarkersList = new LinkedList<Marker>();
			while(it.hasNext()){	
				DBRef<Marker, String> eh = it.next();
				//fetch the marker from the DB and add it to the list
				tempMarkersList.add(eh.fetch());
			}
			
			//add our markers to our route
			routesWithMarkers.add(tempMarkersList);
		}
		
		return routesWithMarkers;
	}
	
	/**
	 * Method to create a route from given markers.
	 * @param requestMap A map of markers, containing their longitude, latitude and type of that marker.
	 * @return tempRoute The created route.
	 * @throws AddressNotFoundException 
	 * @throws ParseException 
	 */
	public Route createRouteFromSubmittedMarkers(HashMap<String, String> requestMap, Route tempRoute) throws AddressNotFoundException, ParseException{
	        MarkerDB markers = MarkerDB.getInstance();
			
	        //create our tempRoute
//	        Route tempRoute = new Route();
	        

//			tempRoute.dateForm=routeOnlyForDate.dateForm;
			tempRoute.setTimeAndValidate(requestMap.get("timeForm"));
			tempRoute.timeForm=requestMap.get("timeForm");
			dateHelper.validateDateAndTime(tempRoute);
//			Logger.info(routeOnlyForDate.seats + "sitze");
	        //iterate over all addresses and get their latitude and longitude, then save those in a list
	        for (String key : requestMap.keySet()) {
	        	
	        	if(key.equals("timeForm") || key.equals("dateForm") ||  key.matches("seats")){
	        		continue;
	        	}
	            Promise<String> resultPromise;
	            
	            Marker tempMarker;

	            if(key.equals("startAdresseForm") || key.equals("startAdresseFormSelect")){
	            	if(key.equals("startAdresseForm") && requestMap.get("startAdresseFormSelect") == ""){
	            		resultPromise = singleAddressStringToGoogleAddress(requestMap.get(key));
	    	            tempMarker = createNewMarkerFromString(resultPromise, key);
		            	tempRoute.startAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);	
	            	} else if(key.equals("startAdresseFormSelect") && requestMap.get("startAdresseFormSelect") != ""){
		            	tempRoute.startAdresse = new DBRef<Marker, String>(markers.findById(requestMap.get(key))._id, Marker.class);	
	            	}
	            }else if(key.equals("zielAdresseForm") || key.equals("zielAdresseFormSelect")){
	            	if(key.equals("zielAdresseForm") && requestMap.get("zielAdresseFormSelect") == ""){
	            		resultPromise = singleAddressStringToGoogleAddress(requestMap.get(key));
	    	            tempMarker = createNewMarkerFromString(resultPromise, key);
		            	tempRoute.zielAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);	
	            	} else if(key.equals("zielAdresseFormSelect") && requestMap.get("zielAdresseFormSelect") != ""){
		            	tempRoute.zielAdresse = new DBRef<Marker, String>(markers.findById(requestMap.get(key))._id, Marker.class);	
	            	}	            
	            	//TODO: need to implement waypoints for fixedpoints
            	}else{
					if(key.matches("wegpunkte.Select") && requestMap.get(key) != ""){
						tempMarker = markers.findById(requestMap.get(key));
			        	DBRef<Marker, String> tempDBRef = new DBRef<Marker, String>(requestMap.get(key), Marker.class);
			            //add our markers to our route
			            tempRoute.wegpunkte.add(tempDBRef); 
			            tempRoute.wegpunkteForm.add(tempMarker.name);
					}else{
						if(requestMap.get(key+"Select") == ""){
							resultPromise = singleAddressStringToGoogleAddress(requestMap.get(key));
							tempMarker = createNewMarkerFromString(resultPromise, key);
							DBRef<Marker, String> tempDBRef = new DBRef<Marker, String>(tempMarker._id, Marker.class);
							//add our markers to our route
							tempRoute.wegpunkte.add(tempDBRef); 
							tempRoute.wegpunkteForm.add(tempMarker.name);
			            }
					}

	            }                
	        }
        return tempRoute;
	}

	/**
	 * Method to update a given route. Iterate over the request map and find the things which need to be updated. 
	 * Always need to test if a dropdown value is selected.
	 * @param id The id of the route to update.
	 * @param requestMap The submitted request, mapped to a HashMap.
	 * @param routes A routeDB instance.
	 * @param markers A markerDB instance.
	 * @param routesList A list with all routes for the user who submitted the form.
	 * @throws AddressNotFoundException 
	 * @throws ParseException Exception to be thrown if a date or time is invalid.
	 */
	public void updateRoute(String id, HashMap<String, String> requestMap,
			RouteDB routes, MarkerDB markers,
			List<DBRef<Route, String>> routesList, Route routeOnlyForDate) throws AddressNotFoundException, ParseException {
		LinkedList<String> waypoints = new LinkedList<String>();
		//get our route
		Route tempRoute=routes.findById(id);
		//update date and time
		dateHelper.updateTimeAndDate(routes, tempRoute, routeOnlyForDate, requestMap.get("timeForm"));
		
		//iterating over request necessary? Could get the specific keys, but would need to
		//iterate over the request anyways for the waypoints.
		//save route only, when we really changed something! No unnecessary database transactions.
		for (String key : requestMap.keySet()) {
        	if(key.equals("timeForm") || key.equals("dateForm")){
        		continue;
        	}
            if(key.equals("startAdresseForm") || key.equals("startAdresseFormSelect")){
            	if(key.equals("startAdresseForm") && requestMap.get("startAdresseFormSelect") == ""){
	        		String startAdresseForm = requestMap.get(key);
					if(!tempRoute.startAdresse.fetch().name.equals(startAdresseForm)){
						updateStartAddress(routes, markers, tempRoute, startAdresseForm);
						routes.save(tempRoute);
					}	
            	} else if(key.equals("startAdresseFormSelect") && requestMap.get("startAdresseFormSelect") != ""){
					if(!tempRoute.startAdresse.fetch()._id.equals(requestMap.get(key))){
		            	tempRoute.startAdresse = new DBRef<Marker, String>(markers.findById(requestMap.get(key))._id, Marker.class);	
						routes.save(tempRoute);
						
					}	
            	}
			 }else if(key.equals("zielAdresseForm") || key.equals("zielAdresseFormSelect")){
	            	if(key.equals("zielAdresseForm") && requestMap.get("zielAdresseFormSelect") == ""){
		        		String zielAdresseForm = requestMap.get(key);
						if(!tempRoute.zielAdresse.fetch().name.equals(zielAdresseForm)){
							updateDestinationAddress(routes, markers, tempRoute, zielAdresseForm);
							routes.save(tempRoute);
						}	
	            	} else if(key.equals("zielAdresseFormSelect") && requestMap.get("zielAdresseFormSelect") != ""){
						if(!tempRoute.zielAdresse.fetch()._id.equals(requestMap.get(key))){
			            	tempRoute.zielAdresse = new DBRef<Marker, String>(markers.findById(requestMap.get(key))._id, Marker.class);	
							routes.save(tempRoute);
						}	
	            	}
			 }else if(key.equals("seats")){
				int seats = Integer.parseInt(requestMap.get("seats"));
				if(tempRoute.seats != seats){
					tempRoute.seats = seats;
					routes.save(tempRoute);
				}
			 }else{
				 if(key.matches("wegpunkte.Select") && requestMap.get(key) != ""){

					 updateWaypointsWithFixedPoint(requestMap.get(key), routes, markers, tempRoute, key);
				 }else{
					 if(requestMap.get(key+"Select") == ""){
						 waypoints.add(requestMap.get(key));
					 }
				 }
			 }
		}
		
		//do we have waypoints?
		if(waypoints.size() > 0){
			//set our updated waypoints.
			updateWaypoints(tempRoute, waypoints);
		}
	}

	/**
	 * Method which is called in case a route to be updated needs to be updated with fixed waypoints.
	 * Waypoints will be added or replaced.
	 * @param fixedPointId The fixed point which needs to be added.
	 * @param routes A RouteDB instance.
	 * @param markers A MarkerDB instance.
	 * @param tempRoute The route which needs to be updated.
	 * @param key The key for the request.
	 * @throws NumberFormatException Is thrown if the number cannot be parsed from the key.
	 */
	private void updateWaypointsWithFixedPoint(
			String fixedPointId, RouteDB routes,
			MarkerDB markers, Route tempRoute,
			String key) throws NumberFormatException {
		FixedPointDB fixedpoints = FixedPointDB.getInstance();

		//get the position of the waypoint
		 int waypointPoisition = Integer.parseInt(key.charAt(9)+"");

		 Marker tempMarker = markers.findById(fixedPointId);
		 //a new waypoint which is fixed waypoint? If so, just add and continue.
		 Logger.info(tempRoute.wegpunkte.size()+" size");
		 if(waypointPoisition >= tempRoute.wegpunkte.size()){
			 tempRoute.wegpunkte.add(new DBRef<Marker, String>(tempMarker._id, Marker.class));
			 tempRoute.wegpunkteForm.add(tempMarker.name);
			 routes.save(tempRoute);
		 }else{
			 if(!tempRoute.wegpunkte.get(waypointPoisition).fetch()._id.equals(tempMarker._id)){
				 //set the new waypoints
				 if(fixedpoints.findById(tempRoute.wegpunkte.get(waypointPoisition).fetch()._id) ==null){
					 markers.delete(tempRoute.wegpunkte.get(waypointPoisition).fetch()._id);
				 }
				 tempRoute.wegpunkte.set(waypointPoisition, new DBRef<Marker, String>(tempMarker._id, Marker.class));
				 tempRoute.wegpunkteForm.set(waypointPoisition, tempMarker.name);
				 routes.save(tempRoute);
			 }
		 }
	}

	
	
	/**
	 * Method to update the waypoints for a given route.
	 * @param route The route to update the waypoints for.
	 * @param waypoints The waypoints submitted.
	 * @throws AddressNotFoundException Costum exception to be thrown if a address cannot be found via Google.
	 */
	private void updateWaypoints(Route route, LinkedList<String> waypoints) throws AddressNotFoundException{
		Promise<String> tempPromise;
		Marker tempMarker;
		Collections.reverse(waypoints);
		MarkerDB markers = MarkerDB.getInstance();
		RouteDB routes = RouteDB.getInstance();
		for(int z = 0; z < waypoints.size(); z++){
			if(z < route.wegpunkte.size()){
				if(!waypoints.get(z).equals(route.wegpunkte.get(z).fetch().name)){
					tempPromise = singleAddressStringToGoogleAddress(waypoints.get(z));				
					tempMarker = createNewMarkerFromString(tempPromise, "wegpunkt"+z);
					markers.delete(route.wegpunkte.get(z).fetch()._id);
					route.wegpunkteForm.set(z, tempMarker.name);
					route.wegpunkte.set(z, new DBRef<Marker, String>(tempMarker._id, Marker.class));
				}
			}else{
				tempPromise = singleAddressStringToGoogleAddress(waypoints.get(z));				
				tempMarker = createNewMarkerFromString(tempPromise, "wegpunkt"+z);
				route.wegpunkte.add(new DBRef<Marker, String>(tempMarker._id, Marker.class));
				route.wegpunkteForm.add(tempMarker.name);
			}
		}
		routes.save(route);
	}
	
	/**
	 * Method to query Google for a given address.
	 * @param address The address string.
	 * @return Googles response as promise in Json format parsed to a string.
	 */
	public Promise<String> singleAddressStringToGoogleAddress(
			String address) {

		return WS.url("https://maps.googleapis.com/maps/api/geocode/json?").setQueryParameter("address", address).setQueryParameter("sensor", "false").setTimeout(10000000).get().map(new Function<WS.Response, String>() {
		        public String apply(WS.Response response) {
		        	String latLng = response.asJson().findParent("results").toString();
		        	Logger.info(latLng);
		        	return latLng;
		        }
			}
		);
	}
	
	/**
	 * Method to create a new marker.
	 * @param addressString The Promise returned by google
	 * @param The description what the marker is.
	 * @return The new marker.
	 * @throws AddressNotFoundException 
	 */
	public Marker createNewMarkerFromString(Promise<String> addressString, String what) throws AddressNotFoundException{
		 MarkerDB markersInstance = MarkerDB.getInstance();

		JsonNode json = Json.parse(addressString.get(20000));


		if(json.findValue("status").asText().equals("ZERO_RESULTS")){
    		throw new AddressNotFoundException();
		}
        Double lng = json.findValue("location").findValue("lng").asDouble();
        Double lat = json.findValue("location").findValue("lat").asDouble();

        String addressLongString = json.findValue("formatted_address").asText();

        return markersInstance.create(new Marker(what, addressLongString, lat, lng));
	}
	
	/**
	 * Method to update the start address of a given route.
	 * @param routes A routeDB instance.
	 * @param markers A markerDB instance.
	 * @param tempRoute The route to update.
	 * @param newAddress The new start address for the route.
	 * @throws AddressNotFoundException Exception to throw in case no address was found.
	 */
	public void updateStartAddress(RouteDB routes, MarkerDB markers,
			Route tempRoute, String newAddress) throws AddressNotFoundException {
		Promise<String> tempPromise;
		Marker tempMarker;
		tempPromise = singleAddressStringToGoogleAddress(newAddress);
		
		tempMarker = createNewMarkerFromString(tempPromise, "startAdresseForm");
		//delete the former start address
		markers.delete(tempRoute.startAdresse.fetch()._id);
		//set the new start address
		tempRoute.startAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);
		routes.save(tempRoute);

	}
	
	/**
	 * Method to update the destination address of a given route.
	 * @param routes A routeDB instance.
	 * @param markers A markerDB instance.
	 * @param tempRoute The route to update.
	 * @param newAddress The new destination address for the route.
	 * @throws AddressNotFoundException Exception to throw in case no address was found.
	 */	
	public void updateDestinationAddress(RouteDB routes, MarkerDB markers,
			Route tempRoute, String newAddress) throws AddressNotFoundException {
		Promise<String> tempPromise;
		Marker tempMarker;
		tempPromise = singleAddressStringToGoogleAddress(newAddress);
		tempMarker = createNewMarkerFromString(tempPromise, "zielAdresseForm");
		//delete the former destination address
		markers.delete(tempRoute.zielAdresse.fetch()._id);
		//set the new destionation address
		tempRoute.zielAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);
		routes.save(tempRoute);
	}
	
}
