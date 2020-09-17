package leet._201_250;

import common.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class _203_RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy; p != null; p = p.next) {
            ListNode q = p.next;
            while (q != null && q.val == val) {
                q = q.next;
            }
            p.next = q;
        }
        return dummy.next;
    }
}
