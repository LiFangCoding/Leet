package _51_100;

import common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class _82_Remove_Duplicates_from_Sorted_List2 {
    /**
     * 1ms
     * T = n
     * <p>
     * (线性扫描) O(n)
     * 为了方便处理边界情况，我们定义一个虚拟元素 dummy 指向链表头节点。
     * 然后从前往后扫描整个链表，每次扫描元素相同的一段，如果这段中的元素个数多于1个，则将整段元素直接删除。
     * https://www.acwing.com/solution/content/166/
     * 时间复杂度分析：整个链表只扫描一遍，所以时间复杂度是 O(n)。
     */
    class Sol_booleanVal {
        //TODO
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            while (prev.next != null) {
                ListNode q = prev.next;
                // find q is null or q val is different from prev.next
                while (q != null && q.val == prev.next.val) {
                    q = q.next;
                }

                // prev, prev.next, q
                if (prev.next.next == q) {
                    prev = prev.next;
                } else {
                    // need to make sure new q is not duplicate
                    prev.next = q;
                }
            }

            return dummy.next;
        }
    }
}
