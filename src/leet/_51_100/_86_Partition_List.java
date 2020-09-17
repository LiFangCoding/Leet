package leet._51_100;

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
        ListNode smallDummy = new ListNode(0);
        ListNode p1 = smallDummy;
        ListNode bigDummy = new ListNode(0);
        ListNode p2 = bigDummy;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
            } else {
                p2.next = cur;
                p2 = p2.next;
            }
        }

        p1.next = bigDummy.next;
        p2.next = null;
        return smallDummy.next;
    }
}
