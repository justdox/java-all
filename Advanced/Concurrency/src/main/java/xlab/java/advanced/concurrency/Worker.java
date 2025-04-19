package xlab.java.advanced.concurrency;

import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

public class Worker implements Runnable {
  private final Runnable payload;
  private CountDownLatch latch;

  public Worker(final Runnable payload) {
    this.payload = payload;
  }

  public Worker(final Runnable payload, final CountDownLatch latch) {
    this.payload = payload;
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
    out.printf("Worker thread %s is running.%n",
      Thread.currentThread().getName());
    if (latch == null) {
      doWork();
    } else {
      doWorkWithCountDownLatch();
    }
  }

  private void doWork() {
    payload.run();
  }

  private void doWorkWithCountDownLatch() {
    payload.run();
    latch.countDown();
  }
}
