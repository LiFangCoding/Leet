package _251_300;

import common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: 4
 */
public class _270_Closest_Binary_Search_Tree_Value {
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;

        int res = root.val;
        double diff = Math.abs(root.val - target);

        while (cur != null) {
            if (Math.abs(cur.val - target) < diff) {
                diff = Math.abs(cur.val - target);
                res = cur.val;
            }

            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return res;
    }
}
