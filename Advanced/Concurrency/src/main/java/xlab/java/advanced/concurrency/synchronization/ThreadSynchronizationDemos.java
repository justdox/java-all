package xlab.java.advanced.concurrency.synchronization;

/**
 * 线程同步示例。
 * This class contains demos of thread synchronization.
 */
public class ThreadSynchronizationDemos {

  public static void main(String[] args) {
    new ThreadSynchronizationUsingSynchronizedMethod(0, 10).run();
  }
}
