package leet._301_350;

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
    // 0 means not chosen, 1 means chosen
    // f[u][0] = Math.max(f(x, 0), f(x, 1)) + Math.max(f(y, 0) + f(y , 1));
    // f[u][1] = f(x, 0) + f(y, 0) + v[u]
    // ans = max(f(root, 0), f(root, 1));
    public int rob(TreeNode root) {
        int[] f = dfs(root);
        return Math.max(f[0], f[1]);
    }

    int[] dfs(TreeNode u) {
        if (u == null) {
            return new int[]{0, 0};
        }

        int[] x = dfs(u.left);
        int[] y = dfs(u.right);
        int[] f = new int[2];
        f[0] = Math.max(x[0], x[1]) + Math.max(y[0], y[1]);
        f[1] = u.val + x[0] + y[0];
        return f;
    }
}
