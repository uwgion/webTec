package controllers;

import java.util.ArrayList;

import helpers.RequestHelpers;

import org.mongojack.DBRef;

import models.Route;
import models.User;
import models.Request;
import db.RequestDB;
import db.RouteDB;
import db.UserDB;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.myRequests;

public class Requests extends Controller{

	/**
	 * Method to display all the requests for a user.
	 * @return The myRequsts page.
	 */
	public static Result displayRequests(){
		UserDB users = UserDB.getInstance();
		User user = users.findByLoggedInHashKey(session().get("sessionID"));
		ArrayList<Request> myCreatedRequests = users.getRequestsForUser(user.loggedInHashKey);
		ArrayList<Route> myCreatedRoutes = users.getRoutesForUser(user.loggedInHashKey);
		ArrayList<Request> myNotApprovedRequests = new ArrayList<Request>();
		for(Route route: myCreatedRoutes){
			for(DBRef<Request, String> request: route.requests){
				Request tempRequest = request.fetch();
				if(tempRequest.status.equals("Anfrage verschickt")){
					myNotApprovedRequests.add(tempRequest);
				}
			}
		}
		Logger.info(myNotApprovedRequests.size() +"");
		return ok(myRequests.render(myNotApprovedRequests, myCreatedRequests));
	}

	/**
	 * Method to create a new request and add this request to the route and the user.
	 * @param routeID The id of the route this request will be for.
	 * @return The my requests page.
	 */
	public static Result createRequest(String routeID){
		UserDB users = UserDB.getInstance();
		RouteDB routes = RouteDB.getInstance();
		RequestDB requests = RequestDB.getInstance();
		RequestHelpers requestHelper = new RequestHelpers();
		
		User user = UserDB.getInstance().findByLoggedInHashKey(session().get("sessionID"));
		Route route = routes.findById(routeID);
	    Form<Request> form = Form.form(Request.class);
	    
	    form = form.bindFromRequest();
	    Request request = new Request();
	    request.requestingUser = new DBRef<User, String>(user._id, User.class);
	    request.startAddress = requestHelper.findMarkerForString(route, form.get().startAddressForm);
	    request.destinationAddress = requestHelper.findMarkerForString(route, form.get().destinationAddressForm);
	    request.seats = form.get().seats;
	    request.status = "Anfrage verschickt";
	    request.route = new DBRef<Route, String>(route._id, Route.class);
	    request = requests.create(request);

	    DBRef<Request, String> requestRef = new DBRef<Request, String>(request._id, Request.class);
	    user.requests.add(requestRef);
	    route.requests.add(requestRef);
	    
	    users.save(user);
	    routes.save(route);
	    
		return redirect(controllers.routes.Requests.displayRequests());
	}
	
	public static Result processRequest(String requestID, String what){
		RequestDB requests = RequestDB.getInstance();
		RouteDB routes = RouteDB.getInstance();
		int todo = Integer.parseInt(what);
		Request request = requests.findById(requestID);
		
		
		switch (todo) {
		case 0:
			Route route = routes.findById(request.route.fetch()._id);
			route.seats -= request.seats;
			request.status = "Anfrage akzeptiert.";
			routes.save(route);
			break;

		case 1:
			request.status = "Anfrage abgelehnt.";
			break;
		}
		
		requests.save(request);
		return redirect(controllers.routes.Requests.displayRequests());
	}
}
