package leet;

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class _1332_DeepestLeavesSum {
    int sum;
    int maxDepth;

    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        maxDepth = 0;

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (d == maxDepth) {
                sum += root.val;
            } else if (d > maxDepth) {
                maxDepth = d;
                sum = root.val;
            }
        }

        if (root.left != null) {
            dfs(root.left, d + 1);
        }

        if (root.right != null) {
            dfs(root.right, d + 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
