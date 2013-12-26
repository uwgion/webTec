package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongojack.DBRef;

import play.data.validation.Constraints;

public class User extends Entity{
	@Constraints.Required
	@Constraints.Email
	public String email;
	
	@Constraints.Required
	public String password;
	
	@Constraints.Required
	public String username;

    public List<DBRef<Route, String>> routes;

	public String loggedInHashKey;
	public Date dateCreated;
	public boolean remember;
	

	public User(){
		routes = new ArrayList<>();
	}
    public String toString() {
        return super.toString() +" email:" +email +" dateCreated:" +dateCreated +" password:" +password+ " loggedInHashKey:"+loggedInHashKey;
    }
	
}
