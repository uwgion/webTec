package models;

import helpers.DateAndTimeHelpers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.mongojack.DBRef;
import org.mongojack.MongoCollection;

import play.data.format.Formats;
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
	@Formats.DateTime(pattern="HH:mm")
//	@Pattern("HH:mm")
	public String timeForm;

	@Required
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date dateForm;


	public Date time;
	
	public void setTimeAndValidate(String time) throws ParseException {
		//no strict seperation of model and logic here
		//need to think about this
		this.time = new DateAndTimeHelpers().parseTime(time);
		GregorianCalendar tempCalTime = new GregorianCalendar();
		tempCalTime.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
		tempCalTime.setTime(this.time);
		
		GregorianCalendar tempCal = new GregorianCalendar();
		tempCal.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
		tempCal.setTime(dateForm);

		tempCal.set(Calendar.HOUR_OF_DAY,tempCalTime.get(Calendar.HOUR_OF_DAY));
		tempCal.set(Calendar.MINUTE,tempCalTime.get(Calendar.MINUTE));
//		tempCal.add(Calendar.DATE,1);
		
		this.dateForm=tempCal.getTime();
	}



	public Route() {
		wegpunkte = new ArrayList<DBRef<Marker, String>>();
		wegpunkteForm = new ArrayList<String>();
		requests = new ArrayList<DBRef<Request, String>>();
		dateCreated = new Date();

	}
}
