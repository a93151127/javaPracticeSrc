package time;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // 獲取當前的日期和時間
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 輸出當前的日期和時間
        System.out.println("Current LocalDateTime: " + currentDateTime);

        // 創建特定的日期和時間
        LocalDateTime specificDateTime = LocalDateTime.of(2022, 3, 15, 12, 30);

        // 輸出特定的日期和時間
        System.out.println("Specific LocalDateTime: " + specificDateTime);

        // 提取日期和時間的各個部分
        System.out.println("Year: " + currentDateTime.getYear());
        System.out.println("Month: " + currentDateTime.getMonth());
        System.out.println("Day: " + currentDateTime.getDayOfMonth());
        System.out.println("Hour: " + currentDateTime.getHour());
        System.out.println("Minute: " + currentDateTime.getMinute());
        System.out.println("Second: " + currentDateTime.getSecond());
    }
}
