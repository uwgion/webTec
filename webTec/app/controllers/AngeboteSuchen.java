package controllers;

import helpers.AddressNotFoundException;
import helpers.RouteAndMarkerHelpers;




import helpers.SearchingForRoutes;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import models.AngebotSuchen;
import models.Marker;
import play.data.Form;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.mongodb.*;

import db.AngeboteSuchenDB;


public class AngeboteSuchen extends Controller {
	//private static Form<AngebotSuchen> angebotSuchenForm = Form.form(AngebotSuchen.class);
	
	 public static Result angeboteSuchen() throws UnknownHostException {
		 
		 Form<AngebotSuchen> form = Form.form(AngebotSuchen.class);
		 form = form.bindFromRequest();
		 
		     
		     if (form.hasErrors()) {
		    	return badRequest(index.render(form));
		     } else {
		    	AngebotSuchen angebotSuchenModel = form.get();
		    	AngeboteSuchenDB angebote = AngeboteSuchenDB.getInstance();	    	
			
				boolean test = false;
											
					RouteAndMarkerHelpers help = new RouteAndMarkerHelpers();
					Promise<String> promStartAdr = help.singleAddressStringToGoogleAddress(angebotSuchenModel.startAdresse);
					Promise<String> promZielAdr = help.singleAddressStringToGoogleAddress(angebotSuchenModel.zielAdresse);
					
				
					Marker startMarker;
					Marker zielMarker;

					try {
						startMarker = help.createNewMarkerFromString(promStartAdr, "startMarker");
					} catch (AddressNotFoundException e2) {		
						e2.printStackTrace();
						return ok("Start Adresse wurde nicht gefunden");
					}
					try {
						zielMarker = help.createNewMarkerFromString(promZielAdr, "zielMarker");
					} catch (AddressNotFoundException e1) {
						e1.printStackTrace();
						return ok("Ziel Adresse wurde nicht gefunden");
					}
					
					//48.0509787, 10.8896110
					
//					double startLng = 48.0509787;
//					double startLat = 10.8896110;
//					
//					double zielLng = 48.0509787;
//					double zielLat = 10.8896110;
					
					double startLng = startMarker.longitude();
					double startLat = startMarker.latitude();
					
					double zielLng = zielMarker.longitude();
					double zielLat = zielMarker.latitude();
					
					SearchingForRoutes sfr = new SearchingForRoutes();
			
					Set<String> nearStartMarkers;
					Set<String> nearZielMarkers;		
					BasicDBList listOfValidRoutes = null;
					Set<String>listOfIdForValidRoutes = null;
					try {
						nearStartMarkers = sfr.findNearMarkers(startLng, startLat);
						nearZielMarkers = sfr.findNearMarkers(zielLng, zielLat);
						listOfValidRoutes = sfr.findValidRoutes(nearStartMarkers, nearZielMarkers);
						listOfIdForValidRoutes = sfr.findIdForValidRoutes(nearStartMarkers, nearZielMarkers);
						
					} catch (UnknownHostException e) {
						System.out.println("the function findNearController didn´t work");
						e.printStackTrace();
					} 
					
		     
					return ok(listOfIdForValidRoutes+" " + "\r\n" + startMarker + "\r\n" + zielMarker);

		     }
		     

		     
	 
	 }
}
	 

