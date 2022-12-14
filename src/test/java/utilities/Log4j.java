package utilities;

import org.apache.log4j.Logger;

public class Log4j {

    private static org.apache.log4j.Logger Log = Logger.getLogger(Log4j.class.getName());

    public static void startLog (String testClassName){
        Log.info("Test is Starting...");
    }

    public static void endLog (String testClassName){
        Log.info("Test is Ending...");
    }


    public static void info (String message) {
        Log.info(message);
    }


    public static void warn (String message) {
        Log.warn(message);
    }


    public static void error (String message) {
        Log.error(message);
    }


    public static void fatal (String message) {
        Log.fatal(message);
    }


    public static void debug (String message) {
        Log.debug(message);
    }
}
