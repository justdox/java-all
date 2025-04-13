package xlab.java.dataaccess.jdbc;

import xlab.java.dataaccess.jdbc.utils.JDBCUtils;
import xlab.java.dataaccess.pojo.City;
import xlab.java.dataaccess.utils.AutoMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CodeKing
 */
public class JDBCApp {
  public static void main(String[] args) {
    System.out.println("Hello JDBC!");

    final String sql = "Select * from city where id>? limit ?,?;"
      + "Select count(*) as total from city where id>?;";

    try (final Connection connection = JDBCUtils.createConnection();
         final PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setInt(1, 10);
      stmt.setInt(2, 0);
      stmt.setInt(3, 10);
      stmt.setInt(4, 10);

      final boolean success = stmt.execute();
      if (success) {
        ResultSet resultSet = stmt.getResultSet();
        List<City> cities = AutoMapper.getRows(resultSet, City.class);

        for (final City city : cities) {
          System.out.println(city);
        }

        if (stmt.getMoreResults()) {
          resultSet = stmt.getResultSet();
          if (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
          }
        }
      } else {

      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
