package time;

import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        // 獲取當前的日期
        LocalDate currentDate = LocalDate.now();

        // 輸出當前的日期
        System.out.println("Current LocalDate: " + currentDate);

        // 創建特定的日期
        LocalDate specificDate = LocalDate.of(2022, 3, 15);

        // 輸出特定的日期
        System.out.println("Specific LocalDate: " + specificDate);

        // 提取日期的各個部分
        System.out.println("Year: " + currentDate.getYear());
        System.out.println("Month: " + currentDate.getMonth());
        System.out.println("Day: " + currentDate.getDayOfMonth());
    }
}

