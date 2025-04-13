package xlab.java.advanced.algorithms.list;

import xlab.java.advanced.datastructure.list.ListNode;

/**
 * @author CodeKing
 */
public class MergeTwoOrderedList {
  public static void main(String[]  args) {
    // {-10,-10,-9,-4,1,6,6},{-8}
    final ListNode<Integer> list1 = ListNode.create(-10, -10, -9, -4, 1, 6, 6);
    final ListNode<Integer> list2 = ListNode.create(-8);
    final ListNode<Integer> merged = merge(list1, list2);
    merged.print();
  }

  private static ListNode<Integer> merge(final ListNode<Integer> list1,
                                         final ListNode<Integer> list2) {
    if (list1 == null && list2 != null) {
      return list2;
    }

    if (list1 != null && list2 == null) {
      return list1;
    }

    if (list1 == null) {
      return null;
    }

    final ListNode<Integer> pre = new ListNode<>(0);
    ListNode<Integer> current = pre;
    ListNode<Integer> current1 = list1;
    ListNode<Integer> current2 = list2;
    int val1 = current1.val;
    int val2 = current2.val;
    int min = Math.min(val1, val2);
    int max = Math.max(val1, val2);
    current.next = new ListNode<>(min);
    current = current.next;
    while (current1 != null || current2 != null) {
      if (current1.next != null) {
        val1 = current1.next.val;
      }
      if (current2.next != null) {
        val2 = current2.next.val;
      }

      if (current1.next == null && current2.next == null) {
        current.next = new ListNode<>(max);
        break;
      }

      if (current1.next != null && val1 <= max) {
        current.next = new ListNode<>(val1);
        current = current.next;
        current.next = new ListNode<>(max);
        current = current.next;
        current1 = current1.next;
        max = val2;
      } else if (current2.next != null && val2 <= max) {
        current.next = new ListNode<>(val2);
        current = current.next;
        current.next = new ListNode<>(max);
        current = current.next;
        current2 = current2.next;
        max = val1;
      } else {
        current.next = new ListNode<>(max);
        current = current.next;
        min = Math.min(val1, val2);
        max = Math.max(val1, val2);
        current.next = new ListNode<>(min);
        current = current.next;
        current1 = current1.next;
        current2 = current2.next;
      }
    }

    return pre.next;
  }
}
