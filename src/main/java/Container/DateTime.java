package Container;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

    public static java.util.Date stringToDate(String time) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = df.parse(time);
            return date;
        } catch (Exception e) {

        }
        return date;
    }
    public static Date trim(Date time)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime( time );
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

}
