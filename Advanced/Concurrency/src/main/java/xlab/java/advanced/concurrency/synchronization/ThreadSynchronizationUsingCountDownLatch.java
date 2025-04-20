package xlab.java.advanced.concurrency.synchronization;

import xlab.java.advanced.concurrency.Worker;

public class ThreadSynchronizationUsingCountDownLatch extends ThreadSynchronizationUsingCountDownLatchBase {

  public ThreadSynchronizationUsingCountDownLatch(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
  }

  @Override
  protected void doWork() {
    for (int i = 0; i < threadCount; i++) {
      new Thread(new Worker(() -> value++, latch)).start();
    }
  }
}
