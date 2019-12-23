package _101_150;

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
     * val -> index
     */
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        _106_ConstructBinaryTreefromInorderandPostorderTraversal test = new _106_ConstructBinaryTreefromInorderandPostorderTraversal();

        int[] A = {9, 3, 15, 20, 7};
        int[] B = {9, 15, 7, 20, 3};
        System.out.println(test.buildTree(A, B));
    }

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
        for (int i = 0; i < inorder.length; i++) {
            /**
             * !!! map is val, index
             * not index, val
             */
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, len1 - 1, postorder, 0, len1 - 1);
    }

    private TreeNode helper(int[] inorder, int start1, int end1,
                            int[] postorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }

        if (start1 == end1) {
            return new TreeNode(inorder[start1]);
        }

        int rootVal = postorder[end2];
        int rootIndex = map.get(rootVal);
        /**
         *
         * left, root, right
         * left, right, root
         */
        int leftLen = rootIndex - start1;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, start1, rootIndex - 1,
                postorder, start2, start2 + leftLen - 1);

        root.right = helper(inorder, rootIndex + 1, end1,
                postorder, start2 + leftLen, end2 - 1);

        return root;
    }
}
