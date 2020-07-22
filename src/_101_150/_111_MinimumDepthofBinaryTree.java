package _101_150;

import common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 */
public class _111_MinimumDepthofBinaryTree {
    /**
     * 对于每个节点：
     * <p>
     * 如果没有子节点，说明是叶节点，则返回1；
     * 如果有子节点，说明是内部结点，则返回子节点的深度的最小值 + 1（加上根节点这层）；
     * 时间复杂度分析：每个节点仅被遍历一次，且遍历时所有操作的复杂度是 O(1)，所以总时间复杂度是 O(n)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }

        int L = minDepth(root.left);
        int R = minDepth(root.right);

        return Math.min(L, R) + 1;
    }
}
