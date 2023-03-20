package chapter1JDKLogging;

import java.util.logging.Logger;

public class HelloJDKLogging {
  public static void main(String[] args) {
    Logger logger = Logger.getGlobal();
    logger.info("start process.....");    
    logger.warning("waring! memorey is running out");
    logger.fine("new program is runing well... please ignored");
    logger.severe("process will be terminated....");
  }
}
