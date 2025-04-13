package xlab.java.fundamentals.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author CodeKing
 */
public class DirectoryDemo {
  public static void main(String[] args) {
    final Path emptyPath = Paths.get("");
    System.out.printf("Paths.get(\"\").toAbsolutePath():%n\t%s%n",
      emptyPath.toAbsolutePath());
    System.out.printf("Paths.get(\".\").toAbsolutePath():%n\t%s%n",
      Paths.get(".").toAbsolutePath());
    System.out.printf("Paths.get(\"/\").toAbsolutePath():%n\t%s%n",
      Paths.get("/").toAbsolutePath());

    System.out.printf("Paths.get(\"test\").toAbsolutePath():%n\t%s%n",
      Paths.get("test").toAbsolutePath());
    System.out.printf("Paths.get(\"test.txt\").toAbsolutePath():%n\t%s%n",
      Paths.get("test.txt").toAbsolutePath());
    System.out.printf("Paths.get(\"./test\").toAbsolutePath():%n\t%s%n",
      Paths.get("./test").toAbsolutePath());
    System.out.printf("Paths.get(\"/test\").toAbsolutePath():%n\t%s%n",
      Paths.get("/test").toAbsolutePath());
  }
}
