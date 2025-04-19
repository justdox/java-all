package xlab.java.advanced.concurrency.synchronization;

import static java.lang.System.out;

public abstract class ThreadSynchronizationBase {
  protected final int threadCount;
  protected int value;
  protected final int finalValue;

  public ThreadSynchronizationBase(final int initialValue,
                                   final int threadCount) {
    this.value = initialValue;
    this.threadCount = threadCount;
    this.finalValue = initialValue + threadCount;
  }

  public abstract void run()
  throws InterruptedException;

  protected void showInitialValue() {
    out.printf("变量的初始值为：%d%n", value);
  }

  protected void showFinalValue() {
    out.printf("变量的最终预期值为：%d%n", finalValue);
    out.printf("变量的最终实际值为：%d%n%n", value);
  }
}
