package leet;

import common.TreeNode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: [2,2,2,5,2]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 */
public class _965_UnivaluedBinaryTree {
    int target;
    boolean ans;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        target = root.val;
        ans = true;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val != target) {
            ans = false;
            return;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public boolean isUnivalTree_divide_conquer(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean L = isUnivalTree_divide_conquer(root.left);
        if (root.left != null) {
            L = L && (root.val == root.left.val);
        }

        boolean R = isUnivalTree_divide_conquer(root.right);
        if (root.right != null) {
            R = R && (root.val == root.right.val);
        }

        return L && R;
    }
}
