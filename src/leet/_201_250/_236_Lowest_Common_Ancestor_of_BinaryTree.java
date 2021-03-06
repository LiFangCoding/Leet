package leet._201_250;

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
    class Sol_divide_conquer {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Res res = helper(root, p, q);
            return res.node;
        }

        private Res helper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return new Res(null, 0);
            }

            Res left = helper(root.left, p, q);
            if (left.count == 2) {
                return left;
            }

            Res right = helper(root.right, p, q);
            if (right.count == 2) {
                return right;
            }

            int count = left.count + right.count + (root.val == p.val ? 1 : 0) + (root.val == q.val ? 1 : 0);

            if (count == 2) {
                return new Res(root, 2);
            } else {
                return new Res(null, count);
            }
        }

        public class Res {
            public TreeNode node;
            public int count;

            public Res(TreeNode node, int count) {
                this.node = node;
                this.count = count;
            }
        }
    }

    class Sol_dfs_bit {
        TreeNode ans = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return ans;
        }

        int dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return 0;

            if (ans != null) return -1;

            int state = dfs(root.left, p, q);
            if (root == p)
                state |= 1;
            else if (root == q)
                state |= 2;

            state |= dfs(root.right, p, q);

            if (state == 3 && ans == null)
                ans = root;
            return state;
        }
    }
}
