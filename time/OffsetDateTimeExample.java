package time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeExample {
    public static void main(String[] args) {
        // 創建一個特定的日期和時間
        LocalDateTime localDateTime = LocalDateTime.of(2022, 3, 15, 12, 30);

        // 將 LocalDateTime 與時區偏移信息結合
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(-5));

        // 使用 withOffsetSameInstant 轉換為特定時區偏移的 OffsetDateTime
        OffsetDateTime offsetDateTimeNew = offsetDateTime.withOffsetSameInstant(ZoneOffset.ofHours(-8));
        System.out.println("OffsetDateTime with new offset: " + offsetDateTimeNew);

        // 使用 toInstant() 轉換為 Instant
        System.out.println("Instant: " + offsetDateTime.toInstant());

        // 使用 toLocalDate()、toLocalTime() 和 toLocalDateTime() 提取部分信息
        System.out.println("LocalDate: " + offsetDateTime.toLocalDate());
        System.out.println("LocalTime: " + offsetDateTime.toLocalTime());
        System.out.println("LocalDateTime: " + offsetDateTime.toLocalDateTime());
    }
}

