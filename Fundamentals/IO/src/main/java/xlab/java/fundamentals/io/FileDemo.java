package xlab.java.fundamentals.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
  public static void main(String[] args) {
    try {
      final File file = File.createTempFile("test", "txt");
      file.deleteOnExit();
      file.setWritable(true);
      System.out.printf("The temporary file path is %s.%n",
        file.getAbsoluteFile());
      final FileWriter writer = new FileWriter(file);
      writer.write("This is a test file.");
      writer.flush();
      writer.close();
      final FileReader reader = new FileReader(file);
      final char[] buffer = new char[1024];
      int read = 0;
      while ((read = reader.read(buffer)) > 0) {
        System.out.println(String.valueOf(buffer, 0, read));
      }
      reader.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
