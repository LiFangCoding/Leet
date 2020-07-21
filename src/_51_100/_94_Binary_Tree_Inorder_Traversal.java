package _51_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _94_Binary_Tree_Inorder_Traversal {
    class Sol_dfs {
        List<Integer> ans;

        public List<Integer> inorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            helper(root);
            return ans;
        }

        /**
         * add the nodes value in inorder.
         */
        private void helper(TreeNode root) {
            if (root == null) {
                return;
            }

            helper(root.left);
            ans.add(root.val);
            helper(root.right);
        }
    }


    class Sol_stack {
        public List<Integer> inorderTraversal_iterative(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode node = root;

            while (true) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                if (stack.isEmpty()) {
                    break;
                }

                TreeNode cur = stack.pop();
                ans.add(cur.val);
                node = cur.right;
            }

            return ans;
        }
    }
}
