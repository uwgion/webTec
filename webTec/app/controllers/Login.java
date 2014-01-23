package controllers;



import models.User;

import org.mongojack.DBCursor;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

import com.mongodb.BasicDBObject;

import db.UserDB;

public class Login extends Controller {
	private static Form<User> userForm = Form.form(User.class);
	
	 public static Result  showLoginForm(){
		 if(request().cookie("sessionID") == null){
			 return ok(login.render(userForm)); 
		 }else{
			return redirect(routes.Application.index());
		 }
	 }
	 
	 public static Result login(){
		  Form<User> form = Form.form(User.class);
//		  DynamicForm form = form.bindFromRequest();
		  form = form.bindFromRequest();
		     
		     if (form.hasErrors()) {
		    	return badRequest(login.render(form));
		     } else {
				User formUser = form.get();
				
				UserDB users = UserDB.getInstance();
				DBCursor<User> cursor =  users.findNative(new BasicDBObject("username", formUser.username));
				String pw ="";
				String id ="";

				boolean test = false;
				if (test==true){
					return ok(""+ cursor.hasNext());
				}
				
				if (cursor.hasNext()) {
					User firstObject = cursor.next();
					pw = firstObject.password;
					id = firstObject._id;
					session("email", firstObject.email);
				}

				if(cursor.count() != 1){
					flash("errors","Falscher Benutzername oder Passwort.");
					return badRequest(login.render(userForm)); 
				}else if(!pw.equals(formUser.password)){
					flash("errors","Falscher Benutzername oder Passwort.");
					return badRequest(login.render(userForm)); 
				}
				String loggedIn = Math.random()+"";
				User user = users.findById(id);
				user.loggedInHashKey = loggedIn;
				users.save(user);	
				
				if(formUser.remember == true){					
					//set the max age of the cookie to 1 week
					response().setCookie("sessionID", loggedIn, 604800);
				}
				if(user.driver){
					session().put("driver", "true");
				}else{
					session().put("driver", "false");
				}
				session().put("sessionID", loggedIn);
				session().put("username", user.username);

				cursor.close();

				//return ok("Deine Eingaben: " +user.email +" " +user.password +" remember: " +user.remember);

				return redirect(routes.Application.index());
		     }
	 }
}
