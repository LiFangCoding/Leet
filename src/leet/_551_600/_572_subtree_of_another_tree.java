package leet._551_600;

import common.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class _572_subtree_of_another_tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (isSame(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
