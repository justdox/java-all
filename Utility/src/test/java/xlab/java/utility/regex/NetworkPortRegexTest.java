package xlab.java.utility.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class NetworkPortRegexTest {

  @Test
  void isMatch() {
    System.out.println(NetworkPortRegex.REGEX_STRING);

    final Random random = new Random();
    for (int i = 0; i < 10; i++) {
      final int input = random.nextInt(99999);
      final boolean expected = input > 0 && input < 65536;
      final boolean actual = NetworkPortRegex.isMatch(String.valueOf(input));
      System.out.printf("Is the number '%d' an valid network port? %b.%n",
        input,
        actual);
      Assertions.assertEquals(expected, actual);
    }
  }
}
