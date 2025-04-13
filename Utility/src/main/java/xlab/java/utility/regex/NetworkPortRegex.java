package xlab.java.utility.regex;

import java.util.regex.Pattern;

/**
 * @author CodeKing
 */
public class NetworkPortRegex {
  static final String PATTERN_1_TO_9 = "[1-9]";
  static final String PATTERN_10_TO_9999 = "[1-9]\\d{1,3}";
  static final String PATTERN_10000_TO_59999 = "[1-5]\\d{4}";
  static final String PATTERN_60000_TO_64999 = "6[0-4]\\d{3}";
  static final String PATTERN_65000_TO_65499 = "65[0-4]\\d{2}";
  public static final String PATTERN_65500_TO_65529 = "655[0-2]\\d";
  public static final String PATTERN_65530_TO_65535 = "6553[0-5]";

  /**
   * 把长度较长的模式放在最前面可以减少匹配时的步骤（通过 RegexBuddy 的 Debug 功能可知）。
   */
  static final String PATTERN_1_TO_65535_WITHOUT_ANCHOR = String.format(
    "(%7$s|%6$s|%5$s|%4$s|%3$s|%2$s|%1$s)",
    PATTERN_1_TO_9, PATTERN_10_TO_9999, PATTERN_10000_TO_59999, PATTERN_60000_TO_64999,
    PATTERN_65000_TO_65499, PATTERN_65500_TO_65529, PATTERN_65530_TO_65535);

  static final String PATTERN_1_TO_65535 = String.format("^%s$",
    PATTERN_1_TO_65535_WITHOUT_ANCHOR);
  public static final Pattern REGEX_1_TO_65535 = Pattern.compile(PATTERN_1_TO_65535);

  public static final String REGEX_STRING = PATTERN_1_TO_65535_WITHOUT_ANCHOR;

  private NetworkPortRegex() {
  }

  public static boolean isMatch(final String input) {
    return REGEX_1_TO_65535.matcher(input).matches();
  }
}
