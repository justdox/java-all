package xlab.java.advanced.datastructure.list;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author CodeKing
 */
public class ListNode<T> {
  public T val;

  public ListNode<T> next;

  public ListNode(final T val) {
    this.val = val;
  }

  public ListNode(final T val, final ListNode<T> next) {
    this(val);
    this.next = next;
  }

  @SafeVarargs
  public static <T> ListNode<T> create(final T... values) {
    final ListNode<T> head = new ListNode<>(values[0]);
    ListNode<T> current = head;
    for (int i = 1; i < values.length; i++) {
      final ListNode<T> next = new ListNode<>(values[i]);
      current.next = next;
      current = next;
    }

    return head;
  }

  public int getLength() {
    ListNode<T> current = this;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }

    return length;
  }

  public String retrieve() {
    ListNode<T> current = this;
    ArrayList<T> values = new ArrayList<>();
    values.add(val);

    while (current.next != null) {
      current = current.next;
      values.add(current.val);
    }

    return values.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  public void print() {
    System.out.println(retrieve());
  }

}
