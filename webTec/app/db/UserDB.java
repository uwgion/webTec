package db;

import java.util.ArrayList;
import java.util.Date;

import org.mongojack.DBCursor;
import org.mongojack.DBRef;

import play.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

import models.Route;
import models.User;


public class UserDB extends Finder<User>{
	public static final String COLLECTION_USERS = "users";
    private static UserDB instance = new UserDB(DBConnect.getDB());

	public UserDB(DB db) {
		super(db, COLLECTION_USERS, User.class);
	}

	 public static void init() {
         Logger.info("Initializing DB. Ensuring indexes.");
		 //in case, then mongod --setParameter textSearchEnabled=true
		 getInstance().db.getCollection(COLLECTION_USERS).ensureIndex(new BasicDBObject("email",1));
		 //getInstance().db.getCollection(COLLECTION_USERS);

	 }
	 /**
	  * Method to find a user by a given sessionID.
	  * @param LoggedInHashKey The sessionID key.
	  * @return The found user or null.
	  */
	public User findByLoggedInHashKey(String LoggedInHashKey) {
		try {
			com.mongodb.DBCursor mongoCursor = db.getCollection(collectionName)
					.find(new BasicDBObject("loggedInHashKey", LoggedInHashKey));
			if(mongoCursor.hasNext()){
				return new org.mongojack.DBCursor<User>(getColl(), mongoCursor).next();
			}else{
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	

	/**
	 * Method to fetch all routes for a user, identified by his sessionID
	 * @param LoggedInHashKey The sessionID key.
	 * @return An ArrayList with all his routes.
	 */
	public ArrayList<Route> getRoutesForUser(String LoggedInHashKey){
		User tempUser = findByLoggedInHashKey(LoggedInHashKey);
		ArrayList<Route> tempList = new ArrayList<>();
		
		Logger.info(tempUser.routes.size()+"");
		for(int z = 0; z < tempUser.routes.size(); z++){
			tempList.add(tempUser.routes.get(z).fetch());
		}

		return tempList;
	}
	public static UserDB getInstance(){
		return instance;
	}
	
	public User create(User newUser){
		newUser.dateCreated = new Date();
        return save(newUser);
	}
}
