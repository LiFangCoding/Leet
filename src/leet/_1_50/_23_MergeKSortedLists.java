package leet._1_50;

import common.ListNode;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class _23_MergeKSortedLists {
    //TODO

    /**
     * 时间复杂度：考虑优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk)，
     * 这里最多有 kn 个点，对于每个点都被插入删除各一次，
     * 故总的时间代价即渐进时间复杂度为 O(kn \times \log k)O(kn×logk)。
     * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k 个，故渐进空间复杂度为 O(k)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        /**
         * !!! comparator
         */
        PriorityQueue<ListNode> minPq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));

        /**
         * !!! node != null
         */
        for (ListNode node : lists) {
            if (node != null) {
                minPq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!minPq.isEmpty()) {
            ListNode node = minPq.remove();
            if (node.next != null) {
                minPq.add(node.next);
                //                node.next = null;
            }

            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }

    class Sol_merge {
        /**
         * 考虑递归「向上回升」的过程——第一轮合并 k/2组，每一组代价2n
         * 一共 logk 层
         * 每一组 k * n
         * 时间复杂度 kn * log k
         * O(logk) 空间复杂度栈
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) {
                return null;
            }

            return mergeHelper(lists, 0, lists.length - 1);
        }

        private ListNode mergeHelper(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }

            if (l > r) {
                return null;
            }

            int mid = l + (r - l) / 2;
            ListNode left = mergeHelper(lists, l, mid);
            ListNode right = mergeHelper(lists, mid + 1, r);
            return mergeTwo(left, right);
        }

        private ListNode mergeTwo(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            cur.next = l1 != null ? l1 : l2;

            return dummy.next;
        }
    }
}
