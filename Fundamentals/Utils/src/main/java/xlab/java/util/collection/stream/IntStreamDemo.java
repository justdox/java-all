package xlab.java.util.collection.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author CodeKing
 */
public class IntStreamDemo {
  public static void main(String[] args) {
    of();
    boxed();
  }

  private static void of() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final IntStream intStream = IntStream.of(nums);
    final int[] numsCopy = intStream.toArray();
    System.out.println(Arrays.equals(nums, numsCopy));
  }

  private static void boxed() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Stream<Integer> integerStream = IntStream.of(nums).boxed();
    final Integer[] integers = integerStream.toArray(Integer[]::new);
    System.out.println(Arrays.toString(integers));

    final Integer[] integers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.equals(integers, integers1));
  }
}
