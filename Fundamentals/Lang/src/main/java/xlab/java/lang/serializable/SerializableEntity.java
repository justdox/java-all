package xlab.java.lang.serializable;

import xlab.java.lang.entities.BaseEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author CodeKing
 */
public class SerializableEntity extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 4158637929946489203L;

  private String directField;

  private transient String transientField;

  public SerializableEntity(final byte byteField,
                            final short shortField,
                            final int intField, final long longField,
                            final float floatField, final double doubleField,
                            final char charField, final boolean booleanField,
                            final String stringField, final DayOfWeek dayOfWeek,
                            final Collection<String> collection,
                            final String[] array, final String directField,
                            final String transientField) {
    super(byteField, shortField, intField, longField, floatField, doubleField
      , charField, booleanField, stringField, dayOfWeek, collection, array);

    this.directField = directField;
    this.transientField = transientField;
  }

  public String getDirectField() {
    return directField;
  }

  public void setDirectField(final String directField) {
    this.directField = directField;
  }

  public String getTransientField() {
    return transientField;
  }

  public void setTransientField(final String transientField) {
    this.transientField = transientField;
  }

  @Override
  public String toString() {
    return "SerializableEntity{" +
      "directField='" + directField + '\'' +
      ", transientField='" + transientField + '\'' +
      ", byteField=" + byteField +
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

  private void writeObject(final ObjectOutputStream out) throws IOException {
    // 只能序列化实现 Serializable 接口的类或接口的字段
    // out.defaultWriteObject();

    // writeXXX 可以自由序列化
    out.writeByte(byteField);
    out.writeShort(shortField);
    out.writeInt(intField);
    out.writeLong(longField);
    out.writeFloat(floatField);
    out.writeDouble(doubleField);
    out.writeChar(charField);
    out.writeBoolean(booleanField);
    out.writeUTF(stringField);
    out.writeInt(dayOfWeek.getValue());
    out.writeObject(collection);
    out.writeObject(array);

    // PutField 不能序列化继承的字段。
    /* final ObjectOutputStream.PutField fields = out.putFields();
    fields.put("byteField", byteField);
    fields.put("shortField", shortField);
    fields.put("intField", intField);
    fields.put("longField", longField);
    fields.put("floatField", floatField);
    fields.put("doubleField", doubleField);
    fields.put("dayOfWeek", dayOfWeek.getValue());
    fields.put("collection", collection);
    fields.put("array", array); */
  }

  private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
    // in.defaultReadObject();

    byteField = in.readByte();
    shortField = in.readShort();
    intField = in.readInt();
    longField = in.readLong();
    floatField = in.readFloat();
    doubleField = in.readDouble();
    charField = in.readChar();
    booleanField = in.readBoolean();
    stringField = in.readUTF();
    dayOfWeek = DayOfWeek.of(in.readInt());
    collection = (Collection<String>) in.readObject();
    array = (String[]) in.readObject();

    // final ObjectInputStream.GetField fields = in.readFields();
  }
}
