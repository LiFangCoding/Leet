package _101_150;

import common.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class _124_BinaryTreeMaximumPathSum {
    int[] A;

    public int maxPathSum(TreeNode root) {
        /**
         * res is A[0]
         * !!! What if root.val < 0.
         */
        A = new int[1];
        A[0] = root.val;

        helper(root);
        return A[0];
    }

    /**
     * Get a path start from node to end.
     * It cannot have two paths since it needs to connect with parent node.
     * <p>
     * We can upate res.
     * <p>
     * start from node, the maximum single path.
     *
     * @return
     */
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0) {
            left = 0;
        }

        if (right < 0) {
            right = 0;
        }

        A[0] = Math.max(A[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
