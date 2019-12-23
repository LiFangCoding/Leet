package _101_150;

import common.ListNode;
import common.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class _109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        /**
         * 1
         * 1 ->2
         * 1 -> 2 -> 3
         * 1 -> 2 -> 3 -> 4
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }

        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        /**
         * !!! if only head exist, use head is not correct.
         * Since head will always point to the valid value.
         * The correct way is to use dummy.next
         */
        root.left = helper(dummy.next);

        ListNode right = slow.next;
        slow.next = null;
        root.right = helper(right);

        return root;
    }
}
