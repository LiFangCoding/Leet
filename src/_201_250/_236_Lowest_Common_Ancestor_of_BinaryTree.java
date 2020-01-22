package _201_250;

import common.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *  
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class _236_Lowest_Common_Ancestor_of_BinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        RT rt = helper(root, p, q);
        return rt.node;
    }

    private RT helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new RT(null, 0);
        }

        RT left = helper(root.left, p, q);
        if (left.count == 2) {
            return left;
        }

        RT right = helper(root.right, p, q);
        if (right.count == 2) {
            return right;
        }

        int count = left.count + right.count + (root.val == p.val ? 1 : 0) + (root.val == q.val ? 1 : 0);

        if (count == 2) {
            return new RT(root, 2);
        } else {
            return new RT(null, count);
        }
    }

    public class RT {
        public TreeNode node;
        public int count;

        public RT(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

}
