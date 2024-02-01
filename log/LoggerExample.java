package log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {
    public static void main(String[] args) {
        // 創建一個 Logger 實例
        Logger logger = Logger.getLogger(LoggerExample.class.getName());

        // 創建 ConsoleHandler 來輸出日誌消息到控制台
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        // 設置 Logger 的日誌級別
        logger.setLevel(Level.WARNING);

        // 獲取 Logger 的日誌級別
        Level loggerLevel = logger.getLevel();
        System.out.println("Logger 的日誌級別: " + loggerLevel);

        // 獲取 Logger 的父級 Logger 的日誌級別
        Level parentLoggerLevel = logger.getParent().getLevel();
        System.out.println("Logger 的父級 Logger 的日誌級別: " + parentLoggerLevel);
    }
}

