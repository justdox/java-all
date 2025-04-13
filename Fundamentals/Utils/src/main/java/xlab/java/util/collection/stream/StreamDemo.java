package xlab.java.util.collection.stream;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author CodeKing
 */
public class StreamDemo {
  public static void main(String[] args) {
    try (final Scanner scanner = new Scanner(System.in)) {
      do {
        // 4 2 3 5 1 8 6 9 0 7
        // 0 1 2 3 4 5 6 7 8 9
        sorted(scanner);

        // 0 1 2 3 4 5 6 9 10 11 12 13 14 15 16 17 18 19 20
        unordered(scanner);
      } while (scanner.hasNextLine());
    }
  }

  private static IntStream getInputNumbers(final Scanner scanner) {
    final String[] strings = scanner.nextLine().trim().split(
      "\\s+");
    return Arrays.stream(strings)
      .mapToInt(Integer::parseInt);
  }

  private static void sorted(final Scanner scanner) {
    System.out.println("Please enter some integers seperated by space(s):");

    getInputNumbers(scanner)
      .sorted()
      .mapToObj(String::valueOf)
      .reduce((p, c) -> p + " " + c)
      .ifPresent(System.out::println);
  }

  private static void unordered(final Scanner scanner) {
    System.out.println("Please enter some integers in asc order seperated by " +
      "space(s):");

    getInputNumbers(scanner).parallel().unordered().mapToObj(String::valueOf)
      .reduce((p, c) -> p + " " + c).ifPresent(System.out::println);
  }

  private static void toArray() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Integer[] integers = IntStream.of(nums).boxed().toArray(Integer[]::new);
    System.out.println(Arrays.toString(integers));
  }
}
