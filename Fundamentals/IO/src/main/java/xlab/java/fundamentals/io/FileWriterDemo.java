package xlab.java.fundamentals.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author CodeKing
 */
public class FileWriterDemo {
  public static void main(String[] args) {
    // final String fileName = "test.txt";

    // 文件不存在时将会自动创建文件。
    final String fileName = "FileWriterTest.txt";

    try (final FileWriter fileWriter = new FileWriter(fileName, true);
         final FileReader fileReader = new FileReader(fileName)) {
      System.out.println("Before content appended:");
      FileReaderDemo.readAndPrint(fileReader);

      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
      final String now = LocalDateTime.now().format(formatter);
      final String message = String.format("%s\t%s%n", now, "Content wrote by" +
        " FileWriter.");
      fileWriter.write(message);
      fileWriter.flush();

      System.out.println("After content appended:");
      FileReaderDemo.readAndPrint(fileReader);

      final List<String> content = Files.readAllLines(Paths.get(fileName).toAbsolutePath(), StandardCharsets.UTF_8);
      for (final String line : content) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
