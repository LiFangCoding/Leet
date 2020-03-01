package _201_250;

import common.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _206_ReverseLinkedList {
    /**
     *
     */
    public ListNode reverseList_iterative(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    /**
     * 1
     * 1,2,3,4  -> 4,3,2,1
     */
    public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head.next;
        head.next = null;

        ListNode newHead = reverseList_recursion(tail);
        tail.next = head;
        return newHead;
    }
}
