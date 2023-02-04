package xlab.java.advanced.datastructure.list;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ListNodeTest {
  static final String input = "1 2 3 4 5 6 7 8 9 10";
  static final Integer[] values = Arrays.stream(input.split("\\s+"))
    .map(Integer::valueOf).toArray(Integer[]::new);

  static {
    System.out.printf("Test case: %s.%n", input);
  }

  private ListNode<Integer> createListNode() {
    return ListNode.create(values);
  }

  @Test
  @Order(1)
  void create() {
    ListNode<Integer> current = createListNode();
    int index = 0;
    while (current != null) {
      assertEquals(values[index++], current.val);
      System.out.printf("The %d node's value is %d.%n", index, current.val);
      current = current.next;
    }
  }

  @Test
  @Order(2)
  void retrieve() {
    final ListNode<Integer> listNode = createListNode();
    assertEquals(input, listNode.retrieve());
  }

  @Test
  @Order(3)
  void getLength() {
    final ListNode<Integer> head = createListNode();
    assertEquals(values.length, head.getLength());
  }
}
