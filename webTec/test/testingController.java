import java.net.UnknownHostException;

import views.html.defaultpages.todo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class testingController {

	public static BasicDBObject q(String key, Object value) {
		return new BasicDBObject(key, value);
	}
//	double[] loc2 = {47.7242629, 8.9349472};
	public static BasicDBObject near(double longitude, double latitude, double maxDistance) {		
		return q("lonLat", q("$near", q("$geometry", q("type", "Point")))).append("lonLat", new double[] { longitude, latitude }).append("lonLat", q("$maxDistance", maxDistance));
	}
	

	public static BasicDBObject near2(double longitude, double latitude, double maxDistance) throws UnknownHostException {		
		
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB( "HoeriMit" );
		DBCollection coll = db.getCollection("markers");
		
		//System.out.println( coll.findOne(near(longitude, latitude, maxDistance)).get("_id").toString());
		//return q("");
		//return q("startAdresse.$id", coll.findOne(near(longitude, latitude, maxDistance).get("_id")));
		
		return q("startAdresse.$id", coll.findOne(new BasicDBObject("_id", "52de7e52bd93b3e46719e4bf")));
	}
	
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB( "HoeriMit" );
		DBCollection coll = db.getCollection("markers");
		DBCollection coll2 = db.getCollection("routes");
		
//		double[] loc2 = {47.7242629, 8.9349472};
//		"lonLat" : [ 47.7242629 , 8.9349472]
		
		
		BasicDBObject queryLonLat2 = near(47.787529, 8.976065, 0.25);
		
		DBCursor cursor = coll.find();
		
		System.out.println(coll.findOne().toString());
		System.out.println();
		System.out.println(coll2.findOne().toString());
		System.out.println();
		
		System.out.println("");
		
//		while (cursor.hasNext()){
//			
//			DBObject next = cursor.next();
//			
//			System.out.println(": " + next.toString());
//		}
		System.out.println("");
		
		DBCursor cursorMarkers = coll.find();
		
		while (cursorMarkers.hasNext()) {
			
			System.out.println(cursorMarkers.next());
		}
		
		System.out.println();
		System.out.println();
		System.out.println(coll2.findOne().toString());
		System.out.println();
		System.out.println(coll.findOne().toString());
		System.out.println();
		System.out.println(coll2.findOne().toString());
		System.out.println();
		

		
				
		System.out.println(coll2.findOne(new BasicDBObject("startAdresse.$ref", "markers")));
		
		System.out.println(coll.findOne(new BasicDBObject("what", "startMarker")));
		
		System.out.println(coll2.findOne(new BasicDBObject("startAdresse.$id", coll.findOne(near2(47.7242629,8.9349472,0.25)))));
		
		System.out.println(coll2.findOne(new BasicDBObject("startAdresse.$id", ("52de859ebd93b3e46719e569"))));
		//System.out.println("" + coll2.findOne(near2(47.7242629,8.9349472,0.25)));
	}
}
