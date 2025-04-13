package xlab.java.fundamentals.io;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderDemo {
  public static void main(String[] args) {
    try (final StringReader reader = new StringReader("This is a StringReader " +
      "demo.")) {
      char[] buffer = new char[1024];
      int read = 0;
      while ((read = reader.read(buffer)) > 0) {
        System.out.print(String.valueOf(buffer, 0, read));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
