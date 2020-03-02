package _101_150;

import common.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
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
public class _148_Sort_List {
    private int i = 0;

    public ListNode sortList(ListNode head) {
        // base case for merge sort
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode rHead = mid.next;
        mid.next = null;

        return merge(sortList(head), sortList(rHead));
    }

    /**
     * 1 -> 1
     * 1, 2  -> 1
     * 1, 2, 3 -> 2
     */
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        cur.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public ListNode sortList_iterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = listNodeLength(head);

        // 哨兵节点，也有叫傀儡节点（处理链表问题的一般技巧）
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 循环 log n 次
        for (int i = 1; i < len; i <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            // 循环 n 次
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                prev.next = mergeTwoLists(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // 根据步长分隔链表
    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;
        return right;
    }

    // 获取链表的长度
    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}
