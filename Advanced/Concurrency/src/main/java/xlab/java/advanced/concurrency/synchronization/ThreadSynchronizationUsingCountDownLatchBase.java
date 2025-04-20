package xlab.java.advanced.concurrency.synchronization;

import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

public abstract class ThreadSynchronizationUsingCountDownLatchBase extends ThreadSynchronizationBase {
  protected final CountDownLatch latch;

  public ThreadSynchronizationUsingCountDownLatchBase(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
    latch = new CountDownLatch(threadCount);
  }

  @Override
  public final void run()
  throws InterruptedException {
    showMessageBeforeDoWork();
    showCountDownValue();
    showInitialValue();

    doWork();
    latch.await();

    showMessageAfterDoWork();
    showCountDownValue();
    showFinalValue();

    cleanUp();
  }

  protected void showCountDownValue() {
    out.printf("当前计数器值为：%d%n", latch.getCount());
  }

  protected abstract void doWork()
  throws InterruptedException;

  protected void cleanUp() {
  }

  protected void showMessageBeforeDoWork() {
    out.println("使用 CountDownLatch 进行线程同步，开始执行……");
  }

  protected void showMessageAfterDoWork() {
    out.println("使用 CountDownLatch 进行线程同步，执行完毕。");
  }
}
