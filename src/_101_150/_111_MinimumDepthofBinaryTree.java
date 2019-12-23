package _101_150;

import common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 */
public class _111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        /**
         * 1
         * 2   3
         * 4     5
         */
        if (root == null) {
            return 0;
        }

        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(helper(root.left), helper(root.right)) + 1;
    }
}
