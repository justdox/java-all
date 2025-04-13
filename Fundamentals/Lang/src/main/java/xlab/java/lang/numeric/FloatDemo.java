package xlab.java.lang.numeric;

/**
 * @author CodeKing
 */
public class FloatDemo {
  public static void main(String[] args) {
    testStaticMethods();
    testInstanceMethods();
  }

  private static void testInstanceMethods() {
    final Float floatValue = 123F;
    System.out.println(floatValue);
  }

  private static void testStaticMethods() {
    System.out.printf("单精度浮点型的大小（位数）为：%d。%n", Float.SIZE);
  }
}
