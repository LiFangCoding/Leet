package _251_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class _257_BinaryTreePaths {
    List<String> res;
    String path;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        path = "";

        if (root == null) {
            return res;
        }

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }

        String temp = path;
        path += root.val + "->";
        dfs(root.left);
        dfs(root.right);
        path = temp;
    }
}