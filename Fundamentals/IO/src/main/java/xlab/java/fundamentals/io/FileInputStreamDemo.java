package xlab.java.fundamentals.io;

import java.nio.file.Paths;

public class FileInputStreamDemo {
  public static void main(String[] args) {
    System.out.printf("Current working directory is: '%s'.%n",
      Paths.get("").toAbsolutePath());
  }
}
