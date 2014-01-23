
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



	public class testController {
		
		private static double lon = 48.0509787;
		private static double lat = 10.8896110;

	   
		public static void main(String[] args) throws UnknownHostException{ 
			MongoClient mongoClient = new MongoClient();
			DB db = mongoClient.getDB( "HoeriMit" );
	    	DBCollection collRoutes = db.getCollection("routes");
	    	DBCollection collMarkers = db.getCollection("markers");
	    	
	    	//BasicDBObject queryLonLat = new BasicDBObject("lonLat", 48.0509788).append("lonLat", 10.8896111);
	    	BasicDBObject queryLonLat = new BasicDBObject();
	    	queryLonLat.append("geoNear", "markers");
	    	double[] loc = {lon, lat};
	    	queryLonLat.append("near", loc);
	    	queryLonLat.append("spherical", true);
//	    	queryLonLat.append("maxDistance", (double)50 / 3959 );
	    	queryLonLat.append("maxDistance", (double)500 / 5000);
	    	CommandResult myResults = db.command(queryLonLat); 
	    	
//	    	System.out.println("Result: " +myResults);
	    	queryLonLat.append("maxDistance", (double)50 / 3959 );
	    	
	    	BasicDBList listOfNearMarkers = new BasicDBList();
	    	Set myset = new HashSet();
	    	
	    	BasicDBList results = (BasicDBList)myResults.get("results");	
	    	for( Iterator < Object > it = results.iterator(); it.hasNext(); )
	    	{
//	    	    BasicDBObject result  = (BasicDBObject) it.next();
//	    	    BasicDBObject dbo = (BasicDBObject) result.get("dis");
//	    	    System.out.println(dbo.getString("Filename"));
	    		BasicDBObject result = (BasicDBObject) it.next();
	    		BasicDBObject dbo = (BasicDBObject) result.get("obj");
//	    		System.out.println(result);
//	    		System.out.println(dbo);
//	    		System.out.println(dbo.getString("_id"));
//	    		listOfNearMarkers.add(dbo.get("_id").toString());
	    		
	    		myset.add(dbo.get("_id").toString());
	    	}

	    	Iterator it = myset.iterator();
	    	while(it.hasNext()){
	    		System.out.println(it.next().toString());
	    		System.out.println(collRoutes.findOne(new BasicDBObject("startAdresse.$id", it.next().toString())));
	    	}
	    	
//	    	Iterator<Object> it = listOfNearMarkers.iterator();
//	    	while(it.hasNext())
//	    	{
//	    		System.out.println(it.next().toString());
////	    		BasicDBObject availableRoutes2 = new BasicDBObject("startAdresse.$id", it.next());
//	    		String startAdr = "it.next().toString()";
//	    		BasicDBObject availableRoutes2 = new BasicDBObject("startAdresse.$id", startAdr);
////	    		System.out.println(collRoutes.find(availableRoutes2));
//	    		
//	    		System.out.println(collRoutes.findOne(availableRoutes2));
//	    	}
	    	
	    	System.out.println(collRoutes.findOne());
	    	String []array = {"52bdb17e74dd38e5aa7a310c", "52bdb17e74dd38e5aa7a310c"};

	    	
	    	BasicDBObject availableRoutes = new BasicDBObject();

	    	availableRoutes.append("startAdresse.$id", array);
	    	DBCursor routesCursor = collRoutes.find(availableRoutes);
	    	try {
	    		while(routesCursor.hasNext()){
	    			System.out.println("available Routes" + routesCursor.next());
	    		}
	    	}finally {
	    		routesCursor.close();
	    	}
	    	
//	    	BasicDBObject routeQuery = new BasicDBObject("startAdresse.$id", collMarkers.findOne(queryLonLat).get("results.obj._id.$oid").toString());
//	    	
//	    	com.mongodb.DBCursor routeCursor = collRoutes.find(routeQuery);
//	    	try {
//	    		while(routeCursor.hasNext()){
//	    			System.out.println(routeCursor.next());
//	    		}
//	    	}finally {
//	    		routeCursor.close();
//	    	}
	    
	    	
//	    	try {
//	    		while(cursor.hasNext()){
//	    			System.out.println(cursor.next().get("_id"));
//	    			System.out.println(collMarkers.findOne(queryLonLat).get("_id"));
//	    			System.out.println("Beispielroute "+ collRoutes.findOne());
//	    	    	BasicDBObject routeQuery = new BasicDBObject("startAdresse.$id", "52bdb17e74dd38e5aa7a310b");
//	    			BasicDBObject routeQuery2 = new BasicDBObject("startAdresse.$id", collMarkers.findOne(queryLonLat).get("_id").toString());
//	    			System.out.println(collRoutes.findOne(routeQuery2));
//	    	    	com.mongodb.DBCursor routeCursor = collRoutes.find(routeQuery);
//	    	    	try {
//	    	    		while(routeCursor.hasNext()){
//	    	    			System.out.println(routeCursor.next());
//	    	    		}
//	    	    	}finally {
//	    	    		routeCursor.close();
//	    	    	}
//	    		}
//	    	}finally {
//	    		cursor.close();
//	    	}
	    	

	    	
	    }
		
		private static void append(String string, double latVergroeßert) {
			// TODO Auto-generated method stub
			
		}

		public static Result angebotSuchen(){
			  Form<AngebotSuchen> form = Form.form(AngebotSuchen.class);
			  form = form.bindFromRequest();
			  
		     if (form.hasErrors()) {
		    	 
		     } else {
		    	 AngebotSuchen formAngebotSuchen = form.get();
		    	 
		    	 RouteDB angebotSuchen = RouteDB.getInstance();
//		    	 DBCursor<Route> cursor = angebotSuchen.findNative(new BasicDBObject("startAdresse", formAngebotSuchen.startAdresse));
		    	
		//    	 while (cursor.hasNext()){
		    		 
		    	 }
		  //   }
			return null;

		}
}

