import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;


public class Main {

    public final static String DEFAULT_TIMEZONE = "Asia/Tokyo";
    public final static String DATE_FORMAT = "yyyy/MM/dd";
    public final static String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public final static String DATETIME_NOSECONDS_FORMAT = "yyyy/MM/dd HH:mm";
    public final static String DATETIMEMILL_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";
    public final static String DATE_FORMAT_YEAR = "yyyy";
    public final static String DATE_FORMAT_MONTH = "yyyy/MM";
    public final static String DATE_FORMAT_MONTHDAY = "MM/dd";
    public final static String DATETIME_ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public final static String DATETIME_EXPANSION_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

    public final static String TIME_SECONDS = ":00";
    public final static String HYPHEN_DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args){
        Date date =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat(DATETIME_FORMAT);
        String dateText =dateFormat.format(date);
        System.out.println(date);
        System.out.println(dateText);
        System.out.println(strToDate(dateText));
        System.out.println(dateTimeFormatz(date,"Asia/Tokyo"));
        System.out.println(toSystemDefaultZoneTime("Asia/Tokyo",date));






    }
    public static String dateFormatz(Date date, String timeZone) {
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }
    public static String dateTimeFormatz(Date date, String timeZone) {
        TimeZone tz = TimeZone.getTimeZone(
            (timeZone == null || timeZone.equals("")) ? DEFAULT_TIMEZONE : timeZone);
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }

    public static java.util.Date strToDate(String strDate) {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        try {
            return sdf.parse(strDate);
        } catch (ParseException p) {
            return null;
        }
    }

    public static java.util.Date toSystemDefaultZoneTime(String originalTimeZone, java.util.Date date) {
        if (originalTimeZone == null || originalTimeZone.equals("")) {
            return date;
        }
        //TimeZoneを除去
        try {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            //元のTimeZoneを付加
            ZonedDateTime originalDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(originalTimeZone));
            //システムデフォルトタイムゾーンによる日時の再作成
            Date date2 = Date.from(originalDateTime.toInstant());
            return date2;
        }
        catch (java.time.DateTimeException e) {
            e.printStackTrace();
            return date;
        }
    }

}
