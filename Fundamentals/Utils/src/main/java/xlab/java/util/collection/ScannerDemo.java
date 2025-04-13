package xlab.java.util.collection;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author CodeKing
 */
public class ScannerDemo {
  private static final Pattern PATTERN_SPACES = Pattern.compile("\\s+");

  public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {
      showDelimiter(scanner);

      // tokens(scanner);

      // next(scanner);
      // nextLine(scanner);

      hasNextAndNext(scanner);
      // hasNextLine(scanner);
    }
  }

  private static void showDelimiter(final Scanner scanner) {
    final Pattern delimiter = scanner.delimiter();
    System.out.printf("Current delimiter pattern used for scanner '%s'.%n",
      delimiter.toString());
  }

  private static void tokens(final Scanner scanner) {
    final Stream<String> tokens = scanner.tokens();
    // System.out.printf("Got %d tokens.%n", tokens.count());

    final AtomicInteger index = new AtomicInteger();
    tokens.forEachOrdered(token -> {
      System.out.printf("Token %d is '%s'.%n", index.addAndGet(1), token);
    });
  }

  private static void next(final Scanner scanner) {
    final String input = scanner.next();
    System.out.printf("next: %s.%n", input);
  }

  private static void nextLine(final Scanner scanner) {
    final String input = scanner.nextLine();
    System.out.printf("nextLine: %s.%n", input);
  }

  private static void hasNextAndNext(final Scanner scanner) {
    System.out.println("Scanner hasNext and next method test.");
    System.out.println("Please enter some tokens seperated by space(s):");
    while (scanner.hasNext()) {
      System.out.println("hasNext: true.");
      System.out.printf("next: %s.%n", scanner.next());
    }

    System.out.println("hasNext: false.");
  }

  private static void hasNextLine(final Scanner scanner) {
    final boolean hasNextLine = scanner.hasNextLine();
    if (hasNextLine) {
      System.out.println("hasNextLine: true.");
      System.out.printf("nextLine: %s.%n", scanner.nextLine());
    }
  }
}
