package time;

import java.util.Date;

public class DateMain {
    public static void main(String[] args) {
        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date();
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
    }
}
