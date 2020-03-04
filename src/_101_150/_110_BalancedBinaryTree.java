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
        return getData(root).isB;
    }

    public Data getData(TreeNode root) {
        if (root == null) {
            return new Data(0, true);
        }

        Data L = getData(root.left);
        if (!L.isB) {
            return new Data(-1, false);
        }

        Data R = getData(root.right);
        if (!R.isB) {
            return new Data(-1, false);
        }

        int h = Math.max(L.h, R.h) + 1;
        boolean isB = L.isB && R.isB && (Math.abs(L.h - R.h) <= 1);

        return new Data(h, isB);
    }

    // D is data for both height and boolean isBalanced.
    public class Data {
        int h;
        boolean isB;

        public Data(int _h, boolean _isB) {
            h = _h;
            isB = _isB;
        }
    }
}
