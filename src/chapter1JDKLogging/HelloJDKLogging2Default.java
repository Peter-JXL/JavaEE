package chapter1JDKLogging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloJDKLogging2Default {

  private static Logger logger = Logger.getLogger("com.peterjxl.logging");

  public static void main(String[] args) {
    logger.info("start process.....");   
    logger.warning("waring! memorey is running out");
    logger.fine("new program is runing well... please ignored");
    logger.severe("process will be terminated....");
  }
}