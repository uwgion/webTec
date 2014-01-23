package controllers;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import models.AngebotSuchen;

import com.mongodb.BasicDBList;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

import db.RouteDB;
import play.data.Form;
import play.mvc.*;

public class testController_V3 {


	
	
	public static void main(String[] args) {
		testController_helper tsthelp = new testController_helper();
		Set<String> nearStartMarkers;
		Set<String> nearZielMarkers;
		try {
			nearStartMarkers = tsthelp.findNearController(48.0509787, 10.8896110);
			nearZielMarkers = tsthelp.findNearController(48.0509787, 10.8896110);
			BasicDBList listOfValidRoutes = tsthelp.findValidRoutes(nearStartMarkers, nearZielMarkers);
			
		} catch (UnknownHostException e) {
			System.out.println("the function findNearController didn´t work");
			e.printStackTrace();
		} 
			
		
	}
}
