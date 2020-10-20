package leet._401_450;

import common.TreeNode;

public class _404_Sum_of_leat_leaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        // determine a leave node is left child.
        // determine left child exists and if it is leave node
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}
