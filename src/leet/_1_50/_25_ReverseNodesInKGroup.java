package leet._1_50;

import common.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class _25_ReverseNodesInKGroup {
    //TODO

    /**
     * 一图胜千言，根据图片看代码，马上就懂了
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        while (true) {
            ListNode start = pre.next;

            ListNode end = pre;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
        }

        return dummy.next;
    }

    /**
     * 1-2-3
     * 3-2-1
     *
     * @param head
     */
    private ListNode reverse(ListNode head) {
        ListNode first = null;
        ListNode second = head;

        while (second != null) {
            ListNode next = second.next;
            second.next = first;
            first = second;
            second = next;
        }

        return first;
    }
}
