package xlab.java.fundamentals.io;

import java.io.IOException;
import java.io.StringWriter;

public class StringWriterDemo {
  public static void main(String[] args) {
    try (final StringWriter writer = new StringWriter()) {
      writer.append('H');
      writer.append('e');
      writer.append('l');
      writer.append('l');
      writer.append('o');
      writer.append(' ');
      writer.append('W');
      writer.append('o');
      writer.append('r');
      writer.append('l');
      writer.append('d');
      writer.append('!');
      writer.append(System.lineSeparator());

      writer.append("This is a StringWriter demo.");
      writer.append(System.lineSeparator());

      final CharSequence csq = "The last line appended.";
      writer.append(csq, 0, csq.length());
      writer.append(System.lineSeparator());

      writer.append(null);
      writer.append(System.lineSeparator());

      // writer.flush();

      System.out.printf("%s", writer);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
