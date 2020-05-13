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
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode cur = stack.pop();
            res.add(cur.val);
            node = node.right;
        }

        return res;
    }
}
