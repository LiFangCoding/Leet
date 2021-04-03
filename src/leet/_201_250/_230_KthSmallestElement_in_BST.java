package leet._201_250;

import common.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class _230_KthSmallestElement_in_BST {
    class Sol_dfs_no_return {
        int k;
        int res;

        public int kthSmallest(TreeNode root, int _k) {
            k = _k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (k < 0 || root == null) return;

            dfs(root.left);
            k--;
            if (k == 0) {
                res = root.val;
                return;
            }

            dfs(root.right);
        }
    }

    class Sol_dfs_with_return {
        int k;
        int res;

        public int kthSmallest(TreeNode root, int _k) {
            k = _k;
            dfs(root);
            return res;
        }

        private boolean dfs(TreeNode root) {
            if (root == null) return false;

            if (dfs(root.left)) return true;

            if (--k == 0) {
                res = root.val;
                return true;
            }

            return dfs(root.right);
        }
    }

    class Sol_stack {
        Stack<TreeNode> stack;

        public int kthSmallest(TreeNode root, int k) {
            stack = new Stack<>();
            pushToStack(root);

            int res = 0;
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                k--;
                if (k == 0) {
                    res = t.val;
                    return res;
                }

                pushToStack(t.right);
            }

            return res;
        }

        private void pushToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
