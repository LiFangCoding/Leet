package leet._101_150;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * inorder, left, root, right
     * postorder, left, right, root
     * val -> index
     */
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        int len1 = inorder.length;
        int len2 = postorder.length;

        if (len1 != len2) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            /**
             * !!! map is val, index
             * not index, val
             */
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, len1 - 1, postorder, 0, len1 - 1);
    }

    private TreeNode helper(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }

        int rootVal = postorder[r2];
        int rootIndex = map.get(rootVal);
        /**
         *
         * left, root, right
         * left, right, root
         */
        int leftDiff = rootIndex - 1 - l1;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, l1, rootIndex - 1, postorder, l2, l2 + leftDiff);
        root.right = helper(inorder, rootIndex + 1, r1, postorder, l2 + leftDiff + 1, r2 - 1);

        return root;
    }
}
