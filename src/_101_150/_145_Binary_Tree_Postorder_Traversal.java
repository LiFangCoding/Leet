package _101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _145_Binary_Tree_Postorder_Traversal {
    List<Integer> res;

    public List<Integer> postorderTraversal_recursion(TreeNode root) {
        res = new ArrayList<>();

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    /**
     * 1
     * 2 3
     * 4,5  6,7
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_iterative(TreeNode root) {
        /**
         * dfs(root.left)
         * dfs(root.right)
         * root.val
         *
         *
         * reverse:
         * root.val
         * root.right
         * root.left
         */
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return res;
    }
}
