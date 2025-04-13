package xlab.java.logging.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CodeKing
 */
public class LogbackApp {

  private static final Logger LOGGER =
    LoggerFactory.getLogger(LogbackApp.class);

  public static void main(String[] args) {
    LOGGER.info("Hello Logback!");
    for (int i = 0; i < 200000; i++) {
      LOGGER.info("This is a log message. {}", i);
    }
  }
}
