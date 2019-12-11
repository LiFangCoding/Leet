package _51_100;

import common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class _92_Reverse_Linked_List2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }

        ListNode prev = cur;
        // reverse start
        ListNode p1 = prev.next;
        ListNode p2 = p1.next;

        for (int i = m + 1; i <= n; i++) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        prev.next.next = p2;
        prev.next = p1;
        return dummy.next;
    }
}
