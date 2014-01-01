package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

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
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		df.setLenient(false);
		
		GregorianCalendar temp = new GregorianCalendar();
		GregorianCalendar tempNow = new GregorianCalendar();

		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		temp.setTime(df.parse(date + " " + time));

		//set new today date plus one hour for GMT+1 // UTC+1
		tempNow.setTimeInMillis(System.currentTimeMillis()+3600000);
		tempNow.setTimeZone(TimeZone.getTimeZone("GMT"));
		tempNow.setTime(tempNow.getTime());

		if(temp.getTime().before(tempNow.getTime())){
			throw new ParseException("Date in past.", 0);
		}
		dateTime = temp.getTime();
	}

	public Route() {
		wegpunkte = new ArrayList<>();
		wegpunkteForm = new ArrayList<>();
		requests = new ArrayList<>();
		dateCreated = new Date();

	}
}
