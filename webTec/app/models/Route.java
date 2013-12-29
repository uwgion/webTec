package models;

import java.util.LinkedList;
import java.util.List;

import org.mongojack.DBRef;
import org.mongojack.MongoCollection;

import play.data.validation.Constraints.Required;

@MongoCollection(name = "routes")
public class Route extends Entity{

	@Required
	public String startAdresseForm;
	
	@Required
	public String zielAdresseForm;

	public List<String> wegpunkteForm;
	
	public DBRef<Marker, String> startAdresse;
	public DBRef<Marker, String> zielAdresse;
	
    public List<DBRef<Marker, String>> wegpunkte;
    
    public Route(){
    	wegpunkte = new LinkedList<>();
    	wegpunkteForm = new LinkedList<>();
    }
}
