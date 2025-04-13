package xlab.java.lang.numeric;

/**
 * @author CodeKing
 */
public class DoubleDemo {
  public static void main(String[] args) {
    testStaticMethods();
    testInstanceMethods();
  }

  private static void testInstanceMethods() {
    final Double doubleValue = 123D;
    System.out.println(doubleValue);
  }

  private static void testStaticMethods() {
    System.out.printf("双精度类型的大小（位数）为：%d。%n", Double.SIZE);
  }
}
