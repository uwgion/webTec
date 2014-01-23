package controllers;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class testController_helper {

	public Set<String> findNearController (double lon, double lat) throws UnknownHostException{
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("HoeriMit");
		
		BasicDBObject queryLonLat = new BasicDBObject();
		queryLonLat.append("geoNear", "markers");
		double[] loc = { lon, lat };
		queryLonLat.append("near", loc);
		queryLonLat.append("spherical", true);
		queryLonLat.append("maxDistance", (double) 500 / 5000);
		CommandResult myResults = db.command(queryLonLat);
		
		Set<String> myset = new HashSet<String>();

		BasicDBList results = (BasicDBList) myResults.get("results");
		for (Iterator<Object> it = results.iterator(); it.hasNext();) {
			BasicDBObject result = (BasicDBObject) it.next();
			BasicDBObject dbo = (BasicDBObject) result.get("obj");
			myset.add(dbo.get("_id").toString());
		}
		
		return myset;
	}
	
	public BasicDBList findValidRoutes(Set<String> nearStartMarkers,Set<String> nearZielMarkers) throws UnknownHostException{
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("HoeriMit");
		DBCollection routesColl = db.getCollection("routes");
		
		Iterator<String> it = nearStartMarkers.iterator();
		BasicDBList listOfPossibleRoutes = new BasicDBList(); 
		
		while (it.hasNext()) {
			String mId = it.next().toString();
			DBObject o = routesColl.findOne(new BasicDBObject("startAdresse.$id", mId));
			if (o != null){
				
				Iterator<String> it2 = nearZielMarkers.iterator();
				while (it2.hasNext()){
					String mId2 = it2.next().toString();		
					BasicDBObject startZielQuery = new BasicDBObject();
					startZielQuery.append("startAdresse.$id", mId);
					startZielQuery.append("zielAdresse.$id", mId2);
					if (routesColl.findOne(startZielQuery) != null)
						//System.out.println(mId + "   " + mId2 + "   " +routesColl.findOne(startZielQuery));
						listOfPossibleRoutes.add(routesColl.findOne(startZielQuery));
						
				}
				
			}	
			
					
		}
		//System.out.println(listOfPossibleRoutes.toString());
		
		return listOfPossibleRoutes;
	}
}
