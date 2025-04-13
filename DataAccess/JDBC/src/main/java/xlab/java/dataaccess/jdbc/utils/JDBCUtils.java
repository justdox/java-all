package xlab.java.dataaccess.jdbc.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author CodeKing
 */
public class JDBCUtils {
  private static final String JDBC_PROPERTIES_FILE_NAME = "db.properties";
  private static final String URL;
  private static final Properties JDBC_PROPERTIES = new Properties();

  private static String driver = null;

  static {
    try {
      JDBC_PROPERTIES.load(ClassLoader.getSystemResourceAsStream(JDBC_PROPERTIES_FILE_NAME));

      driver = JDBC_PROPERTIES.getProperty("driver");
      Class.forName(driver);

      decrypt();

      URL = buildURL();

    } catch (IOException e) {
      final String message = String.format("Can not found the jdbc config " +
        "file '%s'. %s%n", JDBC_PROPERTIES_FILE_NAME, e.getMessage());
      throw new RuntimeException(message);
    } catch (ClassNotFoundException e) {
      final String message = String.format("Can not found the specified " +
        "driver '%s'. %s", driver, e.getMessage());
      throw new RuntimeException(message);
    }
  }

  private static String buildURL() {
    return String.format("jdbc:%s://%s:%s/%s",
      JDBC_PROPERTIES.getProperty("engine"),
      JDBC_PROPERTIES.getProperty("server"),
      JDBC_PROPERTIES.getProperty("port"),
      JDBC_PROPERTIES.getProperty("database")
    );
  }

  private static void decrypt() {
    final String user = JDBC_PROPERTIES.getProperty("user");
    final String password = JDBC_PROPERTIES.getProperty("password");

    JDBC_PROPERTIES.setProperty("user", decrypt(user));
    JDBC_PROPERTIES.setProperty("password", decrypt(password));
  }

  private static String decrypt(final String input) {
    final String decrypted = input;

    return decrypted;
  }


  public static Connection createConnection() throws SQLException {
    return DriverManager.getConnection(URL, JDBC_PROPERTIES);
  }

  private JDBCUtils() {
  }
}
