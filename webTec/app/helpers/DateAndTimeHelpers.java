package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import play.Logger;
import models.Route;

public class DateAndTimeHelpers {

	public Date parseDateAndTime(String time) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        df.setLenient(false);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        GregorianCalendar temp = new GregorianCalendar();

        temp.setTime(df.parse(time));
        Logger.info(df.parse(time).toGMTString());
        return temp.getTime();
	}


	public void validateDateAndTime(Route route)throws ParseException{
		
		Date tempDateNow = new Date();

		if(route.dateForm.before(tempDateNow)){
			throw new ParseException("Date in past.", 1);
		}

	}
}