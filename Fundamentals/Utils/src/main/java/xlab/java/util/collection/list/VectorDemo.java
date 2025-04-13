package xlab.java.util.collection.list;

import java.util.Vector;

/*
java.util
public class Vector<E>
extends java.util.AbstractList<E>
implements java.util.List<E>,
           java.util.RandomAccess,
           Cloneable,
           java.io.Serializable
* */

/**
 * @author CodeKing
 */
public class VectorDemo {
  public static void main(String[] args)
  throws InterruptedException {
    final Vector<String> strings = new Vector<>();
    strings.add("Hello Java Vector!");

    System.out.println(strings);

    threadSafeTesting();
  }

  private static void threadSafeTesting()
  throws InterruptedException {
    final Vector<String> strings = new Vector<>();
    // final ExecutorService pool = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 10; i++) {
      final String message = String.format("message %d.", i);
      new Thread(() -> strings.add(message)).start();
    }

    // pool.shutdown();
    // pool.awaitTermination(1, TimeUnit.SECONDS);

    Thread.sleep(1000);
    System.out.println(strings);
  }
}
