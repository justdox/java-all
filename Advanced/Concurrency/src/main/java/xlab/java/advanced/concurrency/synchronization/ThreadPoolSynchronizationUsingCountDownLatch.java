package xlab.java.advanced.concurrency.synchronization;

import xlab.java.advanced.concurrency.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSynchronizationUsingCountDownLatch extends ThreadSynchronizationUsingCountDownLatchBase {
  final ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

  public ThreadPoolSynchronizationUsingCountDownLatch(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
  }

  @Override
  protected void showMessageBeforeDoWork() {
    System.out.println("使用 CountDownLatch 实现线程池线程同步，开始执行……");
  }

  @Override
  protected void showMessageAfterDoWork() {
    System.out.println("使用 CountDownLatch 实现线程池线程同步，执行完毕。");
  }

  @Override
  protected void cleanUp() {
    super.cleanUp();

    executorService.shutdown();
  }

  @Override
  protected void doWork() {
    for (int i = 0; i < threadCount; i++) {
      executorService.submit(new Worker(() -> value++, latch));
    }
  }
}
