package xlab.java.util.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeKing
 */
public class ArrayListDemo {
  public static void main(String[] args)
  throws InterruptedException {
    final ArrayList<String> strings = new ArrayList<>();
    strings.add("Hello Java ArrayList!");

    System.out.println(strings);
    threadSafeTesting();

  }

  private static void threadSafeTesting()
  throws InterruptedException {
    final List<String> strings = new ArrayList<>();
    strings.add("Original value.");
    final Thread threadA = new Thread(() -> strings.set(0,"Message A."));
    final Thread threadB = new Thread(() -> strings.set(0, "Message B."));
    final Thread threadC = new Thread(() -> strings.set(0, "Message C."));

    threadA.start();
    threadB.start();
    threadC.start();

    threadA.join();
    threadB.join();
    threadC.join();

    System.out.println(strings);
  }
}
