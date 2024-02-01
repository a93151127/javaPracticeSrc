package log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerHandlerExample {
    public static void main(String[] args) {
        // 創建 Logger 實例
        Logger logger = Logger.getLogger(LoggerHandlerExample.class.getName());

        // 創建 ConsoleHandler 並將其添加到 Logger
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        // 設置 Logger 的日誌級別
        logger.setLevel(Level.INFO);

        // 創建另一個 ConsoleHandler 並將其添加到 Logger
        ConsoleHandler anotherConsoleHandler = new ConsoleHandler();
        logger.addHandler(anotherConsoleHandler);

        // 獲取 Logger 目前已經添加的所有 Handler
        Handler[] handlers = logger.getHandlers();

        // 印出每個 Handler 的類型
        System.out.println("Logger 目前已經添加的 Handler:");
        for (Handler handler : handlers) {
            System.out.println("Handler 類型: " + handler.getClass().getName());
        }
    }
}

