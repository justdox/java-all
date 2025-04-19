package xlab.java.advanced;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

public class ThreadsSynchronizationWithCountDownLatch {
  public static void main(String[] args)
  throws InterruptedException {
    out.printf("Main thread %s is running.%n",
      Thread.currentThread().getName());

    CountDownLatch latch = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      new Thread(new Worker(latch)).start();
    }

    latch.await();

    out.printf("Main thread %s is completed.%n",
      Thread.currentThread().getName());
  }
}

class Worker implements Runnable {
  private final CountDownLatch latch;

  public Worker(final CountDownLatch latch) {
    this.latch = latch;
  }

  /**
   * When an object implementing interface {@code Runnable} is used
   * to create a thread, starting the thread causes the object's
   * {@code run} method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method {@code run} is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    try {
      out.printf("Worker thread %s is running.%n",
        Thread.currentThread().getName());
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      latch.countDown();
    }
  }
}
