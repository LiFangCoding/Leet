package _101_150;
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
// Related Topics Tree Depth-first Search

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class _112_PathSum {
    /**
     * 递归，自顶向下从根节点往叶节点走，每走过一个节点，就让 sum 减去该节点的值，则如果走到某个叶节点时，
     * sum 恰好为0，则说明从根节点到这个叶节点的路径上的数的和等于 sum
     * 只要找到一条满足要求的路径，递归即可返回。
     * <p>
     * 时间复杂度分析：每个节点仅被遍历一次，且递归过程中维护 sum 的时间复杂度是 O(1)，所以总时间复杂度是 O(n)
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
