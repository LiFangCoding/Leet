package _1_50;

import common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode sec = prev.next.next;
            ListNode next = sec.next;
            sec.next = null;

            first.next = next;
            sec.next = first;
            prev.next = sec;

            prev = first;
        }

        return dummy.next;
    }
}
