package xlab.java.advanced.reflection;


/**
 * @author CodeKing
 */
public class ReflectionApp {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    printPrimitiveType();
  }

  private static void printPrimitiveType() {
    System.out.println(short.class.getTypeName());
    System.out.println(byte.class.getTypeName());
    System.out.println(char.class.getTypeName());
    System.out.println(int.class.getTypeName());
    System.out.println(long.class.getTypeName());
    System.out.println(float.class.getTypeName());
    System.out.println(double.class.getTypeName());
    System.out.println(boolean.class.getTypeName());
    System.out.println(String.class.getTypeName());
  }
}
