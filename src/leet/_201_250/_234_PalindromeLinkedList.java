package leet._201_250;

import common.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class _234_PalindromeLinkedList {
    /**
     * test case
     * 1
     * 1 -> 2 false
     * 1 -> 1 true
     * 1 -> 2 -> 3 false
     * 1 -> 2 -> 3 true
     * 1 -> 2 ->2 -> 1 true
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        /**
         * get the mid of list
         *
         * 0 |-> 1     1
         *
         * 0 \->  1 -> 2    1
         * 0 -> 1-> 2-> 3  2
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode head2 = reverse(secondHalf);

        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

}
