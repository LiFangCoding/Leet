package _251_300;

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
    int res = 0;

    public static void main(String[] args) {
        _298_BinaryTreeLongestConsecutiveSequence3 test = new _298_BinaryTreeLongestConsecutiveSequence3();
        TreeNode root = TreeNode.stringToTreeNode("[1,null,3,2,4,null,null,null, 5]");

        System.out.println(test.longestConsecutive(root));
    }

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            System.out.println("function is for root : " + root.val + " the len is " + 0);
            return 0;
        }

        if (root.left == null && root.right == null) {
            System.out.println("function is for root : " + root.val + " the len is " + 1);
            return 1;
        }

        int curMax = 0;
        if (root.left != null) {
            curMax = helper(root.left) + (root.val + 1 == root.left.val ? 1 : 0);
        }

        if (root.right != null) {
            int maxright = helper(root.right) + (root.val + 1 == root.right.val ? 1 : 0);
            curMax = Math.max(curMax, maxright);
        }


        System.out.println("function is for root : " + root.val + " the len is " + curMax);
        res = Math.max(res, curMax);
        System.out.println("update the res " + res);
        return curMax;
    }
}
