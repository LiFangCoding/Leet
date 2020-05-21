package _501_550;

import common.TreeNode;

/**
 * bst in order
 */
public class _530_Minimum_Absolute_Difference {
    TreeNode prev;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;

        dfs(root);
        return ans;
    }

    // need inorder traverse.  cannot get the min of left and then get the value.
    // update ans and prev
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (prev != null) {
            ans = Math.min(ans, Math.abs(root.val - prev.val));
        }
        prev = root;

        dfs(root.right);
    }
}
