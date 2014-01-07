package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAndTimeHelpers {

	public Date parseDateAndTime(String time, String date) throws ParseException{
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
        
        return temp.getTime();
	}
}
