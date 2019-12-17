package _101_150;

import common.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class _101_Symmetric_Tree {
    public static boolean isSymmetric_ite_inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode p = root.left;
        TreeNode q = root.right;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (p != null) {
            stack1.
        }

        while (node0 != null || node1 != null || !stk0.isEmpty() || !stk1.isEmpty()) {
            while (node0 != null && node1 != null) {
                stk0.add(node0);
                node0 = node0.left;
                stk1.add(node1);
                node1 = node1.right;
            }
            if (node0 != null || node1 != null) {
                return false;
            }
            node0 = stk0.get(stk0.size() - 1);
            stk0.remove(stk0.size() - 1);
            node1 = stk1.get(stk1.size() - 1);
            stk1.remove(stk1.size() - 1);
            if (node0.val != node1.val) {
                return false;
            }
            node0 = node0.right;
            node1 = node1.left;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}
