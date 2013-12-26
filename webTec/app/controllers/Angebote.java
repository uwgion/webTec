package controllers;

import helpers.RouteAndMarkerHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Marker;
import models.Route;
import models.User;

import org.mongojack.DBCursor;
import org.mongojack.DBRef;

import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;

import com.mongodb.BasicDBObject;

import views.html.*;
import db.MarkerDB;
import db.RouteDB;
import db.UserDB;

/**
 * Class to create, update and destroy offers. Only accessible if logged in.
 *
 */
@Authenticated(Secured.class)
public class Angebote extends Controller{
	static RouteAndMarkerHelpers routeListCreator = new RouteAndMarkerHelpers();

    /**
     * Method to return a list of all routes in the database. 
     * Those routes will then be display on the map.
     * @return The Angebote page with a list of all markers in the database.
     */
    public static Result  angebotErstellen(){
		Form<Route> form = Form.form(Route.class);

    	RouteDB routes = RouteDB.getInstance();
		DBCursor<Route> cursor =  routes.findNative(new BasicDBObject());
		ArrayList<Route> routesList = (ArrayList<Route>) cursor.toArray();
		
		
		return ok(angebotErstellen.render(routesList, form));
    }
    
    /**
     * Method to destroy a route, delete all markers belonging to the route
     * and delete it from a users scope.
     * @param id The route id.
     * @return The new offer list.
     */
    public static Result destroyOffer(String id){
    	String sessionID = session().get("sessionID");
    	UserDB users = UserDB.getInstance();
    	RouteDB routes = RouteDB.getInstance();
    	MarkerDB markers = MarkerDB.getInstance();
    	User user = users.findByLoggedInHashKey(sessionID);
		List<DBRef<Route, String>> routesList = user.routes;
		
		for(int i = 0; i < routesList.size(); i++){
			Route tempRoute=routesList.get(i).fetch();
			if(tempRoute._id.equals(id)){
				List<DBRef<Marker, String>> markerList = tempRoute.wegpunkte;

				for(int z = 0; z < markerList.size(); z++){
					Marker tempMarker = markerList.get(z).fetch();
					markers.delete(tempMarker._id);
				}
				user.routes.remove(i);
				users.save(user);
				routes.delete(tempRoute._id);
				break;
			}
		}
		
		ArrayList<Route> routesListNew = users.getRoutesForUser(sessionID);
		return ok(meineAngebote.render(routesListNew));
    }
    /**
     * Method to return a list of the users routes in the database. 
     * @return The Angebote page with a list of all markers in the database.
     */
    public static Result  meineAngebote(){

    	UserDB users = UserDB.getInstance();
		ArrayList<Route> routesList = users.getRoutesForUser(session().get("sessionID"));
		
		
		return ok(meineAngebote.render(routesList));
    }
    
	/**
     * Method to create a route. Reads a start address, beginning address
     * and if available additional waypoints
     * @return The confirmation page for creating a route.
     */
    public static Result createRoute(){
    	String sessionID = session().get("sessionID");
    	//DynamicForm requestData = Form.form().bindFromRequest();
    	Form<Route> requestData = Form.form(Route.class);
    	RouteDB routes = RouteDB.getInstance();
        UserDB users = UserDB.getInstance();

		DBCursor<Route> cursor =  routes.findNative(new BasicDBObject());
		ArrayList<Route> routesList = users.getRoutesForUser(sessionID);
		
    	requestData = requestData.bindFromRequest();
        // Check if the start address is empty
	    if(!requestData.field("startAdresse").valueOr("").isEmpty()) {
            	requestData.reject("startAdresse", "Keine Startadresse eingegeben.");
        }
        // Check if the destination address is empty
        if(!requestData.hasErrors()) {
        	if(!requestData.field("zielAdresse").valueOr("").isEmpty()) {
            	requestData.reject("zielAdresse", "Keine Zieladresse eingegeben.");
        	}
        }
        if(requestData.hasErrors()) {
            return badRequest(angebotErstellen.render(routesList, requestData));
	    } else {
	    	HashMap<String, String> markers = (HashMap<String, String>) requestData.data();
	      
	    	
	        //get instances
	        RouteDB routesInstance = RouteDB.getInstance();
	       
	        //let 'em build our route and get it
	        Route tempRoute  = routeListCreator.createRouteFromSubmittedMarkers(markers);
	        
	        //get the current user which we need later one to give him the route
	        User tempUser = users.findByLoggedInHashKey(sessionID);
	        
	        //persist our tempRoute
	        Route tempPersistetRoute = routesInstance.create(tempRoute);
	        
	        DBRef<Route, String> routeDBRef = new DBRef<Route, String>(tempPersistetRoute._id, Route.class);


	        tempUser.routes.add(routeDBRef);
//	        boolean me = tempUser.routes.add(routeDBRef);
//	        Logger.info(me+"");
//	        Logger.info(tempUser.routes.size()+"size nach");
//	        
	        users.save(tempUser);
	        
	        routesList = users.getRoutesForUser(sessionID);
	        return ok(angebotErstellen.render(routesList, Form.form(Route.class)));
	    }
    }
}