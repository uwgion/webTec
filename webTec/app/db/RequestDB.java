package db;

import java.util.Date;

import models.Request;
import play.Logger;

import com.mongodb.DB;

public class RequestDB extends Finder<Request>{

	public static final String COLLECTION_REQUESTS = "requests";
    private static RequestDB instance = new RequestDB(DBConnect.getDB());

	public RequestDB(DB db) {
		super(db, COLLECTION_REQUESTS, Request.class);
	}

	 public static void init() {
         Logger.info("Initializing DB. Ensuring indexes.");
		 //in case, then mongod --setParameter textSearchEnabled=true
		 //getInstance().db.getCollection(COLLECTION_REQUESTS).ensureIndex(new BasicDBObject("email",1));
		 //getInstance().db.getCollection(COLLECTION_USERS);

	 }


	public static RequestDB getInstance(){
		return instance;
	}
	
	public Request create(Request newRequest){
		newRequest.dateCreated = new Date();
        return save(newRequest);
	}
}
