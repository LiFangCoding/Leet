import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 *  
 * <p>
 * Note:
 * <p>
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class _872_Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        dfs(root1, leafs1);
        dfs(root2, leafs2);

        if (leafs1.size() != leafs2.size()) {
            return false;
        }

        return leafs1.equals(leafs2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }
}
