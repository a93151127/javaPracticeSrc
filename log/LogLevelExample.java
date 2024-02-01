package log;

import java.util.logging.Level;

public class LogLevelExample {
    public static void main(String[] args) {
        // 創建 Level 實例
        Level infoLevel = Level.INFO;
        Level warningLevel = Level.WARNING;

        // 使用 intValue() 方法獲取 Level 的整數值
        int infoLevelValue = infoLevel.intValue();
        int warningLevelValue = warningLevel.intValue();

        // 印出整數值
        System.out.println("INFO 級別的整數值: " + infoLevelValue);
        System.out.println("WARNING 級別的整數值: " + warningLevelValue);
    }
}

