package leet._101_150;

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
 * 11  13   4
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
    List<Integer> path;
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        path = new ArrayList<>();
        ans = new ArrayList<>();

        addPath(root, sum);
        return ans;
    }

    private void addPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        int newSum = sum - root.val;
        path.add(root.val);
        addPath(root.left, newSum);
        addPath(root.right, newSum);
        path.remove(path.size() - 1);
    }
}
