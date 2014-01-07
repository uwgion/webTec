package models;

import helpers.DateAndTimeHelpers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongojack.DBRef;
import org.mongojack.MongoCollection;

import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;

@MongoCollection(name = "routes")
public class Route extends Entity {

	@Required
	public String startAdresseForm;

	@Required
	public String zielAdresseForm;

	public List<String> wegpunkteForm;

	public DBRef<Marker, String> startAdresse;
	public DBRef<Marker, String> zielAdresse;

	public List<DBRef<Marker, String>> wegpunkte;
	public List<DBRef<Request, String>> requests;
	public Date dateCreated;
	@Required
	@Min(1)
	@Max(9)
	public int seats;

	@Required
	public String timeForm;

	@Required
	public String dateForm;


	public Date dateTime;
	
	public void setDateTime(String time, String date) throws ParseException {
		//no strict seperation of model and logic here
		//need to think about this
		dateTime = new DateAndTimeHelpers().parseDateAndTime(time, date);
	}



	public Route() {
		wegpunkte = new ArrayList<DBRef<Marker, String>>();
		wegpunkteForm = new ArrayList<String>();
		requests = new ArrayList<DBRef<Request, String>>();
		dateCreated = new Date();

	}
}
