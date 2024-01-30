package time;

import java.util.Calendar;

public class CalendarMain {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Calendar cal2017 = Calendar.getInstance();

        // 設定為 2017/2/28
        cal2017.set(2017, 1, 28);

        System.out.println(cal2017.before(cal));
        System.out.println(cal2017.after(cal));

    }
}
