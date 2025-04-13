package xlab.java.sdk.classes.exceptions;

import xlab.java.sdk.classes.exceptions.checked.CustomException;
import xlab.java.sdk.classes.exceptions.checked.CustomThrowable;
import xlab.java.sdk.classes.exceptions.unchecked.CustomError;
import xlab.java.sdk.classes.exceptions.unchecked.CustomRuntimeException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author CodeKing
 */
public class ExceptionExamples {

  private static final Random RANDOM;

  static {
    try {
      RANDOM = SecureRandom.getInstanceStrong();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    try {
      testCheckedExceptions();
      testUncheckedExceptions();
    } catch (CustomException | CustomThrowable | CustomError |
             CustomRuntimeException e) {
      System.out.println(e);
    }
  }

  /**
   * 测试非受检异常（不需要显式地抛出异常）。
   * {@link java.lang.Error Error}、{@link java.lang.RuntimeException
   * RuntimeException} 以及它们的子类都是非受检异常。
   */
  private static void testUncheckedExceptions() {
    final int random = RANDOM.nextInt(20);
    System.out.printf("The random int value is: %d.%n", random);

    if (random > 10) {
      throw new CustomError();
    }

    throw new CustomRuntimeException();
  }

  /**
   * 测试受检异常（必须显式地抛出异常）。
   */
  private static void testCheckedExceptions()
  throws CustomException, CustomThrowable {
    final int random = RANDOM.nextInt(20);

    if (random > 10) {
      throw new CustomException();
    }

    throw new CustomThrowable();
  }

}
