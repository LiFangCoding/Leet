package leet;

import common.TreeNode;

/**
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 * <p>
 * Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,3,3,3,2], target = 3
 * Output: [1,3,null,null,2]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,null,2,null,2], target = 2
 * Output: [1]
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 * Example 4:
 * <p>
 * Input: root = [1,1,1], target = 1
 * Output: []
 * Example 5:
 * <p>
 * Input: root = [1,2,3], target = 1
 * Output: [1,2,3]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 1000
 * Each tree has at most 3000 nodes.
 * Each node's value is between [1, 1000].
 */
public class _1325_DeleteLeavesWith_a_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}