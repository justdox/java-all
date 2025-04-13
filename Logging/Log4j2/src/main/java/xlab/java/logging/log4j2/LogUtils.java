package xlab.java.logging.log4j2;

import org.apache.logging.log4j.LogManager;
// import sun.reflect.Reflection;

/**
 * @author CodeKing
 */
public class LogUtils {
  public static void info(Object message) {
    final Class<?> callerClass = getCallerClass();
    LogManager.getLogger(callerClass).info(message);
  }

  public static void info(String message, Object... params) {
    final Class<?> callerClass = getCallerClass();
    LogManager.getLogger(callerClass).info(message, params);
  }

  private static Class<?> getCallerClass() {
    //noinspection removal
    // java 8
    // return Reflection.getCallerClass(3);
    return StackWalker.getInstance().getCallerClass();
  }

  private LogUtils() {
  }
}
