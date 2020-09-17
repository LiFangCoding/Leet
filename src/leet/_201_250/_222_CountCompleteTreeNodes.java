package leet._201_250;

import common.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 */
public class _222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode cur = root.left;
        int leftH = 0;
        while (cur != null) {
            cur = cur.left;
            leftH++;
        }

        cur = root.right;
        int rightH = 0;
        while (cur != null) {
            cur = cur.right;
            rightH++;
        }

        if (leftH == rightH) {
            return (1 << (leftH + 1)) - 1;
        }

        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
