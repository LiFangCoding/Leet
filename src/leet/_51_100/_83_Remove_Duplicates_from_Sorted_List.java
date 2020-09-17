package leet._51_100;

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
    class Sol_newer {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;

            while (cur != null) {
                int val = cur.val;

                ListNode p = cur.next;
                // delete the value same as cur
                while (p != null && p.val == val) {
                    p = p.next;
                }

                cur.next = p;
                cur = cur.next;
            }

            return head;
        }
    }
}
