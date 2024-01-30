package time;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneMain {
    public static void main(String[] args) {
        String[] zones = TimeZone.getAvailableIDs();
        System.out.println(zones[0]);
        TimeZone z = TimeZone.getTimeZone("Europe/Copenhagen");
        Calendar cal = Calendar.getInstance(z);
        System.out.println(cal.getTime());
//        Arrays.stream(zones)
//                .map(id -> TimeZone.getTimeZone(id))
//                .map(timezone -> Calendar.getInstance(timezone))
//                .forEach(cal -> System.out.println(cal.getTime()));
    }
}
