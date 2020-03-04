package _101_150;

import common.ListNode;

/**
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class _147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            /**
             * !!! update the pre position
             */

            if (cur.val < pre.val) {
                pre = dummy;
            }
            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }

            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;

            cur = next;
        }

        return dummy.next;
    }
}
