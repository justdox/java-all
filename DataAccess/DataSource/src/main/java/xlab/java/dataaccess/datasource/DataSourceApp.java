package xlab.java.dataaccess.datasource;

import com.mysql.cj.jdbc.MysqlDataSource;
import xlab.java.dataaccess.pojo.City;
import xlab.java.dataaccess.utils.AutoMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author CodeKing
 */
public class DataSourceApp {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    System.out.println("Hello world!");

    Class.forName("com.mysql.cj.jdbc.Driver");

    MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setPort(3306);

    dataSource.setDatabaseName("world");

    dataSource.setUser("root");
    dataSource.setPassword("123456");

    dataSource.setUseSSL(true);
    dataSource.setAllowMultiQueries(true);
    dataSource.setCharacterEncoding("UTF-8");
    dataSource.setAutoReconnect(true);
    dataSource.setAutoReconnectForPools(true);

    try (final Connection connection = dataSource.getConnection();
         final Statement stmt = connection.createStatement()) {
      // 一次执行多条语句，Connection 属性必须设置 allowMultiQueries 为 true
      final String sql = "Select Count(*) as Total from city;"
        + "Select * from city;";
      final boolean success = stmt.execute(sql);

      if (success) {
        ResultSet resultSet = stmt.getResultSet();

        if (resultSet.next()) {
          final int total = resultSet.getInt(1);
          System.out.printf("The city record count is %d.%n", total);
        }

        if (stmt.getMoreResults()) {
          resultSet = stmt.getResultSet();

          List<City> cities = AutoMapper.getRows(resultSet, City.class);

          for (final City city : cities) {
            System.out.println(city);
          }
        }
      }
    }
  }
}
