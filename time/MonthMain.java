package time;

import java.time.Month;

public class MonthMain {
    public static void main(String[] args) {
        for(Month month : Month.values()){
            System.out.println(month.ordinal());
            System.out.println(month.getValue());
            System.out.println(month);
            System.out.println("===============");
        }
    }
}
