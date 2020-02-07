package _251_300;

import common.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * The successor of a node p is the node with the smallest key greater than p.val.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *  
 * <p>
 * Note:
 * <p>
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 */
public class _285_InorderSuccessorinBST {
    public static void main(String[] args) {
        _285_InorderSuccessorinBST test = new _285_InorderSuccessorinBST();
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
    }

    class Sol_ite {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode cur = root;
            TreeNode res = null;

            while (cur != null) {
                if (cur.val > p.val) {
                    res = cur;
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            return res;
        }
    }

    class Sol_divide_conquer {
        TreeNode lastNode = null;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) {
                return null;
            }

            TreeNode left = inorderSuccessor(root.left, p);
            if (left != null) {
                return left;
            }

            if (lastNode != null && lastNode.val == p.val) {
                return root;
            }

            lastNode = root;
            return inorderSuccessor(root.right, p);
        }
    }

    /**
     * Need to traverse all nodes. Cannot stop
     */
    class Sol_traverse {
        int target;
        TreeNode prev = null;
        TreeNode res = null;


        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            target = p.val;
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            traverse(root.left);
            System.out.println("current node is " + root.val);

            if (prev != null && prev.val == target) {
                System.out.println("here is equal");
                res = root;
                prev = root;
                return;
            } else {
                prev = root;
            }

            System.out.println("prev node is " + prev.val);
            traverse(root.right);
        }
    }
}
