package xlab.java.lang.cloneable;

import xlab.java.lang.entities.BaseEntity;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author CodeKing
 */
public class CloneableEntity extends BaseEntity implements Cloneable {
  public CloneableEntity(final byte byteField, final short shortField,
                         final int intField, final long longField,
                         final float floatField, final double doubleField,
                         final char charField, final boolean booleanField,
                         final String stringField, final DayOfWeek dayOfWeek,
                         final Collection<String> collection, final String[] array) {
    super(byteField, shortField, intField, longField, floatField, doubleField
      , charField, booleanField, stringField, dayOfWeek, collection, array);
  }



  @Override
  public CloneableEntity clone() {
    try {
      // 如果没有实现 Cloneable 接口，super.clone() 会导致
      // 抛出 CloneNotSupportedException 异常。
      return (CloneableEntity) super.clone();
    } catch (CloneNotSupportedException ignored) {

    }
    return null;
  }

  public CloneableEntity copy() {
    return new CloneableEntity(byteField, shortField, intField, longField,
      floatField, doubleField, charField, booleanField, stringField, dayOfWeek
      , collection, array);
  }

  @Override
  public String toString() {
    return "CloneableEntity{" +
      "dayOfWeek=" + dayOfWeek +
      ", collection=" + collection +
      ", array=" + Arrays.toString(array) +
      ", byteField=" + byteField +
      ", shortField=" + shortField +
      ", intField=" + intField +
      ", longField=" + longField +
      ", floatField=" + floatField +
      ", doubleField=" + doubleField +
      ", charField=" + charField +
      ", booleanField=" + booleanField +
      ", stringField='" + stringField + '\'' +
      '}';
  }
}
