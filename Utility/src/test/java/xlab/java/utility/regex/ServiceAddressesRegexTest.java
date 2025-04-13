package xlab.java.utility.regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

class ServiceAddressesRegexTest {

  @Test
  void isMatch() {
    System.out.println(ServiceAddressesRegex.REGEX_IP_V4_AND_PORT_SEQUENCE);
    final Random random = new Random();
    for (int i = 0; i < 60; i++) {
      final ArrayList<String> list = new ArrayList<>();
      boolean expected = true;
      for (int j = 0; j < 3; j++) {
        final int part1 = random.nextInt(300);
        final int part2 = random.nextInt(300);
        final int part3 = random.nextInt(300);
        final int part4 = random.nextInt(300);
        final int port = random.nextInt(99999);
        final String ipv4AndPort = String.format("%d.%d.%d.%d:%d", part1, part2,
          part3, part4, port);
        list.add(ipv4AndPort);

        final boolean matched = part1 < 256
          && part2 < 256
          && part3 < 256
          && part4 < 256
          && port < 65536;

        if (!matched) {
          expected = false;
        }
      }

      final String ipv4AndPortSequence = String.join(",", list);
      final boolean actual = ServiceAddressesRegex.isMatch(ipv4AndPortSequence);
      System.out.printf("Is the string '%s' an valid IP v4 and port sequence?" +
        " %b.%n", ipv4AndPortSequence, actual);
      Assertions.assertEquals(expected, actual);
    }
  }

  @Test
  void test2() {
    final String[] addresses = new String[]{
      "6.175.97.175:94215,107.55.165.4:69467,104.75.283.69:56481",
      "31.49.174.18:27238,32.137.194.181:23874,179.82.203.93:20695",
      "130.185.34.129:17745,102.93.101.34:58567,53.88.176.190:15405",
      "50.121.192.65:47438,23.244.217.18:8941,88.78.134.58:17467",
      "44.201.116.279:48474,266.209.33.136:51901,221.124.42.101:23429",
    };
    for (final String address : addresses) {
      final boolean result = ServiceAddressesRegex.isMatch(address);
      System.out.printf("Is the string '%s' an valid service address? %b.%n",
        address, result);
    }
  }

  @Test
  void test3() {
    final int[] nums = {1, 2, 3};
    System.out.println(nums);
  }
}
