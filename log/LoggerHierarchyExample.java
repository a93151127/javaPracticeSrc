package log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerHierarchyExample {
    public static void main(String[] args) {
        // 創建主 Logger
        Logger mainLogger = Logger.getLogger("com.example.MainLogger");
        mainLogger.setLevel(Level.INFO);

        // 創建 ConsoleHandler 並將其添加到主 Logger
        ConsoleHandler consoleHandler = new ConsoleHandler();
        mainLogger.addHandler(consoleHandler);

        // 移除主 Logger 的 ConsoleHandler
        mainLogger.setUseParentHandlers(false);

        // 創建子 Logger
        Logger subLogger = Logger.getLogger("com.example.MainLogger.SubLogger");
        subLogger.setLevel(Level.FINE);

        // 設定子 Logger 是否使用父級 Logger 的處理器
//        subLogger.setUseParentHandlers(true); // 默認為 true，即使用父級 Logger 的處理器
        // 設定子 Logger 不使用父級 Logger 的處理器
        subLogger.setUseParentHandlers(false);

        // 測試日誌消息
        mainLogger.info("這是主 Logger 的 INFO 級別訊息");
        subLogger.fine("這是子 Logger 的 FINE 級別訊息");
    }
}
