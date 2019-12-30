package _101_150;

import common.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class _114_FlattenBinaryTreetoLinkedList {
    private TreeNode prev;


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }

        prev = root;

        /**
         * !!! flatten will change root.right.
         */
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
