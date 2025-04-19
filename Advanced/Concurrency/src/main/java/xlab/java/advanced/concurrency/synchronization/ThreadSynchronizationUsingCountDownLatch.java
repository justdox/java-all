package xlab.java.advanced.concurrency.synchronization;

import xlab.java.advanced.concurrency.Worker;

import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

public class ThreadSynchronizationUsingCountDownLatch extends ThreadSynchronizationBase {

  public ThreadSynchronizationUsingCountDownLatch(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
  }

  public void run()
  throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(threadCount);

    out.println("使用 CountDownLatch 进行线程同步，开始执行……");
    out.printf("当前计数器值为：%d%n", latch.getCount());
    showInitialValue();

    for (int i = 0; i < threadCount; i++) {
      new Thread(new Worker(() -> value++, latch)).start();
    }

    latch.await();
    out.println("使用 CountDownLatch 进行线程同步，执行完毕。");
    out.printf("当前计数器值为：%d%n", latch.getCount());
    showFinalValue();
  }
}
