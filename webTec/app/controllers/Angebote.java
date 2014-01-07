package controllers;

import helpers.AddressNotFoundException;
import helpers.RouteAndMarkerHelpers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Marker;
import models.Request;
import models.Route;
import models.User;

import org.mongojack.DBCursor;
import org.mongojack.DBRef;

import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import play.mvc.With;
import views.html.angebotAendern;
import views.html.angebotAnzeigen;
import views.html.angebotErstellen;
import views.html.meineAngebote;
import authenticators.Driver;
import authenticators.Secured;

import com.mongodb.BasicDBObject;

import db.FixedPointDB;
import db.MarkerDB;
import db.RequestDB;
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
	 * Method to display an existing offer.
	 * @param id The id of the offer to display.
	 * @return The page to display the offer.
	 */
	public static Result displayOffer(String id){
		RouteDB routes = RouteDB.getInstance();
    	Route tempRoute = routes.findById(id);
    	Form<Request> form = Form.form(Request.class);

    	return ok(angebotAnzeigen.render(tempRoute,form));
	}
    /**
     * Method to return a list of all routes in the database. 
     * Those routes will then be display on the map.
     * @return The Angebote page with a list of all markers in the database.
     */
	@With({Driver.class})
    public static Result  createOffer(){
		Form<Route> form = Form.form(Route.class);

    	RouteDB routes = RouteDB.getInstance();
		DBCursor<Route> cursor =  routes.findNative(new BasicDBObject());
		ArrayList<Route> routesList = (ArrayList<Route>) cursor.toArray();
		HashMap<String, String> fixedPoints = FixedPointDB.getInstance().getAllFixedPoints();

		
		return ok(angebotErstellen.render(routesList, form, fixedPoints));
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
    	RequestDB requests = RequestDB.getInstance();
    	User user = users.findByLoggedInHashKey(sessionID);
		List<DBRef<Route, String>> routesList = user.routes;
		
		for(int i = 0; i < routesList.size(); i++){
			Route tempRoute=routesList.get(i).fetch();
			if(tempRoute._id.equals(id)){
				List<DBRef<Marker, String>> markerList = tempRoute.wegpunkte;

				//delete the start address marker
				markers.delete(tempRoute.startAdresse.fetch()._id);
				
				//delete the destination address marker
				markers.delete(tempRoute.zielAdresse.fetch()._id);
				
				//delete all waypoint markers
				for(int z = 0; z < markerList.size(); z++){
					Marker tempMarker = markerList.get(z).fetch();
					markers.delete(tempMarker._id);
				}
				//delete all requests
				for(int z = 0; z < tempRoute.requests.size(); z++){
					Request tempRequest = tempRoute.requests.get(z).fetch();
					//quite stupid and inefficient, no other idea though
					List<DBRef<Request, String>> meh = tempRequest.requestingUser.fetch().requests;
					for(int j = 0; j < meh.size(); j++){
						if(meh.get(j).fetch()._id.equals(tempRequest._id)){
							meh.remove(j);
						}
					}
					user.requests = meh;
					requests.delete(tempRequest._id);
				}
				//remove the route from the users collection
				user.routes.remove(i);
				users.save(user);
				//delete the route
				routes.delete(tempRoute._id);
				break;
			}
		}
		

		return redirect(controllers.routes.Angebote.myOffers());
    }
    /**
     * Method to return a list of the users routes in the database. 
     * @return The Angebote page with a list of all markers in the database.
     */
    public static Result  myOffers(){
    	String sessionID = session().get("sessionID");
    	UserDB users = UserDB.getInstance();
		ArrayList<Route> routesList = users.getRoutesForUser(sessionID);
		ArrayList<Request> requestList = users.getRequestsForUser(sessionID);
		return ok(meineAngebote.render(routesList, requestList));
    }
    
	@With({Driver.class})
    public static Result changeOfferForm(String id){

    	Route tempRoute = buildRequestedOffer(id);

    	Form<Route> responseData = Form.form(Route.class);
    	Form<Route> responseDataFilled = responseData.fill(tempRoute);
    	
		return ok(angebotAendern.render(tempRoute, responseDataFilled));
    }
    
    /**
     * Method to fill the form for the route to be changed.
     * @param id Id of the route to be changed.
     * @return The filled form.
     */
    private static Route buildRequestedOffer(String id){
    	RouteDB routes = RouteDB.getInstance();
    	Route tempRoute = routes.findById(id);
    	tempRoute.startAdresseForm = tempRoute.startAdresse.fetch().name;
    	tempRoute.zielAdresseForm = tempRoute.zielAdresse.fetch().name;
    	
    	
    	return tempRoute;
    }
    /**
     * Method to change an existing offer.
     * @param id The id of the offer to change.
     * @return The updated offer list.
     */
	@With({Driver.class})
    public static Result changeOffer(String id){
    	Form<Route> requestData = Form.form(Route.class);
    	String sessionID = session().get("sessionID");
    	requestData = requestData.bindFromRequest();

    	UserDB users = UserDB.getInstance();
    	RouteDB routes = RouteDB.getInstance();
    	MarkerDB markers = MarkerDB.getInstance();
    	
    	//get the user who triggered the request
    	User user = users.findByLoggedInHashKey(sessionID);
    	//get routes for the given user
    	
		List<DBRef<Route, String>> routesList = user.routes;
    	if(requestData.hasErrors()){
    		return badRequest();
    	}
    	
    	HashMap<String, String> requestMap = (HashMap<String, String>) requestData.data();

    	try{
    		routeListCreator.updateRoute(id, requestMap, routes, markers, routesList);
    	}catch(AddressNotFoundException e){

    		flash("errors","Ungültige Adresse eingegeben.");
    		Route tempRoute = buildRequestedOffer(id);
        	Form<Route> responseData = Form.form(Route.class);
        	Form<Route> responseDataFilled = responseData.fill(tempRoute);
    		return badRequest(angebotAendern.render(tempRoute, responseDataFilled));
    	} catch (ParseException e) {
    		Route tempRoute = buildRequestedOffer(id);
        	Form<Route> responseData = Form.form(Route.class);
        	Form<Route> responseDataFilled = responseData.fill(tempRoute);
    		if(e.toString().matches(".*Date in past.")){
	    		flash("errors","Datum oder Uhrzeit in der Vergangenheit.");
    		}else{
    			flash("errors","Ungültiges Datums- oder Uhrzeitformt eingegeben.");
    		}
			return badRequest(angebotAendern.render(tempRoute, responseDataFilled));
		}
    	
		flash("success","Angebot erfolgreich gespeichert.");
		return redirect(controllers.routes.Angebote.myOffers());

	}




	/**
     * Method to create a route. Reads a start address, beginning address
     * and if available additional waypoints
     * @return The confirmation page for creating a route.
     */
	@With({Driver.class})
    public static Result createRoute(){
    	String sessionID = session().get("sessionID");
    	//DynamicForm requestData = Form.form().bindFromRequest();
    	Form<Route> requestData = Form.form(Route.class);
        UserDB users = UserDB.getInstance();

		ArrayList<Route> routesList = users.getRoutesForUser(sessionID);
		
    	requestData = requestData.bindFromRequest();
		Logger.info(requestData.data().toString());

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
		HashMap<String, String> fixedPoints = FixedPointDB.getInstance().getAllFixedPoints();

        if(requestData.hasErrors()) {
            return badRequest(angebotErstellen.render(routesList, requestData, fixedPoints));
	    } else {
	    	HashMap<String, String> markers = (HashMap<String, String>) requestData.data();
	      
	    	
	        //get instances
	        RouteDB routesInstance = RouteDB.getInstance();
	        Route tempRoute;
	    	try{
	    		new Route().setDateTime(markers.get("timeForm"), markers.get("dateForm"));
		        tempRoute  = routeListCreator.createRouteFromSubmittedMarkers(markers);
		        tempRoute.seats = Integer.parseInt(markers.get("seats"));
		        tempRoute.setDateTime(markers.get("timeForm"), markers.get("dateForm"));
		        tempRoute.timeForm=markers.get("timeForm");
		        tempRoute.dateForm=markers.get("dateForm");
	    	}catch(AddressNotFoundException e){
	    		flash("errors","Ungültige Adresse eingegeben.");
				return badRequest(angebotErstellen.render(routesList, requestData, fixedPoints));
	    	}
	    	catch (ParseException e) {
	    		if(e.toString().matches(".*Date in past.")){
		    		flash("errors","Datum oder Uhrzeit in der Vergangenheit.");
	    		}else{
	    			flash("errors","Ungültiges Datums- oder Uhrzeitformt eingegeben.");
	    		}
				return badRequest(angebotErstellen.render(routesList, requestData, fixedPoints));
			}
	        
	        //get the current user which we need later one to give him the route
	        User tempUser = users.findByLoggedInHashKey(sessionID);
	        
	        //persist our tempRoute
	        Route tempPersistetRoute = routesInstance.create(tempRoute);
	        
	        DBRef<Route, String> routeDBRef = new DBRef<Route, String>(tempPersistetRoute._id, Route.class);


	        tempUser.routes.add(routeDBRef);    
	        users.save(tempUser);
	        
	        routesList = users.getRoutesForUser(sessionID);
	    	flash("success","Angebot erfolgreich erstellt.");
	        return redirect(controllers.routes.Angebote.myOffers());
	    }
    }
}
