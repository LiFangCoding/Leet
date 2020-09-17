package leet._101_150;

import common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class _141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        /**
         * !!! fast.next != null. Do not forget it
         */
        while (true) {
            if (fast != null && fast.next != null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            /**
             * !!! after rows. Else it is head == head, always true.
             */
            if (fast == slow) {
                return true;
            }
        }
    }
}
