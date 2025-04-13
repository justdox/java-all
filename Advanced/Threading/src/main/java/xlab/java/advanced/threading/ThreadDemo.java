package xlab.java.advanced.threading;

import java.util.concurrent.TimeUnit;

/**
 * @author CodeKing
 */
public class ThreadDemo {
  public static void main(String[] args)
  throws InterruptedException {
    final Foo foo = new Foo();
    final Thread t1 = new Thread(foo::increase);
    final Thread t2 = new Thread(foo::increase);

    t1.start();
    t2.start(); // coupons

    TimeUnit.SECONDS.sleep(1);
    System.out.println(foo.i);
  }
}

class Foo {
  int i;

  void increase() {
    i++;
  }
}
