package controllers;

import helpers.RouteAndMarkerHelpers;
import models.AngebotSuchen;
import models.User;

import org.mongojack.DBCursor;

import play.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.about;
import views.html.index;

import com.mongodb.BasicDBObject;

import db.UserDB;

public class Application extends Controller {
	static RouteAndMarkerHelpers routeListCreator = new RouteAndMarkerHelpers();
	
    public static Result index() {
		Form<AngebotSuchen> form = Form.form(AngebotSuchen.class);
        return ok(index.render(form));
    }

    public static Result about(){
        return ok(about.render());
    }


    /**
     * Method to logout. Will delete all session variables and the session hash 
     * stored in the database.
     * @return The index/home page.
     */
    public static Result  logout(){
    	 UserDB users = UserDB.getInstance();
	     DBCursor<User> cursor =  users.findNative(new BasicDBObject("loggedInHashKey", session("sessionID")));
	     
	     if (cursor.hasNext()) {
			User user = cursor.next();
			user.loggedInHashKey= "";
			users.save(user);
	     }

	    cursor.close();
	    response().discardCookie("sessionID");

    	session().clear();
        return redirect(routes.Application.index());
    }
    
    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("jsRoutes",
        controllers.routes.javascript.Angebote.destroyOffer(),
        controllers.routes.javascript.Angebote.changeOffer()));	
    }
}
