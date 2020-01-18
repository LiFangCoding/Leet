package _201_250;

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
    public ListNode removeElements(ListNode head, int target) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == target) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
