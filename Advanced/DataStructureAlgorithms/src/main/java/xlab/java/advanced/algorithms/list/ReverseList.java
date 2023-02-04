package xlab.java.advanced.algorithms.list;

import xlab.java.advanced.datastructure.list.ListNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CodeKing
 */
public class ReverseList {
  public static void main(String[] args) {
    System.out.print("Please enter a sequence of numbers that represents a list: ");
    try (final Scanner scanner = new Scanner(System.in)) {
      final String input = scanner.nextLine().trim();
      final int[] values =
        Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      final ListNode listNode = ListNode.create(values);

      listNode.print();

      reverse(listNode).print();
    }
  }

  public static ListNode reverse(final ListNode listNode) {
    ListNode current = listNode;
    ListNode pre = current;
    ListNode next = current.next;
    pre.next = null;

    while (next != null) {
      current = next;
      next = current.next;
      current.next = pre;
      pre = current;
    }

    return current;
  }
}
