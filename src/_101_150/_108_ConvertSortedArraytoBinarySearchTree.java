package _101_150;

import common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class _108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        return helper(A, 0, A.length - 1);
    }

    private TreeNode helper(int[] A, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(A[m]);
        root.left = helper(A, l, m - 1);
        root.right = helper(A, m + 1, r);

        return root;
    }
}
