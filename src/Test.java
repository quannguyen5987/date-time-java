import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String date1="2021/10/22 10:10:09";
        String date2="2021/10/23 10:10:08";
       Date start = strToDate(date1);

        Date stop = strToDate(date2);
//        final  String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
//        SimpleDateFormat dateFormat=new SimpleDateFormat(DATETIME_FORMAT);
//        String dateText1 =dateFormat.format(date);
//
//        System.out.println(dateText1);
//
//        Date start = new Date();
//
//        Date stop = new Date();
        Integer a = Math.toIntExact((stop.getTime() - start.getTime()) / (60 * 60 * 24 * 1000));
        System.out.println(a);
        System.out.println((stop.getTime() - start.getTime()) / (60 * 60 * 24 * 1000));
    }
    public static java.util.Date strToDate(String strDate) {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            return sdf.parse(strDate);
        } catch (ParseException p) {
            return null;
        }
    }
}
