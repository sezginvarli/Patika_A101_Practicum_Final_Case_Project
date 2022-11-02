package Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log {
    private static Logger logger = LogManager.getLogger(Log.class.getName());
    @Test
    public void test(){
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warning Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }
}
