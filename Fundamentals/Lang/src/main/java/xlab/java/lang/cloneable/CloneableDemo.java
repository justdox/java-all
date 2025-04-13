package xlab.java.lang.cloneable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * @author CodeKing
 */
public class CloneableDemo {
  public static void main(String[] args) {

    final DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());

    final CloneableEntity entity = new CloneableEntity((byte) 1, (short) 2, 3
      , 4L, 5F, 6D, 'a', true, "Original entity", dayOfWeek, List.of("One",
      "Two", "Three"), new String[]{"A", "B", "C"});
    final CloneableEntity clone = entity.clone();
    final CloneableEntity copy = entity.copy();

    System.out.println("Original entity:");
    System.out.println(entity);
    System.out.println("Cloned entity:");
    System.out.println(clone);
    System.out.println("Copy entity:");
    System.out.println(copy);
    System.out.println();

    System.out.println("Modifying cloned entity:");
    clone.setIntField(666);
    clone.setStringField("Cloned entity");
    clone.setCollection(List.of("Four", "Five", "Six"));
    clone.setArray(new String[]{"a", "b", "c"});
    System.out.println("Original entity:");
    System.out.println(entity);
    System.out.println("Cloned entity:");
    System.out.println(clone);
    System.out.println("Copy entity:");
    System.out.println(copy);
    System.out.println();

    System.out.println("Modifying copy entity:");
    copy.setIntField(999);
    copy.setStringField("Copied entity");
    copy.setCollection(List.of("Seven", "Eight", "Nine"));
    copy.setArray(new String[]{"Aa", "Bb", "Cc"});
    System.out.println("Original entity:");
    System.out.println(entity);
    System.out.println("Cloned entity:");
    System.out.println(clone);
    System.out.println("Copy entity:");
    System.out.println(copy);
    System.out.println();
  }
}
