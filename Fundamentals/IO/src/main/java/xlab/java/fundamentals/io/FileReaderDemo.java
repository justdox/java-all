package xlab.java.fundamentals.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author CodeKing
 */
public class FileReaderDemo {
  public static void main(String[] args) {
    System.out.printf("Current working director is: '%s'.%n",
      Paths.get("").toAbsolutePath());
    final String fileName = "test.txt";
    readAndPrint(fileName);
  }

  public static void readAndPrint(final FileReader reader) {
    final int length = 1024;
    char[] buffer = new char[length];
    int read = 0;
    int offset = 0;
    final StringBuilder stringBuilder = new StringBuilder();
    try {
      while ((read = reader.read(buffer)) > 0) {
        stringBuilder.append(buffer, offset, read);
        offset += read;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(stringBuilder);
  }

  public static void readAndPrint(final String fileName) {
    try (final FileReader reader = new FileReader(fileName)) {
      readAndPrint(reader);
    } catch (FileNotFoundException ex) {
      throw new RuntimeException(ex);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
