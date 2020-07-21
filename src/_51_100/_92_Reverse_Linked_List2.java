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
    /**
     * T = n
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        // cur is the prev node since i < m
        for (int i = 1; i < m; i++) {
            cur = cur.next;
        }

        // keep a ref here
        ListNode tail = cur.next;
        // the start of reverse
        ListNode second = cur.next;
        ListNode first = null;

        for (int i = m; i <= n; i++) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        cur.next = first;
        tail.next = second;

        return dummy.next;
    }
}
