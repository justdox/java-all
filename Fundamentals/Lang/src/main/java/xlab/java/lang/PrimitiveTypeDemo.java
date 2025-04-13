package xlab.java.lang;

/**
 * @author CodeKing
 */
public class PrimitiveTypeDemo {
  byte byteValue;
  short shortValue;
  int intValue;
  long longValue;
  float floatValue;
  double doubleValue;
  /**
   * 默认值 '\u0000'（Character.MIN_VALUE），即空字符。
   */
  char charValue;
  /**
   * 默认值 false（Boolean.FALSE）。
   */
  boolean booleanValue;

  PrimitiveTypeDemo() {

  }

  public PrimitiveTypeDemo(final byte byteValue, final short shortValue,
                           final int intValue, final long longValue,
                           final float floatValue, final double doubleValue,
                           final char charValue, final boolean booleanValue) {
    this.byteValue = byteValue;
    this.shortValue = shortValue;
    this.intValue = intValue;
    this.longValue = longValue;
    this.floatValue = floatValue;
    this.doubleValue = doubleValue;

    this.charValue = charValue;
    this.booleanValue = booleanValue;
  }

  public static void main(String[] args) {
    final PrimitiveTypeDemo primitiveTypeDemo = new PrimitiveTypeDemo();
    System.out.println(primitiveTypeDemo);
    primitiveTypeDemo.testPrimitiveTypes();
  }

  private void testPrimitiveTypes() {
    System.out.printf("字节类型（有符号数）：%d%n", byteValue);
    System.out.printf("短整型（有符号数）：%d%n", shortValue);

    shortValue += 1;
    // 报错，因为 + - * / 运算结果默认会变成 int
    // shortValue = shortValue + shortValue;
    // shortValue = shortValue - shortValue;
    // shortValue = shortValue * shortValue;
    // shortValue = shortValue / shortValue;

    // += -= *= /= 运算结果能够保持原来的类型
    shortValue += shortValue;
    shortValue -= shortValue;
    shortValue *= shortValue;
    shortValue /= shortValue + 1;
    shortValue += 1;
    shortValue -= 1;
    shortValue *= 1;
    shortValue /= 1;

    final Byte byteWrapper = byteValue;
    final Short shortWrapper = shortValue;
    final Integer intWrapper = intValue;
    final Long longWrapper = longValue;
    final Float floatWrapper = floatValue;
    final Double doubleWrapper = doubleValue;

    System.out.printf("%b%n", byteWrapper.equals(byteValue));
    System.out.printf("%b%n", shortWrapper.equals(shortValue));
    System.out.printf("%b%n", intWrapper.equals(intValue));
    System.out.printf("%b%n", longWrapper.equals(longValue));
    System.out.printf("%b%n", floatWrapper.equals(floatValue));
    System.out.printf("%b%n", doubleWrapper.equals(doubleValue));

    testByte();
    testShort();
    testInteger();
    testLong();
    testFloat();
    testDouble();
    testCharacter();
    testBoolean();
  }

  private void testByte() {
    System.out.printf("Size of byte type is %d bytes.%n", Byte.SIZE);
  }

  private void testShort() {
    System.out.printf("Size of short type is %d bytes.%n", Short.SIZE);

  }

  private void testInteger() {
    System.out.printf("Size of int type is %d bytes.%n", Integer.SIZE);
  }

  private void testLong() {
    System.out.printf("Size of long type is %d bytes.%n", Long.SIZE);
  }

  private void testFloat() {
    System.out.printf("Size of float type is %d bytes.%n", Float.SIZE);
  }

  private void testDouble() {
    System.out.printf("Size of double type is %d bytes.%n", Double.SIZE);
  }

  private void testCharacter() {
    System.out.printf("Size of char type is %d bytes.%n", Character.SIZE);

    System.out.printf("char 默认值与 Character.MIN_VALUE 的值相同？%b%n",
      Character.compare(Character.MIN_VALUE, charValue));

    System.out.printf("char 的默认值与 Character.MIN_VALUE 相同？%b%n",
      (Character.MIN_VALUE == charValue));
  }

  private void testBoolean() {
    System.out.printf("boolean 的默认值与 Boolean.FALSE 的值相同？%b%n",
      Boolean.compare(Boolean.FALSE,
        booleanValue));

    System.out.printf("boolean 的默认值与 Boolean.FALSE 相同？%b%n",
      (Boolean.FALSE == booleanValue));
  }

  @Override
  public String toString() {
    return "PrimitiveTypeDemo{" + "byteValue=" + byteValue + ", shortValue=" + shortValue + ", intValue=" + intValue + ", longValue=" + longValue + ", floatValue=" + floatValue + ", doubleValue=" + doubleValue + ", charValue=" + charValue + ", booleanValue=" + booleanValue + '}';
  }
}
