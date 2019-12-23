package _101_150;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class _110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBal;
    }

    private RT helper(TreeNode root) {
        if (root == null) {
            return new RT(0, true);
        }

        RT left = helper(root.left);
        if (!left.isBal) {
            return new RT(-1, false);
        }

        RT right = helper(root.right);
        if (!right.isBal) {
            return new RT(-1, false);
        }

        if (Math.abs(left.h - right.h) > 1) {
            return new RT(-1, false);
        }

        return new RT(Math.max(left.h, right.h) + 1, true);
    }

    public class RT {
        int h;
        boolean isBal;

        public RT(int h, boolean isBal) {
            this.h = h;
            this.isBal = isBal;
        }
    }
}
