package controllers;


import org.mongojack.DBCursor;

import com.mongodb.BasicDBObject;

import models.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import db.UserDB;
import views.html.*;

/**
 * Created by Kazakor on 23.12.13.
 */
public class Registration extends Controller{

	public static Result showRegistrationForm(){
		Form<User> form = Form.form(User.class);
		return ok(registration.render(form));
	}
	
	public static Result createUser(){
		 
		 
	    Form<User> form = Form.form(User.class);
	     
	    form = form.bindFromRequest();
	    // Check repeated password
	    if(!form.field("password").valueOr("").isEmpty()) {
            if(!form.field("password").valueOr("").equals(form.field("repeatPassword").value())) {
            	form.reject("repeatPassword", "Password don't match");
            }
        }
	    
	    UserDB users = UserDB.getInstance();
	    DBCursor<User> cursor = null;
	    
	    try{
			cursor =  users.findNative(new BasicDBObject("email", form.get().email));
	    }catch(IllegalStateException e){
	    }


		// Check if the email is valid
        if(!form.hasErrors()) {
            if(cursor.hasNext()){
            	form.reject("email", "This email is already taken");
            }
        }

	    try{
	        cursor =  users.findNative(new BasicDBObject("username", form.get().username));
	    }catch(IllegalStateException e){
	    }
	    
        // Check if the username is valid
        if(!form.hasErrors()) {
            if(cursor.hasNext()) {
            	form.reject("username", "This username is already taken");
            }
        }
        if(form.hasErrors()) {
            return badRequest(registration.render(form));
	     } else {
	    	 User newUser = form.get();
			 String loggedIn = Math.random()+"";
			 newUser.loggedInHashKey = loggedIn;

			 if(form.get().remember == true){
				response().setCookie("sessionID", loggedIn, 604800);
			 }
			 session().put("sessionID", loggedIn);

		   	 users.create(newUser);          

		     return redirect(routes.Application.index());
	     }       
	 }
}
