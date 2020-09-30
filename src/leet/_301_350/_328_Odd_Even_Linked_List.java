package leet._301_350;

import common.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ..
 */
public class _328_Odd_Even_Linked_List {
    class Sol_new {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode oh = head, ot = oh;
            ListNode eh = head.next, et = eh;

            for (ListNode p = head.next.next; p != null; ) {
                ot.next = p;
                ot = ot.next;
                p = p.next;

                if (p != null) {
                    et.next = p;
                    et = et.next;
                    p = p.next;
                }
            }

            ot.next = eh;
            et.next = null;
            return oh;
        }
    }

    class Sol_old {
        public ListNode oddEvenList(ListNode head) {
            ListNode oddDummy = new ListNode(0);
            ListNode evenDummy = new ListNode(0);
            ListNode oddP = oddDummy, evenP = evenDummy;

            ListNode cur = head;
            boolean isOdd = true;

            while (cur != null) {
                if (isOdd) {
                    oddP.next = cur;
                    oddP = oddP.next;
                } else {
                    evenP.next = cur;
                    evenP = evenP.next;
                }
                isOdd = !isOdd;
                cur = cur.next;
            }

            oddP.next = evenDummy.next;
            evenP.next = null;

            return oddDummy.next;
        }
    }
}
