package _251_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class _272_ClosestBinarySearchTreeValue2 {
    /**
     * TODO
     */
    List<Integer> inorderList;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorderList = new ArrayList<>();

        int l = 0;
        int r = inorderList.size() - k;

        return null;
    }


    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        inorderList.add(root.val);
        helper(root.right);
    }
}
