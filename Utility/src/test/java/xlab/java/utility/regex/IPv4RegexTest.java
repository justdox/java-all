package xlab.java.utility.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class IPv4RegexTest {

  @Test
  void isMatch() {
    System.out.println(IPv4Regex.REGEX_STRING);
    final Random random = new Random();
    for (int i = 0; i < 60; i++) {
      final int part1 = random.nextInt(300);
      final int part2 = random.nextInt(300);
      final int part3 = random.nextInt(300);
      final int part4 = random.nextInt(300);
      final String ipv4 = String.format("%d.%d.%d.%d", part1, part2, part3, part4);

      final boolean expected = part1 < 256
                            && part2 < 256
                            && part3 < 256
                            && part4 < 256;

      final boolean actual = IPv4Regex.isMatch(ipv4);
      System.out.printf("Is the string '%s' an valid version 4 IP? %b.%n",
        ipv4, actual);
      Assertions.assertEquals(expected, actual);
    }
  }
}
