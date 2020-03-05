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
  // preorder:  root, l, r. we can get part from len
  // inorder: l, root, r
  // val -> idx
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
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(preorder, 0, len1 - 1, inorder, 0, len2 - 1);
  }

  private TreeNode helper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
    if (l1 > r1) {
      return null;
    }

    if (l1 == r1) {
      return new TreeNode(preorder[l1]);
    }

    TreeNode root = new TreeNode(preorder[l1]);
    int idx = map.get(preorder[l1]);

    /**
     * root, leftsub, rightsub
     * leftsub, root, rightsub
     * !!! Abstract, do not think l1 = 0, l2 = 0.
     */
    int addLeftSize = idx - 1 - l2;
    root.left = helper(preorder, l1 + 1, l1 + 1 + addLeftSize, inorder, l2, idx - 1);
    root.right = helper(preorder, l1 + 2 + addLeftSize, r1, inorder, idx + 1, r2);

    return root;
  }
}
