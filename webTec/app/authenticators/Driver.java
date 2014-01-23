package authenticators;

import models.User;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Action.Simple;
import play.mvc.Http.Context;
import play.mvc.Security.Authenticated;
import play.mvc.SimpleResult;
import controllers.routes;
import db.UserDB;

/**
 * Class for tests if a user is a driver.
 * @author 
 *
 */
public class Driver extends Simple{


	/**
	 * Method to test if a user is a driver or not.
	 * 
	 */
	@Authenticated(Secured.class)
	public Promise<SimpleResult> call(Context ctx) throws Throwable {
		String sessionID = ctx.session().get("sessionID");
		UserDB users = UserDB.getInstance();
		User tempUser;
    	tempUser = users.findByLoggedInHashKey(sessionID);
    	if(tempUser.driver == false){
    		ctx.flash().put("errors","Sie sind leider nicht als Fahrer registriert und können keine Angebot erstellen.");    		
    		return F.Promise.pure(( redirect(routes.Application.index())));
    	}

	    return delegate.call(ctx);
	}
}
