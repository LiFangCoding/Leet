package _101_150;

import common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 != len2) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(inorder[i], i);
        }

        /**
         * !!! is len1 - 1, not len1
         */
        return helper(preorder, 0, len1 - 1, inorder, 0, len1 - 1);
    }

    private TreeNode helper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        }

        if (start1 > end1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start1]);
        int rootIndex = map.get(preorder[start1]);

        int leftSubLen = rootIndex - start2;
        /**
         * root, leftsub, rightsub
         * leftsub, root, rightsub
         */
        root.left = helper(preorder, start1 + 1, start1 + leftSubLen,
                inorder, start2, rootIndex - 1);

        root.right = helper(preorder, start1 + leftSubLen + 1, end1,
                inorder, rootIndex + 1, end2);

        return root;
    }
}
