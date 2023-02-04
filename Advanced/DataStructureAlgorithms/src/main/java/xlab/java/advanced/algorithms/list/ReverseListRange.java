package xlab.java.advanced.algorithms.list;

import xlab.java.advanced.datastructure.list.ListNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CodeKing
 */
public class ReverseListRange {
  public static void main(String[] args) {
    // 1 2 3 4 5 6 7 8 9 10
    System.out.print("Please enter a number sequence representing a list: ");
    try (final Scanner scanner = new Scanner(System.in)) {
      String list = "";
      int[] values = new int[0];
      int count = 0;
      int from;
      int to;
      while (scanner.hasNextLine()) {
        if (count == 0) {
          list = scanner.nextLine();
          values = Arrays.stream(list.trim().split("\\s+"))
            .mapToInt(Integer::parseInt).toArray();

          System.out.print("Please enter the reversion range:");
          count++;
        } else if (count == 1) {
          from = scanner.nextInt();
          to = scanner.nextInt();
          scanner.nextLine();

          System.out.printf("Original list:%n%s%n", list);

          System.out.printf("%nReverse from %d to %d:%n", from, to);
          reverse(ListNode.create(values), from, to).print();

          System.out.printf("%nPlease enter a number sequence representing a " +
            "list: ");
          count = 0;
        }
      }
    }
  }

  public static ListNode reverse(final ListNode listNode, final int from,
                                 final int to) {
    if (from == to) {
      return listNode;
    }

    // 找出要反转的子链表（head → ... → tail）
    // 以及与之连接的头尾节点（fromNode、toNode）并记录，它们可能为 null。
    ListNode current = listNode;
    ListNode fromNode = null;
    ListNode toNode;
    ListNode head;
    ListNode tail;

    // current.next != null 防止 to 超过链表长度。
    for (int i = 1; current.next != null && i < from; i++) {
      fromNode = current;
      current = current.next;
    }
    head = current;

    for (int i = from; current.next != null && i < to; i++) {
      current = current.next;
    }
    tail = current;
    toNode = tail.next;

    current = head;
    ListNode pre = current;
    ListNode next = current.next;
    pre.next = toNode;

    while (current != tail) {
      current = next;
      next = current.next;
      current.next = pre;
      pre = current;
    }

    if (fromNode != null) {
      fromNode.next = tail;
      return listNode;
    }

    return tail;
  }
}
