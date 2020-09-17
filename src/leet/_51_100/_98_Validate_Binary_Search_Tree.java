package leet._51_100;

import common.TreeNode;

import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {
    /**
     * 0ms
     */
    class Sol_InRange {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }

            if (min != null && root.val <= min) {
                return false;
            }

            if (max != null && root.val >= max) {
                return false;
            }

            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }

    class Sol_inorder_recursion {
        TreeNode prev;

        public boolean isValidBST(TreeNode root) {
            prev = null;
            return inorder(root);
        }

        private boolean inorder(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!inorder(root.left)) {
                return false;
            }

            if (prev != null && root.val <= prev.val) {
                return false;
            }

            prev = root;

            return inorder(root.right);
        }
    }

    /**
     * 2ms
     * T = n
     * S = h
     */
    class Sol_inorder_iterative {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            TreeNode cur = root;

            while (true) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                if (stack.isEmpty()) {
                    return true;
                }

                TreeNode visitNode = stack.pop();
                if (prev != null && visitNode.val <= prev.val) {
                    return false;
                }

                prev = visitNode;
                cur = visitNode.right;
            }
        }
    }
}
