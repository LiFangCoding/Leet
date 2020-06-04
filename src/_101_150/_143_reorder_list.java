package _101_150;

import common.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class _143_reorder_list {
  /**
   * 2ms
   * T = n
   * S = 1
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode mid = findMiddle(head);
    ListNode tail = reverse(mid.next);
    mid.next = null;

    merge(head, tail);
  }

    private ListNode findMiddle(ListNode head) {
        /**
         *
         * 1
         * 1 2 3
         * 1 2 3 4
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
      ListNode slow = dummy, fast = dummy;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }

  private ListNode reverse(ListNode second) {
    ListNode first = null;
    while (second != null) {
      ListNode temp = second.next;
      second.next = first;
      first = second;
      second = temp;
    }
    return first;
  }

  private void merge(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while (head1 != null && head2 != null) {
      cur.next = head1;
            cur = cur.next;
            head1 = head1.next;

            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }

        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
    }
}
