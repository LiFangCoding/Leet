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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = findMid(head);
        ListNode t = mid.next;
        mid.next = null;
        ListNode right = reverse(t);

        ListNode l1 = head, l2 = right;
        boolean res = true;
        while (l1 != null && l2 != null) {
            // here need to iterate
            if (l1.val != l2.val) {
                res = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        mid.next = reverse(right);
        return res;
    }

    // 1,2,3 -> 2
    // 1,2  -> 1
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

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
}
