package time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.MinguoDate;

public class ChronologyMain {
    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(1986,2,17);

        // 這是中華民國年曆
        MinguoDate minguoDate = MinguoDate.from(birth);
        System.out.println(minguoDate);
        // 顯示到時間
        System.out.println(minguoDate.atTime(LocalTime.of(3,30,0)));

    }
}
