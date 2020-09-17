package leet._101_150;

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
    /**
     * 递归判断：
     * 先递归判断两棵子树是否是平衡的，递归的过程中记录每棵树的最大深度值，然后判断两棵子树的最大深度的差是否不大于1。
     * <p>
     * 时间复杂度分析：每个节点仅被遍历一次，且判断的复杂度是 O(1)。所以总时间复杂度是 O(n)
     */
    public boolean isBalanced(TreeNode root) {
        return getData(root).isB;
    }

    public Res getData(TreeNode root) {
        if (root == null) {
            return new Res(0, true);
        }

        Res L = getData(root.left);
        if (!L.isB) {
            return new Res(-1, false);
        }

        Res R = getData(root.right);
        if (!R.isB) {
            return new Res(-1, false);
        }

        int h = Math.max(L.h, R.h) + 1;
        boolean isB = L.isB && R.isB && (Math.abs(L.h - R.h) <= 1);

        return new Res(h, isB);
    }

    // D is data for both height and boolean isBalanced.
    public class Res {
        int h;
        boolean isB;

        public Res(int _h, boolean _isB) {
            h = _h;
            isB = _isB;
        }
    }
}
