package xlab.java.advanced.concurrency.synchronization;

/**
 * 线程同步示例。
 * This class contains demos of thread synchronization.
 */
public class ThreadSynchronizationDemos {

  public static void main(String[] args)
  throws InterruptedException {
    new ThreadSynchronizationUsingSynchronizedMethod(0, 10).run();

    new ThreadSynchronizationUsingCountDownLatch(0, 10).run();
  }
}
