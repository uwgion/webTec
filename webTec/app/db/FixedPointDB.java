package db;

import java.util.HashMap;

import org.mongojack.JacksonDBCollection;

import models.FixedPoint;
import models.Marker;
import play.Logger;

import com.mongodb.DB;

public class FixedPointDB extends Finder<FixedPoint>{
	public static final String COLLECTION_FIXEDPOINTS = "fixedpoints";
	private static FixedPointDB instance = new FixedPointDB(DBConnect.getDB());

	public FixedPointDB(DB db) {
	    super(db, COLLECTION_FIXEDPOINTS, FixedPoint.class);
	}

	public static void init() {
	        Logger.info("Initializing DB. Ensuring indexes.");
	        /**
	         * geo index
	         */
	        
//	        getInstance().db.getCollection(COLLECTION_FIXEDPOINTS).ensureIndex(new BasicDBObject("lonLat", "2dsphere"));
	}

	public static FixedPointDB getInstance(){
	        return instance;
	}

	public FixedPoint create(FixedPoint fixedPoint){
	        return save(fixedPoint);
	}
	
	public HashMap<String, String> getAllFixedPoints(){
		MarkerDB markers = MarkerDB.getInstance();
		JacksonDBCollection<FixedPoint, String> meh = getColl();
		HashMap<String, String> result = new HashMap<String, String>();
		for(FixedPoint fixedPoint: meh.find()){
			Marker tempMarker = markers.findById(fixedPoint.markerId);
			result.put(tempMarker._id, tempMarker.name);
		}
		
		return result;
	}
}
