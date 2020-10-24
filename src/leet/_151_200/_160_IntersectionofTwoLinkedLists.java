package leet._151_200;

import common.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class _160_IntersectionofTwoLinkedLists {
    /**
     * Consider two conditions and draw the pictures.
     * <p>
     * two intersects
     * <p>
     * two not intersect
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // null also equals null
        ListNode p = headA, q = headB;

        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
}
