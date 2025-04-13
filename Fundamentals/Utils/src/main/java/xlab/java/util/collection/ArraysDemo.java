package xlab.java.util.collection;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author CodeKing
 */
public class ArraysDemo {
  public static void main(String[] args) {
    final int[] nums1 = {1, 2, 3};
    final int[] nums2 = {1, 2, 3};
    System.out.printf("The array nums1 equals array nums2? %b.%n",
      Arrays.equals(nums1, nums2));

    final Integer[] nums11 =
      IntStream.of(nums1).boxed().toArray(Integer[]::new);
    System.out.println(Arrays.toString(nums11));
  }
}
