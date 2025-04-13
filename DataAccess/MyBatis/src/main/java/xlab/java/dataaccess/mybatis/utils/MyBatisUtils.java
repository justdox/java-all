package xlab.java.dataaccess.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

/**
 * @author CodeKing
 */
public class MyBatisUtils {
  private static final String JDBC_PROPERTIES_FILE_NAME = "db.properties";

  private static final String MYBATIS_CONFIG_FILE_NAME = "mybatis-config.xml";

  private static final Properties JDBC_PROPERTIES = new Properties();

  private static final Reader MYBATIS_CONFIG_READER;

  private static final SqlSessionFactory SQL_SESSION_FACTORY;

  static {
    try {
      JDBC_PROPERTIES.load(Resources.getResourceAsStream(JDBC_PROPERTIES_FILE_NAME));
      JDBC_PROPERTIES.setProperty("username", decrypt(JDBC_PROPERTIES.getProperty("username")));
      JDBC_PROPERTIES.setProperty("password", decrypt(JDBC_PROPERTIES.getProperty("password")));

      MYBATIS_CONFIG_READER =
        new InputStreamReader(Resources.getResourceAsStream(MYBATIS_CONFIG_FILE_NAME));

      SQL_SESSION_FACTORY =
        new SqlSessionFactoryBuilder().build(MYBATIS_CONFIG_READER,JDBC_PROPERTIES);

    } catch (IOException e) {
      final String message = String.format("Can not found the config file. " +
        "%s%n", e.getMessage());
      throw new RuntimeException(message);
    }
  }

  private static String decrypt(final String input) {
    return input;
  }

  public static SqlSession createSqlSession() {
    return SQL_SESSION_FACTORY.openSession();
  }

  @SuppressWarnings("unchecked")
  public static <T> PageResult<T> toPageResult(List<List<?>> results) {
    final PageResult<T> result = new PageResult<>();
    result.setItems((List<T>) results.get(0));
    result.setTotal(Integer.parseInt(results.get(1).get(0).toString()));

    return result;
  }

  private MyBatisUtils() {
  }


}
