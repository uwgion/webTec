package db;

import java.util.ArrayList;
import java.util.Date;

import models.Request;
import models.Route;
import models.AngebotSuchen;
import models.User;
import play.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;


public class AngeboteSuchenDB extends Finder<AngebotSuchen>{
	public static final String COLLECTION_ANGEBOTESUCHEN = "markers";
    private static AngeboteSuchenDB instance = new AngeboteSuchenDB(DBConnect.getDB());

	public AngeboteSuchenDB(DB db) {
		super(db, COLLECTION_ANGEBOTESUCHEN, AngebotSuchen.class);
	}

	 public static void init() {
         Logger.info("Initializing DB. Ensuring indexes.");
		 //in case, then mongod --setParameter textSearchEnabled=true
		 //getInstance().db.getCollection(COLLECTION_ANGEBOTESUCHEN).ensureIndex(new BasicDBObject("email",1));
		 getInstance().db.getCollection(COLLECTION_ANGEBOTESUCHEN);

	 }
	 
	 
	 
//	 /**
//	  * Method to find a user by a given sessionID.
//	  * @param LoggedInHashKey The sessionID key.
//	  * @return The found user or null.
//	  */
//	public User findByLoggedInHashKey(String LoggedInHashKey) {
//		try {
//			com.mongodb.DBCursor mongoCursor = db.getCollection(collectionName)
//					.find(new BasicDBObject("loggedInHashKey", LoggedInHashKey));
//			if(mongoCursor.hasNext()){
//				return new org.mongojack.DBCursor<User>(getColl(), mongoCursor).next();
//			}else{
//				return null;
//			}
//		} catch (IllegalArgumentException e) {
//			return null;
//		}
//	}
//	
//
//	/**
//	 * Method to fetch all routes for a user, identified by his sessionID
//	 * @param LoggedInHashKey The sessionID key.
//	 * @return An ArrayList with all his routes.
//	 */
//	public ArrayList<Route> getRoutesForUser(String LoggedInHashKey){
//		User tempUser = findByLoggedInHashKey(LoggedInHashKey);
//		ArrayList<Route> tempList = new ArrayList<Route>();
//		
//		for(int z = 0; z < tempUser.routes.size(); z++){
//			tempList.add(tempUser.routes.get(z).fetch());
//		}
//
//		return tempList;
//	}
//	
//	/**
//	 * Method to fetch all requests for a user, identified by his sessionID
//	 * @param LoggedInHashKey The sessionID key.
//	 * @param approvedRequestsOnly If set only adds approved requests to the list.
//	 * @return An ArrayList with all his requests.
//	 */
//	public ArrayList<Request> getRequestsForUser(String LoggedInHashKey, boolean approvedRequestsOnly){
//		User tempUser = findByLoggedInHashKey(LoggedInHashKey);
//		ArrayList<Request> tempList = new ArrayList<Request>();
//		for(int z = 0; z < tempUser.requests.size(); z++){
//			if(approvedRequestsOnly){
//				if(tempUser.requests.get(z).fetch().status.equals("Anfrage akzeptiert.")){
//					tempList.add(tempUser.requests.get(z).fetch());
//					Logger.info(tempUser.requests.get(z).fetch().status);
//				}
//			}else{
//				tempList.add(tempUser.requests.get(z).fetch());
//			}
//		}
//
//		return tempList;
//	}
//	
	public static AngeboteSuchenDB getInstance(){
		return instance;
	}
//	
//	public User create(User newUser){
//		newUser.dateCreated = new Date();
//        return save(newUser);
//	}
}
