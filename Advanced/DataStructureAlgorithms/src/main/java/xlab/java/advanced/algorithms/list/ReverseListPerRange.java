package xlab.java.advanced.algorithms.list;

import xlab.java.advanced.datastructure.list.ListNode;

/**
 * @author CodeKing
 * <p>
 * BM3 链表中的节点每k个一组翻转
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e
 */
public class ReverseListPerRange {
  public static void main(String[] args) {
    final ListNode<Integer> root = ListNode.create(1, 2, 3, 4, 5, 6, 7, 8, 9,
      10, 11, 12, 13);
    root.print();
    final int length = 13;
    System.out.printf("Reverse per-%d nodes as a range:%n", length);
    reverse(root, length).print();
  }

  private static ListNode<Integer> reverse(final ListNode<Integer> listNode,
                                           final int length) {
    ListNode<Integer> current = listNode;
    ListNode<Integer> root = current;
    ListNode<Integer> head = current;
    ListNode<Integer> tail;
    int turn = 1;
    int i = 1;

    ListNode<Integer> headPre = null;
    ListNode<Integer> tailNext;

    while (current != null && current.next != null) {
      current = current.next;
      i++;

      if (i == length) {
        tail = current;
        tailNext = tail.next;
        if (turn == 1) {
          root = tail;
        }

        reverse(head, tail);
        if (headPre != null) {
          headPre.next = tail;
        }
        headPre = head;

        head.next = tailNext;
        head = tailNext;
        current = head;
        turn++;
        i = 1;
      }
    }

    return root;
  }

  private static void reverse(final ListNode<Integer> head,
                              final ListNode<Integer> tail) {
    ListNode<Integer> current = head;
    ListNode<Integer> pre = current;
    ListNode<Integer> next = current.next;
    while (current != tail) {
      current = next;
      next = current.next;
      current.next = pre;
      pre = current;
    }
  }
}
