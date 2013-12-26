package db;


import play.Logger;
import models.Route;

import com.mongodb.DB;

public class RouteDB extends Finder<Route>{

	public static final String COLLECTION_ROUTES = "routes";
    private static RouteDB instance = new RouteDB(DBConnect.getDB());

	public RouteDB(DB db) {
		super(db, COLLECTION_ROUTES, Route.class);
	}

	 public static void init() {
         Logger.info("Initializing DB. Ensuring indexes.");
		 //in case, then mongod --setParameter textSearchEnabled=true
		 //getInstance().db.getCollection(COLLECTION_ROUTES).ensureIndex(new BasicDBObject("email",1));
		 //getInstance().db.getCollection(COLLECTION_USERS);

	 }
	public static RouteDB getInstance(){
		return instance;
	}
	
	public Route create(Route newRoute){
        return save(newRoute);
	}
}
