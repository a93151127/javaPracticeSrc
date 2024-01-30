package time;

import java.time.Instant;
import java.time.LocalDateTime;

public class EpochMain {
    public static void main(String[] args) {
        // 使用Instant.now()獲取當前時間點
        Instant currentInstant = Instant.now();

        // 輸出當前時間點的Instant物件
        System.out.println("Current Instant: " + currentInstant);

        // 使用Instant的其他方法取得更多信息
        System.out.println("Epoch Second: " + currentInstant.getEpochSecond());
        System.out.println("Nano of Second: " + currentInstant.getNano());

        System.out.println("=========================");
        // 指定一個毫秒數
        long millis = 1612060800000L; // 2021-02-01 00:00:00 UTC

        // 使用Instant.ofEpochMilli創建Instant物件
        Instant instant = Instant.ofEpochMilli(millis);

        // 輸出Instant物件
        System.out.println("Instant: " + instant);

        // 使用Instant的其他方法取得更多信息
        System.out.println("Epoch Second: " + instant.getEpochSecond());
        System.out.println("Nano of Second: " + instant.getNano());
    }
}
