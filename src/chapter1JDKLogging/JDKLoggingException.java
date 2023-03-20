package chapter1JDKLogging;
import java.util.logging.Logger;
public class JDKLoggingException {
  public static void main(String[] args) {
    Logger logger = Logger.getGlobal();

    try {
      int n = 1 / 0;
    } catch (Exception e) {
      // TODO: handle exception
      logger.severe(e.toString());
    }
  }
}
