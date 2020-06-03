package _51_100;

import common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class _82_Remove_Duplicates_from_Sorted_List2 {
  /**
   * 1ms
   * T = n
   */
  class Sol_booleanVal {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null) {
        return head;
      }

      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode prev = dummy;
      ListNode cur = prev.next;

      while (cur != null) {
        boolean dup = false;
        while (cur != null && cur.next != null && cur.val == cur.next.val) {
          dup = true;
          cur = cur.next;
        }

        if (dup) {
          cur = cur.next;
          prev.next = cur;
        } else {
          prev.next = cur;
          prev = prev.next;
          cur = cur.next;
        }
      }

      return dummy.next;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;

    while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int duplicate = cur.next.val;
                ListNode newNext = cur.next.next;
                while (newNext != null && newNext.val == duplicate) {
                    newNext = newNext.next;
                }
                cur.next = newNext;
                /**
                 * !!! here cannot cur = cur.next. ex,
                 * input: [1,2,3,3,4,4,5]
                 * output: [1,2,4,4,5]
                 * expected: [1,2,5]
                 */
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
