package db;

import java.util.Date;

import models.Marker;
import org.mongojack.DBCursor;

import play.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

public class MarkerDB extends Finder<Marker>{


/**
 * collection name for things
 */
public static final String COLLECTION_THINGS = "markers";
private static MarkerDB instance = new MarkerDB(DBConnect.getDB());

public MarkerDB(DB db) {
    super(db, COLLECTION_THINGS, Marker.class);
}

public static void init() {
        Logger.info("Initializing DB. Ensuring indexes.");
        /**
         * geo index
         */
        
        getInstance().db.getCollection(COLLECTION_THINGS).ensureIndex(new BasicDBObject("lonLat", "2dsphere"));
}

public static MarkerDB getInstance(){
        return instance;
}

public Marker create(Marker marker){
        marker.dateCreated = new Date();
        return save(marker);
}
/**
 * @param skip offset
 * @param maxNum maximum number to return
 */
public DBCursor<Marker> list(int skip, int maxNum){
        DBCursor<Marker> markers = getColl().find().skip(skip).limit(maxNum);
        return markers;
}

public org.mongojack.DBCursor<Marker> findMarkersNear(double longitude,
		double latitude, double distance) {
        	return findNative(q("lonLat", near(longitude, latitude, distance)));
		}
}
