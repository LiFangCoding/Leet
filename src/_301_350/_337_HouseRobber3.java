package _301_350;

import common.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class _337_HouseRobber3 {
    public int rob(TreeNode root) {
        int[] ans = robOrNot(root);
        return Math.max(ans[0], ans[1]);
    }

    // 0 means do not rob. 1 means rob
    // f(root)[0] = {f(root.left) 0, 1} + {f(root.right) 0, 1}
    // f(root)1 = root.val + f(root.left)[0] + f[root.right][0]
    public int[] robOrNot(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] l = robOrNot(root.left);
        int[] r = robOrNot(root.right);

        int[] ans = new int[2];
        ans[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        ans[1] = root.val + l[0] + r[0];
        return ans;
    }
}
