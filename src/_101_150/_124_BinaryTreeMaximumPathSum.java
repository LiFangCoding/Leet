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
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        getOnePathSum(root);
        return ans;
    }

    private int getOnePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = Math.max(0, getOnePathSum(root.left));
        int r = Math.max(0, getOnePathSum(root.right));

        int maxSumFromRoot = root.val + l + r;
        ans = Math.max(ans, maxSumFromRoot);
        return root.val + Math.max(l, r);
    }
}
