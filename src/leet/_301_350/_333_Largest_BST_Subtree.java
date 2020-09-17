package leet._301_350;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * <p>
 * Note:
 * A subtree must include all of its descendants.
 * <p>
 * Example:
 * <p>
 * Input: [10,5,15,1,8,null,7]
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * <p>
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-bst-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _333_Largest_BST_Subtree {
    /**
     * 1ms
     * T = n
     */
    List<Integer> list = new ArrayList<>();
    int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Res dfs(TreeNode root) {
        if (root == null) {
            return new Res(0, true, null, null);
        }

        Res L = dfs(root.left);
        Res R = dfs(root.right);

        boolean largeThanL = L.MAX == null || root.val > L.MAX;
        boolean largeThanR = R.MIN == null || root.val < R.MIN;

        if (L.isBst && R.isBst && largeThanL && largeThanR) {
            int totalCnt = L.cnt + R.cnt + 1;
            ans = Math.max(ans, totalCnt);
            return new Res(totalCnt, true, R.MAX == null ? root.val : R.MAX, L.MIN == null ? root.val : L.MIN);
        }

        return new Res(-1, false, null, null);
    }

    class Res {
        int cnt;
        boolean isBst;
        Integer MAX;
        Integer MIN;

        public Res(int cnt, boolean isBst, Integer MAX, Integer MIN) {
            this.cnt = cnt;
            this.isBst = isBst;
            this.MAX = MAX;
            this.MIN = MIN;
        }
    }
}
