package _101_150;//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// Note:
//Bonus points if you could solve it both recursively and iteratively.
// Related Topics Tree Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class _101_Symmetric_Tree {
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

    public boolean isSymmetric_iterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();

        TreeNode lc = root.left;
        TreeNode rc = root.right;

        while (true) {
            while (lc != null && rc != null) {
                left.push(lc);
                right.push(rc);
                lc = lc.left;
                rc = rc.right;
            }

            if (!(lc == null && rc == null)) {
                return false;
            }

            if (left.isEmpty() && right.isEmpty()) {
                return true;
            }

            if (left.isEmpty() || right.isEmpty()) {
                return false;
            }

            lc = left.pop();
            rc = right.pop();

            if (lc.val != rc.val) {
                return false;
            }
            lc = lc.right;
            rc = rc.left;
        }
    }
}
