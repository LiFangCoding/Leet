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
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }

        return curA;
    }
}
