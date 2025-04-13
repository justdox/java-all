package xlab.java.lang;

import xlab.java.lang.cloneable.CloneableDemo;
import xlab.java.lang.serializable.SerializableDemo;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author CodeKing
 */
public class JavaLangDemo {
  public static void main(String[] args) {
    final DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
    testSerializable(args);
    // testCloneable(args);
  }

  private static void testSerializable(String[] args) {
    try {
      SerializableDemo.main(args);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void testCloneable(String[] args) {
    CloneableDemo.main(args);
  }
}
