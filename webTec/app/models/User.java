package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongojack.DBRef;
import org.mongojack.MongoCollection;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;

@MongoCollection(name = "users")
public class User extends Entity{
	public boolean driver;
	@Constraints.Required
	@Constraints.Email
	public String email;
	
	@Constraints.Required
//	@MinLength(6)
	public String password;
	
	@Constraints.Required
	public String username;

    public List<DBRef<Route, String>> routes;
	public List<DBRef<Request, String>> requests;
	
	public String loggedInHashKey;
	public Date dateCreated;
	
	@Required
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date birthday;
	public boolean remember;
	
	public User(){
		routes = new ArrayList<DBRef<Route, String>>();
		requests = new ArrayList<DBRef<Request, String>>();
		dateCreated = new Date();
	}
    public String toString() {
        return super.toString() +" email:" +email +" dateCreated:" +dateCreated +" password:" +password+ " loggedInHashKey:"+loggedInHashKey;
    }
	
}
