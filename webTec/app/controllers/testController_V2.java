package controllers;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import models.AngebotSuchen;

import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;

import db.RouteDB;
import play.data.Form;
import play.mvc.*;

import com.mongodb.*;

public class testController_V2 {

	private static double lon = 48.0509787;
	private static double lat = 10.8896110;
	
	private static double lon2 = 48.0509787;
	private static double lat2 = 10.8896110;

	public static void main(String[] args) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("HoeriMit");
		DBCollection collRoutes = db.getCollection("routes");
		DBCollection collMarkers = db.getCollection("markers");

		/**
		 * Find near startAdress Markers
		 */
		BasicDBObject queryLonLat = new BasicDBObject();
		queryLonLat.append("geoNear", "markers");
		double[] loc = { lon, lat };
		queryLonLat.append("near", loc);
		queryLonLat.append("spherical", true);
		queryLonLat.append("maxDistance", (double) 500 / 5000);
		CommandResult myResults = db.command(queryLonLat);
		
		BasicDBList listOfNearMarkers = new BasicDBList();
		Set<String> myset = new HashSet<String>();

		BasicDBList results = (BasicDBList) myResults.get("results");
		for (Iterator<Object> it = results.iterator(); it.hasNext();) {
			BasicDBObject result = (BasicDBObject) it.next();
			BasicDBObject dbo = (BasicDBObject) result.get("obj");
			myset.add(dbo.get("_id").toString());
		}

		Iterator it = myset.iterator();
		BasicDBList listOfPossibleRoutes = null;
		
		/**
		 * Find near zielAdress Markers
		 */
		
		
		while (it.hasNext()) {
			String mId = it.next().toString();
			listOfPossibleRoutes = new BasicDBList();
			
			if (collRoutes.findOne(new BasicDBObject("startAdresse.$id", mId)) != null){
				System.out.println(mId);
				DBObject o = collRoutes.findOne(new BasicDBObject("startAdresse.$id", mId));
				System.out.println(o);
				listOfPossibleRoutes.add(o);
			}	
			
			if (collRoutes.findOne(new BasicDBObject("wegpunkte.$id", mId)) != null){
				System.out.println(mId);
				DBObject o = collRoutes.findOne(new BasicDBObject("wegpunkte.$id", mId));
				System.out.println(o);
				listOfPossibleRoutes.add(o);	
			}					
		}

		System.out.println(collRoutes.findOne());
		String[] array = { "52bdb17e74dd38e5aa7a310c",
				"52bdb17e74dd38e5aa7a310c" };

		BasicDBObject availableRoutes = new BasicDBObject();

		availableRoutes.append("startAdresse.$id", array);
		DBCursor routesCursor = collRoutes.find(availableRoutes);
		try {
			while (routesCursor.hasNext()) {
				System.out.println("available Routes" + routesCursor.next());
			}
		} finally {
			routesCursor.close();
		}

		

	}
	
}
