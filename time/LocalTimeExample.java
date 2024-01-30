package time;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        // 獲取當前的時間
        LocalTime currentTime = LocalTime.now();

        // 輸出當前的時間
        System.out.println("Current LocalTime: " + currentTime);

        // 創建特定的時間
        LocalTime specificTime = LocalTime.of(12, 30, 45);

        // 輸出特定的時間
        System.out.println("Specific LocalTime: " + specificTime);

        // 提取時間的各個部分
        System.out.println("Hour: " + currentTime.getHour());
        System.out.println("Minute: " + currentTime.getMinute());
        System.out.println("Second: " + currentTime.getSecond());
    }
}

