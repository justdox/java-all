package xlab.java.lang.entities;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * @author CodeKing
 */
public class BaseEntity {
  protected byte byteField;
  protected short shortField;
  protected int intField;
  protected long longField;
  protected float floatField;
  protected double doubleField;
  /**
   * 默认值为 0，\u0000
   */
  protected char charField;
  protected boolean booleanField;
  protected String stringField;
  protected DayOfWeek dayOfWeek;
  protected Collection<String> collection;
  protected String[] array;

  public BaseEntity() {
  }

  public BaseEntity(final byte byteField, final short shortField,
                    final int intField, final long longField,
                    final float floatField, final double doubleField,
                    final char charField, final boolean booleanField,
                    final String stringField, final DayOfWeek dayOfWeek,
                    final Collection<String> collection, final String[] array) {
    this.byteField = byteField;
    this.shortField = shortField;
    this.intField = intField;
    this.longField = longField;
    this.floatField = floatField;
    this.doubleField = doubleField;
    this.charField = charField;
    this.booleanField = booleanField;
    this.stringField = stringField;
    this.dayOfWeek = dayOfWeek;
    this.collection = collection;
    this.array = array;
  }

  public byte getByteField() {
    return byteField;
  }

  public void setByteField(final byte byteField) {
    this.byteField = byteField;
  }

  public short getShortField() {
    return shortField;
  }

  public void setShortField(final short shortField) {
    this.shortField = shortField;
  }

  public int getIntField() {
    return intField;
  }

  public void setIntField(final int intField) {
    this.intField = intField;
  }

  public long getLongField() {
    return longField;
  }

  public void setLongField(final long longField) {
    this.longField = longField;
  }

  public float getFloatField() {
    return floatField;
  }

  public void setFloatField(final float floatField) {
    this.floatField = floatField;
  }

  public double getDoubleField() {
    return doubleField;
  }

  public void setDoubleField(final double doubleField) {
    this.doubleField = doubleField;
  }

  public char getCharField() {
    return charField;
  }

  public void setCharField(final char charField) {
    this.charField = charField;
  }

  public boolean isBooleanField() {
    return booleanField;
  }

  public void setBooleanField(final boolean booleanField) {
    this.booleanField = booleanField;
  }

  public String getStringField() {
    return stringField;
  }

  public void setStringField(final String stringField) {
    this.stringField = stringField;
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(final DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public Collection<String> getCollection() {
    return collection;
  }

  public void setCollection(final Collection<String> collection) {
    this.collection = collection;
  }

  public String[] getArray() {
    return array;
  }

  public void setArray(final String[] array) {
    this.array = array;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
      "byteField=" + byteField +
      ", shortField=" + shortField +
      ", intField=" + intField +
      ", longField=" + longField +
      ", floatField=" + floatField +
      ", doubleField=" + doubleField +
      ", charField=" + charField +
      ", booleanField=" + booleanField +
      ", stringField='" + stringField + '\'' +
      ", dayOfWeek=" + dayOfWeek +
      ", collection=" + collection +
      ", array=" + Arrays.toString(array) +
      '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final BaseEntity that = (BaseEntity) o;
    return byteField == that.byteField && shortField == that.shortField && intField == that.intField && longField == that.longField && Float.compare(that.floatField, floatField) == 0 && Double.compare(that.doubleField, doubleField) == 0 && charField == that.charField && booleanField == that.booleanField && stringField.equals(that.stringField) && dayOfWeek == that.dayOfWeek && collection.equals(that.collection) && Arrays.equals(array, that.array);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(byteField, shortField, intField, longField, floatField, doubleField, charField, booleanField, stringField, dayOfWeek, collection);
    result = 31 * result + Arrays.hashCode(array);
    return result;
  }
}
