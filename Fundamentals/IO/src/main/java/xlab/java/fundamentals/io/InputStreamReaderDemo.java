package xlab.java.fundamentals.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class InputStreamReaderDemo {
  public static void main(String[] args) {
    final String fileName = "test.txt";
    try (final FileInputStream fis = new FileInputStream(fileName);
         // final InputStreamReader reader = new InputStreamReader(fis);
         // final InputStreamReader reader = new InputStreamReader(fis,
         //   Charset.defaultCharset());
         // final InputStreamReader reader = new InputStreamReader(fis,
         //   StandardCharsets.UTF_8);
         final InputStreamReader reader = new InputStreamReader(fis,
           Charset.forName("utf-8"));
    ) {
      final char[] buffer = new char[1024];
      int read = 0;
      while ((read = reader.read(buffer)) > 0) {
        System.out.println(String.valueOf(buffer, 0, read));
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
