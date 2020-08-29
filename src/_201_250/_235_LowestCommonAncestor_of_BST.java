package _201_250;

import common.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *  
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class _235_LowestCommonAncestor_of_BST {
    class Sol_loop {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            TreeNode cur = root;
            int small = Math.min(p.val, q.val);
            int large = Math.max(p.val, q.val);
            /**
             * !!! need a while
             */
            while (cur != null) {
                if (cur.val >= small && cur.val <= large) {
                    return cur;
                } else if (cur.val < small) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }

            return null;
        }
    }

    class Sol_rec {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > q.val) {
                TreeNode temp = p;
                p = q;
                q = temp;
            }

            // p < q.
            if (p.val <= root.val && q.val >= root.val) {
                return root;
            }

            if (q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
