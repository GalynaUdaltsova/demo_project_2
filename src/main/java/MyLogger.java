import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

class MyLogger {
    private static final Logger logger = LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.trace("Log text1");
        logger.debug("Log text2");
        logger.info("Log text3");
        logger.warn("Log text4");
        logger.error("Log text5");
        logger.fatal("Log text6");

    }
}

