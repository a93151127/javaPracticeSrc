package log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerMain.class.getName());
        logger.log(Level.WARNING, "warning 訊息");
        logger.log(Level.INFO, "INFO 訊息");
        logger.log(Level.CONFIG, "CONFIG 訊息");
        logger.log(Level.FINE, "FINE 訊息");
    }
}
