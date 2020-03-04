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

    // get and update. So every root.left, root.right should be run
    private int getOnePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = getOnePathSum(root.left);
        if (l < 0) {
            l = 0;
        }
        int r = getOnePathSum(root.right);
        if (r < 0) {
            r = 0;
        }

        int curSum = root.val + l + r;
        ans = Math.max(ans, curSum);
        return root.val + Math.max(l, r);
    }
}
