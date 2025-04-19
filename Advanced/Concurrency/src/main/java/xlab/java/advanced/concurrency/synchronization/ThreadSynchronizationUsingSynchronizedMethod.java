package xlab.java.advanced.concurrency.synchronization;

import xlab.java.advanced.concurrency.Worker;
import java.util.ArrayList;

public class ThreadSynchronizationUsingSynchronizedMethod extends ThreadSynchronizationBase {

  public ThreadSynchronizationUsingSynchronizedMethod(final int initialValue, final int threadCount) {
    super(initialValue, threadCount);
  }

  private synchronized void increase() {
    value++;
  }

  public void run() {
    System.out.println("使用 synchronized 同步方法进行线程同步，开始执行……");
    showInitialValue();

    var threads = new ArrayList<Thread>(threadCount);
    for (int i = 0; i < threadCount; i++) {
      final String threadName = String.format("worker-%d", i);
      final Thread thread = new Thread(new Worker(this::increase), threadName);
      threads.add(thread);

      thread.start();

      // 创建线程并启动后立即等待，这样可以实现同步并且线程会依次顺序执行。
      // thread.join(10);
    }

    threads.forEach(thread -> {
      try {
        thread.join(10);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    System.out.println("使用 synchronized 同步方法进行线程同步，执行完毕。");
    showFinalValue();
  }
}
