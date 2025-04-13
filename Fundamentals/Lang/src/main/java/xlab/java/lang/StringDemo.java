package xlab.java.lang;

/**
 * @author CodeKing
 */
public class StringDemo {
  public static void main(String[] args) {
    final String s1 = "String literal";
    final String s2 = "String literal";

    System.out.printf("s1 equals s2? %b.%n", s1.equals(s2));
    System.out.printf("s1 == s2? %b.%n", s1 == s2);

    // final String str = "abc一二三";
    final String str = "a𝄞";
    System.out.printf("The length of string '%s' is %d.%n",str, str.length());
  }

  private static void split(final String input, final String token) {
    if (input == null) {
      final String message = "The supplied argument 'input' is null.";
      throw new NullPointerException(message);
    }

    if (token == null) {
      final String message = "The supplied argument 'token' is null.";
      throw new NullPointerException(message);
    }

    String[] segments = input.split(token);

    System.out.printf("Result in %d segments.%n", segments.length);

    int index = 1;
    for (String segment : segments) {
      System.out.printf("The segment %d is '%s', length is %d.%n", index++,
        segment, segment.length());
    }
  }
}
