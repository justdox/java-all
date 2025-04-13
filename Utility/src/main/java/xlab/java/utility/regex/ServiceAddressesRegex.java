package xlab.java.utility.regex;

import java.util.regex.Pattern;

/**
 * @author CodeKing
 */
public class ServiceAddressesRegex {
  static final String DEFAULT_DELIMITER = ",";
  static final String PATTERN_IP_V4_AND_PORT = String.format("(%s:%s)",
    IPv4Regex.REGEX_STRING, NetworkPortRegex.REGEX_STRING);
  static final String PATTERN_IP_V4_AND_PORT_SEQUENCE_WITHOUT_ANCHOR =
    String.format("%1$s(%2$s%1$s)*", PATTERN_IP_V4_AND_PORT, DEFAULT_DELIMITER);
  static final String PATTERN_IP_V4_AND_PORT_SEQUENCE =
    String.format("^%s$", PATTERN_IP_V4_AND_PORT_SEQUENCE_WITHOUT_ANCHOR);
  public static final Pattern REGEX_IP_V4_AND_PORT_SEQUENCE =
    Pattern.compile(PATTERN_IP_V4_AND_PORT_SEQUENCE);
  public static final String REGEX_STRING = PATTERN_IP_V4_AND_PORT_SEQUENCE_WITHOUT_ANCHOR;

  private ServiceAddressesRegex() {
  }

  public static boolean isMatch(final String input) {
    return REGEX_IP_V4_AND_PORT_SEQUENCE.matcher(input).matches();
  }

  public static boolean isMatch(final String input, final String delimiter) {
    return Pattern.compile(PATTERN_IP_V4_AND_PORT_SEQUENCE.replaceAll(DEFAULT_DELIMITER, delimiter)).matcher(input).matches();
  }
}
