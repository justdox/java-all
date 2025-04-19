package xlab.java.advanced.concurrency.synchronization;

import xlab.java.advanced.concurrency.Worker;

import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

public class ThreadsSynchronizationUsingCountDownLatch extends ThreadSynchronizationBase {

  public ThreadsSynchronizationUsingCountDownLatch(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
  }

  public void run()
  throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(threadCount);

    out.println("使用 CountDownLatch 进行线程同步，开始执行……");
    out.printf("变量的初始值为：%d%n", value);
    out.printf("当前计数器值为：%d%n", latch.getCount());

    for (int i = 0; i < threadCount; i++) {
      new Thread(new Worker(() -> value++, latch)).start();
    }

    latch.await();
    out.println("使用 CountDownLatch 进行线程同步，执行完毕。");
    out.printf("当前计数器值为：%d%n", latch.getCount());
    out.printf("变量的最终预期值为：%d%n", finalValue);
    out.printf("变量的最终实际值为：%d%n", value);
  }
}
