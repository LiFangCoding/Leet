package leet._251_300;

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
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;

        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                sb.append("->");
                sb.append(path.get(i));
            }
            res.add(sb.toString());
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        path.remove(path.size() - 1);
    }
}
