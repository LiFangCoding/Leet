package leet._251_300;

import common.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * <p>
 * Output: 3
 * <p>
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * <p>
 * Output: 2
 * <p>
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */
public class _298_BinaryTreeLongestConsecutiveSequence3 {
    public class Sol_slow {
        /**
         * slow solution
         */
        public int longestConsecutive(TreeNode root) {
            ResultType rt = getLongest(root);
            return rt.globalLen;
        }

        private ResultType getLongest(TreeNode root) {
            if (root == null) {
                return new ResultType(0, 0);
            }

            if (root.left == null && root.right == null) {
                return new ResultType(1, 1);
            }

            int localLen = 0;
            ResultType left = getLongest(root.left);
            int locall = 1;
            if (root.left != null && root.val + 1 == root.left.val) {
                locall += left.localLen;
            }

            int localr = 1;
            ResultType right = getLongest(root.right);
            if (root.right != null && root.val + 1 == root.right.val) {
                localr += right.localLen;
            }

            ResultType res = new ResultType(0, 0);
            res.localLen = Math.max(locall, localr);
            res.globalLen = Math.max(res.localLen, Math.max(left.globalLen, right.globalLen));

            return res;
        }

        public class ResultType {
            public int localLen;
            public int globalLen;

            public ResultType(int local, int global) {
                localLen = local;
                globalLen = global;
            }
        }
    }

    public class Sol2 {
        private int res = 0;

        public int longestConsecutive(TreeNode root) {
            dfs(root, 1);
            return res;
        }

        private void dfs(TreeNode root, int len) {
            if (root == null) {
                return;
            }

            res = Math.max(res, len);

            if (root.left != null && root.val + 1 == root.left.val) {
                dfs(root.left, len + 1);
            } else {
                dfs(root.left, 1);
            }

            if (root.right != null && root.val + 1 == root.right.val) {
                dfs(root.right, len + 1);
            } else {
                dfs(root.right, 1);
            }
        }
    }

    private int ans;

    public int longestConsecutive(TreeNode root) {
        ans = 0;

        getConse(root);
        return ans;
    }

    private int getConse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curLen = 1;

        int curLeft = getConse(root.left);
        int curRight = getConse(root.right);

        if (root.left != null && root.val + 1 == root.left.val) {
            curLen += curLeft;
        }

        if (root.right != null && root.val + 1 == root.right.val) {
            curLen = Math.max(curLen, 1 + curRight);
        }

        ans = Math.max(ans, curLen);
        return curLen;
    }
}
