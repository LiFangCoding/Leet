package _51_100;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class _83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode newNext = cur.next;
                while (newNext != null && newNext.val == cur.val) {
                    newNext = newNext.next;
                }
                cur.next = newNext;
                /**
                 * because 3,3,3,4 -> 3,4
                 * But be careful when cur = cur.next is null
                 * cur = cur.next can has error.
                 */
//                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
