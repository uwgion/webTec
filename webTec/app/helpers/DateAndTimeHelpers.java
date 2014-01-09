package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import play.Logger;
import models.Route;
import db.RouteDB;

public class DateAndTimeHelpers {

	/**
	 * Method to parse a time, submitted as string.
	 * @param time The Time to be parsed.
	 * @return The parsed time as Date object.
	 * @throws ParseException Exception to be thrown if the format is not valid.
	 */
	public Date parseTime(String time) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        df.setLenient(false);
        GregorianCalendar temp = new GregorianCalendar();
        temp.setTime(df.parse(time));
        return temp.getTime();
	}

	/**
	 * Method to validate a date inclusive a time. Tests if a date is in the past.
	 * @param route The route which date needs to be validated.
	 * @throws ParseException Exception to be thrown in case a date is in the past.
	 */
	public void validateDateAndTime(Route route)throws ParseException{
		
		Date tempDateNow = new Date();

		if(route.dateForm.before(tempDateNow)){
			throw new ParseException("Date in past.", 1);
		}

	}
	
	/**
	 * Method to update the date and time of a given route.
	 * Verifies, that the input time is valid and different from the existing time.
	 * @param date The submitted date as string.
	 * @param time The submitted time as string. 
	 * @param routes A RouteDB instance.
	 * @param tempRoute The route to update.
	 * @throws ParseException Exception to be thrown in case a date or time is not valid.
	 */
	public void updateTimeAndDate(RouteDB routes, Route tempRoute, String date, String time) throws ParseException {
		Date tempTime = parseTime(time);

		Date tempDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Logger.info(tempDate.toGMTString());
		Logger.info(tempTime.toGMTString());
		if(tempDate.compareTo(tempRoute.dateForm) != 0){
			tempRoute.dateForm=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Logger.info("date!");

			routes.save(tempRoute);
		}
		if(tempTime.compareTo(tempRoute.time) != 0){
			tempRoute.setTimeAndValidate(time);
			tempRoute.timeForm=time;
			Logger.info("dasdasd");
			routes.save(tempRoute);
		}
	}
}