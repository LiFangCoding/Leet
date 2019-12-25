package _101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class _113_PathSum2 {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        helper(root, sum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            /**
             * !!! path need to add current node. Then remove it.
             * Run small test cases before
             * This ends one step before.
             */
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        path.add(root.val);
        helper(root.left, sum - root.val);

        helper(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
