package authenticators;


import controllers.routes;
import db.UserDB;
import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

/**
 * Authenticator class.
 * @author 
 *
 */
public class Secured extends Security.Authenticator {

	/**
	 * Check if a sessionID key is available.
	 * If so, return true and proceed.
	 */
    public String getUsername(Context ctx) {
    	Cookie sessionCookie = ctx.request().cookie("sessionID");
    	String sessionID = ctx.session().get("sessionID");
		UserDB users = UserDB.getInstance();
		User tempUser;
    	if(sessionCookie != null){
			tempUser = users.findByLoggedInHashKey(sessionCookie.value());
			if(tempUser != null){
				ctx.session().put("sessionID", sessionCookie.value());
	    		return ctx.session().put("sessionID", sessionCookie.value());
			}else{
	    		ctx.session().clear();
	    		ctx.response().discardCookie("sessionID");
			}
    	}
    	tempUser = users.findByLoggedInHashKey(sessionID);
		if(tempUser == null){
	    	ctx.session().clear();
	    	ctx.response().discardCookie("sessionID");
		}

    	return ctx.session().get("sessionID");
    }

    /**
     * If no sessionID key is available, redirect to login page.
     */
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Login.login());
    }
}