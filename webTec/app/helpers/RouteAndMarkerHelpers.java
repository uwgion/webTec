package helpers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

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

import db.MarkerDB;
import db.RouteDB;

public class RouteAndMarkerHelpers {

	/**
	 * Method to build a list of routes, containg a list of markers for each
	 * route.
	 * @return A list of routes with their markers.
	 */
	public LinkedList<LinkedList<Marker>> buildMarkerListForRoutesFromDatabase(){

    	RouteDB routes = RouteDB.getInstance();
		DBCursor<Route> cursor =  routes.findNative(new BasicDBObject());
		LinkedList<LinkedList<Marker>> routesWithMarkers = new LinkedList<>();
		
		//iterate over all routes
		while(cursor.hasNext()){			
			Route tempRoute = cursor.next();
			java.util.List<DBRef<Marker, String>> tempList = tempRoute.wegpunkte;
			Iterator<DBRef<Marker, String>> it = tempList.iterator();
			
			//create a list with the markers
			LinkedList<Marker> tempMarkersList = new LinkedList<>();
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
	 * @param markers A map of markers, containing their longitude, latitude and type of that marker.
	 * @return tempRoute The created route.
	 */
	public Route createRouteFromSubmittedMarkers(HashMap<String, String> markers){
		 MarkerDB markersInstance = MarkerDB.getInstance();
	        //create our tempRoute
	        Route tempRoute = new Route();

	        //iterate over all addresses and get their latitude and longitude, then save those in a list
	        for (String key : markers.keySet()) {
	      
	            final Promise<String> resultPromise = singleAddressStringToGoogleAddress(markers.get(key), key);
	            JsonNode json = Json.parse(resultPromise.get());
	            String lng = json.findParent("location").findValue("lng").toString();
	            String lat = json.findParent("location").findValue("lat").toString();
	            String addressLongString = json.findValue("formatted_address").toString();
	            Marker tempMarker = markersInstance.create(new Marker(key, addressLongString, Double.parseDouble(lat), Double.parseDouble(lng)));
	            
	            if(tempMarker.what.equals("startAdresseForm")){
	            	tempRoute.startAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);
	            }else if(tempMarker.what.equals("zielAdresseForm")){
	            	tempRoute.zielAdresse = new DBRef<Marker, String>(tempMarker._id, Marker.class);	
	            }else{
	            	 DBRef<Marker, String> tempDBRef = new DBRef<Marker, String>(tempMarker._id, Marker.class);
	 	            //add our markers to our route
	 	            tempRoute.wegpunkte.add(tempDBRef); 
	            }                
	        }
        return tempRoute;
	}

	/**
	 * Method to query Google for a given address.
	 * @param markerName The name of the marker in the database.
	 * @param key The address string.
	 * @return Googles response as promise in Json format parsed to a string.
	 */
	private Promise<String> singleAddressStringToGoogleAddress(
			String markerName, String key) {
		return WS.url("https://maps.googleapis.com/maps/api/geocode/json?").setQueryParameter("address", markerName).setQueryParameter("sensor", "false").setTimeout(10000000).get().map(new Function<WS.Response, String>() {
		        public String apply(WS.Response response) {
		        	String latLng = response.asJson().findParent("results").toString();
		        	return latLng;
		        }
			}
		);
	}
}
