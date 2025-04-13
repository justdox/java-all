package xlab.java.utility.regex;

import java.util.regex.Pattern;

/**
 * @author CodeKing
 */
public class IPv4Regex {
  static final String PATTERN_IP_V4_PART = "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
  static final String PATTERN_IP_V4_WITHOUT_ANCHOR = String.format(
    "(%1$s\\.){3}%1$s", PATTERN_IP_V4_PART);
  static final String PATTERN_IP_V4 = String.format("^%s$",
    PATTERN_IP_V4_WITHOUT_ANCHOR);
  public static final Pattern REGEX_IP_V4 = Pattern.compile(PATTERN_IP_V4);
  public static final String REGEX_STRING = PATTERN_IP_V4_WITHOUT_ANCHOR;

  private IPv4Regex() {
  }

  public static boolean isMatch(final String input) {
    return REGEX_IP_V4.matcher(input).matches();
  }
}
