package xlab.java.fundamentals.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
  public static void main(String[] args) {
    try {
      final Path file = Files.createFile(Paths.get("file-created-by" +
        "-createFile.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
