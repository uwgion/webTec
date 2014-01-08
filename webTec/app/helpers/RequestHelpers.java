package helpers;

import models.Marker;
import models.Route;

import org.mongojack.DBRef;

import play.Logger;

public class RequestHelpers {

	public DBRef<Marker, String> findMarkerForString(Route route, String address){
		if(route.startAdresse.fetch().name.equals(address)){
			return route.startAdresse;
		}else if(route.zielAdresse.fetch().name.equals(address)){
			return route.zielAdresse;
		}else{
			for(DBRef<Marker, String> markerRef: route.wegpunkte){
				if(markerRef.fetch().name.equals(address)){
					return markerRef;
				}
			}
		}
		return null;
	}
}
