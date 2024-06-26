package app.netlify.bugbank.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    public static void log_INFO(String msg) {
        logger.log(Level.INFO, msg);
    }
}