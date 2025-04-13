package xlab.java.lang.numeric;

import java.util.Scanner;

/**
 * @author CodeKing
 */
public class IntegerDemo {
  public static void main(String[] args) {
    testStaticMethods();
    testInstanceMethods();
  }

  private static void testStaticMethods() {
    System.out.printf("整型的大小（位数）：%d。%n", Integer.SIZE);

    final int number = 1000;
    testBinaryMethods(number);
    System.out.println();
    testBinaryMethods(-number);
    testDecode();
  }

  private static void testBinaryMethods(final int number) {
    System.out.printf("整数 %d 的二进制字符串（Integer.toBinaryString）：%s。%n",
      number, Integer.toBinaryString(number));
    System.out.printf("整数 %d 的二进制补码的位数（Integer.bitCount）：%d。%n", number,
      Integer.bitCount(number));
    System.out.printf("整数 %d 的二进制表示法的前导零个数：%d。%n",
      number, Integer.numberOfLeadingZeros(number));
    System.out.printf("整数 %d 的二进制表示法的末尾零个数：%d。%n",
      number, Integer.numberOfTrailingZeros(number));
    Integer.parseInt("0011", 2);
  }

  private static void testDecode() {
    System.out.println("Please enter a number string(may contains radix prefix" +
      "):");
    try (final Scanner scanner = new Scanner(System.in)) {
      final String number = scanner.nextLine().trim();
      System.out.printf("The number string %s equals to the integer %d.%n",
        number,
        Integer.decode(number));
    }
  }

  private static void testInstanceMethods() {

  }
}
