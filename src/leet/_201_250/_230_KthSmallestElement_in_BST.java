package leet._201_250;

import common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class _230_KthSmallestElement_in_BST {
    int count;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        count = k;

        helper(root);

        return ans;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        count--;
        if (count == 0) {
            ans = root.val;
            return;
        }

        helper(root.right);
    }
}
