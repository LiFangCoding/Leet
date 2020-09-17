package leet._201_250;

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
    class Sol_iteration {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;

            ListNode first = null, second = head;

            while (second != null) {
                ListNode t = second.next;
                second.next = first;
                first = second;
                second = t;
            }

            return first;
        }
    }

    class Sol_recursion {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
