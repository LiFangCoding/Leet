package _51_100;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class _86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode p1 = before;
        ListNode after = new ListNode(0);
        ListNode p2 = after;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p1.next = cur;
                cur = cur.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = cur;
                cur = cur.next;
                p2 = p2.next;
                p2.next = null;
            }
        }

        p1.next = after.next;
        return before.next;
    }
}
