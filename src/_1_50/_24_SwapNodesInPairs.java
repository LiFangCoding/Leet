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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        //TODO: test on leet
        while (true) {
            ListNode first = cur.next;

            if (first == null || first.next == null) {
                break;
            }
            ListNode second = first.next;

            // in order, exchange two nodes
            ListNode next = second.next;

            first.next = next;
            second.next = first;
            cur.next = second;

            cur = first;
        }
        return dummy.next;
    }
}
