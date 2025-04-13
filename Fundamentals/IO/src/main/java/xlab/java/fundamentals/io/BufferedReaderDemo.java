package xlab.java.fundamentals.io;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class BufferedReaderDemo {
  public static void main(String[] args)
  throws IOException {
    readFromConsole();
    readFromAFile();
    readFromHTTPConnection();
  }

  private static void readFromHTTPConnection()
  throws IOException {
    final URL url = new URL("https://www.baidu.com");
    final URLConnection connection = url.openConnection();
    try (final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }

  private static void readFromAFile() {
    try (final BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      System.out.println("Read from a file finished.");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void readFromConsole() {
    try (final BufferedReader reader =
           new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      System.out.println("Please enter some content:");
      while ((line = reader.readLine()) != null) {
        if (line.equals("exit")) {
          System.out.println("Exit reading from console.");
          // System.out.println("Application exits.");
          // System.exit(0);
          break;
        }

        System.out.println(line);
        System.out.println("Please enter some content:");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
