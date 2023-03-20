package chapter1Log4j;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HelloLog4j {

    private static final Logger logger = LogManager.getLogger(HelloLog4j.class);
    public static void main(String[] args) {
      logger.error("error");
      logger.warn("warn");
      logger.info("Info");
      logger.debug("debug");
    }
}
