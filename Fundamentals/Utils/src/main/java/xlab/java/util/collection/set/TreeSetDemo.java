package xlab.java.util.collection.set;

import java.util.Random;
import java.util.TreeSet;

/**
 * @author CodeKing
 */
public class TreeSetDemo {
  public static void main(String[] args) {
    final Random random = new Random();
    final TreeSet<Integer> integers = new TreeSet<>();
    for (int i = 0; i < 10; i++) {
      final int value = random.nextInt(10);
      System.out.printf("The %dth random generated value is %d.%n", i + 1,
        value);
      integers.add(value);
    }

    System.out.printf("The final size of treeSet is %d.%n", integers.size());
    System.out.println(integers);
  }
}
