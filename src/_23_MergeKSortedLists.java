import common.ListNode;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class _23_MergeKSortedLists {
    /**
     * T = O(N * logk)
     * N is the toal num of nodes. K is the nunm of lists.
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        /**
         * Make sure to add comparator to the method
         */
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));

        /**
         * put all in the pq first
         * Pay attention to null one.
         */
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode temp = pq.remove();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        /**
         * T = O(N * logk)
         * N is the toal num of nodes. K is the nunm of lists.
         */
        if ()
    }
}
