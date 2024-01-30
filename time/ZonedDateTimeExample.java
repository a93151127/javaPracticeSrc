package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // 創建一個特定的日期和時間
        LocalDateTime localDateTime = LocalDateTime.of(2022, 3, 15, 12, 30);

        // 將 LocalDateTime 與時區信息結合
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));

        // 使用 atZone() 轉換為特定時區的 ZonedDateTime
        ZonedDateTime newYorkTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("New York Time: " + newYorkTime);

        // 使用 toInstant() 轉換為 Instant
        System.out.println("Instant: " + zonedDateTime.toInstant());

        // 使用 toLocalDate()、toLocalTime() 和 toLocalDateTime() 提取部分信息
        System.out.println("LocalDate: " + zonedDateTime.toLocalDate());
        System.out.println("LocalTime: " + zonedDateTime.toLocalTime());
        System.out.println("LocalDateTime: " + zonedDateTime.toLocalDateTime());
    }
}

