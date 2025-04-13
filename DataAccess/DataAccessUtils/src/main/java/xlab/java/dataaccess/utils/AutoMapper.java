package xlab.java.dataaccess.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CodeKing
 */
public class AutoMapper {
  private AutoMapper() {
  }

  public static <T> T getRow(final ResultSet resultSet, final Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException {
    T row = clazz.newInstance();
    final Field[] fields = clazz.getDeclaredFields();

    setRow(resultSet, clazz, row, fields);

    return row;
  }

  public static <T> List<T> getRows(final ResultSet resultSet,
                                    final Class<T> clazz) throws SQLException {
    final Field[] fields = clazz.getDeclaredFields();
    final List<T> rows = new ArrayList<>();

    while (resultSet.next()) {
      try {
        final T row = clazz.getConstructor().newInstance();
        setRow(resultSet, clazz, row, fields);

        rows.add(row);
      } catch (InstantiationException | IllegalAccessException |
               InvocationTargetException | NoSuchMethodException e) {
        throw new RuntimeException(e);
      }
    }

    return rows;
  }

  private static <T> void setRow(final ResultSet resultSet, final Class<T> clazz, final T row, final Field[] fields) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    final List<String> columns = Arrays.asList(getColumns(resultSet));

    for (Field field : fields) {
      final String name = field.getName();
      if (!columns.contains(name.toLowerCase())) {
        continue;
      }

      final Class<?> fieldType = field.getType();
      final String type = fieldType.getTypeName();
      Object value = getValue(resultSet, name, type);

      // 1、change field visibility.
      // field.setAccessible(true);
      // field.set(row, value);

      // 2、set field by accessor.
      setValue(clazz, row, name, fieldType, value);
    }
  }


  private static Object getValue(final ResultSet resultSet, final String name, final String type) throws SQLException {
    Object value = null;

    switch (type) {
      case "short":
        value = resultSet.getShort(name);
        break;
      case "byte":
        value = resultSet.getByte(name);
        break;
      case "int":
        value = resultSet.getInt(name);
        break;
      case "long":
        value = resultSet.getLong(name);
        break;
      case "float":
        value = resultSet.getFloat(name);
        break;
      case "double":
        value = resultSet.getDouble(name);
        break;
      case "boolean":
        value = resultSet.getBoolean(name);
        break;
      case "java.lang.String":
        value = resultSet.getString(name);
        break;
      case "char":
      default:
        break;
    }

    return value;
  }

  private static <T> void setValue(final Class<T> clazz, final T row, final String name, final Class<?> fieldType, final Object value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    clazz.getDeclaredMethod(buildSetterName(name), fieldType)
      .invoke(row, value);
  }

  private static String[] getColumns(final ResultSet resultSet) {
    try {
      final ResultSetMetaData metaData = resultSet.getMetaData();
      final String[] columns = new String[metaData.getColumnCount()];

      for (int i = 0; i < columns.length; i++) {
        columns[i] = metaData.getColumnLabel(i + 1).toLowerCase();
      }
      return columns;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static String buildSetterName(final String fieldName) {
    final char[] chars = fieldName.toCharArray();
    chars[0] = Character.toUpperCase(chars[0]);

    return "set" + String.valueOf(chars);
  }
}
