package xlab.java.util.collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

/**
 * @author CodeKing
 */
public class HashSetDemo {
  public static void main(String[] args) {
    final Random random = new Random();
    final HashSet<Integer> integers = new HashSet<>();

    for (int i = 0; i < 10; i++) {
      final int value = random.nextInt(10);
      System.out.printf("The %dth random generated value is %d.%n", i+1, value);
      integers.add(value);
    }

    System.out.printf("The final size of hashSet is %d.%n", integers.size());
    System.out.println(integers);

    final HashSet<Foo> foos = new HashSet<>();
    foos.add(new Foo(1));
    foos.add(new Foo(1));
    System.out.println(foos);

  }
}

class Foo {
  int val;

  Foo(final int val) {
    this.val = val;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Foo foo = (Foo) o;
    return val == foo.val;
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }
}
