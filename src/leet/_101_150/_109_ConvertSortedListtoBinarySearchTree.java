package leet._101_150;

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
    //TODO

    /**
     * T = nlogn
     * 递归建立整棵二叉树。
     * 每次以中点为根，以左半部分为左子树，右半部分为右子树。先分别递归建立左子树和右子树，然后令根节点的指针分别指向两棵子树。
     */
    class Sol_recursion {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }

            // 1-2 -3
            // 1-2- 3-4
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy, slow = dummy, prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }

            // slow become the 2 in above
            ListNode right = slow.next;
            slow.next = null;
            prev.next = null;

            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(right);
            return root;
        }
    }

    class Sol_recursion2 {
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

    class Sol_another {
        // better have test case [10]
        public TreeNode sortedListToBST(ListNode head) {
            // need base case. else [-10], mid will always be -10
            if (head == null) {
                return null;
            }

            // important for the listnode and treeNode diff
            if (head.next == null) {
                return new TreeNode(head.val);
            }

            ListNode beforeMid = getBeforeMid(head);
            ListNode mid = beforeMid.next;
            ListNode next = mid.next;

            mid.next = null;
            beforeMid.next = null;

            TreeNode ans = new TreeNode(mid.val);
            ans.left = sortedListToBST(head);
            ans.right = sortedListToBST(next);
            return ans;
        }

        // 1 -> 1   -1
        // 1,2 -> 1  -1
        // 1,2,3  -> 2  1
        private ListNode getBeforeMid(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // here cannot be fast = head.next
            ListNode fast = head, slow = head, prev = dummy;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                prev = prev.next;
            }

            return prev;
        }
    }
}
