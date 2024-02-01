package log;

import java.util.logging.*;

public class LoggerFileHandlerExample {
    public static void main(String[] args) {
        // 創建 Logger 實例
        Logger logger = Logger.getLogger(LoggerFileHandlerExample.class.getName());

        // 移除預設的 ConsoleHandler
        Handler[] defaultHandlers = logger.getHandlers();
        for (Handler handler : defaultHandlers) {
            logger.removeHandler(handler);
        }

        try {
            // 創建 FileHandler 並設定檔案輸出路徑、級別、以及自定義 Formatter
            FileHandler fileHandler = new FileHandler("src\\log\\example.log");
            fileHandler.setLevel(Level.ALL);

            // 自訂 Formatter
            fileHandler.setFormatter(new SimpleFormatter());

            // 將 FileHandler 添加到 Logger
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 測試日誌消息
        logger.log(Level.ALL, "這是一條 CONFIG 級別的日誌消息");
        logger.info("這是一條 CONFIG 級別的日誌消息");
    }

    // 自訂 Formatter
    static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return "[" + record.getLevel() + "] " + record.getMessage() + "\n";
        }
    }
}

