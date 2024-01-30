package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.text.DateFormat.*;


public class DateFormatMain {
    public static void main(String[] args) throws ParseException {
        String dateStr = "20240129";
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        System.out.println(format.parse(dateStr));
    }
}
