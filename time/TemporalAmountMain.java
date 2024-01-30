package time;

import java.time.LocalDate;
import java.time.Period;

import static java.time.Period.*;
import static java.time.format.DateTimeFormatter.ofPattern;

public class TemporalAmountMain {
    public static void main(String[] args) {
        LocalDate birth = LocalDate.parse("1986-02-17");
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth, now);
        System.out.println("你活了幾年 : " + period.getYears());
        System.out.println("你活了幾月 : " + period.getMonths());
        System.out.println("你活了幾天 : " + period.getDays());

    }
}
