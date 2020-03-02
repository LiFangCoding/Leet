package _51_100;

import common.TreeNode;

import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {
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

            boolean l = isValidBST(root.left, min, root.val);
            if (!l) {
                return false;
            }
            boolean r = isValidBST(root.right, root.val, max);
            return r;
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

    class Sol_inorder_iterative {
        public boolean isValidBST_iterative(TreeNode root) {
            if (root == null) {
                return true;
            }

            Stack<TreeNode> s = new Stack<>();
            TreeNode prev = null;
            TreeNode cur = root;

            while (!s.isEmpty() || cur != null) {
                while (cur != null) {
                    s.push(cur);
                    cur = cur.left;
                }

                TreeNode node = s.pop();
                if (prev != null && node.val <= prev.val) {
                    return false;
                }

                prev = node;
                cur = node.right;
            }

            return true;
        }
    }
}
