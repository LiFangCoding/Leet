package _51_100;

import common.TreeNode;

import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST_iterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            /**
             * pay attention, cannot ==.
             * Need cur > prev
             */
            if (prev != null && cur.val <= prev.val) {
                return false;
            }
            prev = cur;
            TreeNode node = cur.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return true;
    }

}
