package _51_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    /**
     * add the nodes value in inorder.
     */
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            TreeNode next = cur.right;
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
        }

        return res;
    }
}
